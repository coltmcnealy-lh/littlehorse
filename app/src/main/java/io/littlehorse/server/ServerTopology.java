package io.littlehorse.server;

import io.littlehorse.common.LHConfig;
import io.littlehorse.common.LHConstants;
import io.littlehorse.common.model.command.Command;
import io.littlehorse.common.model.command.MetadataCmd;
import io.littlehorse.common.model.wfrun.LHTimer;
import io.littlehorse.common.util.serde.LHDeserializer;
import io.littlehorse.common.util.serde.LHSerde;
import io.littlehorse.server.oldprocessors.TimerProcessor;
import io.littlehorse.server.streamsbackend.coreserver.CommandProcessor;
import io.littlehorse.server.streamsbackend.coreserver.CommandProcessorOutput;
import io.littlehorse.server.streamsbackend.coreserver.GlobalMetadataProcessor;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

public class ServerTopology {

    public static String timerSource = "timer-source";
    public static String timerProcessor = "timer-processor";
    public static String newTimerSink = "new-timer-sink";
    public static String maturedTimerSink = "matured-timer-sink";

    public static String coreSource = "core-source";
    public static String coreStore = "core-store";
    public static String coreProcessor = "core-processor";
    public static String coreSink = "core-sink";

    public static String globalMetaSource = "global-metadata-cl-source";
    public static String globalStore = "global-metadata-store";
    public static String globalMetaProcessor = "global-metadata-processor";

    public static Topology initCoreTopology(LHConfig config) {
        Topology topo = new Topology();

        topo.addSource(
            coreSource, // source name
            Serdes.String().deserializer(), // key deserializer
            new LHDeserializer<>(Command.class, config), // value deserializer
            config.getCoreCmdTopicName() // source topic
        );

        topo.addProcessor(
            coreProcessor,
            () -> {
                return new CommandProcessor(config);
            },
            coreSource
        );

        topo.addSink(
            coreSink,
            (key, coreServerOutput, ctx) -> {
                return ((CommandProcessorOutput) coreServerOutput).topic;
            }, // topic extractor
            Serdes.String().serializer(), // key serializer
            (topic, output) -> {
                return ((CommandProcessorOutput) output).payload.toBytes(config);
            }, // value serializer
            coreProcessor // parent name
        );

        StoreBuilder<KeyValueStore<String, Bytes>> partitionedStoreBuilder = Stores.keyValueStoreBuilder(
            Stores.persistentKeyValueStore(LHConstants.CORE_DATA_STORE_NAME),
            Serdes.String(),
            Serdes.Bytes()
        );
        topo.addStateStore(partitionedStoreBuilder, coreProcessor);

        // There's a topic for global communication, which is used for two things:
        // 1. broadcasting global metadata to all instances
        // 2. (LATER) communicating about how many items are in each queue for
        //    each partition.
        // This topic is config.getGlobalMetadatCLTopicName()
        // topo.addSource(globalMetaSource, Serdes.String().deserializer(), new LHDeserializer<>(), config))

        StoreBuilder<KeyValueStore<String, Bytes>> globalStoreBuilder = Stores.keyValueStoreBuilder(
            Stores.persistentKeyValueStore(globalStore),
            Serdes.String(),
            Serdes.Bytes()
        );
        topo.addGlobalStore(
            globalStoreBuilder,
            globalMetaSource,
            Serdes.String().deserializer(),
            new LHDeserializer<MetadataCmd>(MetadataCmd.class, config),
            config.getGlobalMetadataCLTopicName(),
            globalMetaProcessor,
            () -> {
                return new GlobalMetadataProcessor();
            }
            // add lambda to return the processor
        );
        return topo;
    }

    public static Topology initTaggingTopology(LHConfig config) {
        return null;
    }

    public static Topology initTimerTopology(LHConfig config) {
        Topology topo = new Topology();
        Serde<LHTimer> timerSerde = new LHSerde<>(LHTimer.class, config);

        Runtime
            .getRuntime()
            .addShutdownHook(
                new Thread(() -> {
                    timerSerde.close();
                })
            );

        topo.addSource(
            timerSource,
            Serdes.String().deserializer(),
            timerSerde.deserializer(),
            config.getTimerTopic()
        );

        topo.addProcessor(
            timerProcessor,
            () -> {
                return new TimerProcessor();
            },
            timerSource
        );

        topo.addSink(
            maturedTimerSink,
            (key, lhTimer, ctx) -> {
                return ((LHTimer) lhTimer).topic;
            },
            Serdes.String().serializer(),
            (topic, lhTimer) -> {
                return ((LHTimer) lhTimer).getPayload(config);
            },
            timerProcessor
        );

        // Add state store
        StoreBuilder<KeyValueStore<String, LHTimer>> timerStoreBuilder = Stores.keyValueStoreBuilder(
            Stores.persistentKeyValueStore(LHConstants.TIMER_STORE_NAME),
            Serdes.String(),
            timerSerde
        );
        topo.addStateStore(timerStoreBuilder, timerProcessor);

        return topo;
    }
}

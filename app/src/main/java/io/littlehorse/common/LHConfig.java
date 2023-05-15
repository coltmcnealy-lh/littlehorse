package io.littlehorse.common;

import io.grpc.ChannelCredentials;
import io.grpc.TlsChannelCredentials;
import io.grpc.TlsServerCredentials;
import io.littlehorse.common.model.meta.VariableAssignment;
import io.littlehorse.common.model.wfrun.VariableValue;
import io.littlehorse.common.util.LHProducer;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.jlib.common.config.ConfigBase;
import io.littlehorse.jlib.common.config.LHWorkerConfig;
import io.littlehorse.jlib.common.proto.HostInfoPb;
import io.littlehorse.jlib.common.proto.VariableAssignmentPb.SourceCase;
import io.littlehorse.server.streamsimpl.ServerTopology;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.config.TopicConfig;
import org.apache.kafka.common.errors.TopicExistsException;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Utils;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.state.HostInfo;
import org.apache.log4j.Logger;

public class LHConfig extends ConfigBase {

    private static final Logger log = Logger.getLogger(LHConfig.class);

    // Kafka and Kafka Streams-Specific Configuration Env Vars
    public static final String KAFKA_BOOTSTRAP_KEY = "LHS_KAFKA_BOOTSTRAP_SERVERS";
    public static final String LH_CLUSTER_ID_KEY = "LHS_CLUSTER_ID";
    public static final String LH_INSTANCE_ID_KEY = "LHS_INSTANCE_ID";
    public static final String RACK_ID_KEY = "LHS_RACK_ID";

    public static final String REPLICATION_FACTOR_KEY = "LHS_REPLICATION_FACTOR";
    public static final String CLUSTER_PARTITIONS_KEY = "LHS_CLUSTER_PARTITIONS";
    public static final String NUM_STREAM_THREADS_KEY = "LHS_STREAMS_NUM_THREADS";
    public static final String SESSION_TIMEOUT_KEY = "LHS_STREAMS_SESSION_TIMEOUT";
    public static final String COMMIT_INTERVAL_KEY = "LHS_STREAMS_COMMIT_INTERVAL";
    public static final String KAFKA_STATE_DIR_KEY = "LHS_STATE_DIR";
    public static final String NUM_WARMUP_REPLICAS_KEY =
        "LHS_STREAMS_NUM_WARMUP_REPLICAS";
    public static final String NUM_STANDBY_REPLICAS_KEY =
        "LHS_STREAMS_NUM_STANDBY_REPLICAS";

    // General LittleHorse Runtime Behavior Config Env Vars
    public static final String DEFAULT_TIMEOUT_KEY = "LHS_DEFAULT_TASK_TIMEOUT";
    public static final String KAFKA_TOPIC_PREFIX_KEY = "LHS_KAFKA_PREFIX";

    // Host and Port Configuration Env Vars
    public static final String ADVERTISED_LISTENERS_KEY =
        "LHS_ADVERTISED_LISTENER_NAMES";
    public static final String API_BIND_PORT_KEY = "LHS_API_BIND_PORT";
    public static final String INTERNAL_BIND_PORT_KEY = "LHS_INTERNAL_BIND_PORT";
    public static final String INTERNAL_ADVERTISED_HOST_KEY =
        "LHS_INTERNAL_ADVERTISED_HOST";
    public static final String INTERNAL_ADVERTISED_PORT_KEY =
        "LHS_INTERNAL_ADVERTISED_PORT";

    public static final String CA_CERT_KEY = "LHS_CA_CERT";
    public static final String SERVER_CERT_KEY = "LHS_SERVER_CERT";
    public static final String SERVER_KEY_KEY = "LHS_SERVER_KEY";

    public static final String INTERNAL_CA_CERT_KEY = "LHS_INTERNAL_CA_CERT";
    public static final String INTERNAL_SERVER_CERT_KEY = "LHS_INTERNAL_SERVER_CERT";
    public static final String INTERNAL_SERVER_KEY_KEY = "LHS_INTERNAL_SERVER_KEY";

    public static final String KAFKA_TRUSTSTORE_KEY = "LHS_KAFKA_TRUSTSTORE";
    public static final String KAFKA_TRUSTSTORE_PASSWORD_KEY =
        "LHS_KAFKA_TRUSTSTORE_PASSWORD";
    public static final String KAFKA_KEYSTORE_KEY = "LHS_KAFKA_KEYSTORE";
    public static final String KAFKA_KEYSTORE_PASSWORD_KEY =
        "LHS_KAFKA_KEYSTORE_PASSWORD";

    public static final String SHOULD_CREATE_TOPICS_KEY = "LHS_SHOULD_CREATE_TOPICS";

    public static final String DEFAULT_PUBLIC_LISTENER =
        LHWorkerConfig.DEFAULT_PUBLIC_LISTENER;

    protected String[] getEnvKeyPrefixes() {
        return new String[] { "LHS_" };
    }

    private Admin kafkaAdmin;
    private LHProducer producer;
    private LHProducer txnProducer;

    public int getHotMetadataPartition() {
        return (
            Utils.toPositive(
                Utils.murmur2(LHConstants.META_PARTITION_KEY.getBytes())
            ) %
            getClusterPartitions()
        );
    }

    public String getKafkaTopicPrefix() {
        return getOrSetDefault(
            LHConfig.KAFKA_TOPIC_PREFIX_KEY,
            getLHClusterId() + "-"
        );
    }

    public String getCoreCmdTopicName() {
        return getCoreCmdTopicName(getKafkaTopicPrefix());
    }

    public static String getCoreCmdTopicName(String kafkaTopicPrefix) {
        return kafkaTopicPrefix + "core-cmd";
    }

    public String getRepartitionTopicName() {
        return getRepartitionTopicName(getKafkaTopicPrefix());
    }

    public static String getRepartitionTopicName(String kafkaTopicPrefix) {
        return kafkaTopicPrefix + "core-repartition";
    }

    public String getObservabilityEventTopicName() {
        return getObservabilityEventTopicName(getKafkaTopicPrefix());
    }

    public static String getObservabilityEventTopicName(String kafkaTopicPrefix) {
        return kafkaTopicPrefix + "observability";
    }

    public String getGlobalMetadataCLTopicName() {
        return getGlobalMetadataCLTopicName(getKafkaTopicPrefix());
    }

    public static String getGlobalMetadataCLTopicName(String kafkaTopicPrefix) {
        return kafkaTopicPrefix + "global-metadata-cl";
    }

    public String getTimerTopic() {
        return getTimerTopic(getKafkaTopicPrefix());
    }

    public static String getTimerTopic(String kafkaTopicPrefix) {
        return kafkaTopicPrefix + "timers";
    }

    public static String getCoreStoreChangelogTopic(String kafkaTopicPrefix) {
        return kafkaTopicPrefix + "core-" + ServerTopology.CORE_STORE + "-changelog";
    }

    public String getCoreStoreChangelogTopic() {
        return getCoreStoreChangelogTopic(getKafkaTopicPrefix());
    }

    public static String getTimerStoreChangelogTopic(String kafkaTopicPrefix) {
        return (
            kafkaTopicPrefix + "timer-" + ServerTopology.TIMER_STORE + "-changelog"
        );
    }

    public String getTimerStoreChangelogTopic() {
        return getTimerStoreChangelogTopic(getKafkaTopicPrefix());
    }

    public static String getRepartitionStoreChangelogTopic(String kafkaTopicPrefix) {
        return (
            kafkaTopicPrefix +
            "core-" +
            ServerTopology.CORE_REPARTITION_STORE +
            "-changelog"
        );
    }

    public String getRepartitionStoreChangelogTopic() {
        return getRepartitionStoreChangelogTopic(getKafkaTopicPrefix());
    }

    public List<NewTopic> getAllTopics() {
        return getAllTopics(
            getKafkaTopicPrefix(),
            getLHClusterId(),
            getReplicationFactor(),
            getClusterPartitions()
        );
    }

    public static List<NewTopic> getAllTopics(
        String kafkaTopicPrefix,
        String clusterId,
        short replicationFactor,
        int clusterPartitions
    ) {
        List<NewTopic> out = new ArrayList<>();

        // These are non-compacted topics, partitioned with the cluster wide
        // thing.
        List<String> eventTopics = Arrays.asList(
            getCoreCmdTopicName(kafkaTopicPrefix),
            getRepartitionTopicName(kafkaTopicPrefix),
            getObservabilityEventTopicName(kafkaTopicPrefix),
            getTimerTopic(kafkaTopicPrefix)
        );
        for (String name : eventTopics) {
            // default config is normal retention policy (not compact)
            out.add(new NewTopic(name, clusterPartitions, replicationFactor));
        }

        // These need to be compacted.
        List<String> partitionedChangelogs = Arrays.asList(
            getCoreStoreChangelogTopic(kafkaTopicPrefix),
            getRepartitionStoreChangelogTopic(kafkaTopicPrefix),
            getTimerStoreChangelogTopic(kafkaTopicPrefix)
        );
        HashMap<String, String> changelogConfig = new HashMap<String, String>() {
            {
                put(
                    TopicConfig.CLEANUP_POLICY_CONFIG,
                    TopicConfig.CLEANUP_POLICY_COMPACT
                );
            }
        };
        for (String name : partitionedChangelogs) {
            out.add(
                new NewTopic(name, clusterPartitions, replicationFactor)
                    .configs(changelogConfig)
            );
        }

        // Lastly, the global metadata changelog topic.
        // Inputs to global state store's are always treated
        // as changelog topics. Therefore, we need it to be
        // compacted. In order to minimize restore time, we
        // also want the compaction to be quite aggressive.
        HashMap<String, String> globalMetaCLConfig = new HashMap<String, String>() {
            {
                put(
                    TopicConfig.CLEANUP_POLICY_CONFIG,
                    TopicConfig.CLEANUP_POLICY_COMPACT
                );
            }
        };
        out.add(
            new NewTopic(
                getGlobalMetadataCLTopicName(kafkaTopicPrefix),
                // This topic is input to a global store. Therefore, it doesn't
                // make sense to have any more than just one partition.
                1,
                replicationFactor
            )
                .configs(globalMetaCLConfig)
        );

        return out;
    }

    // TODO: Determine how and where to set the topic names for TaskDef queues

    public String getBootstrapServers() {
        return getOrSetDefault(LHConfig.KAFKA_BOOTSTRAP_KEY, "localhost:9092");
    }

    public short getReplicationFactor() {
        return Short.valueOf(
            String.class.cast(
                    props.getOrDefault(LHConfig.REPLICATION_FACTOR_KEY, "1")
                )
        );
    }

    public int getClusterPartitions() {
        return Integer.valueOf(
            String.class.cast(
                    props.getOrDefault(LHConfig.CLUSTER_PARTITIONS_KEY, "72")
                )
        );
    }

    public String getKafkaGroupId(String component) {
        return getLHClusterId() + "-" + component;
    }

    public String getLHClusterId() {
        String clusterId = (String) props.get(LH_CLUSTER_ID_KEY);
        if (clusterId == null) {
            throw new RuntimeException("Must set LH_CLUSTER_ID!");
        }
        return clusterId;
    }

    public String getLHInstanceId() {
        return getOrSetDefault(LHConfig.LH_INSTANCE_ID_KEY, "Unset-group-iid-bad");
    }

    public String getStateDirectory() {
        return getOrSetDefault(LHConfig.KAFKA_STATE_DIR_KEY, "/tmp/kafkaState");
    }

    public String getInternalAdvertisedHost() {
        return getOrSetDefault(LHConfig.INTERNAL_ADVERTISED_HOST_KEY, "localhost");
    }

    // If INTERNAL_ADVERTISED_PORT isn't set, we return INTERNAL_BIND_PORT.
    public int getInternalAdvertisedPort() {
        return Integer.valueOf(
            getOrSetDefault(
                LHConfig.INTERNAL_ADVERTISED_PORT_KEY,
                Integer.valueOf(getInternalBindPort()).toString()
            )
        );
    }

    public int getApiBindPort() {
        return Integer.valueOf(getOrSetDefault(LHConfig.API_BIND_PORT_KEY, "5000"));
    }

    // If INTERNAL_BIND_PORT isn't set, we just return API_BIND_PORT + 1.
    public int getInternalBindPort() {
        return Integer.valueOf(
            getOrSetDefault(
                LHConfig.INTERNAL_BIND_PORT_KEY,
                Integer.valueOf(getApiBindPort() + 1).toString()
            )
        );
    }

    private Map<String, HostInfoPb> publicAdvertisedHostMap;

    public Map<String, HostInfoPb> getPublicAdvertisedHostMap() {
        if (publicAdvertisedHostMap != null) {
            return publicAdvertisedHostMap;
        }

        publicAdvertisedHostMap = new HashMap<>();

        String listenerNames = getOrSetDefault(
            LHConfig.ADVERTISED_LISTENERS_KEY,
            LHConfig.DEFAULT_PUBLIC_LISTENER
        );
        System.out.println("Listener names are " + listenerNames);

        for (String lister : listenerNames.split(",")) {
            publicAdvertisedHostMap.put(lister, getHostForName(lister));
        }

        return publicAdvertisedHostMap;
    }

    private HostInfoPb getHostForName(String listenerName) {
        String fullHost = getOrSetDefault(listenerName, "localhost:5000");

        HostInfoPb.Builder out = HostInfoPb.newBuilder();
        int colonIndex = fullHost.indexOf(":");
        if (colonIndex == -1) {
            throw new RuntimeException(
                "Listener " + listenerName + " set to invalid host " + fullHost
            );
        }

        out.setHost(fullHost.substring(0, colonIndex));
        try {
            out.setPort(
                Integer.valueOf(fullHost.substring(colonIndex + 1, fullHost.length()))
            );
        } catch (Exception exn) {
            throw new RuntimeException(exn);
        }
        return out.build();
    }

    public HostInfo getInternalHostInfo() {
        return new HostInfo(getInternalAdvertisedHost(), getInternalAdvertisedPort());
    }

    public void cleanup() {
        if (this.kafkaAdmin != null) this.kafkaAdmin.close();
        if (this.producer != null) this.producer.close();
        if (this.txnProducer != null) this.txnProducer.close();
    }

    public LHProducer getProducer() {
        if (producer == null) {
            producer = new LHProducer(this);
        }
        return producer;
    }

    public boolean shouldCreateTopics() {
        return Boolean.valueOf(getOrSetDefault(SHOULD_CREATE_TOPICS_KEY, "true"));
    }

    public Properties getKafkaProducerConfig(String component) {
        Properties conf = new Properties();
        conf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, getBootstrapServers());
        conf.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        conf.put(
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
            Serdes.Bytes().serializer().getClass()
        );
        // conf.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        conf.put(ProducerConfig.CLIENT_ID_CONFIG, getKafkaGroupId(component));
        conf.put(
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
            org.apache.kafka.common.serialization.StringSerializer.class
        );
        conf.put(ProducerConfig.ACKS_CONFIG, "all");
        initKafkaSecurity(conf);
        return conf;
    }

    /*
     * EMPLOYEE_TODO: right now, this only supports mtls auth. We want to:
     * 1. Support other auth types, especially SCRAM-SHA-512
     * 2. Clean up the code, because currently it's just kludgey.
     *
     * For part 2), we maybe want to factor out the Kafka configuration to
     * its own class. Maybe. Or maybe not.
     *
     * Either way, this all should be configurable.
     */
    private void initKafkaSecurity(Properties conf) {
        String keystoreLoc = getOrSetDefault(KAFKA_KEYSTORE_KEY, null);
        String keystorePassword = getOrSetDefault(KAFKA_KEYSTORE_PASSWORD_KEY, null);
        String truststoreLoc = getOrSetDefault(KAFKA_TRUSTSTORE_KEY, null);
        String truststorePassword = getOrSetDefault(
            KAFKA_TRUSTSTORE_PASSWORD_KEY,
            null
        );

        if (
            keystoreLoc == null &&
            keystorePassword == null &&
            truststoreLoc == null &&
            truststorePassword == null
        ) {
            log.info("Using plaintext kafka access");
            return;
        }

        if (
            keystoreLoc == null ||
            keystorePassword == null ||
            truststoreLoc == null ||
            truststorePassword == null
        ) {
            throw new RuntimeException(
                "Must provide all or none of the following configs: " +
                KAFKA_KEYSTORE_KEY +
                ", " +
                KAFKA_KEYSTORE_PASSWORD_KEY +
                ", " +
                KAFKA_TRUSTSTORE_KEY +
                ", " +
                KAFKA_TRUSTSTORE_PASSWORD_KEY
            );
        }

        conf.put("security.protocol", "SSL");

        conf.put("ssl.keystore.type", "PKCS12");
        conf.put("ssl.keystore.location", keystoreLoc);
        conf.put("ssl.keystore.password", loadPasswordFrom(keystorePassword));

        conf.put("ssl.truststore.type", "PKCS12");
        conf.put("ssl.truststore.location", truststoreLoc);
        conf.put("ssl.truststore.password", loadPasswordFrom(truststorePassword));
    }

    private static String loadPasswordFrom(String fileName) {
        try (FileInputStream is = new FileInputStream(new File(fileName));) {
            return new String(is.readAllBytes());
        } catch (IOException exn) {
            throw new RuntimeException(exn);
        }
    }

    public Properties getStreamsConfig(String component, boolean exactlyOnce) {
        Properties props = new Properties();
        props.put(
            StreamsConfig.APPLICATION_SERVER_CONFIG,
            this.getInternalAdvertisedHost() + ":" + this.getInternalAdvertisedPort()
        );
        props.put(
            StreamsConfig.APPLICATION_ID_CONFIG,
            this.getKafkaGroupId(component)
        );
        props.put(ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, this.getLHInstanceId());
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, this.getBootstrapServers());
        props.put(StreamsConfig.STATE_DIR_CONFIG, this.getStateDirectory());
        if (exactlyOnce) {
            props.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, "exactly_once_v2");
        }
        props.put(StreamsConfig.TOPOLOGY_OPTIMIZATION_CONFIG, "all");
        props.put(StreamsConfig.REQUEST_TIMEOUT_MS_CONFIG, 30000);
        props.put(
            StreamsConfig.producerPrefix(ProducerConfig.TRANSACTION_TIMEOUT_CONFIG),
            1000 * 15
        );
        props.put(StreamsConfig.producerPrefix(ProducerConfig.ACKS_CONFIG), "all");

        props.put(
            StreamsConfig.consumerPrefix(ConsumerConfig.MAX_POLL_RECORDS_CONFIG),
            10000 // 10,000 instead of 1,000 to improve throughput
        );
        props.put(
            StreamsConfig.consumerPrefix(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG),
            20
        );

        props.put(
            StreamsConfig.REPLICATION_FACTOR_CONFIG,
            (int) getReplicationFactor()
        );
        props.put(
            StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG,
            org.apache.kafka.streams.errors.LogAndContinueExceptionHandler.class
        );
        props.put(
            StreamsConfig.DEFAULT_PRODUCTION_EXCEPTION_HANDLER_CLASS_CONFIG,
            org.apache.kafka.streams.errors.DefaultProductionExceptionHandler.class
        );
        props.put(
            StreamsConfig.consumerPrefix(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG),
            Integer.valueOf(getOrSetDefault(LHConfig.SESSION_TIMEOUT_KEY, "30000"))
        );
        props.put(StreamsConfig.METADATA_MAX_AGE_CONFIG, 1000 * 30);
        props.put(
            StreamsConfig.NUM_STREAM_THREADS_CONFIG,
            Integer.valueOf(getOrSetDefault(LHConfig.NUM_STREAM_THREADS_KEY, "1"))
        );
        props.put(StreamsConfig.TASK_TIMEOUT_MS_CONFIG, 10 * 1000);
        props.put(
            StreamsConfig.producerPrefix(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG),
            10 * 1000
        );
        props.put(
            StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,
            Serdes.StringSerde.class.getName()
        );
        props.put(
            StreamsConfig.NUM_STANDBY_REPLICAS_CONFIG,
            this.getStandbyReplicas()
        );
        props.put(StreamsConfig.MAX_WARMUP_REPLICAS_CONFIG, this.getWarmupReplicas());
        props.put(
            StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,
            Serdes.StringSerde.class.getName()
        );
        props.put(
            StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,
            getStreamsCommitInterval()
        );
        props.put(StreamsConfig.PROBING_REBALANCE_INTERVAL_MS_CONFIG, 1000 * 60);

        // props.put(StreamsConfig.RACK_AWARE_ASSIGNMENT_TAGS_CONFIG, "rack");
        // props.put(StreamsConfig.CLIENT_TAG_PREFIX + "rack", getRackId());

        initKafkaSecurity(props);

        return props;
    }

    public String getRackId() {
        return getOrSetDefault(LHConfig.RACK_ID_KEY, "unset-rack-id-bad-bad");
    }

    public int getStreamsCommitInterval() {
        return Integer.valueOf(getOrSetDefault(LHConfig.COMMIT_INTERVAL_KEY, "100"));
    }

    public VariableAssignment getDefaultTaskTimeout() {
        int timeout = Integer.valueOf(
            getOrSetDefault(LHConfig.DEFAULT_TIMEOUT_KEY, "10")
        );

        VariableValue val = new VariableValue(timeout);
        VariableAssignment out = new VariableAssignment();
        out.rhsSourceType = SourceCase.LITERAL_VALUE;
        out.rhsLiteralValue = val;
        return out;
    }

    public int getStandbyReplicas() {
        return Integer.valueOf(
            getOrSetDefault(LHConfig.NUM_STANDBY_REPLICAS_KEY, "0")
        );
    }

    public int getWarmupReplicas() {
        return Integer.valueOf(
            getOrSetDefault(LHConfig.NUM_WARMUP_REPLICAS_KEY, "12")
        );
    }

    public void createKafkaTopic(NewTopic topic)
        throws InterruptedException, ExecutionException {
        CreateTopicsResult result = kafkaAdmin.createTopics(
            Collections.singleton(topic)
        );
        KafkaFuture<Void> future = result.values().get(topic.name());
        try {
            future.get();
        } catch (Exception e) {
            if (
                e.getCause() != null && e.getCause() instanceof TopicExistsException
            ) {
                LHUtil.log("Topic " + topic.name() + " already exists.");
            } else {
                throw e;
            }
        }
    }

    public LHConfig(Properties props) {
        this.props = props;

        Properties akProperties = new Properties();
        akProperties.put(
            AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
            getBootstrapServers()
        );
        initKafkaSecurity(akProperties);
        this.kafkaAdmin = Admin.create(akProperties);
    }

    public TlsServerCredentials.Builder getServerCreds() {
        String caCertFile = getOrSetDefault(CA_CERT_KEY, null);
        String serverCertFile = getOrSetDefault(SERVER_CERT_KEY, null);
        String serverKeyFile = getOrSetDefault(SERVER_KEY_KEY, null);
        return getCreds(caCertFile, serverCertFile, serverKeyFile);
    }

    public TlsServerCredentials.Builder getInternalServerCreds() {
        String caCertFile = getOrSetDefault(INTERNAL_CA_CERT_KEY, null);
        String serverCertFile = getOrSetDefault(INTERNAL_SERVER_CERT_KEY, null);
        String serverKeyFile = getOrSetDefault(INTERNAL_SERVER_KEY_KEY, null);
        return getCreds(caCertFile, serverCertFile, serverKeyFile);
    }

    public ChannelCredentials getInternalServerClientCreds() {
        String caCertFile = getOrSetDefault(INTERNAL_CA_CERT_KEY, null);
        String serverCertFile = getOrSetDefault(INTERNAL_SERVER_CERT_KEY, null);
        String serverKeyFile = getOrSetDefault(INTERNAL_SERVER_KEY_KEY, null);
        if (caCertFile == null) {
            log.info("No ca cert file, using plaintext internal client");
            return null;
        }
        if (serverCertFile == null || serverKeyFile == null) {
            throw new RuntimeException(
                "CA cert file provided but missing cert or key"
            );
        }
        File serverCert = new File(serverCertFile);
        File serverKey = new File(serverKeyFile);
        File rootCA = new File(caCertFile);

        try {
            TlsChannelCredentials.Builder out = TlsChannelCredentials
                .newBuilder()
                .keyManager(serverCert, serverKey)
                .trustManager(rootCA);

            return out.build();
        } catch (IOException exn) {
            throw new RuntimeException(exn);
        }
    }

    private TlsServerCredentials.Builder getCreds(
        String caCertFile,
        String serverCertFile,
        String serverKeyFile
    ) {
        if (caCertFile == null) {
            log.info("No ca cert file found, deploying insecure!");
            return null;
        }

        if (serverCertFile == null || serverKeyFile == null) {
            throw new RuntimeException(
                "CA cert file provided but missing cert or key"
            );
        }
        File serverCert = new File(serverCertFile);
        File serverKey = new File(serverKeyFile);
        File rootCA = new File(caCertFile);

        try {
            TlsServerCredentials.Builder out = TlsServerCredentials
                .newBuilder()
                .keyManager(serverCert, serverKey)
                .trustManager(rootCA)
                .clientAuth(TlsServerCredentials.ClientAuth.REQUIRE);

            return out;
        } catch (IOException exn) {
            throw new RuntimeException(exn);
        }
    }
}

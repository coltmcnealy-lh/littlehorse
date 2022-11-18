package io.littlehorse.common.model.meta;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.protobuf.MessageOrBuilder;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.exceptions.LHSerdeError;
import io.littlehorse.common.exceptions.LHValidationError;
import io.littlehorse.common.model.GlobalPOSTable;
import io.littlehorse.common.model.POSTable;
import io.littlehorse.common.model.event.WfRunEvent;
import io.littlehorse.common.model.server.Tag;
import io.littlehorse.common.model.wfrun.WfRun;
import io.littlehorse.common.proto.LHStatusPb;
import io.littlehorse.common.proto.ThreadSpecPb;
import io.littlehorse.common.proto.WfSpecPb;
import io.littlehorse.common.proto.WfSpecPbOrBuilder;
import io.littlehorse.common.util.LHGlobalMetaStores;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.server.oldprocessors.util.WfRunStoreAccess;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public class WfSpec extends GlobalPOSTable<WfSpecPbOrBuilder> {

    public String id;
    public String name;
    public Date createdAt;
    public Date updatedAt;
    public long lastOffset;

    public Map<String, ThreadSpec> threadSpecs;

    public String entrypointThreadName;
    public LHStatusPb status;

    @JsonIgnore
    private Map<String, String> varToThreadSpec;

    @JsonIgnore
    private boolean initializedVarToThreadSpec;

    public String getName() {
        return name;
    }

    public String getObjectId() {
        if (id.equals("")) {
            id = LHUtil.generateGuid();
        }
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getPartitionKey() {
        return getObjectId();
    }

    public WfSpec() {
        threadSpecs = new HashMap<>();
        varToThreadSpec = new HashMap<>();
        initializedVarToThreadSpec = false;
    }

    public long getLastUpdatedOffset() {
        return lastOffset;
    }

    public void setLastUpdatedOffset(long newOffset) {
        lastOffset = newOffset;
    }

    public WfSpecPb.Builder toProto() {
        WfSpecPb.Builder out = WfSpecPb
            .newBuilder()
            .setId(id)
            .setCreatedAt(LHUtil.fromDate(createdAt))
            .setUpdatedAt(LHUtil.fromDate(updatedAt))
            .setEntrypointThreadName(entrypointThreadName)
            .setStatus(status)
            .setName(name)
            .setLastUpdatedOffset(lastOffset);

        if (threadSpecs != null) {
            for (Map.Entry<String, ThreadSpec> p : threadSpecs.entrySet()) {
                out.putThreadSpecs(p.getKey(), p.getValue().toProto().build());
            }
        }

        return out;
    }

    public void initFrom(MessageOrBuilder pr) throws LHSerdeError {
        WfSpecPbOrBuilder proto = (WfSpecPbOrBuilder) pr;
        createdAt = LHUtil.fromProtoTs(proto.getCreatedAt());
        id = proto.getId();
        updatedAt = LHUtil.fromProtoTs(proto.getUpdatedAt());
        entrypointThreadName = proto.getEntrypointThreadName();
        status = proto.getStatus();
        name = proto.getName();
        lastOffset = proto.getLastUpdatedOffset();

        for (Map.Entry<String, ThreadSpecPb> e : proto
            .getThreadSpecsMap()
            .entrySet()) {
            ThreadSpec ts = new ThreadSpec();
            ts.wfSpec = this;
            ts.name = e.getKey();
            ts.initFrom(e.getValue());
            threadSpecs.put(e.getKey(), ts);
        }
    }

    @JsonIgnore
    public Class<WfSpecPb> getProtoBaseClass() {
        return WfSpecPb.class;
    }

    public static WfSpec fromProto(WfSpecPbOrBuilder proto) throws LHSerdeError {
        WfSpec out = new WfSpec();
        out.initFrom(proto);
        return out;
    }

    @JsonIgnore
    public boolean handleDelete() {
        return true;
    }

    @JsonIgnore
    public void handlePost(
        POSTable<WfSpecPbOrBuilder> old,
        LHGlobalMetaStores dbClient,
        LHConfig config
    ) throws LHValidationError {
        // This does a lot of validation; therefore, it's quite complicated.
        if (old != null) {
            throw new LHValidationError(null, "Mutating WfSpec not yet supported");
        }

        validate(dbClient, config);
    }

    private void initializeVarToThreadSpec() {
        initializedVarToThreadSpec = true;
        for (ThreadSpec tspec : threadSpecs.values()) {
            for (String varName : tspec.variableDefs.keySet()) {
                varToThreadSpec.put(varName, tspec.name);
            }
        }
    }

    public Pair<String, VariableDef> lookupVarDef(String name) {
        if (!initializedVarToThreadSpec) {
            initializeVarToThreadSpec();
        }
        String tspecName = varToThreadSpec.get(name);
        if (tspecName == null) return null;
        VariableDef out = threadSpecs.get(tspecName).variableDefs.get(name);
        if (out == null) return null;
        return Pair.of(tspecName, out);
    }

    private void validate(LHGlobalMetaStores dbClient, LHConfig config)
        throws LHValidationError {
        if (threadSpecs.get(entrypointThreadName) == null) {
            throw new LHValidationError(null, "Unknown entrypoint thread");
        }

        // Validate the variable definitions.
        // This will get tricky with interrupts, but...
        validateVariablesHelper();

        for (Map.Entry<String, ThreadSpec> e : threadSpecs.entrySet()) {
            ThreadSpec ts = e.getValue();
            try {
                ts.validate(dbClient, config);
            } catch (LHValidationError exn) {
                exn.addPrefix("Thread " + ts.name);
                throw exn;
            }
        }
    }

    // TODO: Do some caching here cuz this could be slow for large workflows.
    public Set<String> getNodeExternalEventDefs() {
        Set<String> out = new HashSet<>();
        for (ThreadSpec tspec : threadSpecs.values()) {
            out.addAll(tspec.getNodeExternalEventDefs());
        }
        return out;
    }

    @JsonIgnore
    public Map<String, VariableDef> getRequiredVariables() {
        return threadSpecs.get(entrypointThreadName).getRequiredInputVariables();
    }

    /*
     * For now, the only validation we do for variables is to make sure that:
     * 1. No variable name is defined twice (this will be useful for future features).
     * 2. Every variable name that is referenced by a VariableAssignment or
     *    VariableMutation is defined by *some* thread *somewhere* in the WfSpec.
     *
     * Future work may entail:
     * 1. Validating variable scope across threads (including Exception handlers,
     *    Interrupt Handlers, and child threads).
     * 2. Validating variable types for mutations, assignments, and task input.
     * 3. Incorporation of JsonSchema or Protobuf Schema for further validation.
     */
    private void validateVariablesHelper() throws LHValidationError {
        varToThreadSpec = new HashMap<>();
        for (ThreadSpec tspec : threadSpecs.values()) {
            for (Map.Entry<String, VariableDef> e : tspec.variableDefs.entrySet()) {
                String varName = e.getKey();

                if (varToThreadSpec.containsKey(varName)) {
                    throw new LHValidationError(
                        null,
                        "Var name " +
                        varName +
                        " defined in threads " +
                        name +
                        " and " +
                        varToThreadSpec.get(varName)
                    );
                }
                varToThreadSpec.put(varName, name);
            }
        }

        // Seen Vars is now loaded.
        initializeVarToThreadSpec();

        for (ThreadSpec tspec : threadSpecs.values()) {
            for (String varName : tspec.getRequiredVariableNames()) {
                if (!varToThreadSpec.containsKey(varName)) {
                    throw new LHValidationError(
                        null,
                        "Thread " + tspec.name + " refers to missing var " + varName
                    );
                }
            }
        }
    }

    public List<Tag> getTags() {
        List<Tag> out = Arrays.asList(new Tag(this, Pair.of("name", name)));

        return out;
    }

    public WfRun startNewRun(WfRunEvent e, WfRunStoreAccess wsa) {
        WfRun out = new WfRun();
        out.stores = wsa;
        out.id = e.runRequest.wfRunId;

        out.wfSpec = this;
        out.wfSpecId = id;
        out.wfSpecName = name;
        out.startTime = e.time;
        out.status = LHStatusPb.RUNNING;

        out.startThread(entrypointThreadName, e.time, null, e.runRequest.variables);

        return out;
    }
}

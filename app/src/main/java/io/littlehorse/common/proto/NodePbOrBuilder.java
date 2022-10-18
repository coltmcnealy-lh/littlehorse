// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lh_proto.proto

package io.littlehorse.common.proto;

public interface NodePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.NodePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .lh_proto.EdgePb outgoing_edges = 1;</code>
   */
  java.util.List<io.littlehorse.common.proto.EdgePb> 
      getOutgoingEdgesList();
  /**
   * <code>repeated .lh_proto.EdgePb outgoing_edges = 1;</code>
   */
  io.littlehorse.common.proto.EdgePb getOutgoingEdges(int index);
  /**
   * <code>repeated .lh_proto.EdgePb outgoing_edges = 1;</code>
   */
  int getOutgoingEdgesCount();
  /**
   * <code>repeated .lh_proto.EdgePb outgoing_edges = 1;</code>
   */
  java.util.List<? extends io.littlehorse.common.proto.EdgePbOrBuilder> 
      getOutgoingEdgesOrBuilderList();
  /**
   * <code>repeated .lh_proto.EdgePb outgoing_edges = 1;</code>
   */
  io.littlehorse.common.proto.EdgePbOrBuilder getOutgoingEdgesOrBuilder(
      int index);

  /**
   * <code>repeated .lh_proto.VariableMutationPb variable_mutations = 2;</code>
   */
  java.util.List<io.littlehorse.common.proto.VariableMutationPb> 
      getVariableMutationsList();
  /**
   * <code>repeated .lh_proto.VariableMutationPb variable_mutations = 2;</code>
   */
  io.littlehorse.common.proto.VariableMutationPb getVariableMutations(int index);
  /**
   * <code>repeated .lh_proto.VariableMutationPb variable_mutations = 2;</code>
   */
  int getVariableMutationsCount();
  /**
   * <code>repeated .lh_proto.VariableMutationPb variable_mutations = 2;</code>
   */
  java.util.List<? extends io.littlehorse.common.proto.VariableMutationPbOrBuilder> 
      getVariableMutationsOrBuilderList();
  /**
   * <code>repeated .lh_proto.VariableMutationPb variable_mutations = 2;</code>
   */
  io.littlehorse.common.proto.VariableMutationPbOrBuilder getVariableMutationsOrBuilder(
      int index);

  /**
   * <code>.lh_proto.OutputSchemaPb output_schema = 3;</code>
   * @return Whether the outputSchema field is set.
   */
  boolean hasOutputSchema();
  /**
   * <code>.lh_proto.OutputSchemaPb output_schema = 3;</code>
   * @return The outputSchema.
   */
  io.littlehorse.common.proto.OutputSchemaPb getOutputSchema();
  /**
   * <code>.lh_proto.OutputSchemaPb output_schema = 3;</code>
   */
  io.littlehorse.common.proto.OutputSchemaPbOrBuilder getOutputSchemaOrBuilder();

  /**
   * <code>.lh_proto.EntrypointNodePb entrypoint = 5;</code>
   * @return Whether the entrypoint field is set.
   */
  boolean hasEntrypoint();
  /**
   * <code>.lh_proto.EntrypointNodePb entrypoint = 5;</code>
   * @return The entrypoint.
   */
  io.littlehorse.common.proto.EntrypointNodePb getEntrypoint();
  /**
   * <code>.lh_proto.EntrypointNodePb entrypoint = 5;</code>
   */
  io.littlehorse.common.proto.EntrypointNodePbOrBuilder getEntrypointOrBuilder();

  /**
   * <code>.lh_proto.ExitNodePb exit = 6;</code>
   * @return Whether the exit field is set.
   */
  boolean hasExit();
  /**
   * <code>.lh_proto.ExitNodePb exit = 6;</code>
   * @return The exit.
   */
  io.littlehorse.common.proto.ExitNodePb getExit();
  /**
   * <code>.lh_proto.ExitNodePb exit = 6;</code>
   */
  io.littlehorse.common.proto.ExitNodePbOrBuilder getExitOrBuilder();

  /**
   * <code>.lh_proto.TaskNodePb task = 7;</code>
   * @return Whether the task field is set.
   */
  boolean hasTask();
  /**
   * <code>.lh_proto.TaskNodePb task = 7;</code>
   * @return The task.
   */
  io.littlehorse.common.proto.TaskNodePb getTask();
  /**
   * <code>.lh_proto.TaskNodePb task = 7;</code>
   */
  io.littlehorse.common.proto.TaskNodePbOrBuilder getTaskOrBuilder();

  /**
   * <code>.lh_proto.ExternalEventNodePb external_event = 8;</code>
   * @return Whether the externalEvent field is set.
   */
  boolean hasExternalEvent();
  /**
   * <code>.lh_proto.ExternalEventNodePb external_event = 8;</code>
   * @return The externalEvent.
   */
  io.littlehorse.common.proto.ExternalEventNodePb getExternalEvent();
  /**
   * <code>.lh_proto.ExternalEventNodePb external_event = 8;</code>
   */
  io.littlehorse.common.proto.ExternalEventNodePbOrBuilder getExternalEventOrBuilder();

  /**
   * <code>.lh_proto.StartThreadNodePb start_thread = 9;</code>
   * @return Whether the startThread field is set.
   */
  boolean hasStartThread();
  /**
   * <code>.lh_proto.StartThreadNodePb start_thread = 9;</code>
   * @return The startThread.
   */
  io.littlehorse.common.proto.StartThreadNodePb getStartThread();
  /**
   * <code>.lh_proto.StartThreadNodePb start_thread = 9;</code>
   */
  io.littlehorse.common.proto.StartThreadNodePbOrBuilder getStartThreadOrBuilder();

  /**
   * <code>.lh_proto.WaitForThreadNodePb wait_for_thread = 10;</code>
   * @return Whether the waitForThread field is set.
   */
  boolean hasWaitForThread();
  /**
   * <code>.lh_proto.WaitForThreadNodePb wait_for_thread = 10;</code>
   * @return The waitForThread.
   */
  io.littlehorse.common.proto.WaitForThreadNodePb getWaitForThread();
  /**
   * <code>.lh_proto.WaitForThreadNodePb wait_for_thread = 10;</code>
   */
  io.littlehorse.common.proto.WaitForThreadNodePbOrBuilder getWaitForThreadOrBuilder();

  /**
   * <code>repeated .lh_proto.ExceptionHandlerPb exception_handlers = 11;</code>
   */
  java.util.List<io.littlehorse.common.proto.ExceptionHandlerPb> 
      getExceptionHandlersList();
  /**
   * <code>repeated .lh_proto.ExceptionHandlerPb exception_handlers = 11;</code>
   */
  io.littlehorse.common.proto.ExceptionHandlerPb getExceptionHandlers(int index);
  /**
   * <code>repeated .lh_proto.ExceptionHandlerPb exception_handlers = 11;</code>
   */
  int getExceptionHandlersCount();
  /**
   * <code>repeated .lh_proto.ExceptionHandlerPb exception_handlers = 11;</code>
   */
  java.util.List<? extends io.littlehorse.common.proto.ExceptionHandlerPbOrBuilder> 
      getExceptionHandlersOrBuilderList();
  /**
   * <code>repeated .lh_proto.ExceptionHandlerPb exception_handlers = 11;</code>
   */
  io.littlehorse.common.proto.ExceptionHandlerPbOrBuilder getExceptionHandlersOrBuilder(
      int index);

  public io.littlehorse.common.proto.NodePb.NodeCase getNodeCase();
}

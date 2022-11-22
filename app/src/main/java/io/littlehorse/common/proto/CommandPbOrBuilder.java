// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: command.proto

package io.littlehorse.common.proto;

public interface CommandPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.CommandPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.Timestamp time = 1;</code>
   * @return Whether the time field is set.
   */
  boolean hasTime();
  /**
   * <code>.google.protobuf.Timestamp time = 1;</code>
   * @return The time.
   */
  com.google.protobuf.Timestamp getTime();
  /**
   * <code>.google.protobuf.Timestamp time = 1;</code>
   */
  com.google.protobuf.TimestampOrBuilder getTimeOrBuilder();

  /**
   * <code>string command_id = 2;</code>
   * @return Whether the commandId field is set.
   */
  boolean hasCommandId();
  /**
   * <code>string command_id = 2;</code>
   * @return The commandId.
   */
  java.lang.String getCommandId();
  /**
   * <code>string command_id = 2;</code>
   * @return The bytes for commandId.
   */
  com.google.protobuf.ByteString
      getCommandIdBytes();

  /**
   * <code>.lh_proto.TaskResultEventPb task_result_event = 3;</code>
   * @return Whether the taskResultEvent field is set.
   */
  boolean hasTaskResultEvent();
  /**
   * <code>.lh_proto.TaskResultEventPb task_result_event = 3;</code>
   * @return The taskResultEvent.
   */
  io.littlehorse.common.proto.TaskResultEventPb getTaskResultEvent();
  /**
   * <code>.lh_proto.TaskResultEventPb task_result_event = 3;</code>
   */
  io.littlehorse.common.proto.TaskResultEventPbOrBuilder getTaskResultEventOrBuilder();

  /**
   * <code>.lh_proto.TaskStartedEventPb task_started_event = 4;</code>
   * @return Whether the taskStartedEvent field is set.
   */
  boolean hasTaskStartedEvent();
  /**
   * <code>.lh_proto.TaskStartedEventPb task_started_event = 4;</code>
   * @return The taskStartedEvent.
   */
  io.littlehorse.common.proto.TaskStartedEventPb getTaskStartedEvent();
  /**
   * <code>.lh_proto.TaskStartedEventPb task_started_event = 4;</code>
   */
  io.littlehorse.common.proto.TaskStartedEventPbOrBuilder getTaskStartedEventOrBuilder();

  /**
   * <code>.lh_proto.PutWfSpecPb put_wf_spec = 6;</code>
   * @return Whether the putWfSpec field is set.
   */
  boolean hasPutWfSpec();
  /**
   * <code>.lh_proto.PutWfSpecPb put_wf_spec = 6;</code>
   * @return The putWfSpec.
   */
  io.littlehorse.common.proto.PutWfSpecPb getPutWfSpec();
  /**
   * <code>.lh_proto.PutWfSpecPb put_wf_spec = 6;</code>
   */
  io.littlehorse.common.proto.PutWfSpecPbOrBuilder getPutWfSpecOrBuilder();

  /**
   * <code>.lh_proto.PutTaskDefPb put_task_def = 7;</code>
   * @return Whether the putTaskDef field is set.
   */
  boolean hasPutTaskDef();
  /**
   * <code>.lh_proto.PutTaskDefPb put_task_def = 7;</code>
   * @return The putTaskDef.
   */
  io.littlehorse.common.proto.PutTaskDefPb getPutTaskDef();
  /**
   * <code>.lh_proto.PutTaskDefPb put_task_def = 7;</code>
   */
  io.littlehorse.common.proto.PutTaskDefPbOrBuilder getPutTaskDefOrBuilder();

  /**
   * <code>.lh_proto.PutExternalEventDefPb put_external_event_def = 8;</code>
   * @return Whether the putExternalEventDef field is set.
   */
  boolean hasPutExternalEventDef();
  /**
   * <code>.lh_proto.PutExternalEventDefPb put_external_event_def = 8;</code>
   * @return The putExternalEventDef.
   */
  io.littlehorse.common.proto.PutExternalEventDefPb getPutExternalEventDef();
  /**
   * <code>.lh_proto.PutExternalEventDefPb put_external_event_def = 8;</code>
   */
  io.littlehorse.common.proto.PutExternalEventDefPbOrBuilder getPutExternalEventDefOrBuilder();

  /**
   * <code>.lh_proto.RunWfPb run_wf = 9;</code>
   * @return Whether the runWf field is set.
   */
  boolean hasRunWf();
  /**
   * <code>.lh_proto.RunWfPb run_wf = 9;</code>
   * @return The runWf.
   */
  io.littlehorse.common.proto.RunWfPb getRunWf();
  /**
   * <code>.lh_proto.RunWfPb run_wf = 9;</code>
   */
  io.littlehorse.common.proto.RunWfPbOrBuilder getRunWfOrBuilder();

  /**
   * <code>.lh_proto.PutExternalEventPb put_external_event = 10;</code>
   * @return Whether the putExternalEvent field is set.
   */
  boolean hasPutExternalEvent();
  /**
   * <code>.lh_proto.PutExternalEventPb put_external_event = 10;</code>
   * @return The putExternalEvent.
   */
  io.littlehorse.common.proto.PutExternalEventPb getPutExternalEvent();
  /**
   * <code>.lh_proto.PutExternalEventPb put_external_event = 10;</code>
   */
  io.littlehorse.common.proto.PutExternalEventPbOrBuilder getPutExternalEventOrBuilder();

  public io.littlehorse.common.proto.CommandPb.CommandCase getCommandCase();
}

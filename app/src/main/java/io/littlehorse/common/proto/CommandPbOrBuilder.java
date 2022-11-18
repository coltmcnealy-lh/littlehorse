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
   * <code>.lh_proto.TaskStartedEventPb task_start_event = 4;</code>
   * @return Whether the taskStartEvent field is set.
   */
  boolean hasTaskStartEvent();
  /**
   * <code>.lh_proto.TaskStartedEventPb task_start_event = 4;</code>
   * @return The taskStartEvent.
   */
  io.littlehorse.common.proto.TaskStartedEventPb getTaskStartEvent();
  /**
   * <code>.lh_proto.TaskStartedEventPb task_start_event = 4;</code>
   */
  io.littlehorse.common.proto.TaskStartedEventPbOrBuilder getTaskStartEventOrBuilder();

  /**
   * <code>.lh_proto.ExternalEventPb external_event = 5;</code>
   * @return Whether the externalEvent field is set.
   */
  boolean hasExternalEvent();
  /**
   * <code>.lh_proto.ExternalEventPb external_event = 5;</code>
   * @return The externalEvent.
   */
  io.littlehorse.common.proto.ExternalEventPb getExternalEvent();
  /**
   * <code>.lh_proto.ExternalEventPb external_event = 5;</code>
   */
  io.littlehorse.common.proto.ExternalEventPbOrBuilder getExternalEventOrBuilder();

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
   * <code>.lh_proto.PutExternalEventDefPb put_external_event = 8;</code>
   * @return Whether the putExternalEvent field is set.
   */
  boolean hasPutExternalEvent();
  /**
   * <code>.lh_proto.PutExternalEventDefPb put_external_event = 8;</code>
   * @return The putExternalEvent.
   */
  io.littlehorse.common.proto.PutExternalEventDefPb getPutExternalEvent();
  /**
   * <code>.lh_proto.PutExternalEventDefPb put_external_event = 8;</code>
   */
  io.littlehorse.common.proto.PutExternalEventDefPbOrBuilder getPutExternalEventOrBuilder();

  /**
   * <code>.lh_proto.WfRunRequestPb wf_run_request = 9;</code>
   * @return Whether the wfRunRequest field is set.
   */
  boolean hasWfRunRequest();
  /**
   * <code>.lh_proto.WfRunRequestPb wf_run_request = 9;</code>
   * @return The wfRunRequest.
   */
  io.littlehorse.common.proto.WfRunRequestPb getWfRunRequest();
  /**
   * <code>.lh_proto.WfRunRequestPb wf_run_request = 9;</code>
   */
  io.littlehorse.common.proto.WfRunRequestPbOrBuilder getWfRunRequestOrBuilder();

  public io.littlehorse.common.proto.CommandPb.PayloadCase getPayloadCase();
}

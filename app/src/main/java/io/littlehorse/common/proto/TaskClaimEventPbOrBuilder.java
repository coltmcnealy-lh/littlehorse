// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_server.proto

package io.littlehorse.common.proto;

public interface TaskClaimEventPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.TaskClaimEventPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string wf_run_id = 1;</code>
   * @return The wfRunId.
   */
  java.lang.String getWfRunId();
  /**
   * <code>string wf_run_id = 1;</code>
   * @return The bytes for wfRunId.
   */
  com.google.protobuf.ByteString
      getWfRunIdBytes();

  /**
   * <code>int32 thread_run_number = 2;</code>
   * @return The threadRunNumber.
   */
  int getThreadRunNumber();

  /**
   * <code>int32 task_run_number = 3;</code>
   * @return The taskRunNumber.
   */
  int getTaskRunNumber();

  /**
   * <code>int32 task_run_position = 4;</code>
   * @return The taskRunPosition.
   */
  int getTaskRunPosition();

  /**
   * <code>.google.protobuf.Timestamp time = 5;</code>
   * @return Whether the time field is set.
   */
  boolean hasTime();
  /**
   * <code>.google.protobuf.Timestamp time = 5;</code>
   * @return The time.
   */
  com.google.protobuf.Timestamp getTime();
  /**
   * <code>.google.protobuf.Timestamp time = 5;</code>
   */
  com.google.protobuf.TimestampOrBuilder getTimeOrBuilder();

  /**
   * <code>string task_worker_version = 6;</code>
   * @return Whether the taskWorkerVersion field is set.
   */
  boolean hasTaskWorkerVersion();
  /**
   * <code>string task_worker_version = 6;</code>
   * @return The taskWorkerVersion.
   */
  java.lang.String getTaskWorkerVersion();
  /**
   * <code>string task_worker_version = 6;</code>
   * @return The bytes for taskWorkerVersion.
   */
  com.google.protobuf.ByteString
      getTaskWorkerVersionBytes();
}

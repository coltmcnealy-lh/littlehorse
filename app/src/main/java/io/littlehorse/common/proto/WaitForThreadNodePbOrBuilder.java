// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wf_spec.proto

package io.littlehorse.common.proto;

public interface WaitForThreadNodePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.WaitForThreadNodePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
   * @return Whether the threadRunNumber field is set.
   */
  boolean hasThreadRunNumber();
  /**
   * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
   * @return The threadRunNumber.
   */
  io.littlehorse.common.proto.VariableAssignmentPb getThreadRunNumber();
  /**
   * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
   */
  io.littlehorse.common.proto.VariableAssignmentPbOrBuilder getThreadRunNumberOrBuilder();

  /**
   * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
   * @return Whether the timeoutSeconds field is set.
   */
  boolean hasTimeoutSeconds();
  /**
   * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
   * @return The timeoutSeconds.
   */
  io.littlehorse.common.proto.VariableAssignmentPb getTimeoutSeconds();
  /**
   * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
   */
  io.littlehorse.common.proto.VariableAssignmentPbOrBuilder getTimeoutSecondsOrBuilder();
}

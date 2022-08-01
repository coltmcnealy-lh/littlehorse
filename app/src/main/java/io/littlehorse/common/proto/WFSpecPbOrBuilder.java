// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wf_spec.proto

package io.littlehorse.common.proto;

public interface WFSpecPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.WFSpecPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   * @return Whether the createdAt field is set.
   */
  boolean hasCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   * @return The createdAt.
   */
  com.google.protobuf.Timestamp getCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp updated_at = 3;</code>
   * @return Whether the updatedAt field is set.
   */
  boolean hasUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 3;</code>
   * @return The updatedAt.
   */
  com.google.protobuf.Timestamp getUpdatedAt();
  /**
   * <code>.google.protobuf.Timestamp updated_at = 3;</code>
   */
  com.google.protobuf.TimestampOrBuilder getUpdatedAtOrBuilder();

  /**
   * <code>map&lt;string, .lh_proto.ThreadSpecPb&gt; thread_specs = 4;</code>
   */
  int getThreadSpecsCount();
  /**
   * <code>map&lt;string, .lh_proto.ThreadSpecPb&gt; thread_specs = 4;</code>
   */
  boolean containsThreadSpecs(
      java.lang.String key);
  /**
   * Use {@link #getThreadSpecsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, io.littlehorse.common.proto.ThreadSpecPb>
  getThreadSpecs();
  /**
   * <code>map&lt;string, .lh_proto.ThreadSpecPb&gt; thread_specs = 4;</code>
   */
  java.util.Map<java.lang.String, io.littlehorse.common.proto.ThreadSpecPb>
  getThreadSpecsMap();
  /**
   * <code>map&lt;string, .lh_proto.ThreadSpecPb&gt; thread_specs = 4;</code>
   */

  io.littlehorse.common.proto.ThreadSpecPb getThreadSpecsOrDefault(
      java.lang.String key,
      io.littlehorse.common.proto.ThreadSpecPb defaultValue);
  /**
   * <code>map&lt;string, .lh_proto.ThreadSpecPb&gt; thread_specs = 4;</code>
   */

  io.littlehorse.common.proto.ThreadSpecPb getThreadSpecsOrThrow(
      java.lang.String key);

  /**
   * <code>string entrypoint_thread_name = 5;</code>
   * @return The entrypointThreadName.
   */
  java.lang.String getEntrypointThreadName();
  /**
   * <code>string entrypoint_thread_name = 5;</code>
   * @return The bytes for entrypointThreadName.
   */
  com.google.protobuf.ByteString
      getEntrypointThreadNameBytes();

  /**
   * <code>.lh_proto.LHStatusPb status = 6;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.lh_proto.LHStatusPb status = 6;</code>
   * @return The status.
   */
  io.littlehorse.common.proto.LHStatusPb getStatus();

  /**
   * <code>string name = 7;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 7;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int64 last_updated_offset = 8;</code>
   * @return The lastUpdatedOffset.
   */
  long getLastUpdatedOffset();
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_server.proto

package io.littlehorse.common.proto;

public interface CentralStoreQueryReplyPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.CentralStoreQueryReplyPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.littlehorse.StoreQueryStatusPb code = 1;</code>
   * @return The enum numeric value on the wire for code.
   */
  int getCodeValue();
  /**
   * <code>.littlehorse.StoreQueryStatusPb code = 1;</code>
   * @return The code.
   */
  io.littlehorse.common.proto.StoreQueryStatusPb getCode();

  /**
   * <code>bytes result = 2;</code>
   * @return Whether the result field is set.
   */
  boolean hasResult();
  /**
   * <code>bytes result = 2;</code>
   * @return The result.
   */
  com.google.protobuf.ByteString getResult();

  /**
   * <code>int64 approximate_lag = 3;</code>
   * @return The approximateLag.
   */
  long getApproximateLag();
}

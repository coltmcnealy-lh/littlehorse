// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tags.proto

package io.littlehorse.common.proto;

public interface TagPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.TagPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.lh_proto.IndexKeyPb key = 1;</code>
   * @return Whether the key field is set.
   */
  boolean hasKey();
  /**
   * <code>.lh_proto.IndexKeyPb key = 1;</code>
   * @return The key.
   */
  io.littlehorse.common.proto.IndexKeyPb getKey();
  /**
   * <code>.lh_proto.IndexKeyPb key = 1;</code>
   */
  io.littlehorse.common.proto.IndexKeyPbOrBuilder getKeyOrBuilder();

  /**
   * <code>string store_key = 2;</code>
   * @return The storeKey.
   */
  java.lang.String getStoreKey();
  /**
   * <code>string store_key = 2;</code>
   * @return The bytes for storeKey.
   */
  com.google.protobuf.ByteString
      getStoreKeyBytes();
}

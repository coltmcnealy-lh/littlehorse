// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.jlib.common.proto;

public interface SearchWfSpecPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.SearchWfSpecPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional bytes bookmark = 1;</code>
   * @return Whether the bookmark field is set.
   */
  boolean hasBookmark();
  /**
   * <code>optional bytes bookmark = 1;</code>
   * @return The bookmark.
   */
  com.google.protobuf.ByteString getBookmark();

  /**
   * <code>optional int32 limit = 2;</code>
   * @return Whether the limit field is set.
   */
  boolean hasLimit();
  /**
   * <code>optional int32 limit = 2;</code>
   * @return The limit.
   */
  int getLimit();

  /**
   * <code>optional string name = 3;</code>
   * @return Whether the name field is set.
   */
  boolean hasName();
  /**
   * <code>optional string name = 3;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>optional string name = 3;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>optional string prefix = 4;</code>
   * @return Whether the prefix field is set.
   */
  boolean hasPrefix();
  /**
   * <code>optional string prefix = 4;</code>
   * @return The prefix.
   */
  java.lang.String getPrefix();
  /**
   * <code>optional string prefix = 4;</code>
   * @return The bytes for prefix.
   */
  com.google.protobuf.ByteString
      getPrefixBytes();

  /**
   * <code>optional string task_def_name = 5;</code>
   * @return Whether the taskDefName field is set.
   */
  boolean hasTaskDefName();
  /**
   * <code>optional string task_def_name = 5;</code>
   * @return The taskDefName.
   */
  java.lang.String getTaskDefName();
  /**
   * <code>optional string task_def_name = 5;</code>
   * @return The bytes for taskDefName.
   */
  com.google.protobuf.ByteString
      getTaskDefNameBytes();
}

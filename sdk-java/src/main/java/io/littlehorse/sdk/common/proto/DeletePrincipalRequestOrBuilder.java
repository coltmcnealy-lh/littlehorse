// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: acls.proto

package io.littlehorse.sdk.common.proto;

public interface DeletePrincipalRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.DeletePrincipalRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The ID of the `Principal` to delete.
   * </pre>
   *
   * <code>.littlehorse.PrincipalId id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <pre>
   * The ID of the `Principal` to delete.
   * </pre>
   *
   * <code>.littlehorse.PrincipalId id = 1;</code>
   * @return The id.
   */
  io.littlehorse.sdk.common.proto.PrincipalId getId();
  /**
   * <pre>
   * The ID of the `Principal` to delete.
   * </pre>
   *
   * <code>.littlehorse.PrincipalId id = 1;</code>
   */
  io.littlehorse.sdk.common.proto.PrincipalIdOrBuilder getIdOrBuilder();
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wf_spec.proto

package io.littlehorse.common.proto;

/**
 * Protobuf type {@code lh_proto.WaitForThreadNodePb}
 */
public final class WaitForThreadNodePb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lh_proto.WaitForThreadNodePb)
    WaitForThreadNodePbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WaitForThreadNodePb.newBuilder() to construct.
  private WaitForThreadNodePb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WaitForThreadNodePb() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new WaitForThreadNodePb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WaitForThreadNodePb(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            io.littlehorse.common.proto.VariableAssignmentPb.Builder subBuilder = null;
            if (threadRunNumber_ != null) {
              subBuilder = threadRunNumber_.toBuilder();
            }
            threadRunNumber_ = input.readMessage(io.littlehorse.common.proto.VariableAssignmentPb.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(threadRunNumber_);
              threadRunNumber_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            io.littlehorse.common.proto.VariableAssignmentPb.Builder subBuilder = null;
            if (timeoutSeconds_ != null) {
              subBuilder = timeoutSeconds_.toBuilder();
            }
            timeoutSeconds_ = input.readMessage(io.littlehorse.common.proto.VariableAssignmentPb.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(timeoutSeconds_);
              timeoutSeconds_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.littlehorse.common.proto.WfSpec.internal_static_lh_proto_WaitForThreadNodePb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.common.proto.WfSpec.internal_static_lh_proto_WaitForThreadNodePb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.common.proto.WaitForThreadNodePb.class, io.littlehorse.common.proto.WaitForThreadNodePb.Builder.class);
  }

  public static final int THREAD_RUN_NUMBER_FIELD_NUMBER = 1;
  private io.littlehorse.common.proto.VariableAssignmentPb threadRunNumber_;
  /**
   * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
   * @return Whether the threadRunNumber field is set.
   */
  @java.lang.Override
  public boolean hasThreadRunNumber() {
    return threadRunNumber_ != null;
  }
  /**
   * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
   * @return The threadRunNumber.
   */
  @java.lang.Override
  public io.littlehorse.common.proto.VariableAssignmentPb getThreadRunNumber() {
    return threadRunNumber_ == null ? io.littlehorse.common.proto.VariableAssignmentPb.getDefaultInstance() : threadRunNumber_;
  }
  /**
   * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
   */
  @java.lang.Override
  public io.littlehorse.common.proto.VariableAssignmentPbOrBuilder getThreadRunNumberOrBuilder() {
    return getThreadRunNumber();
  }

  public static final int TIMEOUT_SECONDS_FIELD_NUMBER = 2;
  private io.littlehorse.common.proto.VariableAssignmentPb timeoutSeconds_;
  /**
   * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
   * @return Whether the timeoutSeconds field is set.
   */
  @java.lang.Override
  public boolean hasTimeoutSeconds() {
    return timeoutSeconds_ != null;
  }
  /**
   * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
   * @return The timeoutSeconds.
   */
  @java.lang.Override
  public io.littlehorse.common.proto.VariableAssignmentPb getTimeoutSeconds() {
    return timeoutSeconds_ == null ? io.littlehorse.common.proto.VariableAssignmentPb.getDefaultInstance() : timeoutSeconds_;
  }
  /**
   * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
   */
  @java.lang.Override
  public io.littlehorse.common.proto.VariableAssignmentPbOrBuilder getTimeoutSecondsOrBuilder() {
    return getTimeoutSeconds();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (threadRunNumber_ != null) {
      output.writeMessage(1, getThreadRunNumber());
    }
    if (timeoutSeconds_ != null) {
      output.writeMessage(2, getTimeoutSeconds());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (threadRunNumber_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getThreadRunNumber());
    }
    if (timeoutSeconds_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getTimeoutSeconds());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.littlehorse.common.proto.WaitForThreadNodePb)) {
      return super.equals(obj);
    }
    io.littlehorse.common.proto.WaitForThreadNodePb other = (io.littlehorse.common.proto.WaitForThreadNodePb) obj;

    if (hasThreadRunNumber() != other.hasThreadRunNumber()) return false;
    if (hasThreadRunNumber()) {
      if (!getThreadRunNumber()
          .equals(other.getThreadRunNumber())) return false;
    }
    if (hasTimeoutSeconds() != other.hasTimeoutSeconds()) return false;
    if (hasTimeoutSeconds()) {
      if (!getTimeoutSeconds()
          .equals(other.getTimeoutSeconds())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasThreadRunNumber()) {
      hash = (37 * hash) + THREAD_RUN_NUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getThreadRunNumber().hashCode();
    }
    if (hasTimeoutSeconds()) {
      hash = (37 * hash) + TIMEOUT_SECONDS_FIELD_NUMBER;
      hash = (53 * hash) + getTimeoutSeconds().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.common.proto.WaitForThreadNodePb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.WaitForThreadNodePb parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.littlehorse.common.proto.WaitForThreadNodePb prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code lh_proto.WaitForThreadNodePb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lh_proto.WaitForThreadNodePb)
      io.littlehorse.common.proto.WaitForThreadNodePbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.common.proto.WfSpec.internal_static_lh_proto_WaitForThreadNodePb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.common.proto.WfSpec.internal_static_lh_proto_WaitForThreadNodePb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.common.proto.WaitForThreadNodePb.class, io.littlehorse.common.proto.WaitForThreadNodePb.Builder.class);
    }

    // Construct using io.littlehorse.common.proto.WaitForThreadNodePb.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (threadRunNumberBuilder_ == null) {
        threadRunNumber_ = null;
      } else {
        threadRunNumber_ = null;
        threadRunNumberBuilder_ = null;
      }
      if (timeoutSecondsBuilder_ == null) {
        timeoutSeconds_ = null;
      } else {
        timeoutSeconds_ = null;
        timeoutSecondsBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.common.proto.WfSpec.internal_static_lh_proto_WaitForThreadNodePb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.WaitForThreadNodePb getDefaultInstanceForType() {
      return io.littlehorse.common.proto.WaitForThreadNodePb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.common.proto.WaitForThreadNodePb build() {
      io.littlehorse.common.proto.WaitForThreadNodePb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.WaitForThreadNodePb buildPartial() {
      io.littlehorse.common.proto.WaitForThreadNodePb result = new io.littlehorse.common.proto.WaitForThreadNodePb(this);
      if (threadRunNumberBuilder_ == null) {
        result.threadRunNumber_ = threadRunNumber_;
      } else {
        result.threadRunNumber_ = threadRunNumberBuilder_.build();
      }
      if (timeoutSecondsBuilder_ == null) {
        result.timeoutSeconds_ = timeoutSeconds_;
      } else {
        result.timeoutSeconds_ = timeoutSecondsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.littlehorse.common.proto.WaitForThreadNodePb) {
        return mergeFrom((io.littlehorse.common.proto.WaitForThreadNodePb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.common.proto.WaitForThreadNodePb other) {
      if (other == io.littlehorse.common.proto.WaitForThreadNodePb.getDefaultInstance()) return this;
      if (other.hasThreadRunNumber()) {
        mergeThreadRunNumber(other.getThreadRunNumber());
      }
      if (other.hasTimeoutSeconds()) {
        mergeTimeoutSeconds(other.getTimeoutSeconds());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.littlehorse.common.proto.WaitForThreadNodePb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.littlehorse.common.proto.WaitForThreadNodePb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private io.littlehorse.common.proto.VariableAssignmentPb threadRunNumber_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.littlehorse.common.proto.VariableAssignmentPb, io.littlehorse.common.proto.VariableAssignmentPb.Builder, io.littlehorse.common.proto.VariableAssignmentPbOrBuilder> threadRunNumberBuilder_;
    /**
     * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
     * @return Whether the threadRunNumber field is set.
     */
    public boolean hasThreadRunNumber() {
      return threadRunNumberBuilder_ != null || threadRunNumber_ != null;
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
     * @return The threadRunNumber.
     */
    public io.littlehorse.common.proto.VariableAssignmentPb getThreadRunNumber() {
      if (threadRunNumberBuilder_ == null) {
        return threadRunNumber_ == null ? io.littlehorse.common.proto.VariableAssignmentPb.getDefaultInstance() : threadRunNumber_;
      } else {
        return threadRunNumberBuilder_.getMessage();
      }
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
     */
    public Builder setThreadRunNumber(io.littlehorse.common.proto.VariableAssignmentPb value) {
      if (threadRunNumberBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        threadRunNumber_ = value;
        onChanged();
      } else {
        threadRunNumberBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
     */
    public Builder setThreadRunNumber(
        io.littlehorse.common.proto.VariableAssignmentPb.Builder builderForValue) {
      if (threadRunNumberBuilder_ == null) {
        threadRunNumber_ = builderForValue.build();
        onChanged();
      } else {
        threadRunNumberBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
     */
    public Builder mergeThreadRunNumber(io.littlehorse.common.proto.VariableAssignmentPb value) {
      if (threadRunNumberBuilder_ == null) {
        if (threadRunNumber_ != null) {
          threadRunNumber_ =
            io.littlehorse.common.proto.VariableAssignmentPb.newBuilder(threadRunNumber_).mergeFrom(value).buildPartial();
        } else {
          threadRunNumber_ = value;
        }
        onChanged();
      } else {
        threadRunNumberBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
     */
    public Builder clearThreadRunNumber() {
      if (threadRunNumberBuilder_ == null) {
        threadRunNumber_ = null;
        onChanged();
      } else {
        threadRunNumber_ = null;
        threadRunNumberBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
     */
    public io.littlehorse.common.proto.VariableAssignmentPb.Builder getThreadRunNumberBuilder() {
      
      onChanged();
      return getThreadRunNumberFieldBuilder().getBuilder();
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
     */
    public io.littlehorse.common.proto.VariableAssignmentPbOrBuilder getThreadRunNumberOrBuilder() {
      if (threadRunNumberBuilder_ != null) {
        return threadRunNumberBuilder_.getMessageOrBuilder();
      } else {
        return threadRunNumber_ == null ?
            io.littlehorse.common.proto.VariableAssignmentPb.getDefaultInstance() : threadRunNumber_;
      }
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb thread_run_number = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.littlehorse.common.proto.VariableAssignmentPb, io.littlehorse.common.proto.VariableAssignmentPb.Builder, io.littlehorse.common.proto.VariableAssignmentPbOrBuilder> 
        getThreadRunNumberFieldBuilder() {
      if (threadRunNumberBuilder_ == null) {
        threadRunNumberBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.littlehorse.common.proto.VariableAssignmentPb, io.littlehorse.common.proto.VariableAssignmentPb.Builder, io.littlehorse.common.proto.VariableAssignmentPbOrBuilder>(
                getThreadRunNumber(),
                getParentForChildren(),
                isClean());
        threadRunNumber_ = null;
      }
      return threadRunNumberBuilder_;
    }

    private io.littlehorse.common.proto.VariableAssignmentPb timeoutSeconds_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.littlehorse.common.proto.VariableAssignmentPb, io.littlehorse.common.proto.VariableAssignmentPb.Builder, io.littlehorse.common.proto.VariableAssignmentPbOrBuilder> timeoutSecondsBuilder_;
    /**
     * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
     * @return Whether the timeoutSeconds field is set.
     */
    public boolean hasTimeoutSeconds() {
      return timeoutSecondsBuilder_ != null || timeoutSeconds_ != null;
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
     * @return The timeoutSeconds.
     */
    public io.littlehorse.common.proto.VariableAssignmentPb getTimeoutSeconds() {
      if (timeoutSecondsBuilder_ == null) {
        return timeoutSeconds_ == null ? io.littlehorse.common.proto.VariableAssignmentPb.getDefaultInstance() : timeoutSeconds_;
      } else {
        return timeoutSecondsBuilder_.getMessage();
      }
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
     */
    public Builder setTimeoutSeconds(io.littlehorse.common.proto.VariableAssignmentPb value) {
      if (timeoutSecondsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        timeoutSeconds_ = value;
        onChanged();
      } else {
        timeoutSecondsBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
     */
    public Builder setTimeoutSeconds(
        io.littlehorse.common.proto.VariableAssignmentPb.Builder builderForValue) {
      if (timeoutSecondsBuilder_ == null) {
        timeoutSeconds_ = builderForValue.build();
        onChanged();
      } else {
        timeoutSecondsBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
     */
    public Builder mergeTimeoutSeconds(io.littlehorse.common.proto.VariableAssignmentPb value) {
      if (timeoutSecondsBuilder_ == null) {
        if (timeoutSeconds_ != null) {
          timeoutSeconds_ =
            io.littlehorse.common.proto.VariableAssignmentPb.newBuilder(timeoutSeconds_).mergeFrom(value).buildPartial();
        } else {
          timeoutSeconds_ = value;
        }
        onChanged();
      } else {
        timeoutSecondsBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
     */
    public Builder clearTimeoutSeconds() {
      if (timeoutSecondsBuilder_ == null) {
        timeoutSeconds_ = null;
        onChanged();
      } else {
        timeoutSeconds_ = null;
        timeoutSecondsBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
     */
    public io.littlehorse.common.proto.VariableAssignmentPb.Builder getTimeoutSecondsBuilder() {
      
      onChanged();
      return getTimeoutSecondsFieldBuilder().getBuilder();
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
     */
    public io.littlehorse.common.proto.VariableAssignmentPbOrBuilder getTimeoutSecondsOrBuilder() {
      if (timeoutSecondsBuilder_ != null) {
        return timeoutSecondsBuilder_.getMessageOrBuilder();
      } else {
        return timeoutSeconds_ == null ?
            io.littlehorse.common.proto.VariableAssignmentPb.getDefaultInstance() : timeoutSeconds_;
      }
    }
    /**
     * <code>.lh_proto.VariableAssignmentPb timeout_seconds = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.littlehorse.common.proto.VariableAssignmentPb, io.littlehorse.common.proto.VariableAssignmentPb.Builder, io.littlehorse.common.proto.VariableAssignmentPbOrBuilder> 
        getTimeoutSecondsFieldBuilder() {
      if (timeoutSecondsBuilder_ == null) {
        timeoutSecondsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.littlehorse.common.proto.VariableAssignmentPb, io.littlehorse.common.proto.VariableAssignmentPb.Builder, io.littlehorse.common.proto.VariableAssignmentPbOrBuilder>(
                getTimeoutSeconds(),
                getParentForChildren(),
                isClean());
        timeoutSeconds_ = null;
      }
      return timeoutSecondsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:lh_proto.WaitForThreadNodePb)
  }

  // @@protoc_insertion_point(class_scope:lh_proto.WaitForThreadNodePb)
  private static final io.littlehorse.common.proto.WaitForThreadNodePb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.common.proto.WaitForThreadNodePb();
  }

  public static io.littlehorse.common.proto.WaitForThreadNodePb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WaitForThreadNodePb>
      PARSER = new com.google.protobuf.AbstractParser<WaitForThreadNodePb>() {
    @java.lang.Override
    public WaitForThreadNodePb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WaitForThreadNodePb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WaitForThreadNodePb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WaitForThreadNodePb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.common.proto.WaitForThreadNodePb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wf_spec.proto

package io.littlehorse.common.proto;

/**
 * Protobuf type {@code lh_proto.InterruptDefPb}
 */
public final class InterruptDefPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lh_proto.InterruptDefPb)
    InterruptDefPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use InterruptDefPb.newBuilder() to construct.
  private InterruptDefPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private InterruptDefPb() {
    externalEventDefName_ = "";
    handlerSpecName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new InterruptDefPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private InterruptDefPb(
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
            java.lang.String s = input.readStringRequireUtf8();

            externalEventDefName_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            handlerSpecName_ = s;
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
    return io.littlehorse.common.proto.WfSpec.internal_static_lh_proto_InterruptDefPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.common.proto.WfSpec.internal_static_lh_proto_InterruptDefPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.common.proto.InterruptDefPb.class, io.littlehorse.common.proto.InterruptDefPb.Builder.class);
  }

  public static final int EXTERNAL_EVENT_DEF_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object externalEventDefName_;
  /**
   * <code>string external_event_def_name = 1;</code>
   * @return The externalEventDefName.
   */
  @java.lang.Override
  public java.lang.String getExternalEventDefName() {
    java.lang.Object ref = externalEventDefName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      externalEventDefName_ = s;
      return s;
    }
  }
  /**
   * <code>string external_event_def_name = 1;</code>
   * @return The bytes for externalEventDefName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getExternalEventDefNameBytes() {
    java.lang.Object ref = externalEventDefName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      externalEventDefName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HANDLER_SPEC_NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object handlerSpecName_;
  /**
   * <code>string handler_spec_name = 2;</code>
   * @return The handlerSpecName.
   */
  @java.lang.Override
  public java.lang.String getHandlerSpecName() {
    java.lang.Object ref = handlerSpecName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      handlerSpecName_ = s;
      return s;
    }
  }
  /**
   * <code>string handler_spec_name = 2;</code>
   * @return The bytes for handlerSpecName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getHandlerSpecNameBytes() {
    java.lang.Object ref = handlerSpecName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      handlerSpecName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getExternalEventDefNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, externalEventDefName_);
    }
    if (!getHandlerSpecNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, handlerSpecName_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getExternalEventDefNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, externalEventDefName_);
    }
    if (!getHandlerSpecNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, handlerSpecName_);
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
    if (!(obj instanceof io.littlehorse.common.proto.InterruptDefPb)) {
      return super.equals(obj);
    }
    io.littlehorse.common.proto.InterruptDefPb other = (io.littlehorse.common.proto.InterruptDefPb) obj;

    if (!getExternalEventDefName()
        .equals(other.getExternalEventDefName())) return false;
    if (!getHandlerSpecName()
        .equals(other.getHandlerSpecName())) return false;
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
    hash = (37 * hash) + EXTERNAL_EVENT_DEF_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getExternalEventDefName().hashCode();
    hash = (37 * hash) + HANDLER_SPEC_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getHandlerSpecName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.common.proto.InterruptDefPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.InterruptDefPb parseFrom(
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
  public static Builder newBuilder(io.littlehorse.common.proto.InterruptDefPb prototype) {
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
   * Protobuf type {@code lh_proto.InterruptDefPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lh_proto.InterruptDefPb)
      io.littlehorse.common.proto.InterruptDefPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.common.proto.WfSpec.internal_static_lh_proto_InterruptDefPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.common.proto.WfSpec.internal_static_lh_proto_InterruptDefPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.common.proto.InterruptDefPb.class, io.littlehorse.common.proto.InterruptDefPb.Builder.class);
    }

    // Construct using io.littlehorse.common.proto.InterruptDefPb.newBuilder()
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
      externalEventDefName_ = "";

      handlerSpecName_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.common.proto.WfSpec.internal_static_lh_proto_InterruptDefPb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.InterruptDefPb getDefaultInstanceForType() {
      return io.littlehorse.common.proto.InterruptDefPb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.common.proto.InterruptDefPb build() {
      io.littlehorse.common.proto.InterruptDefPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.InterruptDefPb buildPartial() {
      io.littlehorse.common.proto.InterruptDefPb result = new io.littlehorse.common.proto.InterruptDefPb(this);
      result.externalEventDefName_ = externalEventDefName_;
      result.handlerSpecName_ = handlerSpecName_;
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
      if (other instanceof io.littlehorse.common.proto.InterruptDefPb) {
        return mergeFrom((io.littlehorse.common.proto.InterruptDefPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.common.proto.InterruptDefPb other) {
      if (other == io.littlehorse.common.proto.InterruptDefPb.getDefaultInstance()) return this;
      if (!other.getExternalEventDefName().isEmpty()) {
        externalEventDefName_ = other.externalEventDefName_;
        onChanged();
      }
      if (!other.getHandlerSpecName().isEmpty()) {
        handlerSpecName_ = other.handlerSpecName_;
        onChanged();
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
      io.littlehorse.common.proto.InterruptDefPb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.littlehorse.common.proto.InterruptDefPb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object externalEventDefName_ = "";
    /**
     * <code>string external_event_def_name = 1;</code>
     * @return The externalEventDefName.
     */
    public java.lang.String getExternalEventDefName() {
      java.lang.Object ref = externalEventDefName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        externalEventDefName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string external_event_def_name = 1;</code>
     * @return The bytes for externalEventDefName.
     */
    public com.google.protobuf.ByteString
        getExternalEventDefNameBytes() {
      java.lang.Object ref = externalEventDefName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        externalEventDefName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string external_event_def_name = 1;</code>
     * @param value The externalEventDefName to set.
     * @return This builder for chaining.
     */
    public Builder setExternalEventDefName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      externalEventDefName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string external_event_def_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearExternalEventDefName() {
      
      externalEventDefName_ = getDefaultInstance().getExternalEventDefName();
      onChanged();
      return this;
    }
    /**
     * <code>string external_event_def_name = 1;</code>
     * @param value The bytes for externalEventDefName to set.
     * @return This builder for chaining.
     */
    public Builder setExternalEventDefNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      externalEventDefName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object handlerSpecName_ = "";
    /**
     * <code>string handler_spec_name = 2;</code>
     * @return The handlerSpecName.
     */
    public java.lang.String getHandlerSpecName() {
      java.lang.Object ref = handlerSpecName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        handlerSpecName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string handler_spec_name = 2;</code>
     * @return The bytes for handlerSpecName.
     */
    public com.google.protobuf.ByteString
        getHandlerSpecNameBytes() {
      java.lang.Object ref = handlerSpecName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        handlerSpecName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string handler_spec_name = 2;</code>
     * @param value The handlerSpecName to set.
     * @return This builder for chaining.
     */
    public Builder setHandlerSpecName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      handlerSpecName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string handler_spec_name = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearHandlerSpecName() {
      
      handlerSpecName_ = getDefaultInstance().getHandlerSpecName();
      onChanged();
      return this;
    }
    /**
     * <code>string handler_spec_name = 2;</code>
     * @param value The bytes for handlerSpecName to set.
     * @return This builder for chaining.
     */
    public Builder setHandlerSpecNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      handlerSpecName_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:lh_proto.InterruptDefPb)
  }

  // @@protoc_insertion_point(class_scope:lh_proto.InterruptDefPb)
  private static final io.littlehorse.common.proto.InterruptDefPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.common.proto.InterruptDefPb();
  }

  public static io.littlehorse.common.proto.InterruptDefPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<InterruptDefPb>
      PARSER = new com.google.protobuf.AbstractParser<InterruptDefPb>() {
    @java.lang.Override
    public InterruptDefPb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new InterruptDefPb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<InterruptDefPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<InterruptDefPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.common.proto.InterruptDefPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


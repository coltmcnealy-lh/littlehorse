// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wf_run.proto

package io.littlehorse.common.proto;

/**
 * Protobuf type {@code lh_proto.NodeRunStatePb}
 */
public final class NodeRunStatePb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lh_proto.NodeRunStatePb)
    NodeRunStatePbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NodeRunStatePb.newBuilder() to construct.
  private NodeRunStatePb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NodeRunStatePb() {
    nodeName_ = "";
    status_ = 0;
    resultCode_ = 0;
    errorMessage_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new NodeRunStatePb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NodeRunStatePb(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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

            nodeName_ = s;
            break;
          }
          case 16: {

            attemptNumber_ = input.readInt32();
            break;
          }
          case 24: {

            position_ = input.readInt32();
            break;
          }
          case 32: {

            number_ = input.readInt32();
            break;
          }
          case 40: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          case 48: {
            int rawValue = input.readEnum();
            bitField0_ |= 0x00000001;
            resultCode_ = rawValue;
            break;
          }
          case 58: {
            java.lang.String s = input.readStringRequireUtf8();
            bitField0_ |= 0x00000002;
            errorMessage_ = s;
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
    return io.littlehorse.common.proto.WfRun.internal_static_lh_proto_NodeRunStatePb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.common.proto.WfRun.internal_static_lh_proto_NodeRunStatePb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.common.proto.NodeRunStatePb.class, io.littlehorse.common.proto.NodeRunStatePb.Builder.class);
  }

  private int bitField0_;
  public static final int NODE_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object nodeName_;
  /**
   * <code>string node_name = 1;</code>
   * @return The nodeName.
   */
  @java.lang.Override
  public java.lang.String getNodeName() {
    java.lang.Object ref = nodeName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nodeName_ = s;
      return s;
    }
  }
  /**
   * <code>string node_name = 1;</code>
   * @return The bytes for nodeName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNodeNameBytes() {
    java.lang.Object ref = nodeName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nodeName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ATTEMPT_NUMBER_FIELD_NUMBER = 2;
  private int attemptNumber_;
  /**
   * <code>int32 attempt_number = 2;</code>
   * @return The attemptNumber.
   */
  @java.lang.Override
  public int getAttemptNumber() {
    return attemptNumber_;
  }

  public static final int POSITION_FIELD_NUMBER = 3;
  private int position_;
  /**
   * <code>int32 position = 3;</code>
   * @return The position.
   */
  @java.lang.Override
  public int getPosition() {
    return position_;
  }

  public static final int NUMBER_FIELD_NUMBER = 4;
  private int number_;
  /**
   * <code>int32 number = 4;</code>
   * @return The number.
   */
  @java.lang.Override
  public int getNumber() {
    return number_;
  }

  public static final int STATUS_FIELD_NUMBER = 5;
  private int status_;
  /**
   * <code>.lh_proto.LHStatusPb status = 5;</code>
   * @return The enum numeric value on the wire for status.
   */
  @java.lang.Override public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.lh_proto.LHStatusPb status = 5;</code>
   * @return The status.
   */
  @java.lang.Override public io.littlehorse.common.proto.LHStatusPb getStatus() {
    @SuppressWarnings("deprecation")
    io.littlehorse.common.proto.LHStatusPb result = io.littlehorse.common.proto.LHStatusPb.valueOf(status_);
    return result == null ? io.littlehorse.common.proto.LHStatusPb.UNRECOGNIZED : result;
  }

  public static final int RESULT_CODE_FIELD_NUMBER = 6;
  private int resultCode_;
  /**
   * <code>.lh_proto.TaskResultCodePb result_code = 6;</code>
   * @return Whether the resultCode field is set.
   */
  @java.lang.Override public boolean hasResultCode() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.lh_proto.TaskResultCodePb result_code = 6;</code>
   * @return The enum numeric value on the wire for resultCode.
   */
  @java.lang.Override public int getResultCodeValue() {
    return resultCode_;
  }
  /**
   * <code>.lh_proto.TaskResultCodePb result_code = 6;</code>
   * @return The resultCode.
   */
  @java.lang.Override public io.littlehorse.common.proto.TaskResultCodePb getResultCode() {
    @SuppressWarnings("deprecation")
    io.littlehorse.common.proto.TaskResultCodePb result = io.littlehorse.common.proto.TaskResultCodePb.valueOf(resultCode_);
    return result == null ? io.littlehorse.common.proto.TaskResultCodePb.UNRECOGNIZED : result;
  }

  public static final int ERROR_MESSAGE_FIELD_NUMBER = 7;
  private volatile java.lang.Object errorMessage_;
  /**
   * <code>string error_message = 7;</code>
   * @return Whether the errorMessage field is set.
   */
  @java.lang.Override
  public boolean hasErrorMessage() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>string error_message = 7;</code>
   * @return The errorMessage.
   */
  @java.lang.Override
  public java.lang.String getErrorMessage() {
    java.lang.Object ref = errorMessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      errorMessage_ = s;
      return s;
    }
  }
  /**
   * <code>string error_message = 7;</code>
   * @return The bytes for errorMessage.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getErrorMessageBytes() {
    java.lang.Object ref = errorMessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      errorMessage_ = b;
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
    if (!getNodeNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, nodeName_);
    }
    if (attemptNumber_ != 0) {
      output.writeInt32(2, attemptNumber_);
    }
    if (position_ != 0) {
      output.writeInt32(3, position_);
    }
    if (number_ != 0) {
      output.writeInt32(4, number_);
    }
    if (status_ != io.littlehorse.common.proto.LHStatusPb.STARTING.getNumber()) {
      output.writeEnum(5, status_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeEnum(6, resultCode_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 7, errorMessage_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNodeNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, nodeName_);
    }
    if (attemptNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, attemptNumber_);
    }
    if (position_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, position_);
    }
    if (number_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, number_);
    }
    if (status_ != io.littlehorse.common.proto.LHStatusPb.STARTING.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, status_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(6, resultCode_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, errorMessage_);
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
    if (!(obj instanceof io.littlehorse.common.proto.NodeRunStatePb)) {
      return super.equals(obj);
    }
    io.littlehorse.common.proto.NodeRunStatePb other = (io.littlehorse.common.proto.NodeRunStatePb) obj;

    if (!getNodeName()
        .equals(other.getNodeName())) return false;
    if (getAttemptNumber()
        != other.getAttemptNumber()) return false;
    if (getPosition()
        != other.getPosition()) return false;
    if (getNumber()
        != other.getNumber()) return false;
    if (status_ != other.status_) return false;
    if (hasResultCode() != other.hasResultCode()) return false;
    if (hasResultCode()) {
      if (resultCode_ != other.resultCode_) return false;
    }
    if (hasErrorMessage() != other.hasErrorMessage()) return false;
    if (hasErrorMessage()) {
      if (!getErrorMessage()
          .equals(other.getErrorMessage())) return false;
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
    hash = (37 * hash) + NODE_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getNodeName().hashCode();
    hash = (37 * hash) + ATTEMPT_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getAttemptNumber();
    hash = (37 * hash) + POSITION_FIELD_NUMBER;
    hash = (53 * hash) + getPosition();
    hash = (37 * hash) + NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getNumber();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    if (hasResultCode()) {
      hash = (37 * hash) + RESULT_CODE_FIELD_NUMBER;
      hash = (53 * hash) + resultCode_;
    }
    if (hasErrorMessage()) {
      hash = (37 * hash) + ERROR_MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getErrorMessage().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.common.proto.NodeRunStatePb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.NodeRunStatePb parseFrom(
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
  public static Builder newBuilder(io.littlehorse.common.proto.NodeRunStatePb prototype) {
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
   * Protobuf type {@code lh_proto.NodeRunStatePb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lh_proto.NodeRunStatePb)
      io.littlehorse.common.proto.NodeRunStatePbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.common.proto.WfRun.internal_static_lh_proto_NodeRunStatePb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.common.proto.WfRun.internal_static_lh_proto_NodeRunStatePb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.common.proto.NodeRunStatePb.class, io.littlehorse.common.proto.NodeRunStatePb.Builder.class);
    }

    // Construct using io.littlehorse.common.proto.NodeRunStatePb.newBuilder()
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
      nodeName_ = "";

      attemptNumber_ = 0;

      position_ = 0;

      number_ = 0;

      status_ = 0;

      resultCode_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      errorMessage_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.common.proto.WfRun.internal_static_lh_proto_NodeRunStatePb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.NodeRunStatePb getDefaultInstanceForType() {
      return io.littlehorse.common.proto.NodeRunStatePb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.common.proto.NodeRunStatePb build() {
      io.littlehorse.common.proto.NodeRunStatePb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.NodeRunStatePb buildPartial() {
      io.littlehorse.common.proto.NodeRunStatePb result = new io.littlehorse.common.proto.NodeRunStatePb(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.nodeName_ = nodeName_;
      result.attemptNumber_ = attemptNumber_;
      result.position_ = position_;
      result.number_ = number_;
      result.status_ = status_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        to_bitField0_ |= 0x00000001;
      }
      result.resultCode_ = resultCode_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        to_bitField0_ |= 0x00000002;
      }
      result.errorMessage_ = errorMessage_;
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof io.littlehorse.common.proto.NodeRunStatePb) {
        return mergeFrom((io.littlehorse.common.proto.NodeRunStatePb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.common.proto.NodeRunStatePb other) {
      if (other == io.littlehorse.common.proto.NodeRunStatePb.getDefaultInstance()) return this;
      if (!other.getNodeName().isEmpty()) {
        nodeName_ = other.nodeName_;
        onChanged();
      }
      if (other.getAttemptNumber() != 0) {
        setAttemptNumber(other.getAttemptNumber());
      }
      if (other.getPosition() != 0) {
        setPosition(other.getPosition());
      }
      if (other.getNumber() != 0) {
        setNumber(other.getNumber());
      }
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (other.hasResultCode()) {
        setResultCode(other.getResultCode());
      }
      if (other.hasErrorMessage()) {
        bitField0_ |= 0x00000002;
        errorMessage_ = other.errorMessage_;
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
      io.littlehorse.common.proto.NodeRunStatePb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.littlehorse.common.proto.NodeRunStatePb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object nodeName_ = "";
    /**
     * <code>string node_name = 1;</code>
     * @return The nodeName.
     */
    public java.lang.String getNodeName() {
      java.lang.Object ref = nodeName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nodeName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string node_name = 1;</code>
     * @return The bytes for nodeName.
     */
    public com.google.protobuf.ByteString
        getNodeNameBytes() {
      java.lang.Object ref = nodeName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nodeName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string node_name = 1;</code>
     * @param value The nodeName to set.
     * @return This builder for chaining.
     */
    public Builder setNodeName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nodeName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string node_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNodeName() {
      
      nodeName_ = getDefaultInstance().getNodeName();
      onChanged();
      return this;
    }
    /**
     * <code>string node_name = 1;</code>
     * @param value The bytes for nodeName to set.
     * @return This builder for chaining.
     */
    public Builder setNodeNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nodeName_ = value;
      onChanged();
      return this;
    }

    private int attemptNumber_ ;
    /**
     * <code>int32 attempt_number = 2;</code>
     * @return The attemptNumber.
     */
    @java.lang.Override
    public int getAttemptNumber() {
      return attemptNumber_;
    }
    /**
     * <code>int32 attempt_number = 2;</code>
     * @param value The attemptNumber to set.
     * @return This builder for chaining.
     */
    public Builder setAttemptNumber(int value) {
      
      attemptNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 attempt_number = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAttemptNumber() {
      
      attemptNumber_ = 0;
      onChanged();
      return this;
    }

    private int position_ ;
    /**
     * <code>int32 position = 3;</code>
     * @return The position.
     */
    @java.lang.Override
    public int getPosition() {
      return position_;
    }
    /**
     * <code>int32 position = 3;</code>
     * @param value The position to set.
     * @return This builder for chaining.
     */
    public Builder setPosition(int value) {
      
      position_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 position = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPosition() {
      
      position_ = 0;
      onChanged();
      return this;
    }

    private int number_ ;
    /**
     * <code>int32 number = 4;</code>
     * @return The number.
     */
    @java.lang.Override
    public int getNumber() {
      return number_;
    }
    /**
     * <code>int32 number = 4;</code>
     * @param value The number to set.
     * @return This builder for chaining.
     */
    public Builder setNumber(int value) {
      
      number_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 number = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumber() {
      
      number_ = 0;
      onChanged();
      return this;
    }

    private int status_ = 0;
    /**
     * <code>.lh_proto.LHStatusPb status = 5;</code>
     * @return The enum numeric value on the wire for status.
     */
    @java.lang.Override public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.lh_proto.LHStatusPb status = 5;</code>
     * @param value The enum numeric value on the wire for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusValue(int value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.LHStatusPb status = 5;</code>
     * @return The status.
     */
    @java.lang.Override
    public io.littlehorse.common.proto.LHStatusPb getStatus() {
      @SuppressWarnings("deprecation")
      io.littlehorse.common.proto.LHStatusPb result = io.littlehorse.common.proto.LHStatusPb.valueOf(status_);
      return result == null ? io.littlehorse.common.proto.LHStatusPb.UNRECOGNIZED : result;
    }
    /**
     * <code>.lh_proto.LHStatusPb status = 5;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(io.littlehorse.common.proto.LHStatusPb value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.LHStatusPb status = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private int resultCode_ = 0;
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 6;</code>
     * @return Whether the resultCode field is set.
     */
    @java.lang.Override public boolean hasResultCode() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 6;</code>
     * @return The enum numeric value on the wire for resultCode.
     */
    @java.lang.Override public int getResultCodeValue() {
      return resultCode_;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 6;</code>
     * @param value The enum numeric value on the wire for resultCode to set.
     * @return This builder for chaining.
     */
    public Builder setResultCodeValue(int value) {
      bitField0_ |= 0x00000001;
      resultCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 6;</code>
     * @return The resultCode.
     */
    @java.lang.Override
    public io.littlehorse.common.proto.TaskResultCodePb getResultCode() {
      @SuppressWarnings("deprecation")
      io.littlehorse.common.proto.TaskResultCodePb result = io.littlehorse.common.proto.TaskResultCodePb.valueOf(resultCode_);
      return result == null ? io.littlehorse.common.proto.TaskResultCodePb.UNRECOGNIZED : result;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 6;</code>
     * @param value The resultCode to set.
     * @return This builder for chaining.
     */
    public Builder setResultCode(io.littlehorse.common.proto.TaskResultCodePb value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      resultCode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearResultCode() {
      bitField0_ = (bitField0_ & ~0x00000001);
      resultCode_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object errorMessage_ = "";
    /**
     * <code>string error_message = 7;</code>
     * @return Whether the errorMessage field is set.
     */
    public boolean hasErrorMessage() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>string error_message = 7;</code>
     * @return The errorMessage.
     */
    public java.lang.String getErrorMessage() {
      java.lang.Object ref = errorMessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        errorMessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string error_message = 7;</code>
     * @return The bytes for errorMessage.
     */
    public com.google.protobuf.ByteString
        getErrorMessageBytes() {
      java.lang.Object ref = errorMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        errorMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string error_message = 7;</code>
     * @param value The errorMessage to set.
     * @return This builder for chaining.
     */
    public Builder setErrorMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      errorMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string error_message = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearErrorMessage() {
      bitField0_ = (bitField0_ & ~0x00000002);
      errorMessage_ = getDefaultInstance().getErrorMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string error_message = 7;</code>
     * @param value The bytes for errorMessage to set.
     * @return This builder for chaining.
     */
    public Builder setErrorMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      bitField0_ |= 0x00000002;
      errorMessage_ = value;
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


    // @@protoc_insertion_point(builder_scope:lh_proto.NodeRunStatePb)
  }

  // @@protoc_insertion_point(class_scope:lh_proto.NodeRunStatePb)
  private static final io.littlehorse.common.proto.NodeRunStatePb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.common.proto.NodeRunStatePb();
  }

  public static io.littlehorse.common.proto.NodeRunStatePb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NodeRunStatePb>
      PARSER = new com.google.protobuf.AbstractParser<NodeRunStatePb>() {
    @java.lang.Override
    public NodeRunStatePb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NodeRunStatePb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NodeRunStatePb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NodeRunStatePb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.common.proto.NodeRunStatePb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tags.proto

package io.littlehorse.common.proto;

/**
 * Protobuf type {@code lh_proto.GETableEntryPb}
 */
public final class GETableEntryPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lh_proto.GETableEntryPb)
    GETableEntryPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GETableEntryPb.newBuilder() to construct.
  private GETableEntryPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GETableEntryPb() {
    entry_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GETableEntryPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GETableEntryPb(
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

            entry_ = input.readBytes();
            break;
          }
          case 16: {

            partition_ = input.readInt32();
            break;
          }
          case 24: {

            lastUpdatedOffset_ = input.readInt64();
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
    return io.littlehorse.common.proto.Tags.internal_static_lh_proto_GETableEntryPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.common.proto.Tags.internal_static_lh_proto_GETableEntryPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.common.proto.GETableEntryPb.class, io.littlehorse.common.proto.GETableEntryPb.Builder.class);
  }

  public static final int ENTRY_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString entry_;
  /**
   * <code>bytes entry = 1;</code>
   * @return The entry.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getEntry() {
    return entry_;
  }

  public static final int PARTITION_FIELD_NUMBER = 2;
  private int partition_;
  /**
   * <code>int32 partition = 2;</code>
   * @return The partition.
   */
  @java.lang.Override
  public int getPartition() {
    return partition_;
  }

  public static final int LAST_UPDATED_OFFSET_FIELD_NUMBER = 3;
  private long lastUpdatedOffset_;
  /**
   * <code>int64 last_updated_offset = 3;</code>
   * @return The lastUpdatedOffset.
   */
  @java.lang.Override
  public long getLastUpdatedOffset() {
    return lastUpdatedOffset_;
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
    if (!entry_.isEmpty()) {
      output.writeBytes(1, entry_);
    }
    if (partition_ != 0) {
      output.writeInt32(2, partition_);
    }
    if (lastUpdatedOffset_ != 0L) {
      output.writeInt64(3, lastUpdatedOffset_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!entry_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, entry_);
    }
    if (partition_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, partition_);
    }
    if (lastUpdatedOffset_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, lastUpdatedOffset_);
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
    if (!(obj instanceof io.littlehorse.common.proto.GETableEntryPb)) {
      return super.equals(obj);
    }
    io.littlehorse.common.proto.GETableEntryPb other = (io.littlehorse.common.proto.GETableEntryPb) obj;

    if (!getEntry()
        .equals(other.getEntry())) return false;
    if (getPartition()
        != other.getPartition()) return false;
    if (getLastUpdatedOffset()
        != other.getLastUpdatedOffset()) return false;
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
    hash = (37 * hash) + ENTRY_FIELD_NUMBER;
    hash = (53 * hash) + getEntry().hashCode();
    hash = (37 * hash) + PARTITION_FIELD_NUMBER;
    hash = (53 * hash) + getPartition();
    hash = (37 * hash) + LAST_UPDATED_OFFSET_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLastUpdatedOffset());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.common.proto.GETableEntryPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.GETableEntryPb parseFrom(
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
  public static Builder newBuilder(io.littlehorse.common.proto.GETableEntryPb prototype) {
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
   * Protobuf type {@code lh_proto.GETableEntryPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lh_proto.GETableEntryPb)
      io.littlehorse.common.proto.GETableEntryPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.common.proto.Tags.internal_static_lh_proto_GETableEntryPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.common.proto.Tags.internal_static_lh_proto_GETableEntryPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.common.proto.GETableEntryPb.class, io.littlehorse.common.proto.GETableEntryPb.Builder.class);
    }

    // Construct using io.littlehorse.common.proto.GETableEntryPb.newBuilder()
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
      entry_ = com.google.protobuf.ByteString.EMPTY;

      partition_ = 0;

      lastUpdatedOffset_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.common.proto.Tags.internal_static_lh_proto_GETableEntryPb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.GETableEntryPb getDefaultInstanceForType() {
      return io.littlehorse.common.proto.GETableEntryPb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.common.proto.GETableEntryPb build() {
      io.littlehorse.common.proto.GETableEntryPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.GETableEntryPb buildPartial() {
      io.littlehorse.common.proto.GETableEntryPb result = new io.littlehorse.common.proto.GETableEntryPb(this);
      result.entry_ = entry_;
      result.partition_ = partition_;
      result.lastUpdatedOffset_ = lastUpdatedOffset_;
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
      if (other instanceof io.littlehorse.common.proto.GETableEntryPb) {
        return mergeFrom((io.littlehorse.common.proto.GETableEntryPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.common.proto.GETableEntryPb other) {
      if (other == io.littlehorse.common.proto.GETableEntryPb.getDefaultInstance()) return this;
      if (other.getEntry() != com.google.protobuf.ByteString.EMPTY) {
        setEntry(other.getEntry());
      }
      if (other.getPartition() != 0) {
        setPartition(other.getPartition());
      }
      if (other.getLastUpdatedOffset() != 0L) {
        setLastUpdatedOffset(other.getLastUpdatedOffset());
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
      io.littlehorse.common.proto.GETableEntryPb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.littlehorse.common.proto.GETableEntryPb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.ByteString entry_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes entry = 1;</code>
     * @return The entry.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getEntry() {
      return entry_;
    }
    /**
     * <code>bytes entry = 1;</code>
     * @param value The entry to set.
     * @return This builder for chaining.
     */
    public Builder setEntry(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      entry_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes entry = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearEntry() {
      
      entry_ = getDefaultInstance().getEntry();
      onChanged();
      return this;
    }

    private int partition_ ;
    /**
     * <code>int32 partition = 2;</code>
     * @return The partition.
     */
    @java.lang.Override
    public int getPartition() {
      return partition_;
    }
    /**
     * <code>int32 partition = 2;</code>
     * @param value The partition to set.
     * @return This builder for chaining.
     */
    public Builder setPartition(int value) {
      
      partition_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 partition = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPartition() {
      
      partition_ = 0;
      onChanged();
      return this;
    }

    private long lastUpdatedOffset_ ;
    /**
     * <code>int64 last_updated_offset = 3;</code>
     * @return The lastUpdatedOffset.
     */
    @java.lang.Override
    public long getLastUpdatedOffset() {
      return lastUpdatedOffset_;
    }
    /**
     * <code>int64 last_updated_offset = 3;</code>
     * @param value The lastUpdatedOffset to set.
     * @return This builder for chaining.
     */
    public Builder setLastUpdatedOffset(long value) {
      
      lastUpdatedOffset_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 last_updated_offset = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearLastUpdatedOffset() {
      
      lastUpdatedOffset_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:lh_proto.GETableEntryPb)
  }

  // @@protoc_insertion_point(class_scope:lh_proto.GETableEntryPb)
  private static final io.littlehorse.common.proto.GETableEntryPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.common.proto.GETableEntryPb();
  }

  public static io.littlehorse.common.proto.GETableEntryPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GETableEntryPb>
      PARSER = new com.google.protobuf.AbstractParser<GETableEntryPb>() {
    @java.lang.Override
    public GETableEntryPb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GETableEntryPb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GETableEntryPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GETableEntryPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.common.proto.GETableEntryPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


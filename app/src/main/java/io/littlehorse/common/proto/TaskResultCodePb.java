// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: status.proto

package io.littlehorse.common.proto;

/**
 * Protobuf enum {@code lh_proto.TaskResultCodePb}
 */
public enum TaskResultCodePb
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>SUCCESS = 0;</code>
   */
  SUCCESS(0),
  /**
   * <code>TIMEOUT = 1;</code>
   */
  TIMEOUT(1),
  /**
   * <code>FAILED = 2;</code>
   */
  FAILED(2),
  /**
   * <code>VAR_SUB_ERROR = 3;</code>
   */
  VAR_SUB_ERROR(3),
  /**
   * <code>VAR_MUTATION_ERROR = 4;</code>
   */
  VAR_MUTATION_ERROR(4),
  /**
   * <code>CHILD_FALIED = 5;</code>
   */
  CHILD_FALIED(5),
  /**
   * <code>INTERRUPT_HANDLER_FAILED = 6;</code>
   */
  INTERRUPT_HANDLER_FAILED(6),
  /**
   * <code>EXCEPTION_HANDLER_FAILED = 7;</code>
   */
  EXCEPTION_HANDLER_FAILED(7),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>SUCCESS = 0;</code>
   */
  public static final int SUCCESS_VALUE = 0;
  /**
   * <code>TIMEOUT = 1;</code>
   */
  public static final int TIMEOUT_VALUE = 1;
  /**
   * <code>FAILED = 2;</code>
   */
  public static final int FAILED_VALUE = 2;
  /**
   * <code>VAR_SUB_ERROR = 3;</code>
   */
  public static final int VAR_SUB_ERROR_VALUE = 3;
  /**
   * <code>VAR_MUTATION_ERROR = 4;</code>
   */
  public static final int VAR_MUTATION_ERROR_VALUE = 4;
  /**
   * <code>CHILD_FALIED = 5;</code>
   */
  public static final int CHILD_FALIED_VALUE = 5;
  /**
   * <code>INTERRUPT_HANDLER_FAILED = 6;</code>
   */
  public static final int INTERRUPT_HANDLER_FAILED_VALUE = 6;
  /**
   * <code>EXCEPTION_HANDLER_FAILED = 7;</code>
   */
  public static final int EXCEPTION_HANDLER_FAILED_VALUE = 7;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static TaskResultCodePb valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static TaskResultCodePb forNumber(int value) {
    switch (value) {
      case 0: return SUCCESS;
      case 1: return TIMEOUT;
      case 2: return FAILED;
      case 3: return VAR_SUB_ERROR;
      case 4: return VAR_MUTATION_ERROR;
      case 5: return CHILD_FALIED;
      case 6: return INTERRUPT_HANDLER_FAILED;
      case 7: return EXCEPTION_HANDLER_FAILED;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<TaskResultCodePb>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      TaskResultCodePb> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<TaskResultCodePb>() {
          public TaskResultCodePb findValueByNumber(int number) {
            return TaskResultCodePb.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return io.littlehorse.common.proto.Status.getDescriptor().getEnumTypes().get(1);
  }

  private static final TaskResultCodePb[] VALUES = values();

  public static TaskResultCodePb valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private TaskResultCodePb(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:lh_proto.TaskResultCodePb)
}


package io.littlehorse.server.streamsimpl.storeinternals.index;

import com.google.protobuf.Message;
import io.littlehorse.common.model.GETable;
import io.littlehorse.common.model.Storeable;
import io.littlehorse.common.proto.AttributePb;
import io.littlehorse.common.proto.GETableClassEnumPb;
import io.littlehorse.common.proto.InternalScanPb.TagPrefixScanPb;
import io.littlehorse.common.proto.TagPb;
import io.littlehorse.common.proto.TagStorageTypePb;
import io.littlehorse.common.util.LHUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

@Setter
public class Tag extends Storeable<TagPb> {

    public TagStorageTypePb tagType;
    public GETableClassEnumPb objectType;
    public List<Attribute> attributes;
    public Date createdAt;
    public String describedObjectId;

    public Class<TagPb> getProtoBaseClass() {
        return TagPb.class;
    }

    @Override
    public TagPb.Builder toProto() {
        TagPb.Builder out = TagPb
            .newBuilder()
            .setObjectType(objectType)
            .setDescribedObjectId(describedObjectId)
            .setCreated(LHUtil.fromDate(createdAt))
            .setStoreKey(this.getStoreKey())
            .setTagType(tagType);

        for (Attribute attr : attributes) {
            out.addAttributes(attr.toProto());
        }
        return out;
    }

    @Override
    public void initFrom(Message proto) {
        TagPb p = (TagPb) proto;
        objectType = p.getObjectType();
        describedObjectId = p.getDescribedObjectId();
        createdAt = LHUtil.fromProtoTs(p.getCreated());

        for (AttributePb attr : p.getAttributesList()) {
            attributes.add(Attribute.fromProto(attr));
        }

        tagType = p.getTagType();
    }

    public String getAttributeString() {
        return getAttributeString(objectType, attributes);
    }

    public static String getAttributeString(
        GETableClassEnumPb objectType,
        TagPrefixScanPb prefixScanSpec
    ) {
        List<Attribute> attrs = new ArrayList<>();
        for (AttributePb apb : prefixScanSpec.getAttributesList()) {
            attrs.add(Attribute.fromProto(apb));
        }
        return getAttributeString(objectType, attrs);
    }

    public static String getAttributeString(
        GETableClassEnumPb objectType,
        List<Attribute> attributes
    ) {
        StringBuilder builder = new StringBuilder();
        builder.append(objectType.toString());
        builder.append("/");
        for (Attribute attr : attributes) {
            builder.append("__");
            builder.append(attr.getEscapedKey());
            builder.append("_");
            builder.append(attr.getEscapedVal());
        }
        return builder.toString();
    }

    public static String getAttributeStringFromPb(
        GETableClassEnumPb objectType,
        List<AttributePb> attributes
    ) {
        return getAttributeString(
            objectType,
            attributes
                .stream()
                .map(attr -> Attribute.fromProto(attr))
                .collect(Collectors.toList())
        );
    }

    public boolean isRemote() {
        return tagType == TagStorageTypePb.REMOTE;
    }

    public String getStoreKey() {
        StringBuilder builder = new StringBuilder(getAttributeString());

        builder.append("/");
        builder.append(LHUtil.toLhDbFormat(createdAt));
        builder.append("/");
        builder.append(describedObjectId);
        return builder.toString();
    }

    public Tag() {
        attributes = new ArrayList<>();
    }

    public String getCounterKey(int partition) {
        switch (tagType) {
            case LOCAL:
                return DiscreteTagLocalCounter.getObjectId(
                    getAttributeString(),
                    partition
                );
            case UNRECOGNIZED:
                return null;
        }
        throw new RuntimeException("Not possible");
    }

    public TagStorageTypePb getTagStorageTypePb() {
        return this.tagType;
    }

    @SafeVarargs
    @SuppressWarnings("unchecked")
    public Tag(
        GETable<?> getable,
        TagStorageTypePb type,
        Pair<String, String>... atts
    ) {
        this(getable, type, Arrays.asList(atts));
    }

    public Tag(
        GETable<?> getable,
        TagStorageTypePb type,
        Collection<Pair<String, String>> atts
    ) {
        this();
        this.objectType =
            GETable.getTypeEnum((Class<? extends GETable<?>>) getable.getClass());
        createdAt = getable.getCreatedAt();
        describedObjectId = getable.getStoreKey();
        this.tagType = type;

        for (Pair<String, String> p : atts) {
            attributes.add(new Attribute(p.getLeft(), p.getRight()));
        }
    }

    public Tag(
        TagStorageTypePb type,
        GETableClassEnumPb objectType,
        Collection<Attribute> attributes,
        String describedObjectId,
        Date createAt
    ) {
        this();
        this.tagType = type;
        this.objectType = objectType;
        this.describedObjectId = describedObjectId;
        if (objectType == GETableClassEnumPb.WF_RUN) {
            System.out.println("describedObjectId" + describedObjectId);
        }
        this.createdAt = createAt;
        this.attributes.addAll(attributes);
    }

    public int hashCode() {
        return getStoreKey().hashCode();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Tag)) return false;
        Tag oe = (Tag) o;
        return getStoreKey().equals(oe.getStoreKey());
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public String getDescribedObjectId() {
        return describedObjectId;
    }

    public GETableClassEnumPb getObjectType() {
        return objectType;
    }
}

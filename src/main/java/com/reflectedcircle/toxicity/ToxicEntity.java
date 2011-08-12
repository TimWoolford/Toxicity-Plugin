package com.reflectedcircle.toxicity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ToxicEntity implements DataEntity {
    public final ToxicityType type;
    public final SourceEntity entity;

    public ToxicEntity(ToxicityType type, SourceEntity entity) {
        this.type = type;
        this.entity = entity;
    }

    public String name() {
        return entity.name();
    }

    public String type() {
        return type.fieldName();
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }
}
package com.reflectedcircle.toxicity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.File;

public class SourceEntity {
    private final String filename;

    public SourceEntity(String filename) {
        this.filename = filename;
    }

    public String name() {
        return new File(filename).getName().replace(".java","");
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
package com.jmxtestbuilder.toy.utils;

public enum StringPropType {
    VALUE("Argument.value"), NAME("Argument.name"), METADATA("Argument.metadata");

    private String name;

    StringPropType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.jmxtestbuilder.toy.dataType;

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

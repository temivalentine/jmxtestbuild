package com.jmxtestbuilder.toy.utils;

public enum BoolPropType {
    ENCODE("HTTPArgument.always_encode"), EQUALS("HTTPArgument.use_equals");

    private String name;

    BoolPropType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.jmxtestbuilder.toy.utils;


import javax.xml.bind.annotation.XmlAnyElement;
import java.util.ArrayList;
import java.util.List;

public class GenericWrapper<T> {

    private List<T> items;

    public GenericWrapper() {
        items = new ArrayList<T>();
    }

    public GenericWrapper(List<T> items) {
        this.items = items;
    }

    @XmlAnyElement(lax = true)
    public List<T> getItems() {
        return items;
    }
}

package com.jmxtestbuilder.toy.utils;

import javax.xml.bind.annotation.XmlAnyElement;
import java.util.ArrayList;
import java.util.List;

public class Wrapper<T> {

    private List<T> items = new ArrayList<T>();

    @XmlAnyElement(lax = true)
    public List<T> getItems() {
        return items;
    }

}
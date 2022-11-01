package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "elementProp")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementProp {

    @XmlElement(name = "stringProp")
    private String stringProp;
}

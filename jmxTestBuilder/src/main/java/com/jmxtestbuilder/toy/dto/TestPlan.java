package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "TestPlan")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestPlan {

    private String stringProp;
    private String boolProp;
    private String elementProp;

}

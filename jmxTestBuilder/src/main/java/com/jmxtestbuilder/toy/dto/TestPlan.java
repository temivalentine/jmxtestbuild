package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "TestPlan")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestPlan {

    private String stringProp;
    private String boolProp;
    private String elementProp;

    @XmlAttribute
    private String guiclass;

    @XmlAttribute
    private String testclass;

    @XmlAttribute
    private String testname;

    @XmlAttribute
    private String enabled;

}

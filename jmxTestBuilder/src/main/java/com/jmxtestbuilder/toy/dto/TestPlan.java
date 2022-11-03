package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "TestPlan")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestPlan<T> {

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

    @XmlElementWrapper(name = "hashTree")
    @XmlAnyElement(lax = true)
    List<T> list;

}

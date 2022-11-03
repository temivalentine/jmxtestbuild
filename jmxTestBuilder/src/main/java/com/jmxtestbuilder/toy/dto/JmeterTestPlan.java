package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "JmeterTestPlan")
@XmlAccessorType(XmlAccessType.FIELD)
public class JmeterTestPlan<T> {

//    @XmlElementWrapper(name = "hashTree")
//    @XmlElement(name = "TestPlan")
//    private List<TestPlan> testPlan;

//    @XmlElementWrapper(name = "hashTree")
//    @XmlElement(name = "HeaderManager")
//    private List<HeaderManager> headerManager;

    @XmlAttribute
    private String version;

    @XmlAttribute
    private String properties;

    @XmlAttribute
    private String jmeter;

    @XmlElementWrapper(name = "hashTree")
    @XmlAnyElement(lax = true)
    List<T> list;

}

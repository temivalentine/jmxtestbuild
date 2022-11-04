package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "jmeterTestPlan")
@XmlAccessorType(XmlAccessType.FIELD)
public class JmeterTestPlan {

    @XmlAttribute
    private String version;

    @XmlAttribute
    private String properties;

    @XmlAttribute
    private String jmeter;

    @XmlElement(name = "hashTree")
    private List<TestPlanHashTree> testPlanHashTreeList;


//    @XmlElementWrapper(name = "hashTree")
//    @XmlAnyElement(lax = true)
//    List<T> list;

}

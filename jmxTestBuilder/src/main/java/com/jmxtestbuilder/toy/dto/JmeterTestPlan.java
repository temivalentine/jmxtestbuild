package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "JmeterTestPlan")
@XmlAccessorType(XmlAccessType.FIELD)
public class JmeterTestPlan {

    @XmlElementWrapper(name = "hashTree")
    @XmlElement(name = "TestPlan")
    private List<TestPlan> testPlan;

    @XmlElementWrapper(name = "hashTree")
    @XmlElement(name = "HeaderManager")
    private List<HeaderManager> headerManager;


//    @XmlElement(name = "HashTree")
//    List<HashTree> hashTrees;

}

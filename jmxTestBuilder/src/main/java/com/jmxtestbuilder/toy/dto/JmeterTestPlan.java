package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
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

    @XmlAnyElement(lax = true)
    List<T> list;

}

package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@Data
//@XmlTransient
//public class HashTree<T> {
//
//    @XmlAnyElement
//    private T hashTree;
//
//}
@Data
@XmlRootElement(name = "hashTree")
@XmlAccessorType(XmlAccessType.FIELD)
public class HashTree {

//    @XmlElement(name = "TestPlan")
//    private List<TestPlan> testPlan;

    @XmlElement(name = "testID")
    private String testID;

}
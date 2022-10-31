package com.jmxtestbuilder.toy.dto;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "jmeterTestPlan")
@XmlAccessorType(XmlAccessType.FIELD)
public class JmeterTestPlan {

    //    @XmlElement(name = "hashTree")
//    private HashTree<T> hashTree;
    @XmlAnyElement(lax = true)
    private List<T> hashTree;
}

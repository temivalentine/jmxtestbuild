package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "JmeterTestPlan")
public class JmeterTestPlan {

    @XmlElement(name = "HashTree")
    List<HashTree> hashTrees;


    //    @XmlElement(name = "hashTree")
//    private HashTree<T> hashTree;
}

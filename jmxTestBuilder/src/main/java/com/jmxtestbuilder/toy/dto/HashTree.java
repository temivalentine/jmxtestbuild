package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlTransient
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HashTree<T> {

    @XmlAnyElement
    private List<T> hashTree;

}
//@Data
//@XmlRootElement(name = "hashTree")
//@XmlAccessorType(XmlAccessType.FIELD)
//public class HashTree {
//
//    @XmlElement(name = "hashTree")
//    private List<T> hashTreeList;

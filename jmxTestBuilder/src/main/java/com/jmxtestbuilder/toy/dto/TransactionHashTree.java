package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "hashTree")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionHashTree {

    @XmlElement(name = "TransactionController")
    private List<TransactionController> transactionControllerList;

    @XmlElement(name = "hashTree")
    private List<HTTPHashTree> httpHashTreeList;
}
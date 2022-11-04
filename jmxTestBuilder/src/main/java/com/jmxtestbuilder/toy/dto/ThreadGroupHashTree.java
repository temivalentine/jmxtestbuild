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
public class ThreadGroupHashTree {

    @XmlElement(name = "ThreadGroup")
    private List<ThreadGroup> threadGroupList;

    @XmlElement(name = "hashTree")
    private List<TransactionHashTree> transactionHashTreeList;
}

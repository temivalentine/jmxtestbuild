package com.jmxtestbuilder.toy.dto;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "HeaderManager")
@XmlAccessorType(XmlAccessType.FIELD)
public class HeaderManager {

    @XmlElement(name = "collectionProps")
    List<CollectionProp> collectionProps;
}
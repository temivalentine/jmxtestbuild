package com.jmxtestbuilder.toy.dto;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "hashTree")
@XmlAccessorType(XmlAccessType.FIELD)
public class HashTree<T> {

//    @XmlElement(name = "HTTPSamplerProxy")
//    private List<HttpRequest> httpRequestList;

    @XmlAnyElement(lax = true)
    List<T> list;
}

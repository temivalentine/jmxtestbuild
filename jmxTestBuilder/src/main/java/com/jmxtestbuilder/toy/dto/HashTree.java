package com.jmxtestbuilder.toy.dto;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "hashTree")
@XmlAccessorType(XmlAccessType.FIELD)
public class HashTree<T> {

    @XmlElementWrapper(name = "hashTree")
    @XmlAnyElement(lax = true)
    List<T> list;
}

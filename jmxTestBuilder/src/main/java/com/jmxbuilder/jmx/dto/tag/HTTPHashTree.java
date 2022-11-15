package com.jmxbuilder.jmx.dto.tag;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "hashTree")
@XmlAccessorType(XmlAccessType.FIELD)
public class HTTPHashTree {

    @XmlElement(name = "HTTPSamplerProxy")
    private List<HTTPSamplerProxy> httpSamplerProxyList;

//    @XmlElement(name = "hashTree")
//    private List<HashTree> hashTreeList;

//    @XmlAnyElement(lax = true)
//    List<T> list;
}

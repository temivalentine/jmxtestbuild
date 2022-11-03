package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlRootElement(name = "HTTPSamplerProxy")
@XmlAccessorType(XmlAccessType.FIELD)
public class HttpRequest {

    @XmlAttribute
    private String guiclass;

    @XmlAttribute
    private String testclass;

    @XmlAttribute
    private String testname;

    @XmlAttribute
    private String enabled;

    @XmlElement
    private String test;


//    @XmlAnyElement(lax = true)
//    private List list;
}

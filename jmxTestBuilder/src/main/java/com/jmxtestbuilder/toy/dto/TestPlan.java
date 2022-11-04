package com.jmxtestbuilder.toy.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "TestPlan")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestPlan {

    @XmlAttribute
    private String guiclass;

    @XmlAttribute
    private String testclass;

    @XmlAttribute
    private String testname;

    @XmlAttribute
    private String enabled;

    @XmlElement(name = "elementProp")
    private List<ElementProp> elementPropList;

    @XmlElement(name = "stringProp")
    private List<StringProp> stringPropList;

    @XmlElement(name = "boolProp")
    private List<BoolProp> boolPropList;

//    @XmlElementWrapper(name = "hashTree")
//    @XmlAnyElement(lax = true)
//    List<T> list;

}

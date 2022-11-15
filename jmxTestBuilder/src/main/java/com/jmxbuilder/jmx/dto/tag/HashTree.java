package com.jmxbuilder.jmx.dto.tag;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * packageName    : com.jmxbuilder.jmx.dto.tag
 * fileName       : HashTree
 * author         : im-happy-coder
 * date           : 22. 11. 15.
 * description    :   <hashTree/>  만들기  용
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 15.        im-happy-coder       최초 생성
 */
@Data
@XmlRootElement(name = "hashTree")
@XmlAccessorType(XmlAccessType.FIELD)
public class HashTree {

    @XmlAttribute
    private String hashTree;
}

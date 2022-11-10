package com.jmxtestbuilder.toy.dto.data;

import lombok.Data;

/**
 * packageName    : com.jmxtestbuilder.toy.dto.excel
 * fileName       : Element
 * author         : im-happy-coder
 * date           : 22. 11. 10.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 10.        im-happy-coder       최초 생성
 */
@Data
public class ElementSub {

    //BoolPropSub
    private String alwaysEncode;

    private String useEquals;

    //StringPropSub
    private String value;

    private String name;

    private String metadata;
}

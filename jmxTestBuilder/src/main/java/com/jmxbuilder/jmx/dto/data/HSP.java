package com.jmxbuilder.jmx.dto.data;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * packageName    : com.jmxtestbuilder.toy.dto.excel
 * fileName       : HSP
 * author         : im-happy-coder
 * date           : 22. 11. 10.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 10.        im-happy-coder       최초 생성
 */

@Data
public class HSP {

    //StringProp
    private String name;

    private String comments;

    private String protocol;

    private String ip;

    private String port;

    private String method;

    private String path;

    private String contentEncoding;

    private String embeddedUrlRe;

    private String connectTimeout;

    private String responseTimeout;

    //BoolProp
    private String followRedirects;

    private String autoRedirects;

    private String useKeepalive;

    private String doMultipartPost;

    private String browserCompatibleMultipart;

    //HashMap
    List<HashMap<String, String>> elmapList;
}

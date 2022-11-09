package com.jmxtestbuilder.toy.dto.excel;

import lombok.Data;

import java.util.List;

@Data
public class QueryParam {

    private List<String> prdNo;

    private List<String> onOff;

    private List<String> type;

    private List<String> ordNo;
}

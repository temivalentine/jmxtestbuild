package com.jmxbuilder.jmx.utils;

import com.jmxbuilder.jmx.dto.data.ExcelParam;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


/**
 * packageName    : com.jmxtestbuilder.toy.utils
 * fileName       : URLParser
 * author         : im-happy-coder
 * date           : 22. 11. 10.
 * description    : excel to object parser
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 10.        im-happy-coder       최초 생성
 */
public class URLParser {
    public static void main(String[] args) throws IOException {
        readExcel();
    }

    public static void readExcel() throws IOException {
        FileInputStream file = new FileInputStream("/root/IdeaProjects/jmxtestbuild/jmxTestBuilder/src/main/resources/test.xlsx");
        List<ExcelParam> dataList = new ArrayList<>();

        Workbook workbook = null;
        workbook = new XSSFWorkbook(file);
        Sheet worksheet = workbook.getSheetAt(0);

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            Row row = worksheet.getRow(i);
            ExcelParam data = new ExcelParam();

            data.setDevice(row.getCell(0).getStringCellValue());
            data.setModule(row.getCell(1).getStringCellValue());
            data.setUpdate(row.getCell(2).getStringCellValue());
            data.setUrl(row.getCell(3).getStringCellValue());
            data.setDescription(row.getCell(4).getStringCellValue());
            data.setEtc(row.getCell(5).getStringCellValue());

//            System.out.println("================JSON URL================   : " + data.getUrl());

            //URL uriComponents
            UriComponents uriComponents = UriComponentsBuilder.fromUriString(data.getUrl()).build();
            MultiValueMap<String, String> queryParams = uriComponents.getQueryParams();
            // keys
            HashMap<String, String> hashMap = new HashMap<>();
            Set<String> keySet = queryParams.keySet();
            Iterator<String> it = keySet.iterator();
            while (it.hasNext()) {
                String keys = it.next();
                String values = queryParams.get(keys).get(0);
//                System.out.println("keys ======= : " + keys + "values ============ : " + values);
                hashMap.put(keys, values);
            }
            hashMap.forEach((key, value) -> {
                System.out.println(key + ":" + value);
            });
            dataList.add(data);
        }
    }
}

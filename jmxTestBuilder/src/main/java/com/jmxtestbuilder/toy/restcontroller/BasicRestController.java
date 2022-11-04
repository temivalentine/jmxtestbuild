package com.jmxtestbuilder.toy.restcontroller;

import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController("/api")
public class BasicRestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @PostMapping("/excel/read")
    public void excel2Json(@RequestParam("file") MultipartFile file) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());

            XSSFSheet worksheet = workbook.getSheetAt(0);

            List<JSONObject> dataList = new ArrayList<>();

            Row header = worksheet.getRow(1);

            for (int i = 2; i < worksheet.getPhysicalNumberOfRows(); i++) {
                Row row = worksheet.getRow(i);
                JSONObject rowJsonObject = new JSONObject();
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    String columnName = header.getCell(j).toString();
                    String columnValue = row.getCell(j).toString();
                    rowJsonObject.put(columnName, columnValue);
//                    System.out.println(rowJsonObject);
                }
                dataList.add(rowJsonObject);
            }
            writeData2JsonFile(dataList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeData2JsonFile(List<JSONObject> dataList) {
        Gson gson = new Gson();
        try {
            FileWriter file = new FileWriter("/root/IdeaProjects/jmxtestbuild/jmxTestBuilder/src/main/resources/data.json");
            file.write(gson.toJson(dataList));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

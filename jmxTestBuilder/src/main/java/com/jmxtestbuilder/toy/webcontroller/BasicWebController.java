package com.jmxtestbuilder.toy.webcontroller;

import com.jmxtestbuilder.toy.dto.excel.ExcelData;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BasicWebController {

    @GetMapping("/excel")
    public String main() {
        return "jmx/excel";
    }


    @PostMapping("/view/read")
    public String readExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        List<ExcelData> dataList = new ArrayList<>();

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        if (!extension.equals("xlsx") && !extension.equals("xls")) {
            throw new IOException("do not excel file.");
        }

        Workbook workbook = null;

        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        }
        Sheet worksheet = workbook.getSheetAt(0);

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            Row row = worksheet.getRow(i);

            ExcelData data = new ExcelData();

            data.setDevice(row.getCell(0).getStringCellValue());
            data.setModule(row.getCell(1).getStringCellValue());
            data.setUpdate(row.getCell(2).getStringCellValue());
            data.setUrl(row.getCell(3).getStringCellValue());
            data.setDescription(row.getCell(4).getStringCellValue());
            data.setEtc(row.getCell(5).getStringCellValue());

            dataList.add(data);
        }
        model.addAttribute("datas", dataList);
        return "jmx/excelList";
    }

}

package com.jmxtestbuilder.toy.webcontroller;

import com.jmxtestbuilder.toy.dto.BoolProp;
import com.jmxtestbuilder.toy.dto.CollectionProp;
import com.jmxtestbuilder.toy.dto.ElementProp;
import com.jmxtestbuilder.toy.dto.StringProp;
import com.jmxtestbuilder.toy.dto.excel.ExcelData;
import com.jmxtestbuilder.toy.dto.excel.QueryParam;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class BasicWebController {

    @GetMapping("/excel")
    public String main() {
        return "jmx/excel";
    }


    @PostMapping("/view/read")
    public String readExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException, URISyntaxException {

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

            System.out.println("================JSON URL================   : " + data.getUrl());

            //URL uriComponents
            UriComponents uriComponents = UriComponentsBuilder.fromUriString(data.getUrl()).build();
            MultiValueMap<String, String> queryParams = uriComponents.getQueryParams();
            QueryParam queryParam = new QueryParam();
            List<QueryParam> queryParamList = new ArrayList<>();

            List<String> prdNo = null;
            List<String> onOff = null;
            List<String> type = null;
            List<String> ordNo = null;

            Set<String> testSet = queryParams.keySet();

            Iterator<String> it = testSet.iterator();
            while (it.hasNext()) {
                String temp = it.next();
                queryParams.get(temp);
                System.out.println(temp);
            }

            prdNo = queryParams.get("prdNo");
            onOff = queryParams.get("onOff");
            type = queryParams.get("type");
            ordNo = queryParams.get("ordNo");

            System.out.println("prdNo  : " + prdNo + "          onOff  : " + onOff + "          type  : " + type + "          ordNo  : " + ordNo);

            System.out.println("================Query Param  : " + queryParams);

            queryParam.setPrdNo(prdNo);
            queryParam.setType(type);
            queryParam.setOnOff(onOff);
            queryParam.setOrdNo(ordNo);

            queryParamList.add(queryParam);

            System.out.println("=================Query List   : " + queryParamList.toString());

            System.out.println("");
            System.out.println("");
            System.out.println("");

            dataList.add(data);

            System.out.println("===========================================marshal==================================");
            System.out.println("");
            System.out.println("");

            //Test marshal method 1
//            collectionElementProp(queryParamList);
        }
        model.addAttribute("datas", dataList);
        return "jmx/excelList";
    }

    //Custom Method() 1
    public static void collectionElementProp(List<QueryParam> url) {

        BoolProp boolProp = new BoolProp();
        boolProp.setName("HTTPArgument.always_encode");
        boolProp.setValue("true");

        BoolProp boolProp2 = new BoolProp();
        boolProp2.setName("HTTPArgument.use_equals");
        boolProp2.setValue("true");

        StringProp stringProp = new StringProp();
        stringProp.setName("Argument.value");
        stringProp.setValue("test");

        StringProp stringProp2 = new StringProp();
        stringProp2.setName("Argument.metadata");
        stringProp2.setValue("=");

        StringProp stringProp3 = new StringProp();
        stringProp3.setName("Argument.name");
        stringProp3.setValue("id");

        List<BoolProp> boolPropList = new ArrayList<>();
        List<StringProp> stringPropList = new ArrayList<>();
        boolPropList.add(boolProp);
        boolPropList.add(boolProp2);
        stringPropList.add(stringProp);
        stringPropList.add(stringProp2);
        stringPropList.add(stringProp3);

        ElementProp elementProp = new ElementProp();
        elementProp.setName("id");
        elementProp.setElementType("HTTPArgument");
        elementProp.setBoolPropList(boolPropList);
        elementProp.setStringPropList(stringPropList);

        CollectionProp collectionProp = new CollectionProp();
        List<ElementProp> elementPropList = new ArrayList<>();
        collectionProp.setName("Arguments.arguments");
        elementPropList.add(elementProp);
        collectionProp.setElementPropList(elementPropList);

        ElementProp elementProp2 = new ElementProp();
        elementProp2.setName("HTTPsampler.Arguments");
        elementProp2.setElementType("Arguments");
        elementProp2.setGuiclass("HTTPArgumentsPanel");
        elementProp2.setTestclass("Arguments");
        elementProp2.setEnabled("true");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ElementProp.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(elementProp, sw);
            System.out.println(sw);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

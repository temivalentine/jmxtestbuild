package com.jmxtestbuilder.toy.webcontroller;

import org.springframework.stereotype.Controller;

@Controller
public class BasicWebController {
//    @GetMapping("/excel")
//    public String main() {
//        return "jmx/excel";
//    }
//    @PostMapping("/view/read")
//    public String readExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException {
//
//        List<ExcelData> dataList = new ArrayList<>();
//
//        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//
//        if (!extension.equals("xlsx") && !extension.equals("xls")) {
//            throw new IOException("do not excel file.");
//        }
//
//        Workbook workbook = null;
//
//        if (extension.equals("xlsx")) {
//            workbook = new XSSFWorkbook(file.getInputStream());
//        } else if (extension.equals("xls")) {
//            workbook = new HSSFWorkbook(file.getInputStream());
//        }
//        Sheet worksheet = workbook.getSheetAt(0);
//
//        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
//            Row row = worksheet.getRow(i);
//
//            ExcelData data = new ExcelData();
//
//            data.setDevice(row.getCell(0).getStringCellValue());
//            data.setModule(row.getCell(1).getStringCellValue());
//            data.setUpdate(row.getCell(2).getStringCellValue());
//            data.setUrl(row.getCell(3).getStringCellValue());
//            data.setDescription(row.getCell(4).getStringCellValue());
//            data.setEtc(row.getCell(5).getStringCellValue());
//
//            System.out.println("================JSON URL================   : " + data.getUrl());
//
//            //URL uriComponents
//            UriComponents uriComponents = UriComponentsBuilder.fromUriString(data.getUrl()).build();
//            MultiValueMap<String, String> queryParams = uriComponents.getQueryParams();
//            // keys
//            Set<String> keySet = queryParams.keySet();
//            Iterator<String> it = keySet.iterator();
//            while (it.hasNext()) {
//                String keys = it.next();
//                queryParams.get(keys);
//                String values = queryParams.get(keys).get(0);
//            }
//            dataList.add(data);
//        }
//        model.addAttribute("datas", dataList);
//        return "jmx/excelList";
//    }
}

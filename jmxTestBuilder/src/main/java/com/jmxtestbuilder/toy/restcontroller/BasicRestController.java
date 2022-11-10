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


}

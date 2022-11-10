package com.jmxbuilder.jmx.restcontroller;

import org.springframework.web.bind.annotation.*;

@RestController("/api")
public class BasicRestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }


}

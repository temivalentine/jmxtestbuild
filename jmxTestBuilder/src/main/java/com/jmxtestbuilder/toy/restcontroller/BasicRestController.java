package com.jmxtestbuilder.toy.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jmx/rest")
public class BasicRestController {

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}
	
}

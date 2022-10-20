package com.jmxtestbuilder.toy.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jmx/web")
public class BasicWebController {

	@RequestMapping("/test")
	public String build(Model model) {
		
		model.addAttribute("welcome", "JMX Builder DEMO");
		
		return "jmx/test";
	}
	
}

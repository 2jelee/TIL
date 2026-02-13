package com.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InformationController {  // annotation  Controller 
	
	private static final Logger logger = LoggerFactory.getLogger(InformationController.class);
	
	//@RequestMapping("/kbs")
	@RequestMapping(value = "/aa", method = RequestMethod.GET)
	public String info(Model m) {
		
		logger.info("InformationController 에서 로그 출력합니다");
		
		m.addAttribute("address", "송파구 가락동333");
		m.addAttribute("name", "이순신333");
		m.addAttribute("age", 333);
		
		return "info";  //  /WEB-INF/views/ + info + .jsp
	}

}

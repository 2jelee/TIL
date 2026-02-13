package com.exam.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
    	String str = "<script>"
    					+ "location.href='/main.do';"
    				+ "</script>";
        return str;
    }
 
    @RequestMapping("/main.do")
    public String main() {
        return "main";                
    }
     
    @RequestMapping("/sub/ceo.do")
    public String hitoryPage() {
        return "sub/ceo";        
    }

}

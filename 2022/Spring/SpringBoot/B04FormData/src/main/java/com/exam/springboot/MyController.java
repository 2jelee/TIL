package com.exam.springboot;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping("/")
    public String root(){
        return "home";
    }

    //Model 객체 사용하기
    @RequestMapping("/model.do")
    public String test1(Model model) {
        model.addAttribute("name", "홍길동");
        //Model에 속성 저장 후 뷰로 전달
        return "model";       
    }
    
    //ModelAndView 객체 사용하기
    @RequestMapping("/mv.do")
    public ModelAndView test2() {
        ModelAndView mv = new ModelAndView();
         
        List<String> lists = new ArrayList<>();         
        lists.add("test1");
        lists.add("test2");
        lists.add("test3");
        
        //Model객체에 데이터를 저장하고, View를 설정하는 2가지 기능이있다.
        mv.addObject("lists", lists);
        mv.addObject("name", "홍길동");
        mv.setViewName("mv");
        
        return mv;                                     
    }

    //폼값처리1 : HttpServletRequest 객체를 사용하여 폼값 받기
    @RequestMapping("/request.do")
    public String test3(HttpServletRequest httpServletRequest, Model model) {		
    	String id = httpServletRequest.getParameter("id");
		String name = httpServletRequest.getParameter("name");

		model.addAttribute("id", id);
        model.addAttribute("name", name);

        return "request";       
    }
    //폼값처리2 : @RequestParam 어노테이션을 통한 파라미터 저장
    @RequestMapping("/param.do")
    public String test4(@RequestParam("id") String id,
    		            @RequestParam("name") String name,
    		            Model model) {

    	model.addAttribute("id", id);
        model.addAttribute("name", name);

        return "param";       
    }
    //폼값처리3 : 커맨드객체를 통해 폼값 한번에 받은 후 저장
    @RequestMapping("/command.do")
    public String test5(MemberVO memberVO, Model model) {
    	/*
    	전송된 폼값은 MemberVO에 저장된 후 Model객체에 다시 저장됨.
    	 */
        return "command";       
    }
}


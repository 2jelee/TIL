package com.exam.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.springboot.jdbc.MemberDAO;

@Controller
public class MyController {
	
	//DAO객체를 자동주입 받음
	@Autowired
	private MemberDAO memberDAO;

    @RequestMapping("/")
    public String root() {
        return "home";
    }
 
    //회원리스트 전체 조회하기
    @RequestMapping("/memberList.do")
    public String memberList(Model model) {
    	//memberList()가 반환한 List컬렉션을 Model객체에 저장한 후 뷰로 전달.
    	model.addAttribute("memberList", memberDAO.memberList());
        return "memberList";       
    }
}

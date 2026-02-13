package com.exam.springboot.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@Autowired
	MemberVO member1;
 
	@Autowired
	@Qualifier("student")
	IPerson iPerson1;
	
	@Autowired
	MemberVO member2;
	
	//@Component를 주석처리 했으므로 여기서 오류 발생됨.
//	@Autowired
//	@Qualifier("teacher")
//	IPerson iPerson2;
	
	@RequestMapping("/")
	@ResponseBody 
	public String root() {
		
		member1.memberPrint();
		
		//자동주입 받았을때는 필요없는 코드
		member2.setiPerson(new Teacher());//자동주입 안될때는 new를 통해 빈생성
		member2.memberPrint();
		
		return "Annotation 사용하기";
	}
		
}

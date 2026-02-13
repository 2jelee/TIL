package com.kosmo.k11security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	/*
	시큐리티 1단계 : 기본페이지 사용하기
	 */
	//USER 권한이 있어야 접근가능한 요청명
	@RequestMapping("/security1-1/index.do")
	public String security1_1(){
		return "09Security/Step1/index";
	}
	//권한없이 누구나 접근가능한 요청명
	@RequestMapping("/security1-2/access.do")
	public String security1_2() {
		return "09Security/Step1/access";
	}
}

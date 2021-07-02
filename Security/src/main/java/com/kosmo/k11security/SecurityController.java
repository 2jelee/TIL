package com.kosmo.k11security;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	/*
	시큐리티 2단계 : 커스텀 로그인 페이지 사용하기
	 */
	@RequestMapping("/security2/index.do")
	public String securityIndex2(Principal principal, 
			Authentication authentication, Model model) {
		/*
		controller에서 시큐리티를 통해 로그인한 사용자 정보를 얻어오기
		: @Controller로 선언된 클래스에서는 메소드 인자로 Principal 객체를 통해
		  사용자 아이디를 얻어올 수 있다.
		*/
		
		//방법 1] Principal 객체를 통한 사용자 아이디 얻기
		String user_id = principal.getName();
		System.out.println("user_id="+user_id);
		
		//방법 2] Authentication 객체를 통한 사용자 아이디 얻기
		UserDetails userDetails = 
				(UserDetails)authentication.getPrincipal();
		String detail_id = userDetails.getUsername();
		System.out.println("detail_id="+detail_id);
		
		/*
		// SecurityContextHolder 전역변수를 이용하여 얻어오는 방법
		방법 3] 일반적인 클래스에서 사용자 정보 얻어오기
				스프링 컨테이너의 전역변수로 선언된 SecurityContextHolder객체를 이용해서 
				사용자 아이디를 얻어올 수 있다.
		 */
		Object object = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserDetails sch = (UserDetails)object;
		String sch_id = sch.getUsername();
		System.out.println("sch_id"+sch_id);
		
		model.addAttribute("user_id", user_id);

		return "09Security/Step2/index";
	}
	@RequestMapping("/security2/login.do")
	public String securityIndex2Login(Model model, Principal principal) {
		
		String user_id = "";
		try {
			user_id = principal.getName();
			System.out.println("user_id="+user_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("user_id", user_id);
		return "09Security/Step2/login";
	}
	@RequestMapping("/security2/accessDenied.do")
	public String securityIndex2AccessDenied() {
		return "09Security/Step2/accessDenied";
	}
	@RequestMapping("/security2/admin/main.do")
	public String securityIndex2AdminMain() {
		return "09Security/Step2/adminMain";
	}
	
	
	
	
	@RequestMapping("/security3/form.do")
	public String formPage() {
		return "09Security/Warning/postForm";
	}

}

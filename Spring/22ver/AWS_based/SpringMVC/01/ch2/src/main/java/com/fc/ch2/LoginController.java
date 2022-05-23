package com.fc.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
//	@RequestMapping("/login")
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// [Session] 1. session 종료
		session.invalidate();
		
		// [Session] 2. 홈으로 이동 
		return "redirect:/";
	}
	
	@PostMapping("/login")
//	public String login(@CookieValue("id") String cookieId, String id, String pwd, boolean remeberId, String toURL, 
	public String login(String id, String pwd, boolean remeberId, String toURL, 
						HttpServletResponse response, HttpServletRequest request) throws Exception {
//	public String login(String id, String pwd, String remeberId) throws Exception {
				
		//1. id와 pwd를 확인 
		if(!loginCheck(id, pwd)) {
			//2-1. 일치하지 않으면 loginForm으로 이동  
			String msg = URLEncoder.encode("id 또는 패스워드가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg="+msg; //redirect하는 경우에 GET으로 간다. => 즉, GetMapping된 loginForm() 메서드가 받는다.
		}
		
		// 2-2. 일치하면 
		// [Session] 세션 객체 얻어오기  
		HttpSession session = request.getSession();
		// [Session] 세션 객체에 id 저장 
		session.setAttribute("id", id);
		
		if (remeberId) { //boolean type
			// 1. 쿠키를 생성
			Cookie cookie = new Cookie("id", id);  
			// 2. 응답에 저장
			response.addCookie(cookie);			
		} else { 
			// 1. 쿠키를 생성
			Cookie cookie = new Cookie("id", id);  
			// 2. 응답에 저장
			cookie.setMaxAge(0); //쿠키를 삭제 
			response.addCookie(cookie);	//응답에 저장 
		}
			
		// 3. 홈으로 이동 
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:"+toURL; //index.jsp로 가도록 
	} 
	
	private boolean loginCheck(String id, String pwd) { 
//		return true;
		return "asdf".equals(id) && "1234".equals(pwd); // id가 asdf고 패스워드가 1234일때 로그인 되도록 
		// 순서를 이와 같이 한 이유가 있다. 기본적으로 매개변수 null check를 해야하나, 다음과 같은 순서일 경우 할 필요 X
	}
}

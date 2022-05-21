package com.fc.ch2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
//	public String list() {
	public String list(HttpServletRequest request) {		
//		if(!logincheck()) {
		if(!logincheck(request)) {		
			return "redirect:/login/login";
		}
		return "boardList";
	}

	private boolean logincheck(HttpServletRequest request) { 
		// 1. session 얻어서 
		HttpSession session = request.getSession();
		// 2. 세션에 id가 있는지 확인 / 있으면 true를 반환
//		if(session.getAttribute("id")!=null) {
//			return true;
//		}
//		else return false;

		// if~else 줄을 간략히
		return session.getAttribute("id")!=null; // null이 아니면 true
	}
}

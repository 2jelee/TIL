package com.example.response.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.response.dto.User;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
 
@Controller
@Slf4j		 // log찍는 
@Builder
public class PageController {
	@RequestMapping("/main") // GET, http://localhost:8182/main 
	public String main() {
		return "main.html";
	}
	
	@ResponseBody
	@GetMapping("/user") // GET, http://localhost:8182/user 
	public User user() {
		User user = new User();
//		var user = new User(); // 11 version부터 위와 같은 코드로 만드는. (var => 타입 추론)
		user.setName("1jelee");
		user.setAddress("인천");
		
		return user;
		
	}
}

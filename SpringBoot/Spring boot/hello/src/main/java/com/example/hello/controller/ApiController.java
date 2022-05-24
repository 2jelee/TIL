package com.example.hello.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Rest API를 처리하는 컨트롤러로 등록 
@RequestMapping("api")
public class ApiController {
	@GetMapping("/hello")
	public String hello() {
		return "스프링부트 실행 "+new Date()+"\n";
	}
}

package com.example.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client") // [GET], http://localhost:8183/api/client
public class ApiController {
	@GetMapping("/hello")
	public String getHello() {
		return "GET hello";
	}
}

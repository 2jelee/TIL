package com.example.hello.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dto.PostRequestDto;

/*
	String : value
	number : value
	boolean : value
	object : value{ }
	array : value[ ]
	
	JSON 		=> 주로 snake_case 사용 
	{
		"phoneNumber" : "010-1234-5678",
		"age" : 10,						 //number type이므로 "" 쓰지 X
		"isAgree" : false,
		"account" : {
						"email" : "2jelee@gmail.com",
						"password" : "12345"
					}
		
	}
	
	// [USER] 조회하는 경우
	{
		"user_list": [
			{
				"account": "2jelee",
				"password": "1234"
			}
		]
	}
 */

@RestController
@RequestMapping("/api")
public class PostApiController {
	@PostMapping("/post")
	public void post(@RequestBody Map<String, Object> requestData) { // [GET] @RequestParam | [POST] @RequestBody
//		requestData.entrySet().forEach(strObjectEntry -> {
//			System.out.println("Key (strObjectEntry's getKey()) : "+ strObjectEntry.getKey());
//			System.out.println("Value (strObjectEntry's getValue()) : "+ strObjectEntry.getValue());
//			
//		}); 
		requestData.forEach((key, value)->{
			System.out.println("key : "+ key);
			System.out.println("value : "+ value); 
		});
	}
	
	@PostMapping("/post-object")
	public void postObject(@RequestBody PostRequestDto reqData) {
		System.out.println("reqData: "+reqData);
	}
}

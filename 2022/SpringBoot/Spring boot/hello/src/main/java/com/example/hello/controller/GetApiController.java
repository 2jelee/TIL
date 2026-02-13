package com.example.hello.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
	
	@GetMapping(path="/hello") // path="/hello"
	public String getHello() {
		return "get Hello";
	}
	
	@RequestMapping(path="/hi", method=RequestMethod.GET)
	public String hi() {
		return "hi";
	}
	
	// 주소줄에 소문자로 기재해야 한다 => camelCase 사용 X
	@GetMapping("/path-variable/{id}") // 
	public String pathVariable(@PathVariable(name="id") String pathId) {	 // @PathVariable
		System.out.println("pathVariable's pathId = " + pathId);
		return pathId;
	}
	
	//구글에서 검색어 ham으로 검색 결과 가져옴
	/*
	https://www.google.com/search?q=ham
	&rlz=1C6CHFA_enKR1001
	&sxsrf=ALiCzsauKx-kfRoNnBDgNtEHZHEI08x92A%3A1653283807706
	&source=hp
	&ei=3xuLYr6DKYjP2roPgK-t4AM
	&iflsig=AJiK0e8AAAAAYosp73KRcqpFeyuDXRA8cBswmczgDnuP
	&ved=0ahUKEwj-7saQ8vT3AhWIp1YBHYBXCzwQ4dUDCAk
	&uact=5
	&oq=ham
	&gs_lcp=Cgdnd3Mtd2l6EAMyCAgAEIAEELEDMgsILhCABBCxAxCDATIOCC4QgAQQsQMQgwEQ1AIyBQguEIAEMg4ILhCABBCxAxDHARCjAjILCC4QgAQQsQMQ1AIyCwgAEIAEELEDEIMBMggIABCABBCxAzILCC4QgAQQsQMQgwEyBQgAEIAEOgYIswEQhQQ6DgguEIAEELEDEMcBENEDOg0ILhCABBDHARDRAxAKOhEILhCABBCxAxCDARDHARCjAjoUCC4QgAQQsQMQgwEQxwEQowIQ1AI6EQguEIAEELEDEIMBEMcBENEDOgQILhADOgoILhDHARDRAxADULkIWNsvYNYwaAZwAHgAgAG6AYgBqQWSAQMwLjSYAQCgAQGwAQE&sclient=gws-wiz
	*/
	
	@GetMapping(path="query-param")
//	public String queryParam(Map<String, String> queryParam) {
	public String queryParam(@RequestParam Map<String, String> queryParam) { // @RequestParam
		StringBuilder sb = new StringBuilder();
		queryParam.entrySet().forEach(entry -> { //entrySet : 추상메서드.. -> set으로 분리
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
			sb.append(entry.getKey()+" = "+ entry.getValue()+"\n");
		});
		return sb.toString();
	}
	// http://localhost:8181/api/get/query-param?name=2jelee
	
	@GetMapping(path="query-param2") 
	public String queryParam2(@RequestParam String name, 
								@RequestParam String email, 
								@RequestParam int age) { // @RequestParam 
		System.out.println("name = " + name);
		System.out.println("email = " + email);
		System.out.println("age = " + age);
		
		return name+ ", "+email+", "+age;
	}
	
	// ?
	@GetMapping(path="query-param3") 
	public String queryParam3(UserRequest ur) {   //객체 타입으로 리턴할 때는 @RequestParam 사용 X => 권장 방식   
		  System.out.println(ur.getName());
		  System.out.println(ur.getEmail());
		  System.out.println(ur.getAge()); 
		
//		System.out.println(ur.get);
		
		return ur.toString();
	}
}

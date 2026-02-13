package com.example.response.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.response.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	// TEXT
	@GetMapping("/text") // GET, http://localhost:8182/api/text?account=user100
	public String text(@RequestParam String account) {
		return account;
	}
	
	// JSON
	@PostMapping("/json") // POST, http://localhost:8182/api/json (json 뒤에 절대 / 붙이지 말자!!)
	public User json(@RequestBody User user) { //@RequestBody 받아오자 << POST이므로 
		System.out.println("user : "+user);

		/*
		객체(Obj) 타입으로 리턴을 받으면 get 메소드를 보게 되는데, 
		Int 타입은 X (null로 반환됨) -> Primative type (Integer)을 사용해야 한다. 
		*/
		// req -> Object mapper -> object -> method -> object mapper -> json -> response
		return user; // 200 OK
	}

	// ResponseEntity
	@PutMapping("/put") // PUT, http://localhost:8182/api/put
	public ResponseEntity<User> put(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(user); // CREATED : 201
	}
}

/*
{
	"name": "2jelee",
	"age": 10,
	"phoneNumber": "010-1234-5678",
	"address": "경기도 성남시 수정구"
}
*/
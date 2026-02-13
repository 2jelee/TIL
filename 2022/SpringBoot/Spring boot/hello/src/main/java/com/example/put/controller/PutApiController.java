package com.example.put.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.put.dto.PostRequestDTO;

@RestController
@RequestMapping("/api")
public class PutApiController {

	@PutMapping("/put")
	public PostRequestDTO put(@RequestBody PostRequestDTO requestDTO) {
		System.out.println(requestDTO);
		return requestDTO;
	}
	
	@PutMapping("/put-id/{userId}")
	public PostRequestDTO put(@RequestBody PostRequestDTO requestDTO, 
//			Long userId) {
			@PathVariable(name="userId") Long user_id) { //mapping된 이름과 다를 때 
		System.out.println("user_id : " + user_id);
		return requestDTO;
	}
}



/*
{
	"name": "2jelee",
	"age": 20,
	"car_list": [
	    {
	      "name": "BMW",
	      "car_name": "11가 1234"
	    },
	    {
	    	"name": "Sonata",
	      "car_name": "22가 5678"
	    }
	]
}
 */
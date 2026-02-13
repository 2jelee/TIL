package com.example.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor		 //생성자 함수 사용하기 
public class Sample {
	private  String id;
	private  String name;
	
//	@Builder
//	public Sample(String id, String name) {
//		this.id = id;
//		this.name = name;
//	}
		
}

// 데이터를 set method 없이 쓰기 
class SampleTest{
//	private String id = "2jelee";
//	private String name = "가나다";
	
	Sample sample = Sample.builder()
//									.id(id)
									.id("플라밍고")
//									.name(name).
									.name("밍고")
									.build();
}

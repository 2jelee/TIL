package com.example.put.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(value=PropertyNamingStrategy.SnakeCaseStrategy.class) //해당 클래스 전체에 일괄적으로 snake_case로 바꿔주기
public class PostRequestDTO {
	private String name;
	private int age;
	private List<CarDTO> carList;
	
}

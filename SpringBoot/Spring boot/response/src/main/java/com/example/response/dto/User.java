package com.example.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
//import lombok.Data;

@JsonNaming(value=PropertyNamingStrategy.SnakeCaseStrategy.class) // pom.xml >> 2.4.6
//@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // null값 포함시키고 싶지 않으면.
public class User {
	private String name;
	
//	private int age;
	private Integer age; //primative Type
	
//	@JsonProperty("phone_number")
	private String phoneNumber; 
	
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
 
	
}

package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
[JSON 예시]

{
	"account": "2jelee",
	"email": "2jelee@sw.or.kr",
	"address": "경기도 성남시 수정구",
	"password": "1223",
	"phone_number": "010-1234-5678",
	"OPT": "1234OPT"
}

 */

public class PostRequestDto {
	// 권장 : snake_case
	private String account, email, address, password;
	
	@JsonProperty("phone_number")
	private String phoneNumber; // camelCase -> 문제발생 소지 있음 => 대신 처리 방법이 따로 존재 (@JsonProperty("phone_number") 사용)
	
	@JsonProperty("OPT") // 이러한 것이 있다고 알려주기 (카멜도, 스네이크도 아닌 것들인 경우도 이 어노테이션을 사용해서 인식시킴)
	private String OPT; // 무조건 다 대문자로 지정한 경우에 해당 (Rest API는 소문자 사용해라: 주소줄에 대문자 사용 X)

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOPT() {
		return OPT;
	}

	public void setOPT(String oPT) {
		OPT = oPT;
	}

	@Override
	public String toString() {
		return "PostRequestDto [account=" + account + ", email=" + email + ", address=" + address + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", OPT=" + OPT + "]";
	}
	
	
}

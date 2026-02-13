package com.exam.springboot.jdbc;

import lombok.Data;

/*
kosmo계정의 member테이블을 대상으로 DTO객체 생성
 */
@Data
public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String regidate;
	
}

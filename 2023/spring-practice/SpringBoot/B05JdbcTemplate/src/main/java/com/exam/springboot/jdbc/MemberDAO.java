package com.exam.springboot.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	//JdbcTemplate객체를 자동으로 주입받음
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//회원테이블 전체 조회
	public List<MemberDTO> memberList(){
		//쿼리문 작성
		String query = "SELECT * FROM member";
		/*
		select계열의 쿼리문을 실행한 후 ResultSet을 얻어와서 
		타입 매개변수로 설정된 DTO객체에 순서대로 저장한 후 
		List컬렉션으로 결과값을 반환한다. 
		 */
		List<MemberDTO> list = 
				jdbcTemplate.query(query, 
						new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		
		return list;
	}	
}


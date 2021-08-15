package com.exam.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/*
컨트롤러와 Mapper사이에서 서비스 역할의 인터페이스 정의 
 */
@Mapper
public interface IMyUserDAO {

	//회원리스트 보기를 위한 추상메소드 
	List<MyUserDTO> userList();
}

package com.example.jpaBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaBoard.model.Board;

// interface가 interface 상속 : extends
// <T, ID> : template type(자료형이 결정되지 않은) | Primary key로 지정한 id의 자료형 타입 
public interface BoardRepository extends JpaRepository<Board, Integer> {

	
}

//package com.example.jpaBoard.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.domain.Sort.Order;
//import org.springframework.stereotype.Service;
//
//import com.example.jpaBoard.model.Board;
//import com.example.jpaBoard.repository.BoardRepository;
//
//@Service
//public class BoardServiceImpl implements BoardService{
//	@Autowired
//	BoardRepository boardRepository;
//
//	@Override
//	public Page<Board> findAll(Integer currentPage) {
////		Sort sort = new Sort(null);
//		PageRequest pr = new PageRequest(currentPage, 5, 
//										new Sort(new Order(Direction.DESC, "reply"),
//												 new Order(Direction.ASC, "reply_step")
//												)
//										);
////		protected PageRequest(int page, int size, Sort sort) {
//		return boardRepository.findAll(pr);
//	}
//	
//	
//	
//}

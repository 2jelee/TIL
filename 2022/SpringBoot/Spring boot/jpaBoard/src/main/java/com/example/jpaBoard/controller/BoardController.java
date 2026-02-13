package com.example.jpaBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jpaBoard.model.Board;
import com.example.jpaBoard.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
//	@RequestMapping(value="/", method = RequestMethod.GET)
	@GetMapping("/")
	public String index() {
		return "redirect:/board/list/0";
	}
	
	@GetMapping("/list/{currentPage}")
	public String findAll(Model model, Pageable pageable, @PathVariable Integer currentPage) {
		Page<Board> page = boardService.findAll(currentPage);
		model.addAttribute("page", page);
		
		return "list"; // /jsp/ + list + .jsp
	}
}

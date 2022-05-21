//package com.fc.ch2;
//
//import java.io.FileNotFoundException;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller; 
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ResponseStatus(HttpStatus.BAD_REQUEST) // 500 -> 400
//class MyException extends RuntimeException{
//	MyException(String msg){
//		super(msg);
//	}
//	MyException() { this(""); }
//	
//}
//@Controller
//public class ExceptionController2 {  
//	@RequestMapping("/ex3")
//	public String main() throws Exception { 
//		throw new MyException("예외가 발생했습니다.");  
//	}
//	
//	@RequestMapping("/ex4")
//	public String main2() throws Exception { 
//		throw new NullPointerException("NullPointerException 예외가 발생했습니다.");    
//	}
//	
//	@RequestMapping("/ex3")
//	public String main3() throws Exception { 
//		throw new FileNotFoundException("FileNotFoundException 예외가 발생했습니다."); // 다음과 같이 FileNotFoundException 처럼 일치하는 예외가 없으면 최고 조상인 Exception이 처리
//	}
//}

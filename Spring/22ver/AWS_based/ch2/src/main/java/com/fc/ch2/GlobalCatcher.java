package com.fc.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice("com.fc.ch2") // 지정 : 해당 패키지만 적용해라.
@ControllerAdvice // 지정X : 모든 패키지에 적용해라. 
public class GlobalCatcher { 
	// try~catch문을 사용함으로써 각 메서드에서 공통으로 발생하던 에러(코드 중)를 따로 메서드로 처리 + @ExceptionHandler 함.
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 -> 500 error
	public String catcher(Exception ex, Model m) { 
//		System.out.println("catcher() in ExceptionController !");
		m.addAttribute("ex", ex); // 어떤 종류의 에러인지 뷰단에 출력하기  
		return "error";
	}
	
//	@ExceptionHandler(NullPointerException.class)
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);  
		return "error";
	}
}

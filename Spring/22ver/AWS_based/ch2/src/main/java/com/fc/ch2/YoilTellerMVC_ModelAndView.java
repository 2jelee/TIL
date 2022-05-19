package com.fc.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 연 월 일을 입력하면 요일을 알려주는 프로그램 
@Controller
public class YoilTellerMVC_ModelAndView {
//	public static void main(String[] args) {	
	@RequestMapping("/getYoilMVC")
	// http://localhost:8080/ch2/getYoilMVC?year=2022&month=5&day=16
//	public String main(int year, int month, int day, Model model) throws IOException {
//	public void main(int year, int month, int day, Model model) throws IOException { 
	
	// 반환타입을 ModelAndView로 주기 => model과 view를 합치기 (parameter로 Model을 만들지 않고 내부에서 만든다.)  
	public ModelAndView main(int year, int month, int day) throws IOException {	
		// 반환 타입 ModelAndView이므로 내부에 객체 생성 
		ModelAndView mv = new ModelAndView();
		
		// *1. 유효성 검사
//		if(!isValid(year, month, day)) {
//			return "yoilError";
//		}
		
		// 2. 요일 계산 
		char yoil = getYoil(year, month, day);
		
		// 3. 계산한 결과를 model에 저장
//		model.addAttribute("year", year);		
//		model.addAttribute("month", month);
//		model.addAttribute("day", day); 
//		model.addAttribute("yoil", yoil); 
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil); 
		 
//		return "yoil";	//jsp | /WEB-INF/views/yoil.jsp
		
		// 결과를 보여줄 view를 지정하여 같이 넘겨주기 
		mv.setViewName("yoil");
		return mv;
	}
		
		// 1. 입력 => 제거 
	
	// 유효성 검사 추가 
	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true; // return false일 경우, yoilError.jsp 파일로 넘어간다. 
	}

	// 이 클래스 안에서만 사용하므로 private으로 했다.
	private char getYoil(int year, int month, int day) {			
		// 2. 작업
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		
		// 1 = 일요일 
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); 
		return " 일월화수목금토".charAt(dayOfWeek);
		
		// 3. 출력 => return으로 간단하게 
//		return "yoil"; //jsp | /WEB-INF/views/yoil.jsp
	} 
} 
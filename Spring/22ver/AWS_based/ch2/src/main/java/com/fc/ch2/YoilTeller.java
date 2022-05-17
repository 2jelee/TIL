package com.fc.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 연 월 일을 입력하면 요일을 알려주는 프로그램 
@Controller
public class YoilTeller {
//	public static void main(String[] args) {	
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 입력 
//		String year = args[0];
		String year = request.getParameter("year");
//		String month = args[1];
		String month = request.getParameter("month");
//		String day = args[2];
		String day = request.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);

		// 2. 작업
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd);
		
		// 1 = 일요일 
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		// 3. 출력 
//		System.out.println(year + "년 " + month +"월 " + day + "일은 ");
//		System.out.println(yoil+"요일입니다.");
		
		// response 객체로 브라우저 상에 출력하기.
//		response.getWriter(); // response 객체에서 브라우저로의 출력 스트림을 얻는다. //getWriter => IOException으로 위임
		// 브라우저는 자신이 보내는 파일이 바이너리인지 텍스트인지 모르므로 알려줘야 한다.
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8"); //한글 깨짐 방지
		
		PrintWriter out = response.getWriter(); 
		out.println(year + "년 " + month +"월 " + day + "일은 ");
		out.println(yoil+"요일입니다.");
	}
} 
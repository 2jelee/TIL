package com.kosa.date;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/serverDate")
@WebServlet("/douzone")
/* [웹 페이지 등록 1. ] annotation 뒤 "/ ~~" 경로를 반드시 표시해주자. */
public class ServletDate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response); 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response); 
	}

	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {  // 예외처리
			System.out.println("Hello Servlet");
			
			response.setCharacterEncoding("euc-kr"); // 한글깨짐 처리
			Calendar c = Calendar.getInstance();  //시스템이 갖고 있는 날짜를 얻어옴
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			// 추상클래스는 객체를 생성할 수 없으나 getWriter(response라는 )를 통해 생성 
			PrintWriter out = response.getWriter();  // 예외 발생함
			out.write("<html><head><title>서버측 시간을 얻어서 씁니다.</title></head>");
			out.write("<body><h1><font color='red'> Hello Servlet </font></h1>");
			out.write("<h2>현재 시간은 ");
			out.write(Integer.toString(hour) + " 시");
			out.write(Integer.toString(minute) + " 분");
			out.write(Integer.toString(second) + " 초 입니다.");
			
			out.write("</h2></body></html>");
			out.close();
	}
	
}









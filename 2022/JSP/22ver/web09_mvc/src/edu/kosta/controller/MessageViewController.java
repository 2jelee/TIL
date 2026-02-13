package edu.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class MessageViewController extends HttpServlet implements Servlet {
	// 1. 전송방식 결정
	// 2. 사용자 요청 분석 (doGet / doPost 방식)	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		  doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 doProcess(request, response);
	}
	
	// 2. 사용자 요청 처리 메세지 (doGet / doPost 방식)
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String msg = request.getParameter("message");
		Object result = null;
		
		if( msg == null || msg.equals("test") ) {
			result = "메세지가 없거나, test로 넘어왔습니다.";
			
		} else if( msg.equals("name") ) {
			result = "나의 이름은 kingsmile입니다";
			
		} else if( msg.equals("aa") ) {
			result = "aa 입니다";
		} else {
			result = "찾는 type이 없군요";
		} // if end
		
		//3. 저장 - request.setAttribuet("변수", 값or변수(데이터) ); 
		request.setAttribute("result", result);
		
		// 4. 해당 뷰 페이지로 이동
		RequestDispatcher  dispatcher 
						= request.getRequestDispatcher("/view/messageView.jsp");
		dispatcher.forward(request, response);	
	}
}








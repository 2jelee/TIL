package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mp")
public class MessageProcess extends HttpServlet implements CommandProcess {

/*	@Override
	public void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws Throwable {
		request.setAttribute("message", "hi~~~ MVC 기반의 데이터 보내기");
		
		RequestDispatcher  d = request.getRequestDispatcher("/view/messageProcess.jsp");
		d.forward(request, response);
	}*/
	
	@Override
	public String doProcess(HttpServletRequest request,
			         HttpServletResponse response) throws Throwable {
		request.setAttribute("message", "메세지 변경했습니다");
		return "/view/messageProcess.jsp";
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try{
			 //doProcess(request, response);
			RequestDispatcher  d = request.getRequestDispatcher(doProcess(request, response));
			d.forward(request, response);
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try{
			 //doProcess(request, response);
			RequestDispatcher  d = request.getRequestDispatcher(doProcess(request, response));
			d.forward(request, response);
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
}

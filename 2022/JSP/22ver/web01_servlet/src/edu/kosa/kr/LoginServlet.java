package edu.kosa.kr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// DB 대체
	public String user = "jel";
	public String passwd = "1234"; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// network로 왔다갔다하는 애들 => text이므로 " " 로 받는다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 한글깨짐 UTF-8 설정
		response.setCharacterEncoding("euc-kr");
		
		//IO 객체(PrintWriter)로 출력 객체 생성
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Login Result</title></head><body><b><br> ");
		
		if(user.equals(id) && !passwd.equals(pwd)) {
			out.println("암호가 틀렸습니다. <br>");
			out.println("<a href='html/loginForm.html'> Login </a> ");
		} else if(user.equals(id) && passwd.equals(pwd)) {
			out.println("반갑습니다. 어서오세요! <br>");
			out.println("당신의 아이디는 "+ id + " 입니다. <br> ");
			out.println("당신의 암호는 "+ pwd+ " 입니다. <br> ");
		} else {
			out.println("등록되지 않은 사용자입니다. <br> ");
		}
		out.println("</b></body></head></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ArrayServlet.do")
public class ArrayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String[] arrayStr = request.getParameterValues("string[]");
		System.out.println(Arrays.toString(arrayStr));
		
		if( arrayStr != null ) {
			PrintWriter out = response.getWriter();
			out.write("[" + arrayStr[0] + " , " + arrayStr[1] +"]" );
			out.close();
		} // end if
	}

}






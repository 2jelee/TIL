package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IdCheckAction.do")
public class IdCheckAction extends HttpServlet {
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml");
		String id = req.getParameter("id");
		String xml = "";
		
		if( id.equals("kingsmile") ) {
			xml = "<id>y</id>";
		} else {
			xml = "<id>n</id>";
		} // if end
		
		PrintWriter out = resp.getWriter();
		out.write(xml);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	
}

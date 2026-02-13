package edu.kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageProcess implements CommandProcess {

	@Override
	public String doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String str = "th160기 Kosta 홧팅!!!";
		//저장
		request.setAttribute("message", str);
		// 페이지 이동( 실제 처리 뷰)
		return "/view/show.jsp";
	}

}

package edu.kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListController implements CommandProcess {

	@Override
	public String doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		request.setAttribute("message", "List page 입니다");
		// 페이지 이동( 실제 처리 뷰)
		return "/view/list.jsp";
	}

}

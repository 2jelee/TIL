package edu.kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteController implements CommandProcess {

	@Override
	public String doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		request.setAttribute("message", "Write page 입니다");
		// 페이지 이동( 실제 처리 뷰)
		return "/view/write.jsp";
	}

}

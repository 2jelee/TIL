package com.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InfoController implements Controller {  // Controller

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// 본인 주소, 학과, 학교 
		String address = "서울 연희동";
		ModelAndView mav = new ModelAndView();
		mav.addObject("address", address);
		mav.addObject("subject", "디지털콘텐츠학과");
		mav.addObject("st", "KOSA대학교");
		
		mav.setViewName("info"); //   /WEB-INF/views/+ info + .jsp
		//mav.setViewName("/WEB-INF/views/info.jsp"); // move view page
		
		return mav;
	}

}

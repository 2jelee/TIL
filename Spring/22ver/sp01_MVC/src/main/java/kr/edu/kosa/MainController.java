package kr.edu.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller {  // Controller 
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String name = "강감찬";
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);  // data save
		mav.addObject("age",  33);
		mav.setViewName("main");  //   /WEB-INF/jsp/ + main + .jsp
		
		/*mav.setViewName("/WEB-INF/jsp/main.jsp");*/  // move view page
		
		return mav;
	}

}

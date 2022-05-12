package kr.edu.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//import com.sun.org.slf4j.internal.Logger; 
 

public class HelloController implements Controller {
	
//	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
//	logger.info("Welcome hello.jsp page move");

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("nickname", "king"); 	// data
		mv.setViewName("/views/hello.jsp"); // move views
		
		return mv;
	}

}

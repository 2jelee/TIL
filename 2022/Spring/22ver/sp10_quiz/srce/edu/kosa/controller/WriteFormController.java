
package edu.kosa.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class WriteFormController {
//	
//	@RequestMapping("/writeform.do")
//	public String writeForm(Model model) {
//		
//		return "writeform";  //   /WEB-INF/views/ + writeform + .jsp
//	}
//	
//}
//


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriteFormController {
	
	@RequestMapping("/writeForm.do")
	public String writeForm(Model model) {
		
		return "writeForm";  //   /WEB-INF/views/ + writeform + .jsp
	}
	
}


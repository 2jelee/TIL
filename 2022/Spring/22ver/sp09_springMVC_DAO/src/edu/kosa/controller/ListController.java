package edu.kosa.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.kosa.model.GuestDAO;

@Controller
public class ListController {
	
	private GuestDAO  guestDAO;   // DB 연결 관련

	public void setGuestDAO(GuestDAO guestDAO) {   // DI
		this.guestDAO = guestDAO;
	}
	
	//@RequestMapping("/aa.do")     //  localhost:8080/list/aa.do
	@RequestMapping("list.do")
	public  String list(Model model) { 
		List list = guestDAO.listGuest(); 
		model.addAttribute("list", list);  // data save
		
		return "list" ;    //   /WEB-INF/views/ + list + .jsp
	}

	@RequestMapping("/hello.do")
	//public String  hello() {
	public ModelAndView  hello() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("greeting", getGreeting());
		mav.setViewName("hello");  //  hello.jsp
		
		return mav; 
		//return "hello";     
	}
	
	public  Object getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if( hour >= 6 && hour <= 11) {
			return "좋은 아침";
		} else 	if( hour >= 12 && hour <= 15) {
			return "점심입니다. 밥 먹고 졸려요";
		} else 	if( hour >= 18 && hour <= 20) {
			return "편한 저녁입니다.";
		}
		
		return "Hello World";
	}
}  

package com.kosmo.k11springlegacy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import common.StudentDTO;

@Controller
public class RequestMappingController {

	//검색페이지에 대한 매핑만 단순히 설정. << 여기 주석 위치 맞?
	@RequestMapping("/requestMapping/index.do")
	public String rmIndex() {
		
		return "02RequestMapping/index";
	}
	
	
	
	/*
	단순히 요청명만 매핑하는 경우에는 value, method를 생략할 수 있으ㅏㄴ
	전송방식까지 명시해야할 경우에는 속성을 제거하면 error 발생
	*/
	@RequestMapping(value="/requestMapping/getSearch.do",
			method=RequestMethod.GET)
	public String getSearch(HttpServletRequest req,
		Model model) {
		
		System.out.println("RequestMethod.GET 방식으로 " + "폼값전송");
		
		//request객체를 통해 폼값받기
		String sColumn = req.getParameter("searchColumn");
		String sWord = req.getParameter("searchWord");
		
		//model객체에 저장하기
		model.addAttribute("sColumn", sColumn);
		model.addAttribute("sWord", sWord);
		
		//View를 호출
		return "02RequestMapping/getSearch";
		
	}
	
	/*
	ModelAndView객체 	<< 사용도 높
		: View로 전송할 데이터의 저장과 View를 호출하는 2가지 기능을
		  동시에 처리할 수 있는 클래스
		
		-View 설정 : 참조변수.setViewName("뷰의경로 및 파일명")
		-model객체에 데이터 저장 : 참조변수.addObject("속성명", "속성값")
		최종적으로 뷰를 호출할때는 ModelAndView 참조변수를 return한다.
	 */
	@RequestMapping(method=RequestMethod.POST,
		value="/requestMapping/postLogin.do")
	public ModelAndView postLogin(
			@RequestParam("user_id") String id,
			@RequestParam("user_pw") String pw
		) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("02RequestMapping/postLogin");
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		
		/*
		ModelAndView 객체를 반환하여 뷰를 호출한다.
		해당 메소드의 반환타입도 해당 객체타입으로 지정함.
		 */
		return mv;
	}
	
	
	/*
	@ModelAttribute 어노테이션
		: 뷰로 전달되는 커멘드객체의 이름을 임의로 변경하고 싶을때 사용함.
		  studentDTO를 si로 변경하여 뷰로 전달함.   << 정확히는 모델에 저장되어야 뷰로 전달될 수 있으므로
		  (여기서 si => studentInfo)
	 */
	@RequestMapping("/requestMapping/modelAttribute")
	public String studentInfo(
		@ModelAttribute("si") StudentDTO studentDTO) {
		
		return "02RequestMapping/modelAttribute";
	}
			
}

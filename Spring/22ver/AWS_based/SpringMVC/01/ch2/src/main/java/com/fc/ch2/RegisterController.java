package com.fc.ch2;
  
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 

@Controller
public class RegisterController {
	@InitBinder
	public void toDate(WebDataBinder binder) {
		// User.java에 다음과 같이 선언: @DateTimeFormat(pattern="yyyy-mm-dd") 함으로써 필요 없어지는 코드 
//		SimpleDateFormat df = new  SimpleDateFormat("yyyy-mm-dd"); //CustomDateEditor로 형식만 지정 
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
		
		// [자동 검증]
//		binder.setValidator(new UserValidator()); // UserValidator를 WebBinder의 Validator로 등록 => 로컬 validator로 등록 (로컬: 해당 컨트롤러 내에서만 사용 O)
		
		// [글로벌 Validator]
//		binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList ="+ validatorList);
		
	}
	
//	@RequestMapping(value = "/register/save", method= {RequestMethod.GET, RequestMethod.POST}) // method를 배열 형식으로 선언. => 2가지 모두 허용하겠다.	
//	@RequestMapping("/register/add") // [GET 방식]
//	@PostMapping("/register/add")
//	@GetMapping("/register/add")
	@RequestMapping(value = "/register/add", method= {RequestMethod.GET, RequestMethod.POST}) // method를 배열 형식으로 선언. => 2가지 모두 허용하겠다.		
	public String register() {
		return "registerForm"; 	// WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping("/register/save") // [GET 방식]
	// POST 방식 
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	
	@PostMapping("/register/save") // @PostMapping : Maven 4.3~
//	[ 주의 ] BindingResult 는 바인딩할 객체 바로 뒤에 위치해야 한다.
//	public String save(User user, BindingResult result, Model m) throws Exception { // 여기서 Model은 "/register/save"에 대한 모델이다.
	// [자동 검증] 으로 인한 어노테이션(@Valid) 추가 - 검증할 객체 앞에 
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {  
		
		System.out.println("result: "+result);
		System.out.println("user: "+user);
		
		// [수동 검증] Validator를 직접 생성하고 validator()를 직접 호출 
		// "1. 유효성 검사"를 주석 처리 : 따로 Class 생성 
		// User 객체를 검증한 결과, 에러가 있으면 registerForm을 이용해서 에러를 보여주어야 한다.
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); //BindingResult는 Error의 자손
//		
//		if(result.hasErrors()) {
//			return "registerForm";
//		}
		////////////////////////////// 수동검증 끝 
		
		// 1. 유효성 검사 
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못 입력했습니다.", "utf-8");
//			
//			// 이 두 줄의 코드는 아래 한줄 코드와 동일 (redirect: 재요청) 
//			m.addAttribute("msg", msg);
//			return "foward:/register/add";
////			return "redirect:/register/add?msg="+msg; // URL 재작성(rewriting)
//		}
		// 2. DB에 신규회원 정보를 저장 
		return "registerInfo"; 
	}

	private boolean isValid(User user) { 
		return true;
//		return false;
	}
}

package com.fc.ch2;
 
import java.net.URLEncoder; 
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String save(User user, BindingResult result, Model m) throws Exception { // 여기서 Model은 "/register/save"에 대한 모델이다.
		System.out.println("result: "+result);
		System.out.println("user: "+user);
		
		// 1. 유효성 검사 
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력했습니다.", "utf-8");
			
			// 이 두 줄의 코드는 아래 한줄 코드와 동일 (redirect: 재요청) 
			m.addAttribute("msg", msg);
			return "foward:/register/add";
//			return "redirect:/register/add?msg="+msg; // URL 재작성(rewriting)
		}
		// 2. DB에 신규회원 정보를 저장 
		return "registerInfo"; 
	}

	private boolean isValid(User user) { 
		return true;
//		return false;
	}
}

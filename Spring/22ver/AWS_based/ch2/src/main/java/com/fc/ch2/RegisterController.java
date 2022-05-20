package com.fc.ch2;
 
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 

@Controller
public class RegisterController {
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
	public String save(User user, Model m) throws Exception { // 여기서 Model은 "/register/save"에 대한 모델이다.
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
//		return true;
		return false;
	}
}

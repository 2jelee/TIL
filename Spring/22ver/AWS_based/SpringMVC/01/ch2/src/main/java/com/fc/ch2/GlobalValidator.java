package com.fc.ch2;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GlobalValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
//			return User.class.equals(clazz); // 검증하려는 객체가 User타입인지 확인
		return User.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인
	}

	@Override
	public void validate(Object target, Errors errors) { 
		System.out.println("GlobalValidator.validate() is called");

		//User 객체를 검증 

		User user = (User)target;
		String id = user.getId();
		
//		if(id==null || "".equals(id.trim())) {
//			errors.rejectValue("id", "required");
//		}
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required", "ID는 필수값 입니다."); //3번째 것은 default Message : 웬만하면 넣지 않으며, 파일로 따로 관리한다.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		
		if(id==null || id.length() <  5 || id.length() > 12) {
//			errors.rejectValue("id", "invalidLength");
			errors.rejectValue("id", "invalidLength", new String[] {"", "5", "12"}, null ); //default Message : null로 지정했음 | "": 0을 의미 
		}
		
	}
}

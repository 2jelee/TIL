package com.exam.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.springboot.jdbc.IMyUserDAO;

@Controller
public class MyController {
	
	//DAO 인터페이스 자동주입
	@Autowired
    private IMyUserDAO userDao;

    @RequestMapping("/")
    public String root() {
        return "home";
    }
      
    //회원리스트 가져오기
	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
    public String userlistPage(Model model) {
		//Mapper에서 반환해주는 회원리스트를 담은 List 컬렉션을 View로 전달
		model.addAttribute("userList", userDao.userList());
        return "userlist";
    }

}


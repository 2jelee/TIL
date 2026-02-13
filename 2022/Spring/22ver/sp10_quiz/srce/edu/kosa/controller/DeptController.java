package edu.kosa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kosa.model.DeptDAO;

@Controller
public class DeptController { 
	private DeptDAO deptDAO;    
	
	// DI
	public void setDeptDAO(DeptDAO deptDAO) {  
		this.deptDAO = deptDAO;
	}
	 
	@RequestMapping("dept.do")
	public String dept(Model model) { 
		List list = deptDAO.listDept(); 
		model.addAttribute("dept", list);  // data save
		
		// ? list
		return "dept" ;
	} 
}  

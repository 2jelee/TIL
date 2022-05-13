package edu.kosa.controller;
 

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kosa.model.DeptDAO;
import edu.kosa.model.DeptDTO;

@Controller
public class WriteController { 
	private DeptDAO deptDAO; 
	
	// DI
	public void setDeptDAO(DeptDAO deptDAO) { 
		this.deptDAO = deptDAO;
	}

	@RequestMapping("/write.do")
	public String write(Model model, HttpServletRequest request) { 
		int dcode = Integer.parseInt(request.getParameter("dcode"));
		String dname = request.getParameter("dname");
		int pdept = Integer.parseInt(request.getParameter("pdept"));
		String area = request.getParameter("area"); 
		
		DeptDTO dto = new DeptDTO();
		dto.setDcode(dcode);
		dto.setDname(dname);
		dto.setPdept(pdept);
		dto.setArea(area); 
		
		deptDAO.insertDept(dto); 
		
		return "dept";   //   /WEB-INF/views/ + dept + .jsp
	}
}




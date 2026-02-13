package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import model.JDBCTemplateDAO;
import model.SpringBbsDTO;

public class EditActionCommand implements BbsCommandImpl {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		//커맨드객체를 통해 모든 폼값을 저장한 DTO를 가져온다.
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		SpringBbsDTO springBbsDTO = (SpringBbsDTO)map.get("springBbsDTO");
		
		JDBCTemplateDAO dao = new JDBCTemplateDAO(); // <<이를 사용하므로써 폼값을 개별적으로 받지 않아도 됨. 한번에 받아옴.
													/* 
													String idx = req.getParameter("idx");  
													... (중략)
													//dao.edit(idx, name, title, contents, pass); << 여기서 이를 대체함.
													*/
		
		dao.edit(springBbsDTO);
	}
} 

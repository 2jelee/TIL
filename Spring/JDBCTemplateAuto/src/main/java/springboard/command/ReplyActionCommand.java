package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

@Service
public class ReplyActionCommand implements BbsCommandImpl {
	
	@Autowired
	JDBCTemplateDAO dao;
	
	@Override
	public void execute(Model model) {

		//요청을 한번에 가져옴
		Map<String, Object> paramMap = model.asMap();
		HttpServletRequest req = (HttpServletRequest)paramMap.get("req");
		SpringBbsDTO dto = (SpringBbsDTO)paramMap.get("springBbsDTO");
		
//		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		
		dao.reply(dto);
		//dao.close();
	}

}

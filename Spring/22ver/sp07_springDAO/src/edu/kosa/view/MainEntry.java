package edu.kosa.view; 
 
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.kosa.dao_xml.UserDAO;
import edu.kosa.model.UserVO; 


public class MainEntry {
	public static void main(String[] args) throws Exception  {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ctx.xml");
		UserDAO dao = ctx.getBean("dao", UserDAO.class);
		
		System.out.println("확인하고 싶은 ID ? ");
		String id = new Scanner(System.in).next();
		
		UserVO vo = dao.selectById(id);
		System.out.println("\n");
		System.out.println(vo.getId() + " / " + vo.getName() + " / " + vo.getPassword()); 
		
		// 공통
//			ConnectionMaker conn = new SConnectionMakerImpl();
//			UserDAO dao = new UserDAO(conn) ;
			
//		UserDAO dao = new UserDAO(new SConnectionMakerImpl()); 
//		UserVO vo = new UserVO();
		
//		vo.setId("yuna");
//		vo.setName("김연아");
//		vo.setPassword("1234");
//		
//		dao.insert(vo);		
//		dao.selectAll();
		
		/*
		UserDAO dao = new OracleUserDAOImpl();
		Scanner sc = new Scanner(System.in);
		dao.menu();
		
		switch (sc.nextInt()) {
		case 1:
			UserVO user = new UserVO();
			System.out.print("user id = ");			user.setId(sc.next());
			System.out.print("user name = ");	user.setName(sc.next());
			System.out.print("user pwd = ");		user.setPassword(sc.next());
			
			dao.insert(user);
			System.out.println(user.getId() + " 추가 성공!!!");
			System.out.println("============================");
			break;
			
		case 2 :
			break; 
			
		default:
			break;
		}*/
	}
} 

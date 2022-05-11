package edu.kosa.view;

import java.sql.Connection;
import java.util.Scanner;

import edu.kosa.dao.OracleUserDAOImpl;
import edu.kosa.dao.UserDAO;
import edu.kosa.model.UserVO; 

public class MainEntry {
	public static void main(String[] args) throws Exception {
		UserDAO dao = new OracleUserDAOImpl();
		
		Connection conn = dao.getConnection();
//		UserVO vo = new UserVO();
//		dao.insert(user);
		 
		Scanner sc = new Scanner(System.in);
		dao.menu();
		
		switch (sc.nextInt()) {
		case 1:
			UserVO user = new UserVO();
			System.out.println("user id = ");				user.setId(sc.next());
			System.out.println("user name = "); 			user.setName(sc.next());
			System.out.println("user password = ");			user.setPassword(sc.next());
			
			dao.insert(user);
			System.out.println(user.getId()+" 추가 성공");
			System.out.println("-----------------");
			break;
			
		case 2:
//			UserVO user2 = new UserVO();
//			System.out.println("user id = ");				user2.setId(sc.next());
//			
//			dao.selectById(user2);
//			System.out.println(user2.getId()+" !");
//			System.out.println("-----------------");

			UserVO user2 = new UserVO(); 
			dao.selectAll(user2); 
			System.out.println(user2.getId()+" 검색 성공");
			System.out.println("-----------------");
			break;
			
		case 3: 
			
			break;
			
			
		default:
			break;
		}
	}
}

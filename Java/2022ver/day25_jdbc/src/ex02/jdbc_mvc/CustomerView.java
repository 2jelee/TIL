package ex02.jdbc_mvc;

import java.sql.SQLException;

// View  
public class CustomerView {
	public static void main(String[] args) throws SQLException {
		 
		CustomerController.connect();  
		CustomerController.menu(); 	   
	}
}

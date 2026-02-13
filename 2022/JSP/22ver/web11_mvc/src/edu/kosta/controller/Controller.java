package edu.kosta.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	
	private Map commandMap = new HashMap();
	String command = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		result(request, response);   //처리할 사용자 함수
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		result(request, response); 
	}
	
	//초기화 - 1회만 호출됨
	//명령어와 명령어처리 클래스가 매핑되어 있는 properties 파일을 읽어서 저장하는 역할
	@Override
	public void init(ServletConfig config) throws ServletException {
		//web.xml 에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");
		//명령어와 처리 클래스의 매핑정보를 저장할 properties 객체 생성
		Properties pr = new Properties();
		FileInputStream  f = null;
		
		try {
			//Command.properties 파일의 내용을 읽어옴
			f = new FileInputStream(props);
			pr.load(f);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if( f != null ) try{ f.close(); }catch(Exception e) { e.printStackTrace(); }
		} // try end
		
		Iterator key = pr.keySet().iterator();
		
		while( key.hasNext() ) {
			command = (String)key.next();  // list.do
			//properties 파일의 명령처리 클래스 부분을 받아온다.
			String className = pr.getProperty(command);   //edu.kosta.controller.MessageProcess
			
			//MessageProcess  mp = new MessageProcess();
			try {
				//forName()은 문자열을 클래스로 변환....
				Class  commandClass = Class.forName(className);
				System.out.println("commandClass : " + commandClass);
				
				//클래스로 변환 시켰기 때문에 객체 생성할 수 있음
				Object  commandInstance  =  commandClass.newInstance();
				System.out.println("commandInstance : " + commandInstance);
				
				commandMap.put(command, commandInstance);				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}  // while end	
	} // end init(~~)

	protected void result(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		CommandProcess  cp = null;
		String view = null;
		
		try {
			//command = request.getParameter("command");   // command.properties 확장자를 뺀 파일명만...
			//System.out.println("command : " + command);
			
			cp = (CommandProcess)commandMap.get(command);
			System.out.println("cp : " + cp);
			
			view = cp.doProcess(request, response);
			System.out.println("view page : " + view);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(view);
		dp.forward(request, response);
				
	}

}










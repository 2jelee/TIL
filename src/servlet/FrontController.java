package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
요청명 매핑 시 *를 사용하면 모든 문자열을 대체하여 아래와 같은 경우 .one으로 끝나는 모든 요청명을 한번에 매핑할 수 있음
 */
@WebServlet("*.one")
public class FrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//호스트명(localhost)를 제외한 나머지 URL얻어옴
		String uri = req.getRequestURI();
		//uri의 제일 마지막을 문자열을 얻어오기 위해 /의 index를 얻어옴.
		int lastSlash = uri.lastIndexOf("/");
		//요청명의 제일 마지막 문자열을 얻어옴.
		String commandStr = uri.substring(lastSlash);
		
		//마지막 요청명을 비교해서 각 처리를 위한 메소드 호출
		if(commandStr.equals("/regist.one")) {
			registFunc(req);
		}
		//request영역에 속성 저장 후 view로 포워드 함
		else if(commandStr.equals("/login.one")) {
			loginFunc(req);
		}
		else if(commandStr.equals("/freeboard.one")) {
			freeboard(req);
		}
		
		req.setAttribute("uri", uri);
		req.setAttribute("commandStr", commandStr);
		req.getRequestDispatcher("/13Servlet/FrontController.jsp").forward(req, resp);
	}
	void registFunc(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>회원가입</h4>");
	}
	void loginFunc(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>로그인</h4>");
	}
	void freeboard(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>자유게시판</h4>");
	}
}

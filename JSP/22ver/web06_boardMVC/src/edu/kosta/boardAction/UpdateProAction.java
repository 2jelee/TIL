package edu.kosta.boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosta.boardModel.BoardDAO;
import edu.kosta.boardModel.BoardVO;

public class UpdateProAction implements CommandAction {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");   // 업데이트시 한글 깨짐처리 
		
		String pageNum = request.getParameter("pageNum");
		BoardVO vo = new BoardVO();
		
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setWriter(request.getParameter("writer"));
		vo.setSubject(request.getParameter("subject"));
		vo.setEmail(request.getParameter("email"));
		vo.setContent(request.getParameter("content"));
		vo.setPasswd(request.getParameter("passwd"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int check = dao.update(vo);  //실제 변경 내용 반영 함수 호출
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", new Integer(check));	 //jsp페이지로 pageNum이랑 check값들구가
			
		return "/board/updatePro.jsp";
	}

}

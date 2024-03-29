package model2.mvcboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import fileupload.FileUtil;
import utils.JSFunction;

@WebServlet("/mvcboard/edit.do")
public class EditController extends HttpServlet{
	
	//수정폼
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//파라미터로 전달된 일련번호를 통해 기존 게시물을 조회함 
		String idx = req.getParameter("idx");
		MVCBoardDAO dao = new MVCBoardDAO();
		MVCBoardDTO dto = dao.selectView(idx);
		//하나의 레코드를 저장한 DTO객체를 request영역에 저장한 후 View로 포워드 (포워드O >> 이동X)
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/14MVCBoard/Edit.jsp").forward(req, resp);
	}

	
	
	
	
	//Controller	>> model2.mvcboard.EditController.java 메소드 추가
	//수정 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//물리적 경로(/Uploads)와 제한용량(maxPostSize)을 통해
		//	MultipartRequest 객체생성 및 파일 업로드
		String saveDirectory = req.getServletContext().getRealPath("/Uploads");
		ServletContext application = this.getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		if(mr!=null) {
			//파일을 제외한 나머지 폼값 받기
			String idx = mr.getParameter("idx");
			String prevOfile = mr.getParameter("prevOfile");
			String prevSfile = mr.getParameter("prevSfile");
			
			String name = mr.getParameter("name");
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
			
			/*
			서블릿에서 getSession() 메소드를 통해 session내장객체를 얻어온 후,
			session영역의 비밀번호를 가져와서 DTO에 저장.
			 */
			HttpSession session = req.getSession();
			String pass = (String)session.getAttribute("pass");
			
			MVCBoardDTO dto = new MVCBoardDTO();
			dto.setIdx(idx);
			dto.setName(name);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setPass(pass);
			
			
			//새롭게 업로드된 (서버에 저장된) 파일명을 얻어옴
			String fileName = mr.getFilesystemName("ofile");
			if(fileName!=null) {
				//새롭게 등록된 파일이 있다면 파일명 변경을 위해 파일명을 결정하고,
				String nowTime = new SimpleDateFormat("yyyyMMdd_hmsS").format(new Date());
				int extIdx = fileName.lastIndexOf(".");
				String newFileName = nowTime + fileName.substring(extIdx, fileName.length());
				
				//저장된 파일의 파일명을 변경함
				File oldFile = new File(saveDirectory+File.separator+fileName);
				File newFile = new File(saveDirectory+File.separator+newFileName);
				oldFile.renameTo(newFile);
				
				//새로운 파일명을 DTO에 저장.
				dto.setOfile(fileName);
				dto.setSfile(newFileName);
				
				//기존에 등록되어 있던 파일을 삭제(deleteFile)
				FileUtil.deleteFile(req, "/Uploads", prevSfile);
			}
			else {
				/*
				새롭게 등록된 파일이 없다면 
				기존파일명을 유지하기 위해 hidden입력상자의 내용을 그대로 적용함.
				 */
				dto.setOfile(prevOfile);
				dto.setSfile(prevSfile);
			}
			//레코드 업데이트 처리
			MVCBoardDAO dao = new MVCBoardDAO();
			int result = dao.updatePost(dto);
			dao.close();
			if(result==1) {
				session.removeAttribute("pass");
				resp.sendRedirect("../mvcboard/view.do?idx="+idx);
			}
			else {
				JSFunction.alertLocation(resp, "비밀번호 검증을 다시 진행해주세요.",
						"../mvcboard/view.do?idx="+idx);
			}
		}
		else {
			/*
			1.디렉토리의 물리적 경로가 잘못되었거나 2.파일 용량이 초과되었을 때에는 
				MultipartRequest객체가 생성되지 X.
			즉, 글쓰기 오류가 발생하게 된다.
			 */
			JSFunction.alertBack(resp, "글 수정 중 오류가 발생했습니다.");
		}
	}
}

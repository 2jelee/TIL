package sub04.gallery;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import fileupload.FileUtil;
import utils.JSFunction;


public class WriteController extends HttpServlet{
	
	//글쓰기 페이지로 진입 시에는 get방식 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
		req.getRequestDispatcher("/space/sub04_write.jsp").forward(req, resp);
	}
	 
	//글쓰기 내용 입력 후 전송했을 때는 post방식 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//서블릿에서 디렉토리의 물리적 경로 얻어오기
		String saveDirectory = req.getServletContext().getRealPath("/Uploads");
		//서블릿에서 컨텍스트 초기화 파라미터 얻어오기
		ServletContext application = this.getServletContext();
		//파일 업로드 제한용량
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		//파일 업로드 처리
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		if(mr!=null) {
			//파일 외 파라미터 받기
			String id = mr.getParameter("id");
//			String name = mr.getParameter("name"); //삭제예정
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
//			String pass = mr.getParameter("pass");		// 삭제예정
			
			GalleryDTO dto = new GalleryDTO();
			dto.setId(id);
//			dto.setName(name);	//삭제예정
			dto.setTitle(title);
			dto.setContent(content);
//			dto.setPass(pass);	// 삭제예정
			
			//서버에 저장된 파일명 변경
			String fileName = mr.getFilesystemName("ofile");
			if(fileName!=null) {
				String nowTime = new SimpleDateFormat("yyyyMMdd_hmsS").format(new Date());
				int extIdx = fileName.lastIndexOf(".");
				String newFileName = nowTime + fileName.substring(extIdx, fileName.length());
				
				File oldFile = new File(saveDirectory+File.separator+fileName);
				File newFile = new File(saveDirectory+File.separator+newFileName);
				oldFile.renameTo(newFile);
				
				dto.setOfile(fileName);
				dto.setSfile(newFileName);
			}
			
			//DAO에서 insert 처리
			GalleryDAO dao = new GalleryDAO();
			
			int result = dao.insertWrite(dto);
			dao.close();
			if(result==1) {
				resp.sendRedirect("../gallery/list.do");
//				resp.sendRedirect("../gallery/sub04.do");
//				resp.sendRedirect("../mvcboard/list.do");
			}
			else {
				resp.sendRedirect("../gallery/write.do");
//				resp.sendRedirect("../mvcboard/write.do");
			}
		}
		else {
			//파일 첨부를 위한 객체생성이 안된 경우
			JSFunction.alertLocation(resp, "글 작성중 오류가 발생했습니다.", "../gallery/write.do");
		}
	}
}

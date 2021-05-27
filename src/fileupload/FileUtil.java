package fileupload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;


public class FileUtil {
	
	public static MultipartRequest uploadFile(HttpServlet req,
			String saveDirectory, int maxPostSize) {
		
		MultipartRequest mr = null;
		try { 
			/*
			파일 업로드를 위해 MulipartRequest 객체를 생성함.
			해당 객체가 정상적으로 생성되면 파일업로드는 완료됨.
			 */
			mr = new MultipartRequest(req, saveDirectory, maxPostSize, "UTF-8");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return mr;
	}
}

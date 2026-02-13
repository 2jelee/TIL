package com.exam.springboot;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MyController {

	@RequestMapping("/")	
    public String root() {
        return "home";
    }

	@RequestMapping("/uploadForm.do")
	public String uploadForm(){		
		return "uploadForm";
	}
	//업로드 처리
	@RequestMapping("/uploadProc.do")
	public @ResponseBody String uploadOk(HttpServletRequest request) {
		int size = 1024 * 1024 * 10;//업로드용량 : 10Mb
		String file = "";
		String oriFile = "";
		
		JSONObject obj = new JSONObject();

		try {
			/*
			물리적경로 설정 : 
				C:\02Workspaces\B08FileUpload\bin\main\static\Uploads
				스프링 부트는 기존 프로젝트와는 다르게 bin 하위로 지정된다. 
			 */
			String path = 
					ResourceUtils.getFile("classpath:static/uploads/").toPath().toString();
			System.out.println(path);
			
			/*
			아래 객체가 생성됨과 동시에 파일은 서버로 업로드된다. 
			특히 DefaultFileRenamePolicy객체는 파일명이 동일할때 자동으로 파일명에 인덱스를
			부여하여 중복되지 않도록 처리해준다. 
			 */
			MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", 
					new DefaultFileRenamePolicy());			
			Enumeration files = multi.getFileNames();
			String str = (String)files.nextElement();
			
			file = multi.getFilesystemName(str);
			oriFile = multi.getOriginalFileName(str);
			
			obj.put("success", 1);//Wrapper클래스를 통한 AutoBoxing처리됨
			obj.put("file", file);
			obj.put("oriFile", oriFile);
			obj.put("desc", "업로드 성공");
		} 
		catch (Exception e) {
			e.printStackTrace();
			obj.put("success", new Integer(0));//현재는 이와같이 사용하지 않음. 그냥 0으로 기술해야 함.
			obj.put("desc", "업로드 실패");
		}
		//JSON객체를 문자열 형태로 변환하여 출력
		return obj.toJSONString();
	}
}



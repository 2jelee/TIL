package com.kosmo.k11security;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileuploadController {
	
	//서버의 물리적경로 알아보기
	@RequestMapping("/fileUpload/uploadPath.do")
	public void uploadPath(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException {
		
		//request 객체를 통해 upload폴더의 물리적 경로를 얻어옴.
		String path = req.getSession().getServletContext()
				.getRealPath("/resources/upload");
		
		//response객체를 통해 MIME 타입을 설정함.
		resp.setContentType("text/html; charset=utf-8");
		
		//View를 호출하지 않고 컨트롤러에서 내용을 즉시 출력한다. (view의 도움없이 출력된)
		PrintWriter pw = resp.getWriter();
		pw.print("/upload 디렉토리의 물리적 경로 : " + path);
	}
	

	//파일 업로드 폼 매핑
	@RequestMapping("/fileUpload/uploadForm.do")
	public String uploadForm() {
		return "06FileUpload/uploadForm";
	}
	
	/*
	UUID(Universally Unique Identifier)
		: 범용 고유 식별자.
		  randomUUId()를 통해 문자열을 생성하면 하이픈이 4개 포함된 32자의
		  랜덤하고 유니크한 문자열이 생성됨.
		  JDK에서 기본 클래스로 제공된다.   << 스프링에서 제공이 X. 즉, 자바, jsp 등에서도 사용할 수 있다는 말.
	 */
	public static String getUuid() {
		String uuid = UUID.randomUUID().toString(); //randomUUID() << static 타입임(이탤릭체)
		System.out.println("생성된UUID-1:"+uuid);
		//중간에 포함된 하이픈을 제거함.
		uuid = uuid.replaceAll("-", "");
		System.out.println("생성된UUID-2:"+uuid);
		return uuid;
	}
	
	
	/*
	파일업로드 처리
		: 파일업로드는 반드시 POST방식으로 전송해야되므로
		  컨트롤러 매핑시 method, value 2가지 속성을 기술한다.
	 */
	@RequestMapping(value="/fileUpload/uploadAction.do", method=RequestMethod.POST)
	public String uploadAction(Model model, MultipartHttpServletRequest req) {
		//업로드 폴더의 물리적 경로 얻어옴
		String path =
			req.getSession().getServletContext().getRealPath("/resources/upload");
		
		//폼값과 파일명을 저장 후 View로 전달하기 위한 맵 컬렉션
		Map returnObj = new HashMap(); //return값을 저장할 ~를 생성 //Map을 DB삼아..
		try {
			//getFileNames함수를 통해 Iterator객체를 얻어오고 있음.
			//업로드 폼의 file속성의 필드를 얻어옴. (여기서는 업로드폼이 2개임)
			Iterator itr = req.getFileNames();
			
			//업로드 처리를 위한 각종 변수 생성
			MultipartFile mfile = null;
			String fileName = "";
			List resultList = new ArrayList();
			
			//파일 외 폼값을 전송받음.
			String title = req.getParameter("title");
			System.out.println("title="+title);
			
			//물리적 경로에 폴더가 없는 경우 생성할 수 있도록
			/*
			물리적 경로를 기반으로 File객체를 생성한 후 지정된 디렉토리가 있는지 확인함.
			만약 없다면 디렉토리를 생성한다.
			 */
			File directory = new File(path);
			if(!directory.isDirectory()) {
				directory.mkdirs();
			}
			
			//업로드폼의 file필드 갯수만큼 반복 //현재의 경우 2번
			while(itr.hasNext()) {
				//전송된 파일의 이름을 읽어온다.
				fileName = (String)itr.next();
				mfile = req.getFile(fileName);
				System.out.println("mfile="+mfile);
				
				//한글깨짐 방지 처리 후 전송된 파일명을 가져옴.
				String originalName = new String(mfile.getOriginalFilename().getBytes(),"UTF-8");
				//만약 서버로 전송된 파일이 없다면 while문의 처음으로 돌아간다.
				if("".equals(originalName)) {
					continue;
				}
				
				String ext = originalName.substring(originalName.lastIndexOf(".")); //파일의 확장자를 얻어옴.
				String saveFileName = getUuid() + ext; //UUID를 통해 얻어온 문자열에 확장자를 붙여준다.
				//물리적 경로에 새롭게 생성된 파일명으로 파일 저장
				File serverFullName = new File(path + File.separator + saveFileName); 
				mfile.transferTo(serverFullName);
				
				Map file = new HashMap();
				file.put("originalName", originalName);	//원본 파일명
				file.put("saveFileName", saveFileName);	//저장된 파일명
				file.put("serverFullName", serverFullName); //파일의 전체경로
				file.put("title", title); //제목
				
				resultList.add(file); 
			}
			returnObj.put("files", resultList); //files라는 이름으로 또 저장
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("returnObj", returnObj); //모델에 저장 후 view로 전달
		return "06FileUpload/uploadAction";
	}
	
	
	
	//파일 목록보기
	@RequestMapping("/fileUpload/uploadList.do")
	public String uploadList(HttpServletRequest req, Model model) {
		//서버의 물리적 경로 얻어오기
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		//경로를 기반으로 파일객체 생성
		File file = new File(path);
		//파일의 목록을 배열형태로 얻어옴
		File[] fileArray = file.listFiles();
		//뷰로 전달할 파일목록을 저장하기 위해 Map컬렉션 생성
		Map<String, Integer> fileMap = new HashMap<String, Integer>();
		for(File f : fileArray) {
			//Key값으로 파일명, Value값으로 파일의 용량을 저장
			fileMap.put(f.getName(), (int)Math.ceil(f.length()/1024.0));
		}
		
		model.addAttribute("fileMap", fileMap);
		return "06FileUpload/uploadList"; //뷰의 경로 지정ㄷ
	}
	
	
	//파일 다운로드
	@RequestMapping("/fileUpload/download.do")
	public ModelAndView download(HttpServletRequest req, HttpServletResponse resp) 
			throws Exception {
		
		//저장된 파일명
		String fileName = req.getParameter("fileName");
		//원본 파일명
		String oriFileName = req.getParameter("oriFileName");
		//물리적 경로
		String saveDirectory = req.getSession().getServletContext().getRealPath("/resources/upload");

		//경로와 파일명을 통해 파일객체 생성
		File downloadFile = new File(saveDirectory + "/" + fileName);
		//해당 경로에 파일이 있는지 확인
		if(!downloadFile.canRead()) {
			throw new Exception("파일을 찾을 수 없습니다.");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fileDownloadView"); //다운로드할 View명
		mv.addObject("downloadFile", downloadFile); //저장된 파일명
		mv.addObject("oriFileName", oriFileName); //원본파일명
		return mv;	
	}
}

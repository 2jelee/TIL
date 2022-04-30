<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*,  java.io.*,   java.awt.*,  java.awt.image.*"  %>
<%@ page import="edu.kosta.thumb.*"  %>

<%
		String realPath = ""; 
		String savePath="upload";
		String encType = "UTF-8";
		int maxSize = 1024 * 1024 * 5;
		
		ServletContext context = getServletContext();
		realPath = context.getRealPath(savePath);
		
		try {
			MultipartRequest  multi = new MultipartRequest(
										request,
										realPath,
										maxSize,
										encType,
										new DefaultFileRenamePolicy()
							);
			
			Enumeration files = multi.getFileNames();
			int zoom = 5;
	////////////////////////////////////////////////////////////////		
			for(int i = 0; i < files.size(); i++) {
			    String originalFileName =  files.get(i).getOriginalFilename();
			    int index = originalFileName.lastIndexOf(".");
			    String fileName = originalFileName.substring(0, index);
			    String fileExt = originalFileName.substring(index + 1);

			    File file = new File(PATH + originalFileName);
			    logger.info(file.getAbsolutePath());
			    
			    savePath.get(i).transferTo(file);
			    
			    // 썸네일을 생성하는 메소드를 호출합니다.
			    Thumbnail.createImage(file.getAbsolutePath(), originalFileName, fileExt, zoom);
			  			    
			}
		//////////////////////////////////////////////////////////////////////	
			while( files.hasMoreElements() ) {
				String name = (String)files.nextElement();
				String fileName = multi.getFilesystemName(name);
				String orgfileName = realPath + "\\" + fileName;
				String thumbFileName = realPath + "\\" + fileName;
%>
		원본 파일 저장 경로 및 파일명 : <%= orgfileName %> <br>
	   <img src="<%=orgfileName %>"  border="0"> <br><br><br>
	   
<% 	Thumbnail.createImage(orgfileName, thumbFileName, zoom);  %>	
	
	 	썸네일 이미지 저장 경로 및 파일명 : <%= thumbFileName %> <br>
	 	<<img src="../upload/<%= thumbFileName %>"  border="0"> 
		
<%
			} // end while	
		} catch( Exception e ) {
			e.printStackTrace();
		}
%>





<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ page import="java.sql.*" %>
 <%@ page import="dbconn.util.*" %>
  <%@ page import="dbclose.util.*" %>
  
  <% 
	  if ( session.getAttribute("userid")  == null   ||  !session.getAttribute("userid").equals("admin") ) {
			//다른 페이지로 강제 이동...
			out.print("<script>");
			out.print("location.href='ex29_login.jsp' ");
			out.print("</script>");	
		} //if end
		
		String deleteId = request.getParameter("id");
		Connection conn = null;
  		PreparedStatement pstmt = null;
  		
  		try{
  			conn = ConnectionUtil.getConnection("oracle");
  			String sql = "DELETE FROM KOSTAMEMBER WHERE ID= ?";
  			pstmt = conn.prepareStatement(sql);
  			pstmt.setString(1, deleteId);
  			pstmt.executeUpdate();
  			out.print("<script>");
			out.print("location.href='ex30_memberList.jsp' ");
			out.print("</script>");	
			
  		}catch (Exception e){
  			e.printStackTrace();
  		}finally{
  			CloseUtil.close(pstmt);
  			CloseUtil.close(conn);
  		}
  	%>
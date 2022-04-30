<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

 <%@ page import="java.sql.*" %>
 <%@ page import="dbconn.util.*" %>
  <%@ page import="dbclose.util.*" %>
  <<script type="text/javascript" src="js/check.js">
<!--

//-->
</script>

<<script type="text/javascript">
<!--
	function aa() {
	
	}
//-->
</script>
  <% 
	  if ( session.getAttribute("userid")  == null   ||
				!session.getAttribute("userid").equals("admin") ) {
			//다른 페이지로 강제 이동...
			out.print("<script>");
			out.print("location.href='ex29_login.jsp' ");
			out.print("</script>");	
		} //if end
		
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Connection conn = null;
  		PreparedStatement pstmt = null;
  		
  		try{
  			conn = ConnectionUtil.getConnection("oracle");
  			pstmt = conn.prepareStatement("UPDATE KOSTAMEMBER SET NAME=? , EMAIL=? WHERE ID = ?");
  			pstmt.setString(1, name);
  			pstmt.setString(2, email);
  			pstmt.setString(3, id);
  		    pstmt.executeQuery();
  			
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
  
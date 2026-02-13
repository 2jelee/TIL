<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ page import="java.sql.*" %>
   <%@ page import="dbconn.util.*" %>
  <%@ page import="dbclose.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 검색</title>
<style type="text/css">
	table {		border: solid 2px black;		border-collapse: collapse;   	}
	tr {		border: solid 1px blue;		background-color: white;		color : black;	}
	td {		border: solid 1px red;	}
</style>
</head>
<%
		//1. 검색할 사람의 이름 받아오기
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("search");
		//out.print(name);
		//2. 유효성 검사
		if ( name == null || name.trim().equals("") ) {
			response.sendRedirect("ex30_memberList.jsp");
			return;
		}
		
		//3. db 연결하여 select 문을 db에 전송
		Connection conn = null;
  		PreparedStatement pstmt = null;
  		ResultSet rs = null;
  		
  		try{
  			conn = ConnectionUtil.getConnection("oracle");
  			String sql = "SELECT COUNT(*) FROM KOSTAMEMBER WHERE NAME LIKE '%" + name + "%' "; 
  			String sql2 = "SELECT ID, NAME, EMAIL FROM KOSTAMEMBER WHERE NAME LIKE '%" + name + "%' ";
  																							
  			pstmt = conn.prepareStatement(sql);
  			rs = pstmt.executeQuery();
  			
  		//4. 그 결과를 받아와서 테이블 형태로 보여주기
  		rs.next();
  		int count = rs.getInt(1); 		
%>
<body>
	<table style="width: 900px; height: 500px">
		<tr>
			<td colspan="2"><jsp:include page="/CommonModule/Top.jsp" /> </td>
		</tr>
		<tr>
			<td  style="width: 200px"><jsp:include page="/CommonModule/Left.jsp" /> </td>
			<td style="width: 700px">
				<div  align="center">
					<table width="500" border="1">
						<tr bgcolor="gold">
							<th width="30%">아이디</th>
							<th width="30%">이름</th>
							<th width="30%">이메일</th>
						</tr>
						<%
							 	if( count > 0 ) {
							 		pstmt = conn.prepareStatement(sql2);
							 		rs = pstmt.executeQuery();
							 		while (rs.next()){
							 			String id = rs.getString(1);
							 			String name2 = rs.getString(2);
							 			String email = rs.getString(3);
							 			
						%>
							<tr>
								<td><%= id %></td>
								<td><%= name2 %></td>
								<td><%= email %></td>
							</tr>
						<%
							 		}//while end
							 		out.println("<tr><td colspan='3'>");
						 			out.println("<b>" + name + "님은 총" + count +"명 입니다. </b>");
						 			out.println("</td></tr>");
						 			
							 	} else {
							 		out.println("<tr><td colspan='3'>");
						 			out.println("<b>" + name + "님 정보는 없습니다. </b>");
						 			out.println("</td></tr>");
							 	} //end if
						%>					
					</table>
				</div>
			
			</td>
		</tr>
		<%	
  		}catch (Exception e){
  			e.printStackTrace();
  		}finally{
  			//5. 연결된 자원 반납 
  			CloseUtil.close(rs);
  			CloseUtil.close(pstmt);
  			CloseUtil.close(conn);
  		}
  	%>
	<tr>
		<td colspan="2"><jsp:include page="/CommonModule/Bottom.jsp" /> </td>
	</tr>
	</table>
</body>
</html>







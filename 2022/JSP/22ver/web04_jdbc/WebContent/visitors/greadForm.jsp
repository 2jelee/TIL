<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.* ,  java.util.* "%>
<%@ page import="com.kosta.visitors.* " %>

<%
		int numPerPage = 5;  //한페이지에서 보여줄 게시글의 수
		int numPerBlock = 3;  // 한페이지에 보일 페이지 번호의 개수 지정
%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>초간단 허접 방명록</title>
</head>
<link href="../css/mystyle.css" rel="stylesheet" type="text/css" >
<body>
<h3>방명록</h3>
<div align="center"><a href="gwriteForm.jsp">방명록 작성(쓰기)</a> </div>
<div align="center"><a href="gdeleteForm.jsp">방명록 삭제</a> </div>
<div align="center"><a href="gupdateForm.jsp">방명록 업데이트</a> </div>
<div id="menu"><%@ include file="menu.jsp" %></div>

<div id="main">
<%
		Connection conn = BookDAO.loadOracleDriver();
		String pstr = request.getParameter("page");  /// 하단에서 <a href="greadForm.jsp?page=
		int mypage = 1;
		try {
			mypage = Integer.parseInt(pstr);
		} catch(Exception e ) {
			try{
				mypage = 1;    // page 없는 경우에는 마지막 페이지(가장 최근글)를 지정
			} catch(Exception ee) {
				ee.printStackTrace();
			}
		}
																//	conn,    1,        5
		Vector<BookVO> data = BookDAO.select(conn, mypage, numPerPage);
	
		int n = data.size();  // 5
		out.print("<table width ='100%' >");
		for(int i=0; i < n ; i++ ) {
			BookVO vo = (BookVO) data.elementAt(i);
			int num = vo.getNum();          /////////////////////////
			String name = vo.getName();
			String email = vo.getEmail();
			String home = vo.getHome();
			String contents = vo.getContents();
%>
	<tr>
		<td>번 호 : <%= num %></td> <!-- 추가 -->
	</tr>
		<tr bgcolor="e7e7e7">
			<td>이 름 : <%= name %></td>
		</tr>
		<tr>
			<td>E-Mail : 
			<% if( email != null && email.length() > 0 )  { %>
			
			<a href="mailto:<%=email %>"><%=email %></a>
			
			<% } // if end %>
			</td>
		</tr>
		
		<tr>
			<td>홈페이지 : 
			<% if( home != null && home.length() > 0 )  { %>
			
			<a href=<%=home %>><%=home %></a>
			
			<% } // if end %>
			</td>
		</tr>
		<tr>
			<td>내 용 : <p style='text-align: justify'><%= contents %> </p> </td>
		</tr>		
<%	} // for end  %>
	</table>
	<div style="text-align: center;">
	<%
		// 현재 페이지 번호가 소속된 블록 번호를 계산
		int currentBlock = (int)Math.ceil( mypage / (double) numPerBlock );  //  1/5 
		//데이터베이스 테이블에 저장된 총 페이지 수를 얻는다.
		double totalPage = BookDAO.getPageCount(conn, numPerPage);  // 4
		//총 블록수 계산
		int totalBlock = (int)Math.ceil((double)totalPage / numPerBlock ) ; //  4 / 3
		///////////////////////////////////////////////////////////////////
	    out.print("currentBlock : " + currentBlock);
		out.print("totalPage : " + totalPage);
		out.print("totalBlock : " + totalBlock); 
		///////////////////////////////////////////////////////////////////
		
		if( currentBlock > 1 ) {
		%>
		<a href="greadForm.jsp?page=<%=(currentBlock -1 ) * numPerBlock %>"> 이전</a>
		
   <%	
		} // if end
		//for 문을 돌려서 각 페이지 번호에 해당하는 페이지의 방명록 내용을
		// 읽을 수 있도록 링크 만든다. 
		//for(int i=numPerBlock; i>= 1; i-- ) {  // 내림차순 출력 
		for(int i=1; i<= numPerBlock; i++) {    // 오름차순 출력
			int pn = numPerBlock * (currentBlock - 1) + i ;  // 3 * 0  + 1
			
			if( pn > totalPage )	continue;
			
			//페이지 번호에서 현재 페이지에는 밑줄을 친다.
			if( pn == mypage ) {
	%>
		<a href="greadForm.jsp?page=<%=pn %>">
			<span style="text-decoration: underline;"> <%= pn %></span>
		</a> &nbsp;&nbsp;&nbsp;
	
	<% } else { %>
			
			<a href="greadForm.jsp?page=<%=pn %>"><%=pn %></a>&nbsp;&nbsp;&nbsp;
	
	<%			
			} // if end
		} // for end
		
		// totalBlock이 currentBlock 보다 크다는 것은 현재 앞쪽에 표시 되지 않은 
		// 페이지 번호가 있다는 의미
		if( totalBlock > currentBlock ) {
			int togo = (currentBlock+1) * numPerBlock ;
			
			if( togo > totalPage ) {
				togo = (int) totalPage; 
			} // if end
	%>
			<a href="greadForm.jsp?page=<%=togo %>"> ▶</a>  <!--  다음 -->
	<%
		} // if end
		conn.close();
	%>	
	</div>
</div>
</body>
</html>







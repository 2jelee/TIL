<%@page import="java.util.concurrent.ExecutionException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.* ,  dbclose.util.*"  %>
<%@ page import="dbconn.util.*"  %>
<!DOCTYPE>
<html><head>
<title>JDBC trancation</title>
<style type="text/css">
	table { 
		border: 1px solid;  
		width: 400px;  
		
	}
	td, th {
		text-align: center;
		border: 1px solid;
	}
</style>
</head>
<body>
<h3>지역 부서 보기(Oralce insert)</h3>
<table>
	<!-- <tr>
		<th>부서코드</th><th>부서명</th><th>지역코드</th><th>지사명</th>
	</tr> -->
	<%
		
		Connection conn = null;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		String errorMsg = null;
		
		String deptSql = "INSERT INTO DEPT2 VALUES(888, '전산실', 30000, '가락지사')";
		try{
			conn = ConnectionUtil.getConnection("oracle");
			
			conn.setAutoCommit(false); // 트랜잭션 제어
			pstmt = conn.prepareStatement(deptSql);
			int result = pstmt.executeUpdate(); // 반환값 없는 경우 
			
			out.print(result + "개 추가 성공");
			
			//정상처리 되면,..
			conn.commit();

		}catch(Exception e) {
			//비정상 처리 되었으면,....
			conn.rollback();    // conn.rollback(savepoint);
			errorMsg = e.getMessage();  	//e.printStackTrace();
			
		} finally {
			CloseUtil.close(pstmt);
			CloseUtil.close(conn);
		}
	%>
	</table>
	<p>	SQL 실행 결과 : <%= errorMsg %> </p>
</body>
</html>
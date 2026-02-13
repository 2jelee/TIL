<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>홈트레이닝 커뮤니티(가제)</title>
<style type="text/css" media="screen">
@import url("../css/common.css");
@import url("../css/main.css");
@import url("../css/sub.css");
</style>
</head>
 <body>
 <!-- 공통링크  -->
<%--  <%@ include file="../common/CommonLink.jsp" %> --%>
 
	<center>
	<div id="wrap">
		<%@ include file="../include/top.jsp" %>

		<img src="../images/member/sub_image.jpg" id="main_visual" />

		<div class="contents_box">
			<div class="left_contents">
				<%@ include file = "../include/member_leftmenu.jsp" %>
			</div>
			<div class="right_contents">
				<div class="top_title">
					<img src="../images/login_title.gif" alt="인사말" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;멤버쉽&nbsp;>&nbsp;로그인<p>
				</div>
				
				
				
				
				<div class="login_box01">
				
				<span style="color:red; font-size:1.5em;">		
					<%=request.getAttribute("ERROR_MSG")==null ?
						"" : request.getAttribute("ERROR_MSG") %>
				</span>
				
				<%
				if(session.getAttribute("USER_ID")==null){ 
				%>
					<script>
					function loginValidate(fn){
						if(!fn.user_id.value){
							alert("아이디를 입력하세요");
							fn.user_id.focus();
							return false;
						}
						if(fn.user_pw.value==""){
							alert("패스워드를 입력하세요");
							fn.user_pw.focus();
							return false;
						}
					}
					</script>
					
					<form action="../main/LoginProcessMap.jsp" method="post" name="loginFrm"
						onsubmit="return loginValidate(this);"> 
					<table cellpadding="0" cellspacing="0" border="0">
						<colgroup>
							<col width="45px" />
							<col width="120px" />
							<col width="55px" />
						</colgroup>
						<tr>
							<th><img src="../images/login_tit01.gif" alt="아이디" /></th>
<!-- 							<td><input type="text" name="" value="" class="login_input" /></td> -->
							<td> 
								<input type="text" name="user_id" tabindex="1" />
							</td>
							<td rowspan="2"><input type="image" src="../images/login_btn01.gif" alt="로그인" /></td>
<!-- 							<td colspan="2" style="text-align:center;"> -->
<!-- 								<input type="submit" value="로그인하기" tabindex="3" /> -->
<!-- 							</td>	 -->
						</tr>
						<tr>
							<th><img src="../images/login_tit02.gif" alt="패스워드" /></th>
<!-- 							<td><input type="text" name="" value="" class="login_input" /></td> -->
							<td>
								<input type="password" name="user_pw" tabindex="2" />
							</td>	
						</tr>
					</table>
					</form>

					<p>
						<input type="checkbox" name="" value="" /><img src="../images/login_tit03.gif" alt="저장" />
						<a href="../member/id_pw.jsp"><img src="../images/login_btn02.gif" alt="아이디/패스워드찾기" /></a>
						<a href="../member/join01.jsp"><img src="../images/login_btn03.gif" alt="회원가입" /></a>
					</p>
					
					 
					<!-- 로그인 후 -->
					<!-- <p style="padding:10px 0px 10px 10px"><span style="font-weight:bold; color:#333;">000님,</span> 반갑습니다.<br />로그인 하셨습니다.</p>
					<p style="text-align:right; padding-right:10px;">
						<a href=""><img src="../images/login_btn04.gif" /></a>
						<a href=""><img src="../images/login_btn05.gif" /></a>
					</p> -->
					<% 
					}else{
					//세션영역에 회원인증 정보가 있을때이므로 로그인이 된 상태
					%>
					<center>
						<table border='0'>
							<tr>
								<td style="text-align:center;">		
									<font size="2.5em" weight="bold" color="blue"><%=session.getAttribute("USER_NAME") %></font> 회원님 안녕하세요.
									<br />
									오늘도 즐거운 운동을!!
									<br /><br />
									<a href="Logout.jsp"><img src="../images/login_btn04.gif" alt="회원정보수정" /></a> <!-- 회원정보 수정버튼 노출 -->
									<a href="../main/Logout.jsp"><img src="../images/login_btn05.gif" alt="로그아웃" /></a>
								</td>
							</tr>
						</table>
					</center>
					<% } %>
			 
				</div>
				
				
				
				
				
				
				
				
<!-- 					<img src="../images/login_tit.gif" style="margin-bottom:30px;" /> -->
<!-- 					<ul> -->
<!-- 						아이디 입력칸 -->
<!-- 						<li><img src="../images/login_tit001.gif" alt="아이디" style="margin-right:15px;" /><input type="text" name="" value="" class="login_input01" /></li> -->
						
<!-- 						패스워드 입력칸 -->
<!-- 						<li><img src="../images/login_tit002.gif" alt="비밀번호" style="margin-right:15px;" /><input type="text" name="" value="" class="login_input01" /></li> -->
<!-- 					</ul> -->
<!-- 					LOGIN 버튼 -->
<!-- 					<a href=""><img src="../images/login_btn.gif" class="login_btn01" /></a> -->
<!-- 				</div> -->
<!-- 				<p style="text-align:center; margin-bottom:50px;"><a href=""><img src="../images/login_btn02.gif" alt="아이디/패스워드찾기" /></a>&nbsp;<a href=""><img src="../images/login_btn03.gif" alt="회원가입" /></a></p> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>

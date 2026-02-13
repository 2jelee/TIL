<%@page import="utils.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
//체크박스 체크용 변수
String cookieCheck = "";
//쿠키명이 loginId 인 쿠키값 읽어오기
String loginId = CookieManager.readCookie(request, "loginId");
//빈값이 아니면...
if(!loginId.equals("")) {
	//체크용 변수에 checked를 할당
	cookieCheck = "checked";	
}
%>   


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
<center>
	<div id="wrap">
		<%@ include file="../include/top.jsp"%>
		
		<div id="main_visual">
		<a href="/product/sub01.jsp"><img src="../images/drago.jpg" width="1000" height="400" border="0" /></a>
<!-- 		<a href="/product/sub01.jsp"><img src="../images/drago.jpg" /></a><a href="/product/sub01_02.jsp"><img src="../images/main_image_02.jpg" /></a><a href="/product/sub01_03.jsp"><img src="../images/main_image_03.jpg" /></a><a href="/product/sub02.jsp"><img src="../images/main_image_04.jpg" /></a> -->
		</div>

		<div class="main_contents">
			<div class="main_con_left">
				<!-- 로그인 부분 -->
				<p class="main_title" style="border:0px; margin-bottom:0px;"><img src="../images/main_title01.gif" alt="로그인 LOGIN" /></p>
				<div class="login_box">
				<!--  
					로그인에 실패한 경우 request영역에 속성을 저장한 후
					로그인 페이지로 포워드 하면 그 영역이 공유되어 아래
					메세지가 출력된다. 
				-->
				<span style="color:red; font-size:1.5em;">		
					<%=request.getAttribute("ERROR_MSG")==null ?
						"" : request.getAttribute("ERROR_MSG") %>
				</span>
				
				<%
				/*
					session영역에 회원인증 정보가 없다면 로그아웃 상태이므로
					로그인 폼을 출력한다.
				*/
				if(session.getAttribute("USER_ID")==null){ 
				%>
					<script>
					//로그인 폼의 입력값을 검증하는 JS함수 정의
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
					<!--  
						로그인 1단계 : LoginProcess.jsp
						로그인 2단계 : LoginProcessDTO.jsp
						로그인 3단계 : LoginProcessMap.jsp
					-->
					<form action="LoginProcessMap.jsp" method="post" name="loginFrm"
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
<!-- 								<input type="text" name="user_id" tabindex="1" /> -->
								<input type="text" name="user_id" value="<%=loginId %>" 
										tabindex="1" />
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
						<label>
							<input type="checkbox" name="save_check" value="Y"
								<%=cookieCheck %> tabindex="3" /> <img src="../images/login_tit03.gif" alt="저장" />
						</label>
<!-- 						<input type="checkbox" name="" value="" /><img src="../images/login_tit03.gif" alt="저장" /> -->
						
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
									<font size="2.5em" color="blue"><%=session.getAttribute("USER_NAME") %></font>님 반갑습니다.
									<br />
									오늘도 즐거운 운동을!!
									<br /><br />
									<a href="Logout.jsp"><img src="../images/login_btn04.gif" alt="회원정보수정" /></a> <!-- 회원정보 수정버튼 노출 -->
									<a href="Logout.jsp"><img src="../images/login_btn05.gif" alt="로그아웃" /></a>
								</td>
							</tr>
						</table>
					</center>
					<% } %>
			 
				</div>
			</div>
			<div class="main_con_center">
				<p class="main_title"><img src="../images/main_title02.gif" alt="공지사항 NOTICE" /><a href="../space/sub01_list.jsp"><img src="../images/more.gif" alt="more" class="more_btn" /></a></p>
				<ul class="main_board_list">
					<li><p><a href="">마포 구립 장애인 직업재활센터 홈페이지</a><span>2012.01.26</span></p></li>
					<li><a href="">마포 구립 장애인 직업재활센터 홈페이지</a><span>2012.01.26</span></li>
					<li><a href="">마포 구립 장애인 직업재활센터 홈페이지</a><span>2012.01.26</span></li>
					<li><a href="">마포 구립 장애인 직업재활센터 홈페이지</a><span>2012.01.26</span></li>
				</ul>
			</div>
			<div class="main_con_right">
				<p class="main_title"><img src="../images/main_title03.gif" alt="자유게시판 FREE BOARD" /><a href="../space/sub03.jsp"><img src="../images/more.gif" alt="more" class="more_btn" /></a></p>
				<ul class="main_board_list">
					<li><p><a href="">마포 구립 장애인 직업재활센터 홈페이지</a><span>2012.01.26</span></p></li>
					<li><a href="">마포 구립 장애인 직업재활센터 홈페이지마포 구립 장애인 직업재활센터 홈페이지마포 구립 장애인 직업재활센터 홈페이지</a><span>2012.01.26</span></li>
					<li><a href="">마포 구립 장애인 직업재활센터 홈페이지</a><span>2012.01.26</span></li>
					<li><a href="">마포 구립 장애인 직업재활센터 홈페이지</a><span>2012.01.26</span></li>
				</ul>
			</div>
		</div>

		<div class="main_contents">
			<div class="main_con_left">
				<p class="main_title"><img src="../images/main_title04.gif" alt="월간일정 CALENDAR" /></p>
				<img src="../images/main_tel.gif" />
			</div>
			<div class="main_con_center">
				<p class="main_title" style="border:0px; margin-bottom:0px;"><img src="../images/main_title05.gif" alt="월간일정 CALENDAR" /></p>
				<div class="cal_top">
					<table cellpadding="0" cellspacing="0" border="0">
						<colgroup>
							<col width="13px;" />
							<col width="*" />
							<col width="13px;" />
						</colgroup>
						<tr>
							<td><a href=""><img src="../images/cal_a01.gif" style="margin-top:3px;" /></a></td>
							<td><img src="../images/calender_2012.gif" />&nbsp;&nbsp;<img src="../images/calender_m1.gif" /></td>
							<td><a href=""><img src="../images/cal_a02.gif" style="margin-top:3px;" /></a></td>
						</tr>
					</table>
				</div>
				<div class="cal_bottom">
					<table cellpadding="0" cellspacing="0" border="0" class="calendar">
						<colgroup>
							<col width="14%" />
							<col width="14%" />
							<col width="14%" />
							<col width="14%" />
							<col width="14%" />
							<col width="14%" />
							<col width="*" />
						</colgroup>
						<tr>
							<th><img src="../images/day01.gif" alt="S" /></th>
							<th><img src="../images/day02.gif" alt="M" /></th>
							<th><img src="../images/day03.gif" alt="T" /></th>
							<th><img src="../images/day04.gif" alt="W" /></th>
							<th><img src="../images/day05.gif" alt="T" /></th>
							<th><img src="../images/day06.gif" alt="F" /></th>
							<th><img src="../images/day07.gif" alt="S" /></th>
						</tr>
						<tr>
							<td><a href="">&nbsp;</a></td>
							<td><a href="">&nbsp;</a></td>
							<td><a href="">&nbsp;</a></td>
							<td><a href="">&nbsp;</a></td>
							<td><a href="">1</a></td>
							<td><a href="">2</a></td>
							<td><a href="">3</a></td>
						</tr>
						<tr>
							<td><a href="">4</a></td>
							<td><a href="">5</a></td>
							<td><a href="">6</a></td>
							<td><a href="">7</a></td>
							<td><a href="">8</a></td>
							<td><a href="">9</a></td>
							<td><a href="">10</a></td>
						</tr>
						<tr>
							<td><a href="">11</a></td>
							<td><a href="">12</a></td>
							<td><a href="">13</a></td>
							<td><a href="">14</a></td>
							<td><a href="">15</a></td>
							<td><a href="">16</a></td>
							<td><a href="">17</a></td>
						</tr>
						<tr>
							<td><a href="">18</a></td>
							<td><a href="">19</a></td>
							<td><a href="">20</a></td>
							<td><a href="">21</a></td>
							<td><a href="">22</a></td>
							<td><a href="">23</a></td>
							<td><a href="">24</a></td>
						</tr>
						<tr>
							<td><a href="">25</a></td>
							<td><a href="">26</a></td>
							<td><a href="">27</a></td>
							<td><a href="">28</a></td>
							<td><a href="">29</a></td>
							<td><a href="">30</a></td>
							<td><a href="">31</a></td>
						</tr>
						<tr>
							<td><a href="">&nbsp;</a></td>
							<td><a href="">&nbsp;</a></td>
							<td><a href="">&nbsp;</a></td>
							<td><a href="">&nbsp;</a></td>
							<td><a href="">&nbsp;</a></td>
							<td><a href="">&nbsp;</a></td>
							<td><a href="">&nbsp;</a></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="main_con_right">
				<p class="main_title"><img src="../images/main_title06.gif" alt="사진게시판 PHOTO BOARD" /><a href="/space/sub04.jsp"><img src="../images/more.gif" alt="more" class="more_btn" /></a></p>
				<ul class="main_photo_list">
					<li>
						<dl>
							<dt><a href=""><img src="../images/g_img.gif" /></a></dt>
							<dd><a href="">마포 구립 장애인...</a></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt><a href=""><img src="../images/g_img.gif" /></a></dt>
							<dd><a href="">마포 구립 장애인...</a></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt><a href=""><img src="../images/g_img.gif" /></a></dt>
							<dd><a href="">마포 구립 장애인...</a></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt><a href=""><img src="../images/g_img.gif" /></a></dt>
							<dd><a href="">마포 구립 장애인...</a></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt><a href=""><img src="../images/g_img.gif" /></a></dt>
							<dd><a href="">마포 구립 장애인...</a></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt><a href=""><img src="../images/g_img.gif" /></a></dt>
							<dd><a href="">마포 구립 장애인...</a></dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
		<%@ include file="../include/quick.jsp"%>
	</div>

	<%@ include file="../include/footer.jsp"%>
	
</center>
</body>
</html>
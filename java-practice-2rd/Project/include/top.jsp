<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="top" style="border:0px solid #000;"> 
	<a href="../main/main.jsp"><img src="../images/dumbbell.JPG" width="150" height="63" alt="홈트레이닝 커뮤니티(가제)" id="top_logo" /></a>
	<ul id="lnb">
	<tr>	
		<!-- 로그인전 -->
		<li>
			<% if(session.getAttribute("USER_ID")==null){ %>
				<a href="../member/login.jsp"><img src="../images/lnb01.gif" alt="LOGIN" /></a>			
			<% }else{ %>
				<a href="../main/Logout.jsp"><img src="../images/lnb05.gif" alt="LOGOUT" /></a>
			<% } %>
		</li>
		
		
		
		<!-- 로그인후 -->
<!-- 		<li><a href="../center/sub07.jsp"><img src="../images/lnb05.gif" alt="LOG OUT" /></a></li> -->
<!-- 		<li><a href="../center/sub07.jsp"><img src="../images/lnb06.gif" alt="MODIFY" /></a></li> -->
		
		
		<!-- 로그인/비로그인 공통 -->
			<li><a href="../member/join01.jsp"><img src="../images/lnb02.gif" alt="JOIN" /></a></li>
<!-- 		<li><a href="../member/sitemap.jsp"><img src="../images/lnb03.gif" alt="SITEMAP" /></a></li> -->
<!-- 		<li><a href="../center/sub06.jsp"><img src="../images/lnb04.gif" alt="CONTACT US" /></a></li> -->
		
	</ul>	 
	
	<!-- <a href="../center/sub01.jsp"><img src="../images/navi.jpg" id="navigation" /></a> -->
	<img src="../images/menu_bar.JPG" id="navigation"  width="753" height="65" usemap="#GNB"/>
	<map name="GNB">
	<area shape="rect" alt="" title="" coords="4,4,198,45" href="../center/sub01.jsp" target="" />
	<area shape="rect" alt="" title="" coords="222,7,392,44" href="../space/sub01_list.jsp" target="" />
	<area shape="rect" alt="" title="" coords="409,6,573,43" href="../market/sub01.jsp" target="" />
	<area shape="rect" alt="" title="" coords="587,8,749,42" href="../product/sub01.jsp" target="" />
<!-- 		<area shape="rect" alt="" title="" coords="0,0,80,33" href="../center/sub01.jsp" target="" /> -->
<!-- <!-- 		<area shape="rect" alt="" title="" coords="86,0,188,33" href="../business/sub01.jsp" target="" /> -->
<!-- 		<area shape="rect" alt="" title="" coords="193,0,316,33" href="../product/sub01.jsp" target="" /> -->
<!-- 		<area shape="rect" alt="" title="" coords="321,0,420,33" href="../market/sub01.jsp" target="" /> -->
<!-- 		<area shape="rect" alt="" title="" coords="428,0,529,33" href="../space/sub01_notice.jsp" target="" /> -->
<!-- 		<area shape="rect" alt="" title="" coords="536,0,638,33" href="../community/sub01.jsp" target="" /> -->
<!-- 		<area shape="rect" alt="" title="" coords="641,0,749,33" href="../volunteer/sub01.jsp" target="" /> -->
	</map>
	
	<!--  <div style="position:absolute; margin:-25px 0 0 200px;  border:0px solid #000;">	
		<object type="application/x-shockwave-flash" data="../swf/navi.swf" width="753" height="65">
			<param name="wmode" value="transparent" />
		</object>		
	</div>  -->
</div>
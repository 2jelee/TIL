<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI계산기 페이지</title>
</head>
 <body>
<center>
	<div id="wrap">
	<%@ include file="../include/top.jsp" %>

	<img src="../images/product/sub_image.jpg" id="main_visual" />
	
	<div class="contents_box">
	<div class="left_contents">
			
	<%@ include file = "../include/product_leftmenu.jsp" %>
	</div>
	<div class="right_contents">
		<div class="top_title">
			<img src="../images/bmi cal icon.JPG" alt="자체생산품" width="220" height="40" class="con_title" />
			<p class="location"><text><img src="../images/center/house.gif" />&nbsp;&nbsp;자료실&nbsp;>&nbsp;BMI계산기<p>
		</div>
		
		
		
		
		
		<form action=../product/bmi.jsp>
<!--         <form method="post" action="MemberJoinAction.do" name="userInfo" onsubmit="return checkValue()"> -->
			<table border="1" bordercolor="black" width ="750" height="200" align = "center" >
	        <tr bgcolor="gray" align ="center">
	       
	        </tr>
	        <tr align = "center" bgcolor="lightgray">
	        <td>성별정보</td>
	        <td>신체정보</td>
	        
	        <tr>
	            <td id="title" align="center">성별&nbsp;&nbsp;&nbsp;&nbsp;
	                <input type="radio" name="gender" value="남" >남
	                <input type="radio" name="gender" value="여" checked>여
	                
	            <td id="title">키 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="height" />cm</br>
	                    몸무게 : <input type="text" name="weight"/>kg</br>
	                    나이 : &nbsp;&nbsp;&nbsp;<input type="text" name="age"/>살
	            </td>
	        </tr>
	        <tr>
	        <td colspan="3" align = "center" bgcolor="white"><input type="submit" value="계산하기"/></td>
<!-- 	        <td colspan="3" align = "center" bgcolor="white"><input type="submit" value="계산하기"/><a href="javascript:fn_calBMI();" class="btn btn-default btn-block" role="button">계산하기</a></td> -->
	        </td>
	    </tr>
	 
	    </table>
    
    
    
    
    
		
		
		
		</div>
	</div>
	<%@ include file="../include/quick.jsp" %>
</div>


<%@ include file="../include/footer.jsp" %>
</center>
 </body>
</html>

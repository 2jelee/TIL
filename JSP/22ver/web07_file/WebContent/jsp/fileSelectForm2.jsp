<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../view/color.jsp" %>

<!-- ------------------------------------------------------------------ -->
 <%!
 		public String getParam(HttpServletRequest request,  String paramName ) {
	 		if( request.getParameter(paramName) != null ) {
	 			return request.getParameter(paramName);
	 		} else {
	 			return "";
	 		}
 		}
 %>
 <%
 		request.setCharacterEncoding("utf-8");
 		int fileCount = 0;
 		
 		if( request.getParameter("addcnt") != null  ) {
 			fileCount = Integer.parseInt(request.getParameter("addcnt"));
 		}
 %>
 <!-- ------------------------------------------------------------------ -->

<html>
<head><title>여러개의 파일을 업로드하는 예제</title></head>
<link href="../view/style.css" rel="stylesheet" type="text/css" >

<script type="text/javascript">
	function inputValue(form1, param, form2, idx){   //inputValue(this.form, title,frmName2, 1)"
		var paramValue = form1.elements[idx].value;
		form2.elements[idx].value = paramValue;
		return;
	}
	
	function addFile(formName){
		if(formName.addcnt.value == ""){
			alert("입력할 파일 갯수를 넣고 확인 클릭해라~");
			formName.addcnt.focus();
			return;
		}
		
		formName.submit();
	}
	
	function elementCheck(formName){
		paramIndex = 1;
		for(idx=0; idx<formName.elements.length; idx++){
			if(formName.elements[idx].type == "file"){
				if(formName.elements[idx].value==""){
					var msg = paramIndex + "번째 파일 정보가 없습니다.\n"+
										"업로드할 파일을 선택해라!!";
					alert(msg);
					formName.elements[idx].focus();
					return ;
				}
				
				paramIndex++;
			}
		}
		formName.action = "fileSelectPro2.jsp";
		formName.submit();
	}
	
	
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#storetype").change(function(){
		    var x=$(this).val();
		});
		alert(x);
	});

	/* var sel = document.getElementsByName('storetype');
	var sv = sel.value;
	alert(sv); */
</script>
<body bgcolor="<%= bodyback_c %>">
	<div align="center">
		<h2>여러개의 파일을 업로드하는 예제 입니다.</h2>
		<font color="#0000ff" size="2">파일 갯수를 입력한 후 확인 눌러줘요<br>
		입력이 완료되면 파일 업로드를 위한 업로드 단추를 눌러요~ 
		</font>	</div> <br>
	<form name="frmName" method="post">
	<table width="50%" border="1" align="center" cellpadding="1" cellspacing="1">
	
	<tr>
    	<td width="15%" bgcolor="<%=value_c %>" align="center">업 종</td>
		   <td> 
		   <%-- <select	name="storetype" id="storetype" onkeyup="inputValue(this.form, storetype,frmName2, 3)" 
		   value=" <%=getParam(request, "storetype") %>" > --%>
		  <select	name="storetype" id="storetype" > 
			<option value="한식">한식</option>
			<option value="중식">중식</option>
			<option value="일식">일식</option>
			<option value="패스트푸드">패스트푸드</option>
			<option value="술집">술집</option>
			<option value="카페">카페</option>
			
		</select> &nbsp;&nbsp;
		
		</td>
		</tr>
	
	<tr>
		<td width="15%" bgcolor="<%=value_c %>" align="center">작성자</td>
		<td><input type="text" name="user" onkeyup="inputValue(this.form, user,frmName2, 0)" 
			value=" <%=getParam(request, "user") %>" ></td>
			
	<tr>
		<td width="15%" bgcolor="<%=value_c %>" align="center">제목</td>
		<td><input type="text" name="title" onkeyup="inputValue(this.form, title,frmName2, 1)" 
			value="<%=getParam(request, "title") %>" ></td>
	</tr>
	
	<tr>
		<td width="15%" bgcolor="<%=value_c %>" align="center">내용</td>
		<td width="50%" colspan="3">
		<textarea name="abstract" cols="40" 
		onkeyup="inputValue(this.form, abstract, frmName2, 2)">
		<%= getParam(request, "abstract") %>
		</textarea>
		</td>
	</tr>
	
	<tr>
		<td colspan="4" bgcolor="<%=value_c %>" align="center" >
		업로드할 파일 수 입력
		<input type="text" name="addcnt" >
		<input type="button" value="확인" onclick="addFile(this.form)">
		</td>
	</tr>
	</table>
</form>
		<!-- action="fileSelectPro2.jsp" -->
<form  name="frmName2" method="post" enctype="multipart/form-data"  >
	<table width="50%" border="1" align="center" cellpadding="1" cellspacing="1" >
    <tr>
    	<td width="40%" bgcolor="<%=value_c %>" align="center">
    	<input type="hidden" name="txtUser" value="<%= getParam(request, "user") %>" >   	
    	<input type="hidden" name="txtTitle" value="<%= getParam(request, "title") %>" >
    	<input type="hidden" name="txtAbstract" value="<%= getParam(request, "abstract") %>" >
    	<!-- ------------------------------------------------------------------ -->
    	<%
    			for( int i = 0; i < fileCount ; i++ ) {
    	%>
    	<input type="file"  size="50" name="selectFile<%=i %>" > <br>
    	<%    } // end for  %>
 		<!-- ------------------------------------------------------------------ -->
    	<input type="button" value="업로드" onclick="elementCheck(this.form)" > 
    	<!-- <input type="submit" value="업로드" onclick="elementCheck(this.form)" >  -->
    	</td>
    </tr>
    </table>
</form>
</body>
</html>










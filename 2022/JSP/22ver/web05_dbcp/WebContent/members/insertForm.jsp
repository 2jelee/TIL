<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../view/color.jsp"%>
<html>
<head>
<title>회원가입창</title>
<link href="/view/mystyle.css" rel="stylesheet" type="text/css">
<script language="JavaScript">
<!--
    function checkIt() { //사용자가 입력폼에 입력한 상황을 체크
        var userinput = eval("document.userinput");
        if(!userinput.id.value) {  //아이디를 입력하지 않으면...
            alert("ID필수 사항입니다.");
            userinput.id.focus();
            return false; //사용자가 서비스를 요청한 시점으로 돌아감
        }
        
        if(!userinput.passwd.value ) { //비밀번호를 입력하지 않으면 수행
            alert("비밀번호 넣으세요");
            return false;
        }
        if(userinput.passwd.value != userinput.passwd2.value)
        {  //비밀번호와 재입력비밀번호가 같지 않으면 수행
            alert("암호를 동일하게 입력하세요");
            return false;
        }
       
        if(!userinput.name.value) { //이름을 입력하지 않으면 수행
            alert("사용자 이름을 입력하세요");
            return false;
        }
        if(!userinput.jumin1.value  || !userinput.jumin2.value )
        { //주민번호의 앞자리와 뒷자리를 입력하지 않으면 수행
            alert("주민등록번호 넣으세요");
            return false;
        }
    }
	
	// 아이디 중복 여부 판단 함수
    function openConfirmid(userinput) {
        if (!userinput.id.value) {  //아이디를 입력했는지 검사
            alert("아이디 넣으세요");
            return;
        }
        //url과 사용자 입력 id를 조회합니다.
        url = "confirmId.jsp?id=" + userinput.id.value ;
        
        //새로운 윈도우를 연다.
        open(url, "confirm", 
        "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300, height=200");
    }
    //-->
</script>


<body bgcolor="<%=bodyback_c%>">

<form method="post" action="insertPro.jsp" name="userinput" onSubmit="return checkIt()">
  <table width="600" border="1" cellspacing="0" cellpadding="3" align="center" >
    <tr> 
    <td colspan="2" height="39" align="center" bgcolor="<%=value_c%>" >
       <font size="+1" ><b>회원가입</b></font></td>
    </tr>
    <tr> 
      <td width="200" bgcolor="<%=value_c%>"><b>아이디입력</b></td>
      <td width="400" bgcolor="<%=value_c%>">&nbsp;</td>
    </tr>  

    <tr> 
      <td width="200"> 사용자 ID</td>
      <td width="400"> 
        <input type="text" name="id" size="10" maxlength="12" placeholder="id에 입력요망">
        <input type="button" name="confirm_id" value="ID중복확인" OnClick="openConfirmid(this.form)">
      </td>
    </tr>
    <tr> 
      <td width="200"> 비밀번호</td>
      <td width="400" > 
        <input type="password" name="passwd" size="15" maxlength="12" placeholder="비번 입력요망">
      </td>
    <tr>  
      <td width="200">비밀번호 확인</td>
      <td width="400"> 
        <input type="password" name="passwd2" size="15" maxlength="12" placeholder="비번확인">
      </td>
    </tr>
    
    <tr> 
      <td width="200" bgcolor="<%=value_c%>"><b>개인정보 입력</b></td>
      <td width="400" bgcolor="<%=value_c%>">&nbsp;</td>
    <tr>  
    <tr> 
      <td width="200">사용자 이름</td>
      <td width="400"> 
        <input type="text" name="name" size="15" maxlength="10" placeholder="이름입력하세요">
      </td>
    </tr>
    <tr> 
      <td width="200">주민등록번호</td>
      <td width="400"> 
        <input type="number" name="jumin1" size="7" maxlength="6" placeholder="123456">
        -<input type="number" name="jumin2" size="7" maxlength="7" placeholder="1234567">
      </td>
    </tr>
    <tr> 
      <td width="200">E-Mail</td>
      <td width="400"> 
        <input type="email" name="email" size="40" maxlength="30" placeholder="kosta@kosta.or.kr">
      </td>
    </tr>
    <tr> 
      <td width="200"> Blog</td>
      <td width="400"> 
        <input type="text" name="blog" size="60" maxlength="50">
      </td>
    </tr>
    <tr> 
      <td colspan="2" align="center" bgcolor="<%=value_c%>"> 
          <input type="submit" name="confirm" value="등 록" >
          <input type="reset" name="reset" value="다시입력">
          <input type="button" value="가입확인" onclick="javascript:window.location='main.jsp'">
      </td>
    </tr>
  </table>
</form>
</body>
</html>

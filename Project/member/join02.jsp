<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>

<script type="text/javascript">
// 회원가입 화면의 입력값들을 검사한다.
	function checkValue(){
		var form = document.userInfo;
	
	if(!form.name.value){
		alert("이름을 입력하세요.");
	return false;
	}
	
	if(!form.id.value){
		alert("아이디를 입력하세요.");
	return false;
	}
	
// 	if(form.idDuplication.value != "idCheck"){
// 		alert("아이디 중복체크를 해주세요.");
// 	return false;
// 	}
	
	if(!form.pass.value){
		alert("비밀번호를 입력하세요.");
	return false;
	}
	
	// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
	if(form.pass.value != form.pass2.value ){
		alert("비밀번호를 확인하세요.");
	return false;
	}    
	
	if(!form.tel1.value && !form.tel2.value && !form.tel3.value){
// 	if(!form.tel.value){
		alert("전화번호를 입력하세요.");
	return false;
	}
	
	if(!form.mobile1.value && !form.mobile2.value && !form.mobile3.value){
		alert("휴대폰번호를 입력하세요.");
	return false;
	}
	
	if(!form.email1.value && !form.email2.value){
		alert("이메일 주소를 입력하세요.");
	return false;
	}
	
	if(!form.zip1.value && !form.zip2.value && !form.zip3.value && !form.zip4.value){
		alert("주소를 입력하세요.");
	return false;
	}
}
	

// 아이디 중복체크 화면open
function openIdChk(){

window.name = "parentForm";
window.open("../member/IdCheckForm.jsp",
    "chkForm", "width=500, height=300, resizable = no, scrollbars = no");    
}

// // 아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
// // 이렇게 하는 이유는 중복체크 후 다시 아이디 창이 새로운 아이디를 입력했을 때
// // 다시 중복체크를 하도록 한다.
// function inputIdChk(){
// document.userInfo.idDuplication.value ="idUncheck";
// }
</script>
</head>



<body>
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
				<img src="../images/join_tit.gif" alt="회원가입" class="con_title" />
				<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;멤버쉽&nbsp;>&nbsp;회원가입<p>
			</div>

			<p class="join_title"><img src="../images/join_tit03.gif" alt="회원정보입력" /></p>




			<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
	        <!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 joinProcess.jsp-->
<!-- 	        <form method="post" action="MemberJoinAction.do" name="userInfo" onsubmit="return checkValue()"> -->
				
<!-- 				<form method="post" action="UseBeanFormResult.jsp"> -->
				<form method="post" action="../member/join02_joinProcess.jsp" name="userInfo" onsubmit="return checkValue()">
				
				<table cellpadding="0" cellspacing="0" border="0" class="join_box">
					<colgroup>
						<col width="80px;" />
						<col width="*" />
					</colgroup>
					
					<!-- 1. 이름 입력란 -->
					<tr>
						<th><img src="../images/join_tit001.gif" /></th>
						<td><input type="text" name="name" value="" class="join_input" /></td>
					</tr>
					
					<!-- 2. 아이디 입력란 -->
					<tr>
						<th><img src="../images/join_tit002.gif" /></th>
<!-- 						<td><input type="text" name="id"  value="" class="join_input" />&nbsp;<a onclick="id_check_person();" style="cursor:hand;"><img src="../images/btn_idcheck.gif" alt="중복확인"/></a>&nbsp;&nbsp;<span>* 4자 이상 12자 이내의 영문/숫자 조합하여 공백 없이 기입</span></td> -->
						<td><input type="text" name="id"  value="" class="join_input" />&nbsp;<a onclick="openIdChk()" style="cursor:hand;"><img src="../images/btn_idcheck.gif" alt="중복확인"/></a>&nbsp;&nbsp;<span>* 4자 이상 12자 이내의 영문/숫자 조합하여 공백 없이 기입</span></td>
					</tr>
					
					<!-- 3. 비밀번호 입력란 -->
					<tr>
						<th><img src="../images/join_tit003.gif" /></th>
						<td><input type="password" name="pass" value="" class="join_input" />&nbsp;&nbsp;<span>* 4자 이상 12자 이내의 영문/숫자 조합</span></td>
					</tr>
					
					<!-- 4. 비밀번호 확인용 입력란 -->
					<tr>
						<th><img src="../images/join_tit04.gif" /></th>
						<td><input type="password" name="pass2" value="" class="join_input" /></td>
					</tr>
					
					<!-- 5. 전화번호 입력란 -->
					<tr>
						<th><img src="../images/join_tit06.gif" /></th>
<!-- 						<td name="tel" value=""> -->
						<td>
<!-- 							<input type="text" name="tel" value=""  class="join_input" style="width:200px;" /> -->
							<input type="text" name="tel1" value="" maxlength="3" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="tel2" value="" maxlength="4" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="tel3" value="" maxlength="4" class="join_input" style="width:50px;" />
						</td>
					</tr>
					
					<!-- 6. 휴대폰번호 입력란 -->
					<tr>
						<th><img src="../images/join_tit07.gif" /></th>
<!-- 						<td name="mobile"> -->
							<td>
							<input type="text" name="mobile1" value=""  maxlength="3" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="mobile2" value="" maxlength="4" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="mobile3" value="" maxlength="4" class="join_input" style="width:50px;" />
							</td>
					</tr>
					
					<!-- 7. 이메일 입력란 -->
					<tr>
						<th><img src="../images/join_tit08.gif" /></th>
<!-- 						<td name="email"> -->
						<td>
						<input type="text" name="email1" style="width:100px;height:20px;border:solid 1px #dadada;" value="" /> @ 
<!-- 						<input type="text" name="email2" style="width:100px;height:20px;border:solid 1px #dadada;" value="" /> -->
<!-- 						<input type="text" name="email2" style="width:150px;height:20px;border:solid 1px #dadada;" value="" readonly /> -->
<!-- 						<select name="last_email_check2" onChange="email_input(this);" class="pass" id="last_email_check2" > -->
 						<select name="email2" onChange="email_input(this);" class="pass" id="last_email_check2" > 
							<option selected="" value="">----선택----</option>
							<option value="1" >직접입력</option>
							<option value="gmail.com" >gmail.com</option>
							<option value="naver.com" >naver.com</option>
							<option value="hanmail.net" >hanmail.net</option>
							<option value="nate.com" >nate.com</option>
						</select>
	 
						<input type="checkbox" name="open_email" value="1">
						<span>이메일 수신동의</span></td>
					</tr> 
					
					<!-- 8. 거주지 입력란 -->
					<tr>
						<th><img src="../images/join_tit09.gif" /></th>

						<td>
						<input type="text" name="zip1" id="sample6_postcode" placeholder="우편번호">
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
						<input type="text" name="zip2" id="sample6_address" placeholder="주소"><br>
						<input type="text" name="zip3" id="sample6_detailAddress" placeholder="상세주소">
						<input type="text" name="zip4" id="sample6_extraAddress" placeholder="참고항목">
	                    </td>
					</tr>
				</table>
					
					
				
				<center>
					<button type="submit" class="btn btn-danger">가입하기</button>
					<button type="button" class="btn btn-warning" 
						onclick="location.href='../member/join01.jsp';">최소하기</button>
	            </center>
        </form>
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
// 회원가입창의 아이디 입력란의 값을 가져온다. -->
function pValue(){
    document.getElementById("userId").value = opener.document.userInfo.id.value;
}

// 아이디 중복체크
function idCheck(){

    var id = document.getElementById("userId").value;

    if (!id) {
        alert("아이디를 입력하지 않았습니다.");
        return false;
    } 
    else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){ 
        alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
        return false;
    }
    else
    {
        var param="id="+id
        httpRequest = getXMLHttpRequest();
        httpRequest.onreadystatechange = callback;
        httpRequest.open("POST", "MemberIdCheckAction.do", true);    
        httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
        httpRequest.send(param);
    }
}

function callback(){
    if(httpRequest.readyState == 4){
        // 결과값을 가져온다.
        var resultText = httpRequest.responseText;
        if(resultText == 0){
            alert("사용할수없는 아이디입니다.");
            document.getElementById("cancelBtn").style.visibility='visible';
            document.getElementById("useBtn").style.visibility='hidden';
            document.getElementById("msg").innerHTML ="";
        } 
        else if(resultText == 1){ 
            document.getElementById("cancelBtn").style.visibility='hidden';
            document.getElementById("useBtn").style.visibility='visible';
            document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다.";
        }
    }
}
    
// 사용하기 클릭 시 부모창으로 값 전달 
function sendCheckValue(){
    // 중복체크 결과인 idCheck 값을 전달한다.
    opener.document.userInfo.idDuplication.value ="idCheck";
    // 회원가입 화면의 ID입력란에 값을 전달
    opener.document.userInfo.id.value = document.getElementById("userId").value;
    
    if (opener != null) {
        opener.chkForm = null;
        self.close();
    }    
}    
</script>


</head>

<div class="container">
<h2>아이디 중복체크</h2>
<!-- Button to Open the Modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
	중복확인
</button>

<!-- The Modal -->
<div class="modal fade" id="myModal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
    
			<!-- Modal Header -->
		    <div class="modal-header">
		      <h4 class="modal-title">아이디 확인결과</h4>
		      <button type="button" class="close" data-dismiss="modal">&times;</button>
		    </div>
      
		    <!-- Modal body -->
		    <div class="modal-body1">
		   		이미 존재하는 아이디입니다.
		    </div>
		    <div class="modal-body2">
		   		사용할 수 있는 아이디입니다.
		    </div>
      
			<!-- Modal footer -->
			<div class="modal-footer">
		    	<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			</div>
      
   		</div>
	</div>
</div>
  
</div>

</body>
</html>
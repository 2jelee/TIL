<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>php Board - Login</title>
    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous">
    </script>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
<?php
    include 'logo.php';
?>
<form name="loginSubmit" id="loginSubmit" method="post" action="login_ok.php">
    <h3 style="text-align: left">로그인 페이지</h3>
<!--    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="row g-3 align-items-center">
        <div class="col-auto">
            <label for="inputPassword6" class="col-form-label">Password</label>
        </div>
        <div class="col-auto">
            <input type="password" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline">
        </div>
        <div class="col-auto">
            <span id="passwordHelpInline" class="form-text">Must be 8-20 characters long.</span>
        </div>
    </div>-->


    <div class="col-lg-4"></div>
    <div class="form-group">아이디
        <input type="text" class="form-control" placeholder="아이디" name="id" maxlength="15">
    </div>
    <div class="form-group">패스워드
        <input type="password" class="form-control" placeholder="비밀번호" name="pass" maxlength="20">
    </div>
    <a href="#"><span class="btn btn-primary form-control" onclick="check_input()">로그인</span></a>
</form>
<!--<button class="btn btn-primary form-control" onclick="window.open('join.php');">회원가입</button>-->

<script>
function check_input(){
    if(!document.loginSubmit.id.value){
    alert("아이디를 입력하세요.");
    document.loginSubmit.id.focus();
    return;
    }

    if(!document.loginSubmit.pass.value){
    alert("비밀번호를 입력하세요.");
    document.loginSubmit.pass.focus();
    return;
    }
document.loginSubmit.submit();
}

/* jQuery 적용 test */
/*
$('#loginSubmit').css('border','1px solid blue')
*/

</script>
<!--<script src="login.js"></script>-->

</body>
</html>
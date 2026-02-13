<?php
    include_once "db_conn.php";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>php Board - Join</title>
    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>

    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
<form name="joinSubmit" id="joinSubmit" method="post" action="join_ok.php">
<!--
    <h3>회원가입 페이지</h3>
    <form>
        <div class="row mb-3">
            <label for="id" class="col-sm-2 col-form-label">ID</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="id">
            </div>
        </div><div class="row mb-3">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3">
            </div>
        </div>
        <div class="row mb-3">
            <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail3" width="" >
            </div>
        </div>
        <fieldset class="row mb-3">
            <legend class="col-form-label col-sm-2 pt-0">성별</legend>
            <div class="col-sm-10">
                <div class="form-check">
                    <label><input type="radio" name="gender" id="man" value="01" checked>남자</label>
                    <label><input type="radio" name="gender" id="woman" value="02">여자</label>
                </div>
            </div>
        </fieldset>
        <button type="submit" class="btn btn-primary" onclick="check_input()">회원가입</button>
    </form>
-->












    <?php
        include 'logo.php'
    ?>

    <div class="form-group">아이디
        <input type="text" class="form-control" name="id" id="id" maxlength="15">
    </div>
    <div class="form-group">비밀번호
        <input type="password" class="form-control" name="pass" id="pass" maxlength="20">
    </div>
    <div class="form-group">비밀번호 확인
        <input type="password" class="form-control" name="pw_confirm" id="pw_confirm" maxlength="20">
    </div>
    <div class="form-group">이름
        <input type="text" class="form-control" name="name" id="name" maxlength="20">
    </div>
    <div class="form-group">성별
        <label><input type="radio" name="gender" id="gender" value="01" checked>남자</label>
        <label><input type="radio" name="gender" id="gender" value="02">여자</label>
    </div>
    <div class="form-group">전화번호
        <input type="text" class="form-control" name="phone" id="phone" maxlength="20">
    </div>
    <div class="form-group">이메일
        <input type="email" class="form-control" name="email" id="email" maxlength="20">
    </div>
    <a href="#"><span class="btn btn-primary form-control" onclick="check_input()">회원가입</span></a>
<!--            &nbsp;-->
<!--            <span class="btn btn-primary form-control" onclick="reset_form()">초기화?</span>-->
</form>

<script>
function check_input() {
    if(!$("#id").val()) {
        alert("아이디를 입력하세요.");
        $("#id").focus();
        return;
    }
    if(!$("#pass").val()) {
        alert("비밀번호를 입력하세요.");
        $("#pass").focus();
        return;
    }
    if(!$("#pw_confirm").val()) {
        alert("비밀번호 확인을 진행하세요.");
        $("#pw_confirm").focus();
        return;
    }
    if($("#pass").val() != $("#pw_confirm").val()){
        alert("비밀번호가 일치하지 않습니다. 다시 한번 확인해주세요.");
        $("#pw_confirm").focus();
        return;
    }
    if(!$("#name").val()) {
        alert("이름을 입력하세요.");
        $("#name").focus();
        return;
    }
    if(!$("#phone").val()) {
        alert("전화번호를 입력하세요.");
        $("#phone").focus();
        return;
    }
    if(!$("#email").val()) {
        alert("이메일을 입력하세요.");
        $("#email").focus();
        return;
    }
    /*if(!$(".form").("input[name='gender']:checked").val(){
        alert("성별을 선택하세요.");
        return;
    }*/
document.joinSubmit.submit();
}

/* jQuery 적용 test */
/*$('#joinSubmit').css('border','1px solid blue')*/

</script>
<!--<script src="login.js"></script>
-->
</body>
</html>
<?php
    include 'db_conn.php';
?>
<!DOCTYPE html>
<html>
<head>
    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous">
    </script>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <style>
        #container {
            width: 1200px;
            margin: 50px;
            padding: 50px;
            padding-right: 105px;
            border-style: solid;
            padding-top: 30px;
            color: #50575e;
        }
        #finBtn {
            width: max-content;
        }
    </style>
</head>
<body>
<?php
    include 'header.php';
?>
<form name="writeSubmit" id="writeSubmit" method="post" action="write_pass.php">
    <div id="container">
        <label>작 성 자 :</label>&nbsp
        <?php
            echo("{$userid}");
        ?>
        <br><br>
        <div class="form-group">
            <label for="title" class="form-label">제 목
                <input type="textarea" class="form-control" id="title" name="title" rows="3" placeholder="제목을 입력하세요." style="width: 1100px; height: auto">
            </label>
        </div>
        <div class="form-group">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">비밀글로 설정하기</label>
        </div>
        <br>
        <div class="form-group">
            <label for="writePass" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="writePass" name="writePass" placeholder="비밀번호" style="width: auto";>
        </div>
        <br>
        <div class="form-group">
            <label for="content" class="form-label">내 용</label> <!-- name으로 입력한 값 전송 -->
            <input type="textarea" class="form-control" id="content" name="content" rows="3" placeholder="여기에 내용을 입력하세요." style="width: 1100px; height: 500px">
<!--            <textarea class="form-control" id="content" rows="3" placeholder="이곳에 내용을 입력하세요." style="width: 1100px; height: 500px;"></textarea>-->
        </div>
        <br>
        <div class="form-group" id="finBtn">
            <a href="#"><span class="btn btn-primary form-control" onclick="check_input()">작성 완료</span></a>
        </div>
    </div>
</form>
</div>
<script>
function check_input() {
    if(!$("#title").val()) {
        alert("제목을 입력하세요.");
        $("#title").focus();
        return;
    }
    if($(".form-check-input").is(':checked')) {
        if(!$("#writePass").val()) {
            alert("비밀번호를 입력하세요.");
            $("#writePass").focus();
            return;
        }
    }
    if(!$("#content").val()) {
        alert("내용을 입력하세요.");
        $("#content").focus();
        return;
    }
document.writeSubmit.submit();
}
</script>
</body>
<?php
include "config.php";
include "db_conn.php";

$date = date('Y-m-d h:i:s');
$title = $_POST['title'];
$content = $_POST['content'];
$pass = '0';
$hit = '0';

//$row = mysqli_fetch_array($result);
//$db_pass = password_hash($row['pass'],PASSWORD_DEFAULT);

//$pass = $_POST['pass'];

//mq("alter table board auto_increment =1"); //auto_increment 값 초기화 (삭제 시 번호 비지 않게 하기 위해서)
echo "<script>alert('제목에 들어간 값 : {$title}')</script>";
echo "<script>alert('내용에 들어간 값 : {$content}')</script>";
//echo "<script>alert('{$date}')</script>";

//순서 지켜서 해보기?
//mq("INSERT board
//            SET
//
//                title = '$title' ,
//                content = $content ,
//                id = $userid,
//                date = $date;
//   ");

$con = mysqli_connect("localhost", "root", "", "bbs");
    $sql = "INSERT INTO board(title, content, id, pass, date, hit) ";
    $sql .= "values('$title', '$content', '$userid', '$pass', '$date', '$hit')";
    mq("INSERT board
                    SET
                        title = '.$title.' ,
                        content = '.$content.' ,
                        id = '.$userid.' ,
                        pass = '.$pass.',
                        date = '.$date.',
                        hit = '.$hit.'
            ");

echo "
      <script>
          alert('정상적으로 게시물 등록이 완료되었습니다.');
          location.href = 'index.php';
      </script>
	  ";
?>

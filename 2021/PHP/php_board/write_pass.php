<?php
include "config.php";
include "db_conn.php";

$name = $userid;
$date = date('Y-m-d h:m:s');
$writePass = $_POST['writePass']; // 암호화 X
//$writePass = password_hash($_POST['writePass'], PASSWORD_DEFAULT); // 입력받은 패스워드를 해쉬값으로 암호화
$title = $_POST['title'];
$content = $_POST['content'];
//mq("alter table board auto_increment =1"); //auto_increment 값 초기화 (삭제 시 번호 비지 않게 하기 위해서)

mq("INSERT 
			board
		SET	
		    idx = '".$bno."',
			id = '".$name."',  
			title = '".$title."', 
			content = '".$content."',  
			pass = '".$writePass."',
			date ='".$date."'
    ");
?>
<script>
    alert("게시물 등록이 완료되었습니다.");
    location.href = 'index.php';
</script>
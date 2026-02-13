<?php
    include_once "db_conn.php";

    $id = $_POST['id'];
    $pass = $_POST['pass'];
    $name = $_POST['name'];
    $gender = $_POST['gender'];
    $phone = $_POST['phone'];
    $email  = $_POST['email'];


  $con = mysqli_connect("localhost", "root", "", "bbs");

  	$sql = "INSERT INTO user(id, pass, name, gender, phone, email) ";
  	$sql .= "values('$id', '$pass', '$name', '$gender', '$phone', '$email')";
 	mq("INSERT user
 		        SET
                    id = '$id' ,
                    pass = '$pass',
                    name = '$name',
                    gender = '$gender',
                    phone = '$phone',
                    email = '$email'
 		");
//mq("insert into user(id,pass,name,gender,phone,email) values('".$id."','".$pass."','".$name."','".$gender."','".$phone."','".$email."')");


echo "
      <script>
          alert('회원가입이 완료되었습니다.');
          location.href = 'index.php';
      </script>
	  ";
?>

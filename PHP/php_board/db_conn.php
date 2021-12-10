<!-- DB 연동-->
<?php
    $db_id="root";
    $db_pw="";
    $db_name="bbs";
    $db_domain="localhost";
    $db=mysqli_connect($db_domain,$db_id,$db_pw,$db_name);

    /* mysqli_connect 함수를 통해 php와 MySQL을 연결, 쿼리실행 함수를 매번 필요할 때마다 호출할 수 있게
    추후 코드 간소화를 위해 사용*/
    function mq($sql){
        global $db;
        return $db->query($sql);
    }
?>

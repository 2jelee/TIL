<?php
    include_once "config.php";
    include_once "db_conn.php";

    // 페이징 처리
    if(isset($_GET["page"]))
        $page = $_GET["page"];
    else
        $page = 1;
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
        .boardType {
            margin-top: 20px;
            margin-bottom: 20px;
            font-size: 25px;
        }
        .table_head{
            background-color: lightgrey;
            text-align: center;
            width: auto;
        }
        .list{
            text-align: center;
            width: auto;
        }
        .btn btn-sm btn-outline-secondary{
            text-align: right;
        }
        .notice {
            font-size: 12px;
            color: red;
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div id="boardList">
<!--        <div class="boardType" align="center"><b>자유게시판</b></div>-->
        <?php
            if($userid){
        ?>
            <div align="right" style="margin-top:10px; margin-bottom: 10px;"><button class="btn btn-sm btn-outline-secondary" type = "button" onclick = "location.href='write.php';">글쓰기</button></div>
        <?php
            } else{
        ?>
            <div class="notice">※회원제 게시판입니다. 게시물을 확인하려면 로그인 하십시오.※</div>
        <?php
            }
        ?>
        <table class="table table-hover">
            <tr class="table_head">
                <th>번 호</th>
                <th style="width: 500px;";">제 목</th>
                <th>작 성 자</th>
                <th>작 성 일</th>
                <th>조 회 수</th>
            </tr>

            <!-- 페이징 처리 -->
            <?php
                $sql = mq("SELECT * FROM board");
                $total_record = mysqli_num_rows($sql); //게시판 총 레코드 수
                $list = 10; //30개씩 게시물 출력
                    $block_cnt = 10; //10개씩 페이지이동 버튼 생성
                    $block_num = ceil($page / $block_cnt);
                    $block_start = (($block_num -1) * $block_cnt) + 1; // 블록의 시작 번호
                $block_end = $block_start + $block_cnt -1; //블록의 끝(마지막) 번호

                $total_page = ceil($total_record / $list);

                if($block_end > $total_page){
                    $block_end = $total_page;
                }
                $total_block = ceil($total_page/$block_cnt); //블록의 총 갯수
                $page_start = ($page-1)*$list; //페이지 시작

                //게시글 정보 가져오기
                $sql2 = mq("select * from board order by idx desc limit $page_start, $list");
                while($board = $sql2->fetch_array()){
                $title=$board["title"];

            ?>
            <tbody>
                <tr class="list" id="list">
                    <td><?=$board['idx']; ?></td>
                    <td width="200" style="text-align: left; padding-left: 100px">
                        <span class="read_check" style="cursor: pointer;" data-action="read.php?idx=<?=$board['idx']?>" ><?=$title?></span>
                    </td>
                    <td><?=$board['id']; ?></td>
                    <td><?=$board['date']?></td>
                    <td><?=$board['hit']?></td> <!-- 추후 hit로 고치기-->
                </tr>
            </tbody>
            <?php
                    }
            ?>
        </table>
        <div id="page_num" style="text-align: center;">
            <div id="page_num" style="text-align: center; margin-bottom: 30px";>
                <?php
                    if ($page <= 1){
                        // 빈 값
                    } else {
                        echo "<a href='index.php?page=1'>처음 </a>";
                    }

                    if ($page <= 1){
                        // 빈 값
                    } else {
                        $pre = $page - 1;
                        echo "<a href='index.php?page=$pre'>◀ 이전 </a>";

                    }

                    for($i = $block_start; $i <= $block_end; $i++){
                        if($page == $i){
                            echo "<b> $i </b>";
                        } else {
                            echo "<a href='index.php?page=$i'> $i </a>";
                        }
                    }

                    if($page >= $total_page){
                        // 빈 값
                    } else {
                        $next = $page + 1;
                        echo "<a href='index.php?page=$next'> 다음 ▶</a>";
                    }

                    if($page >= $total_page){
                        // 빈 값
                    } else {
                        echo "<a href='index.php?page=$total_page'> 마지막</a>";
                    }
                ?>
            </div>
        </div>
    </div>
</div>
<script>
    $(function(){
        $(".read_check").click(function(){
            <?php
                if($userid == null) {
            ?>
                alert("회원제 게시판입니다. 게시물을 확인하려면 로그인 하십시오.");
            <?php
            } else {
            ?>
                var action_url = $(this).attr("data-action");
                $(location).attr("href",action_url);
            <?php
            }
            ?>
        });
    });
</script>
</body>
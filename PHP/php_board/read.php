<?php
include 'db_conn.php';

$bno = $_GET['idx']; // $bno에 idx값을 받아와 넣음

$sql = mq("select * 
			        from board 
			    where idx='".$bno."'
			   ");
$board = $sql->fetch_array();
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
        .btn container {
            display: flex;
            flex-direction: row-reverse;

        }
    </style>
</head>
<body>
<?php
include 'header.php';
?>
    <div id="container">
        <table class="table">
            <tr hidden>
                <th>idx값</th>
                <td><?=$bno?></td>
            </tr>
            <tr>
                <th style="width: 100px;">작 성 자 :</th>
                <td colspan="2"><?=$board['id']?></td>
            </tr>
            <tr>
                <th>제 목 :</th>
                <td colspan="2"><?=$board['title']?></td>
            </tr>
            <tr>
                <th>내 용</th>
            </tr>
            <tr>
                <td colspan="2"><?=$board['content']?></td>
            </tr>
        </table>
        <div class="btn container" style="text-align: end;" onclick="function()">
            <a href="index.php" class="btn btn-primary">목 록</a>
            <?php
                if ($board['id']==$userid){
            ?>
            <a href="update.php?<?=$board['idx']?>" class="btn btn-primary">수 정</a>
            <a href="delete.php?<?=$board['idx']?>" class="btn btn-primary" id="btnDelete" style="background-color: red; border-color: red;">삭 제</a>
            <?php
                }
            ?>
        </div>
    </div>
</form>
</div>
<script>
</script>
</body>
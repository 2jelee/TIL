<?php
    include 'config.php';
?>
<!DOCTYPE html>
<html>
<head>
    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous">
    </script>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <?php
            include 'logo.php';
        ?>
        <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>

        <nav class="navbar navbar-light bg-light">
            <form class="container-fluid justify-content-start">
                <div>
                    <?php
                        if(!$userid){
                    ?>
                        <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='login.php';">Login</button>&nbsp;
                        <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='join.php';">Join</button>
                    <?php
                        } else{
                            $logged = $username."(".$userid.")";
                    ?>
                    <?php
                        echo ("안녕하세요! {$userid}님");
                    ?>
                        <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='logout.php'">Logout</button>
                    <?php
                        }
                    ?>
                </div>
            </form>
        </nav>
    </div>
</nav>
</body>
</html>
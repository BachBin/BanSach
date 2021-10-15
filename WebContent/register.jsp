<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="css/dkdn.css">
    <title>Đăng ký</title>
</head>

<body>
    <div id="logreg-forms">
        <form action="new-user" class="logreg-forms" method="post">
            <input type="text" name="makhcr" class="form-control" placeholder="Mã khách hàng" required="" autofocus="">
            <input type="password" name="matkhaucr" class="form-control" placeholder="Mật khẩu" required autofocus="">
            <input type="password" name="rematkhaucr" class="form-control" placeholder="Nhập lại mật khẩu" required
                autofocus="">
            <input type="text" name="hotencr" class="form-control" placeholder="Họ và tên" required="" autofocus="">
            <input type="text" name="diachicr" class="form-control" placeholder="Địa chỉ" required="" autofocus="">

            <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Đăng ký</button>
            <a href="home"><i class="fas fa-angle-left"></i> Trở lại</a>
        </form>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous">
    </script>
    <script src="js/dkdn.js"></script>
</body>

</html>
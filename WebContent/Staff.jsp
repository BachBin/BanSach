<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lý Staff</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <style>
        .m-10px {
            margin: 5px;
        }
    </style>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link" href="qlloaisach">Quản Lý Loại Sách</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="qlsach">Quản Lý Sách</a>
    </li>    
    <li class="nav-item">
        <a class="nav-link" href="qlhoadon">Quản Lý Hoá Đơn</a>
    </li>         
</ul>

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center" style="margin-top: 10px">Xin chào ${authadmin.getTendn() }</h2>  
            <br>
            <form action="logoutadmin" method="get" class="text-center">
					<input type="submit" class="btn btn-outline-primary" value="Đăng xuất" class="float-right">
			</form>        
        </div>        
    </div>
</div>
</body>
</html>
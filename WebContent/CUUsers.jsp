<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm/Sửa Tài Khoản</title>
  	<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 
      
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/css/bootstrap4-toggle.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/js/bootstrap4-toggle.min.js"></script>
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
    <c:if test="${sessionScope.authadmin.isIsadmin()=='true' }">
	    <li class="nav-item">
	        <a class="nav-link" href="qltaikhoan">Quản Lý Tài Khoản </a>
	    </li>  
    </c:if>
     
    <li class="nav-item">
        <a class="nav-link" href="logoutadmin">Đăng Xuất </a>
    </li>  
</ul>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center">Thêm/Sửa Tài Khoản</h2>
        </div>
        <jsp:useBean id="user" class="Bo.Loginbo" scope="request"></jsp:useBean>
        <div class="panel-body">
            <form method="post" action="cuusers">                
                <div class="form-group">
                    <label for="name">Tên Đăng Nhập:</label>   
                    <input type="text" name="id" value="${not empty param.id?param.id:''  }" hidden="true">   
                    <c:choose>
                    	<c:when test="${not empty param.id }">
                    		<input disabled required="true" type="text" class="form-control" id="tendn" name="tendn" value="${not empty param.id?param.id:'' }">
                    	</c:when>
                    	<c:otherwise>
                    		<input required="true" type="text" class="form-control" id="tendn" name="tendn" value="${not empty param.id?param.id:'' }">
                    	</c:otherwise>
                    </c:choose>
                </div>
                <div class="form-group">
                    <label for="name">Mật Khẩu:</label>                    
                    <input required="true" type="text" class="form-control" id="matkhau" name="matkhau" value="${not empty param.id?user.getInfor(param.id).getMatkhau():'' }">
                </div>
                <div class="form-group">
                    <label for="name">Quyền:</label>
                    <input id="quyen" name="quyen" type="checkbox" checked data-toggle="toggle" data-on="STAFF" data-off="ADMIN" data-onstyle="success" data-offstyle="danger">
                    <c:choose>
                    	<c:when test="${user.getInfor(param.id).isIsadmin()==true}">
                    		<script type="text/javascript">
                    			$('#quyen').bootstrapToggle('off')
                    		</script>	
                    	</c:when>
                    	<c:otherwise>
                    		<script type="text/javascript">
                    			$('#quyen').bootstrapToggle('on')
                    		</script>		  	
                    	</c:otherwise>
                    </c:choose>                   	
                 </div>
                <div align="center">
                    <button class="btn btn-success">Lưu</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
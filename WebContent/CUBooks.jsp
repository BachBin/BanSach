<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm/Sửa Sách</title>
  	<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>   
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
            <h2 class="text-center">Thêm/Sửa Sách</h2>
        </div>
        <div class="panel-body">
            <form method="post" action="">                
                <div class="form-group">
                    <label for="name">Tên Loại Sách:</label>
                    <input type="text" name="id" value="${not empty param.id?param.id:''  }" hidden="true">
                    <input required="true" type="text" class="form-control" id="name" name="name" value="${not empty param.name?param.name:'' }">
                </div>
                <div class="form-group">
                    <label for="name">Số Lượng:</label>                    
                    <input required="true" type="number" class="form-control" id="sl" name="sl" value="">
                </div>
                <div class="form-group">
                    <label for="name">Giá:</label>                   
                    <input required="true" type="number" class="form-control" id="gia" name="gia" value="">
                </div>
                <div class="form-group">
                    <label for="name">Tác Giả:</label>                    
                    <input required="true" type="text" class="form-control" id="tacgia" name="tacgia" value="">
                </div>
                <div class="form-group">
                    <label for="name">Loại:</label>                    
                    <select class="custom-select">
                    	<option selected>Chọn...</option>
                    	<c:forEach items="" var="">
                    		<option value="0"></option>			
                    	</c:forEach>                    			    		    
                    </select>
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
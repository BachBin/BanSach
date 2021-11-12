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
     
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/momentjs/2.14.1/moment.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
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
        <jsp:useBean id="book" class="Bo.Bookbo" scope="request"></jsp:useBean>
        <div class="panel-body">
            <form method="post" action="addbooks" enctype= "multipart/form-data">            
                <div class="form-group">
                    <label for="name">Tên Loại Sách:</label>
                    <input type="text" name="id" value="${not empty param.id?param.id:''  }" hidden="true">
                    <input required="true" type="text" class="form-control" id="name" name="name" value="${not empty param.id?book.getBookbyMaSach(param.id).getTensach():'' }">
                </div>
                <div class="form-group">
                    <label for="name">Số Lượng:</label>                    
                    <input required="true" type="number" class="form-control" id="sl" name="sl" value="${not empty param.id?book.getBookbyMaSach(param.id).getSoluong():'' }">
                </div>
                <div class="form-group">
                    <label for="name">Giá:</label>                   
                    <input required="true" type="number" class="form-control" id="gia" name="gia" value="${not empty param.id?book.getBookbyMaSach(param.id).getGia():'' }">
                </div>
                <div class="form-group">
                    <label for="name">Tác Giả:</label>                    
                    <input required="true" type="text" class="form-control" id="tacgia" name="tacgia" value="${not empty param.id?book.getBookbyMaSach(param.id).getTacgia():'' }">
                </div>
                <jsp:useBean id="cate" class="Bo.Categorybo" scope="request"></jsp:useBean>
                <div class="form-group">
                    <label for="name">Loại:</label>                    
                    <select class="form-control" id="loai" name ="loai">
                    	<option selected>Chọn...</option>
                    	<c:forEach items="${cate.getloai()}" var="i">
                    		<c:choose>
                    		<c:when test="${i.getMaloai()==book.getBookbyMaSach(param.id).getMaloai()}">
                    			<option selected value="${i.getMaloai() }">${i.getTenloai() }</option>			
                    		</c:when>
                    		<c:otherwise>
                    			<option value="${i.getMaloai() }">${i.getTenloai() }</option>	
                    		</c:otherwise>
                    		</c:choose>
                    	</c:forEach>                    			    		    
                    </select>
                </div>
                <div class="form-group">
                    <label for="name">Số Tập (không có để 0):</label>                    
                    <input required="true" type="text" class="form-control" id="sotap" name="sotap" value="${not empty param.id?book.getBookbyMaSach(param.id).getSotap():'' }">
                </div>
                <div class="form-group">
                  <label for="name">Ngày Nhập: ${not empty param.id?book.getBookbyMaSach(param.id).getNgaynhap():'' }</label>                  
                  <div class='input-group date' id='datetimepicker1'>
                  	 <input type="text" class="form-control" id="ngaynhap" name="ngaynhap" value="${not empty param.id?book.getBookbyMaSach(param.id).getNgaynhap():'' }">
				     <span class="input-group-addon">
                     <span class="glyphicon glyphicon-calendar"></span>
                     </span>
                  </div>
               </div>
                <div class="form-group">
                    <label for="name">Ảnh:</label>   
                    <input type="file" name="imgfile">  
                    <br>
                    <c:if test="${not empty param.id}">
                    	<img style="width: 100px;height: 100px" alt="Ảnh mô tả" src="${not empty param.id?book.getBookbyMaSach(param.id).getAnh():'' }">
                    </c:if>                    
                </div>
                <div align="center">
                    <button class="btn btn-success">Lưu</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
  $(function () {
    $('#datetimepicker1').datetimepicker();
 });
</script>
</body>
</html>
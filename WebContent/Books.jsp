<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lý Sách</title>
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
        <a class="nav-link active" href="qlsach">Quản Lý Sách</a>
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
            <h2 class="text-center" style="margin-top: 10px">Quản Lý Sách</h2> 
            <div class="panel-body">
			    <div class="row d-flex justify-content-between">
			        <div>
			            <a href="CUBooks.jsp">
			                <button class="btn btn-success" style="margin-bottom: 15px;">Thêm Sách</button>
			            </a>
			        </div>
			        <div>
			            <div class="form-inline active-pink-4">
			            	<form action="searchbook" method="get">
			            	<input name="search" class="form-control search form-control-sm mr-3 w-75" type="text" value="${param.search }" placeholder="Tìm kiếm..." aria-label="Search">
			                <i class="fas fa-search" aria-hidden="true"></i>	
			            	</form>			                
			            </div>
			        </div>
			    </div>
			
			    <table class="table table-bordered table-hover">
			        <thead>
			        <tr>
			            <th width="50px">STT</th>
			            <th>Ảnh</th>
			            <th>Tên Sách</th>
			            <th width="50px">Số Lượng</th>
			            <th>Giá</th>
			            <th width="50px">Tác Giả</th>
			            <th>Loại</th>			           
			            <th width="150px">Ngày Nhập</th>			           
			            <th width="50px"></th>
			            <th width="50px"></th>
			        </tr>
			        </thead>
			        <tbody>
			        	<c:set var = "stt"  value = "${1}"/>
			        	<c:forEach items="${dsbook }" var="s">
			        		<tr>
			                    <td>${stt }</td>
			                    <td>
			                    <img alt="Ảnh mô tả" src="${s.getAnh() }" style="width: 100px;height: 100px">
			                    </td>
			                    <td>${s.getTensach() }</td>
			                    <td>${s.getSoluong() }</td> 
			                    <td>			                    
			                    <fmt:formatNumber value="${s.getGia() }" pattern="###,###,###" />			                   	
			                    </td>
			                    <td>${s.getTacgia() }</td>
			                    <jsp:useBean id="cate" class="Bo.Categorybo" scope="request"></jsp:useBean>
			                    <td>${cate.getTenLoai(s.getMaloai()) }</td>
			                    <td>${s.getNgaynhap() }</td>
			                    <td>
			                        <a href="#"><button class="btn btn-warning">Sửa</button></a>
			                    </td>
			                    <td>
			                        <a href="#" onclick="return confirm('Bạn có thực sự muốn xoá?')" class="btn btn-danger">Xoá</a>
			                    </td>                            
			            	</tr> 
			            	<c:set var = "stt"  value = "${stt+1}"/>  
			        	</c:forEach>			                 
			        </tbody>
			    </table>    
			</div>     
		</div>        
    </div>
</div>
</body>
</html>
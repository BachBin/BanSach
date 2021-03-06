<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lý Hoá Đơn</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>   
    <script src="js/tata.js"></script>	
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
        <a class="nav-link active" href="qlhoadon">Quản Lý Hoá Đơn</a>
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
	<c:if test="${not empty sessionScope.alertx }">
		<script type="text/javascript">
			tata.success('Thành công', 'Xoá đơn hàng thành công!');
		</script>
		<c:remove var="alertx" />
	</c:if>
	<c:if test="${not empty sessionScope.errorx }">
		<script type="text/javascript">
			tata.error('Thất bại', 'Xoá đơn hàng thất bại!');
		</script>
		<c:remove var="errorx" />
	</c:if>
	<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center" style="margin-top: 10px">Quản Lý Hoá Đơn</h2>  
            <div class="panel-body">
			    <div class="row d-flex justify-content-end" style="margin-bottom: 10px;">			        
			        <div>
			            <div class="form-inline active-pink-4">
			            	<form action="searchorder" method="get">
			            	<input name="search" class="form-control search form-control-sm mr-3 w-75" type="text" value="${param.search }" placeholder="Tìm kiếm..." aria-label="Search">
			                <i class="fas fa-search" aria-hidden="true"></i>	
			            	</form>			                
			            </div>
			        </div>
			    </div>
			
			    <table class="table table-bordered table-hover">
			        <thead>
			        <tr>
			            <th  style="width:5%">STT</th>
                        <th  style="width:20%">Tổng tiền</th>
                       	<th style="width:20%">Ngày mua</th>
                       	<th style="width:20%">Họ tên</th>
                    	<th style="width:20%">Địa chỉ</th>
                   		<th style="width:15%">SĐT</th>
                    	<th style="width:15%">Trạng thái</th>
                    	<th style="width:5%"></th>
                    	<th style="width:5%"></th>                    	
			        </tr>
			        </thead>
			        <tbody>
			        	<c:set var = "stt"  value = "${1}"/>
			        	<c:forEach items="${dsOrder }" var="ct">
			        		<tr>
			                    <td>${stt }</td>
			                    
			                    <td><fmt:formatNumber value="${ct.getTongTien() }" pattern="###,###,###" /></td>
			                    <td>${ct.getNgayMua() }</td>
			                    <td>${ct.getHoten() }</td>
			                    <td>${ct.getDiachi() }</td>
			                    <td>${ct.getSodt() }</td>
			                    <td>
			                    <c:choose>
			                    	<c:when test="${ct.isDaMua()==true }">
			                    		<i class="fas fa-check-circle" style="color: green"></i>	
			                    	</c:when>
			                    	<c:otherwise>
			                    		<i class="far fa-times-circle" style="color: red"></i>
			                    	</c:otherwise>
			                    </c:choose>			                  
			                    </td>
			                    <td><a href="orderdetail?id=${ct.getMaHoaDon() }" target="_blank"><button class="btn btn-primary">Xem</button></a></td>			                    
			                    <td>
			                        <a href="deleteorder?id=${ct.getMaHoaDon() }" onclick="return confirm('Bạn có thực sự muốn xoá?')" class="btn btn-danger">Xoá</a>
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
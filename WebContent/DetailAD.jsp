<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chi Tiết Hoá Đơn</title>
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
	<c:if test="${not empty sessionScope.alertx }">
		<script type="text/javascript">
			tata.success('Thành công', 'Xoá chi tiết đơn hàng thành công!');
		</script>
		<c:remove var="alertx" />
	</c:if>
	<c:if test="${not empty sessionScope.errorx }">
		<script type="text/javascript">
			tata.error('Thất bại', 'Xoá chi tiết đơn hàng thất bại!');
		</script>
		<c:remove var="errorx" />
	</c:if>
	<c:if test="${not empty sessionScope.alertx1 }">
		<script type="text/javascript">
			tata.success('Thành công', 'Xác nhận chi tiết đơn hàng thành công!');
		</script>
		<c:remove var="alertx1" />
	</c:if>
	<c:if test="${not empty sessionScope.errorx1 }">
		<script type="text/javascript">
			tata.success('Thành công', 'Cập nhật đơn hàng, số lượng trong kho chưa đủ!');
		</script>
		<c:remove var="errorx1" />
	</c:if>
	<c:if test="${not empty sessionScope.errorx2 }">
		<script type="text/javascript">
			tata.error('Thất bại', 'Số lượng trong kho không đủ!');
		</script>
		<c:remove var="errorx2" />
	</c:if>
	
	<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center" style="margin-top: 10px">Chi Tiết Hoá Đơn</h2>  
            <div class="panel-body">
			    <div class="row d-flex justify-content-end" style="margin-bottom: 10px;">			        
			        <div>
			            <div class="form-inline active-pink-4">
			            	<form action="searchcate" method="get">
			            	<input name="search" class="form-control search form-control-sm mr-3 w-75" type="text" value="${param.search }" placeholder="Tìm kiếm..." aria-label="Search">
			                <i class="fas fa-search" aria-hidden="true"></i>	
			            	</form>			                
			            </div>
			        </div>
			    </div>
			
			    <table class="table table-bordered table-hover">
			        <thead>
			        <tr>			            
                        <th width="5%" scope="col">STT</th>
                        <th width="10%" scope="col">Hình ảnh</th>
                        <th width="30%" scope="col">Tên sách</th>
                        <th width="20%" scope="col">Giá</th>
                        <th width="5%" scope="col">SL</th>     
                        <th width="5%" scope="col">Trạng thái</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
			        </tr>
			        </thead>
			        <tbody>
			        	<c:set var = "stt"  value = "${1}"/>
			        	<c:forEach items="${dsOrder }" var="ct">
			        		<tr>
			                    <td>${stt }</td>			                    
			                    <td>
			                    	<img style="width: 70px; height: 70px;" class="img-fluid card-img-top" src="${ct.getAnh() }">
			                    </td>
			                    <td>${ct.getTensach() }</td>
			                    <td><fmt:formatNumber value="${ct.getGia() }" pattern="###,###,###" /></td>
			                    <td>${ct.getSlmua() }</td>
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
			                    <td>
			                    <a href="deletedetail?id=${ct.getMaChiTietHD() }&ido=${param.id}" onclick="return confirm('Bạn có thực sự muốn xoá?')"><button class="btn btn-danger">Xoá</button></a>
			                    </td>	
			                    <td>
			                    <a href="accept?id=${ct.getMaChiTietHD() }&ido=${param.id}"><button class="btn btn-success">Xác nhận</button></a>
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
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lý Loại Sách</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>   
    <link href="css/style.css" rel="stylesheet" type="text/css" />	
	<script src="js/tata.js"></script>	
</head>
<body>
	<c:if test="${not empty sessionScope.alert1 }">
    	<script type="text/javascript">
    		tata.success('Thành công', 'Sửa loại thành công!');
		</script>
		<c:remove var="alert1"/>
    </c:if>	
    <c:if test="${not empty sessionScope.alert2 }">
    	<script type="text/javascript">
    		tata.success('Thành công', 'Thêm loại thành công!');
		</script>
		<c:remove var="alert2"/>
    </c:if>	
	<c:if test="${not empty sessionScope.error }">
    	<script type="text/javascript">
    		tata.error('Thất bại', 'Tên loại đã tồn tại!');
		</script>
		<c:remove var="error"/>
    </c:if>	
    <c:if test="${not empty sessionScope.alertx }">
    	<script type="text/javascript">
    		tata.success('Thành công', 'Xoá loại thành công!');
		</script>
		<c:remove var="alertx"/>
    </c:if>	
    <c:if test="${not empty sessionScope.errorx }">
    	<script type="text/javascript">
    		tata.error('Thất bại', 'Xoá loại thất bại, đã có sách hãy xoá sách trước!');
		</script>
		<c:remove var="errorx"/>
    </c:if>	
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" href="qlloaisach">Quản Lý Loại Sách</a>
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
            <h2 class="text-center" style="margin-top: 10px">Quản Lý Loại Sách</h2>  
            <div class="panel-body">
			    <div class="row d-flex justify-content-between">
			        <div>
			            <a href="CUCategories.jsp">
			                <button class="btn btn-success" style="margin-bottom: 15px;">Thêm Danh Mục</button>
			            </a>
			        </div>
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
			            <th width="50px">STT</th>
			            <th>Tên Loại Sách</th>
			            <th width="50px"></th>
			            <th width="50px"></th>
			        </tr>
			        </thead>
			        <tbody class="categories" id="content">
			        	<c:set var = "stt"  value = "${1}"/>
			        	<c:forEach items="${dscate }" var="ct">
			        		<tr>
			                    <td>${stt }</td>
			                    <td>${ct.getTenloai() }</td>
			                    <td>
			                        <a href="CUCategories.jsp?id=${ct.getMaloai() }&name=${ct.getTenloai()}"><button class="btn btn-warning">Sửa</button></a>
			                    </td>
			                    <td>
			                        <a href="delcategories?id=${ct.getMaloai() }" onclick="return confirm('Bạn có thực sự muốn xoá?')" class="btn btn-danger">Xoá</a>
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
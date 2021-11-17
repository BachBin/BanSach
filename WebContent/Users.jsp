<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Quản Lý Tài Khoản</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script src="js/tata.js"></script>	
</head>
<body>
	<c:if test="${not empty sessionScope.alert1 }">
		<script type="text/javascript">
			tata.success('Thành công', 'Cập nhật tài khoản thành công!');
		</script>
		<c:remove var="alert1" />
	</c:if>
	<c:if test="${not empty sessionScope.alert2 }">
		<script type="text/javascript">
			tata.success('Thành công', 'Tạo tài khoản thành công!');
		</script>
		<c:remove var="alert2" />
	</c:if>
	<c:if test="${not empty sessionScope.error1 }">
		<script type="text/javascript">
			tata.error('Thất bại', 'Cập nhật tài khoản thất bại!');
		</script>
		<c:remove var="error1" />
	</c:if>
	<c:if test="${not empty sessionScope.error2 }">
		<script type="text/javascript">
			tata.error('Thất bại', 'Tạo tài khoản thất bại, tên tài khoản đã tồn tại!');
		</script>
		<c:remove var="error2" />
	</c:if>
	<c:if test="${not empty sessionScope.alertx }">
		<script type="text/javascript">
			tata.success('Thành công', 'Xoá tài khoản thành công!');
		</script>
		<c:remove var="alertx" />
	</c:if>
	<c:if test="${not empty sessionScope.errorx }">
		<script type="text/javascript">
			tata.error('Thất bại', 'Xoá tài khoản thất bại!');
		</script>
		<c:remove var="errorx" />
	</c:if>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="qlloaisach">Quản
				Lý Loại Sách</a></li>
		<li class="nav-item"><a class="nav-link" href="qlsach">Quản
				Lý Sách</a></li>
		<li class="nav-item"><a class="nav-link" href="qlhoadon">Quản
				Lý Hoá Đơn</a></li>
		<c:if test="${sessionScope.authadmin.isIsadmin()=='true' }">
			<li class="nav-item"><a class="nav-link active"
				href="qltaikhoan">Quản Lý Tài Khoản </a></li>
		</c:if>
		<li class="nav-item"><a class="nav-link" href="logoutadmin">Đăng
				Xuất </a></li>
	</ul>
	<div class="row no-gutters">
		<div class="col-6 col-md-3" style="margin-left:30px; margin-right: 60px">
			<h2 class="sub-header">Tài khoản nhân viên</h2>
			<a href="CUUsers.jsp">
			     <button class="btn btn-success" style="margin-bottom: 15px;">Thêm Tài Khoản</button>
			</a>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="col-md-1">#</th>
							<th class="col-md-3">Tên đăng nhập</th>
							<th class="col-md-3">Mật khẩu</th>
							<th class="col-md-1">Quyền</th>
							<th class="col-md-1"></th>
							<th class="col-md-1"></th>
						</tr>
					</thead>
					<tbody>
						<c:set var="stt" value="${1}" />
						<c:forEach items="${ dsnv}" var="nv">
							<tr>
								<td class="col-md-1">${stt }</td>
								<td class="col-md-2">${nv.getTendn() }</td>
								<td class="col-md-2">${nv.getMatkhau() }</td>
								<c:choose>
									<c:when test="${nv.isIsadmin() == true}">
										<td class="col-md-1">ADMIN</td>
									</c:when>
									<c:otherwise>
										<td class="col-md-1">STAFF</td>
									</c:otherwise>
								</c:choose>
								<td class="col-md-1">
									<a href="CUUsers.jsp?id=${nv.getTendn() }"><i class="fas fa-edit"></i></a>
								</td>
								<td class="col-md-1">
									<a href="deleteuser?id=${nv.getTendn() }" onclick="return confirm('Bạn có thực sự muốn xoá?')"><i class="fas fa-trash-alt" style="color: red;"></i></a>
								</td>
							</tr>
							<c:set var="stt" value="${stt+1}" />
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-sm-6 col-md-8">
			<h2 class="sub-header">Tài khoản khách hàng</h2>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="col-md-1">#</th>
							<th class="col-md-2">Họ tên</th>
							<th class="col-md-2">Địa chỉ</th>
							<th class="col-md-2">SĐT</th>
							<th class="col-md-2">Email</th>
							<th class="col-md-2">Tên đăng nhập</th>							
						</tr>
					</thead>
					<tbody>
						<c:set var="stt" value="${1}" />
						<c:forEach items="${ dskh}" var="kh">
							<tr>
								<td class="col-md-1">${stt }</td>
								<td class="col-md-2">${kh.getHoten() }</td>
								<td class="col-md-2">${kh.getDiachi() }</td>
								<td class="col-md-2">${kh.getSdt() }</td>
								<td class="col-md-2">${kh.getEmail() }</td>
								<td class="col-md-2">${kh.getTendn() }</td>								
							</tr>
							<c:set var="stt" value="${stt+1}" />
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
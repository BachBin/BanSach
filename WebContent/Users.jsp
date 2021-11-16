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
</head>
<body>
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
		<div class="col-6 col-md-3" style="margin-left:20px; margin-right: 50px">
			<h2 class="sub-header">Tài khoản nhân viên</h2>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="col-md-1">#</th>
							<th class="col-md-2">Tên đăng nhập</th>
							<th class="col-md-2">Mật khẩu</th>
							<th class="col-md-1">Quyền</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="stt" value="${1}" />
						<c:forEach items="${ dsnv}" var="nv">
							<tr>
								<td class="col-md-1">${stt }</td>
								<td class="col-md-2">${nv.getTendn() }</td>
								<td class="col-md-2">${nv.getMatkhau() }</td>
								<td class="col-md-1">${nv.isIsadmin() }</td>
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
							<th class="col-md-2">Mật khẩu</th>
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
								<td class="col-md-2">${kh.getMatkhau() }</td>
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
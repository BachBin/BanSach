<%@page import="Bean.Login"%>
<%@page import="Bean.Customerbean"%>
<%@page import="Bo.GioHangbo"%>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
	.pass-icon {
		float: right;
		margin-top: -27px;
		margin-right: 10px;
		position: relative;
		z-index: 5;
		font-size: 18px;
		cursor: pointer;
	}
</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Login auth = null;
	if(session.getAttribute("auth")!=null){
		auth = (Login)session.getAttribute("auth");
	}	
%>
<% if(request.getAttribute("alert")!=null){%>
	<script type="text/javascript">
		alert("<%=request.getAttribute("alert ")%>");
	</script>
<%} %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a href="home" class="navbar-brand">Book<b>Name</b></a>
	<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- Collection of nav links, forms, and other content for toggling -->
	<div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
		<div class="navbar-nav">
			<a href="home" class="nav-item nav-link active">Trang chủ</a>
			<%	
					long sizeCart = 0;
					GioHangbo ds =  (GioHangbo)session.getAttribute("order");
					if(ds!=null)
						sizeCart = ds.Size();
			%>
			<%if(auth!=null && auth.isIsadmin()==true) {%>
				<a href="" class="nav-item nav-link">Quản lý sách</a>
				<a href="" class="nav-item nav-link">Quản lý tài khoản</a>
			<%} %>
			<%if(auth==null){%>
				<a href="cart" class="nav-item nav-link">Giỏ hàng <span id="cartMenu"
					class="badge badge-danger"><%= sizeCart%></span></a>		
			<%} else if(auth!=null && auth.isIsadmin()==false){%>
				<a href="cart" class="nav-item nav-link">Giỏ hàng <span id="cartMenu"
					class="badge badge-danger"><%= sizeCart%></span></a>
				<a href="" class="nav-item nav-link">Thanh toán</a>
				<a href="" class="nav-item nav-link">Lịch sử mua hàng</a>
			<%} %>
			
			
			
			
			
		</div>
		<form class="navbar-form form-inline" action="searchenter">
			<div class="input-group search-box">
				<input oninput="searchAjax(this)" type="text" id="search" class="form-control" placeholder="Tìm kiếm..."
					name="search"
					value="<%=(request.getAttribute("search")!=null)?(String)request.getAttribute("search"):""%>">
				<div class="input-group-append">
					<span class="input-group-text">
						<i class="material-icons">&#xE8B6;</i>
					</span>
				</div>
			</div>
		</form>


		<% if(auth == null){ 
				auth = new Login("","",false);
			%>


		<div class="navbar-nav ml-auto formdkdn">
			<div class="nav-item">
				<a href="login" class="nav-link mr-4">Đăng nhập</a>
			</div>

			<div class="nav-item">
				<a href="register" class="btn btn-primary sign-up-btn">Đăng ký</a>
			</div>
		</div>
	</div>
	<%} 
			else{ %>
	<div class="navbar-nav ml-auto action-buttons loginsuccess">
		<div class="nav-item dropdown">
			<a href="#" data-toggle="dropdown" style="width: 100px"
				class="nav-link dropdown-toggle mr-4 btn btn-info btn-lg">
				<i class="fas fa-user"></i>	
				 <%=auth.getTendn() %>
			</a>
			<div class="dropdown-menu action-form">
				<form action="editUser" method="post">
					<p class="hint-text" style="font-size: 18px;">Thông tin tài khoản</p>
					<div class="or-seperator"></div>
					<br>
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control rounded" placeholder="Mã khách hàng"
								required="required" name="makh" value="<%=auth.getTendn()%>">
						</div>
					</div>

					<div class="form-group">
						<input type="password" id="password" class="form-control rounded" placeholder="Mật khẩu"
							required="required" name="matkhau" value="<%=auth.getMatkhau()%>">
						<span id="toggle" class="fa fa-fw fa-eye pass-icon"></span>
					</div>					
					
					<input type="submit" class="btn btn-primary btn-block" value="Cập nhật thông tin">
				</form>
				<br>
				<form action="log-out" method="get">
					<input type="submit" class="btn btn-outline-primary" value="Đăng xuất" class="float-right">
				</form>
			</div>

		</div>
	</div>
	<%} %>
</nav>

<script type="text/javascript">
	function searchAjax(par) {
		var search = par.value;
		$.ajax({
			url: "/BanSach/search",
			type: "get",
			data: {
				search: search
			},
			success: function (data) {
				var row = document.getElementById("content");
				row.innerHTML = data;
			},
			error: function (xhr) {
				location.reload();
			}
		});
	}
	$(document).ready(function () {

		$("#toggle").click(function () {

			if ($("#password").attr("type") == "password") {
				//Change type attribute
				$("#password").attr("type", "text");
			} else {
				//Change type attribute
				$("#password").attr("type", "password");
			}
		});

	});
</script>
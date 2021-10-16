<%@page import="Bean.Customerbean"%>
<%@page import="Bo.GioHangbo"%>
	
    
	
    
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Varela+Round">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Customerbean auth = null;
	if(session.getAttribute("auth")!=null){
		auth = (Customerbean)session.getAttribute("auth");
	}	
%>
<% if(request.getAttribute("alert")!=null){%>
	<script type="text/javascript">
		alert("<%=request.getAttribute("alert")%>");
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
				<a href="cart" class="nav-item nav-link">Giỏ hàng <span id="cartMenu" class="badge badge-danger"><%= sizeCart%></span></a>	
				<% if(auth!=null) {	%>
					<a href="" class="nav-item nav-link">Thanh toán</a>
					<a href="" class="nav-item nav-link">Lịch sử mua hàng</a>
				<%} %>			
			</div>
			<form class="navbar-form form-inline">
				<div class="input-group search-box">								
					<input type="text" id="search" class="form-control" placeholder="Tìm kiếm..." name="txttk" value="">
					<div class="input-group-append">
						<span class="input-group-text">
							<i class="material-icons">&#xE8B6;</i>
						</span>
					</div>
				</div>
			</form>		
			
			
			<% if(auth == null){ 
				auth = new Customerbean(-1,"","","","","","");
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
							<% String[] tem = auth.getHoten().split("\\s+");%>
							<%= tem[tem.length-1]%>
						</a>
						<div class="dropdown-menu action-form">
							<form action="editUser" method="post">
								<p class="hint-text" style="font-size: 18px;">Thông tin tài khoản</p>
								<div class="or-seperator"></div>
								<br>
								<div class="form-group">
									<div class="input-group">
										<input type="text" class="form-control rounded" placeholder="Mã khách hàng" required="required" name="makh" value="<%=auth.getTendn()%>">
									</div>									
								</div>

							<div class="form-group">								
								<div class="input-group">
									<input type="password" class="form-control rounded" placeholder="Mật khẩu" required="required" name="matkhau" value="<%=auth.getMatkhau()%>">
								</div>
							</div>
							<div class="form-group">
									<input type="text" class="form-control" placeholder="Họ và tên"
										required="required" name="hoten" value="<%=auth.getHoten()%>">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Địa chỉ"
										required="required" name="diachi" value="<%=auth.getDiachi()%>">
								</div>	
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Số điện thoại"
										required="required" name="sdt" value="<%=auth.getSdt()%>">
								</div>	
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Email"
										required="required" name="email" value="<%=auth.getEmail()%>">
								</div>						
								<input type="submit" class="btn btn-primary btn-block" value="Cập nhật thông tin">
							</form>
							<br>
							<form action="log-out" method="get" >							
								<input type="submit" class="btn btn-outline-primary" value="Đăng xuất" class="float-right">
							</form>
						</div>
						
					</div>	
				</div>
			<%} %>	    
	        
	</nav>
	
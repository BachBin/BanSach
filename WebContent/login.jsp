<%@page import="Bean.Login"%>
<%@page import="Bean.Customerbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
		integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<link rel="stylesheet" href="css/dkdn.css">
	<title>Đăng nhập</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<style type="text/css">
		.pass-icon {
			float: right;
			margin-top: -29px;
			margin-right: 10px;
			position: relative;
			z-index: 5;
			font-size: 18px;
			cursor: pointer;
		}
	</style>
</head>

<body>
	<%
		String tk = "";
		String mk = "";
		Login user = (Login) session.getAttribute("auth");
		if(user!=null){
			tk = user.getTendn();
			mk = user.getMatkhau();
		}
		if(request.getAttribute("tknew")!=null && request.getAttribute("mknew")!=null) {
			tk = (String)request.getAttribute("tknew");
			mk = (String)request.getAttribute("mknew");
		}			
	%>
	<div id="logreg-forms">
		<%if(request.getAttribute("mess")!=null) {%>
		<div class="alert alert-danger text-justify text-center" role="alert">
			<%=(String)request.getAttribute("mess") %>
		</div>
		<%} %>
		<form class="form-signin" method="post" action="checklogin">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> ĐĂNG NHẬP</h1>
			<div class="social-login">
				<a class="btn"
					href="https://www.facebook.com/v2.12/dialog/oauth?client_id=1292739434493098&redirect_uri=https://localhost:8443/BookName/login-facebook">
					<button class="btn facebook-btn social-btn" type="button"><span><i class="fab fa-facebook-f"></i>
							Đăng nhập với Facebook</span> </button>
				</a>
				<a class="btn">
					<button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i>
							Đăng nhập với Google+</span> </button>
				</a>
			</div>
			<p style="text-align:center"> HOẶC </p>
			<input type="text" name="username" class="form-control" placeholder="Tên tài khoản" required="" autofocus=""
				value="<%=(request.getAttribute("tk")!=null)?(String)request.getAttribute("tk"):tk%>">
			<div class="form-group">
				<input type="password" id="password" name="password" class="form-control" placeholder="Mật khẩu"
					required="" value="<%=mk%>">
				<span id="toggle" class="fa fa-fw fa-eye pass-icon"></span>
			</div>
			<button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Đăng
				nhập</button>
			<a href="#" id="forgot_pswd">Quên mật khẩu?</a>
			<hr>
			<!-- <p>Don't have an account!</p>  -->
			<a href="register" style="color: white;" class="btn btn-primary "><i class="fas fa-user-plus"></i> Đăng
				ký tài khoản</a>

		</form>

		<form action="/reset/password/" class="form-reset">
			<input type="text" id="resetid" class="form-control" placeholder="Mã khách hàng" required="" autofocus="">
			<button class="btn btn-primary btn-block" type="submit">Quên mật khẩu?</button>
			<a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Trở lại</a>
		</form>
	</div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous">
	</script>
	<script src="js/dkdn.js"></script>
	<script type="text/javascript">
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
</body>

</html>

<%@page import="Bean.Customerbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="css/dkdn.css">
    <title>Đăng nhập</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<%
		String tk = "";
		String mk = "";
		Customerbean user = (Customerbean) session.getAttribute("auth");
		if(user!=null){
			tk = user.getTendn();
			mk = user.getMatkhau();
		}
	%>
    <div id="logreg-forms">
    	<%if(request.getAttribute("error")!=null) {%>
    		<div class="alert alert-danger text-justify text-center" role="alert">
			  	<%=(String)request.getAttribute("error") %>
			</div>
    	<%} %>
        <form class="form-signin" method="post" action="user-login">
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Đăng nhập</h1>
            <div class="social-login">
	            <a class="btn" href="https://www.facebook.com/v2.12/dialog/oauth?client_id=1292739434493098&redirect_uri=https://localhost:8443/BookName/login-facebook">
	            	<button class="btn facebook-btn social-btn" type="button"><span><i class="fab fa-facebook-f"></i> Đăng nhập với Facebook</span> </button>
	            </a>
	            <a class="btn">
	            	<button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i> Đăng nhập với Google+</span> </button>
	            </a>            	
            </div>
            <p style="text-align:center"> HOẶC  </p>
            <input type="text" name="makh" class="form-control" placeholder="Tên tài khoản" required="" autofocus="" value="<%=tk%>">
            <input type="password" name="matkhau" class="form-control" placeholder="Mật khẩu" required="" value="<%=mk%>">
            
            <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Đăng nhập</button>
            <a href="#" id="forgot_pswd">Quên mật khẩu?</a>
            <hr>
            <!-- <p>Don't have an account!</p>  -->
            <a href="register.jsp" style="color: white;" class="btn btn-primary "><i class="fas fa-user-plus"></i> Đăng ký tài khoản</a>
            
            </form>
			
            <form action="/reset/password/" class="form-reset">
                <input type="text" id="resetid" class="form-control" placeholder="Mã khách hàng" required="" autofocus="">
                <button class="btn btn-primary btn-block" type="submit">Quên mật khẩu?</button>
                <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Trở lại</a>
            </form>             
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="js/dkdn.js"></script>
</body>
</html>
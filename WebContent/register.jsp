<%@page import="Bean.GioHangbean"%>
<%@page import="Dao.Bookdao"%>
<%@page import="Bean.Customerbean"%>
<%@page import="Bean.Categorybean"%>
<%@page import="Bean.Bookbean"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="org.apache.tomcat.util.buf.UEncoder.SafeCharsSet"%>
<%@page import="org.apache.tomcat.util.buf.UEncoder.SafeCharsSet"%>
<%@page import="Bo.Customerbo"%>
<%@page import="Bo.Categorybo"%>
<%@page import="Bo.Bookbo"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>Đăng ký</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">		
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
		integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<link rel="stylesheet" href="css/dkdn.css">	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="css/dkdn.css">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="css/style.css" rel="stylesheet" type="text/css" />	
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
	
	String hoten= (request.getAttribute("hoten")!=null)?(String)request.getAttribute("hoten"):"";
	String diachi= (request.getAttribute("diachi")!=null)?(String)request.getAttribute("diachi"):"";
	String sdt= (request.getAttribute("sdt")!=null)?(String)request.getAttribute("sdt"):"";
	String email= (request.getAttribute("email")!=null)?(String)request.getAttribute("email"):"";
    String tk = (request.getAttribute("tknew")!=null)?(String)request.getAttribute("tknew"):"";
    String mk = (request.getAttribute("mknew")!=null)?(String)request.getAttribute("mknew"):"";
    String remk = (request.getAttribute("remk")!=null)?(String)request.getAttribute("remk"):"";
    
    Customerbean user = (Customerbean) session.getAttribute("auth");
    if(user!=null){
        tk = user.getTendn();
        mk = user.getMatkhau();
    }   
    ArrayList<Categorybean> dscate = (ArrayList<Categorybean>)request.getAttribute("dscate");
	Bookbean booknew = (Bookbean)request.getAttribute("booknew");
	%>	
	
	<jsp:include page="includes/Menu.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-dark text-white text-uppercase"><i class="fa fa-list"></i> Loại sách
					</div>
					<ul class="list-group category_block">
						<%for(Categorybean loai: dscate){ %>
						<li id="tag<%=loai.getMaloai() %>" class="list-group-item text-white">
							<a href="loadcategories?maloai=<%=loai.getMaloai()%>"><%=loai.getTenloai()%></a>
						</li>
						<%} %>
					</ul>
				</div>
				<div class="card bg-light mb-3">
					<div class="card-header bg-dark text-white text-uppercase">Sách mới cập nhật</div>
					<div class="card-body">
						<img class="img-fluid card-img-top" src="<%=booknew.getAnh()%>">
						<h3>
							<a href="detail?bookid='<%=booknew.getMasach() %>'" class="card-title"><%=booknew.getTensach()%></a>
						</h3>
						<p class="card-text"><i class="fas fa-at"></i> Tác giả: <%=booknew.getTacgia() %></p>
						<p class="bloc_left_price">
							<%=NumberFormat.getNumberInstance(Locale.US).format(booknew.getGia())%> VNĐ</p>
						<div class="col">
							<a href="javascript:return false;" onclick="addAjax(<%=booknew.getMasach()%>)"
								class="btn btn-success btn-block"><i class="fas fa-cart-plus"></i> Thêm giỏ</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<div id="logreg-forms">
                    <%if(request.getAttribute("mess")!=null) {%>
                    <div class="alert alert-danger text-justify text-center" role="alert">
                        <%=(String)request.getAttribute("mess") %>
                    </div>
                    <%} %>
                    <form action="create" class="logreg-forms" method="post">
                        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> ĐĂNG KÝ</h1>              
                        <input type="text" name="hoten" class="form-control" placeholder="Họ và tên" required="" autofocus=""
                            value="<%=hoten%>">
                        <input type="text" name="diachi" class="form-control" placeholder="Địa chỉ" required="" autofocus=""
                            value="<%=diachi%>">   
                        <input type="number" name="sdt" class="form-control" placeholder="Số điện thoại" required="" autofocus=""
                            value="<%=sdt%>">  
                       	<input type="email" name="email" class="form-control" placeholder="Email" autofocus=""
                            value="<%=email%>">         
                        <input type="text" name="tendncr" class="form-control" placeholder="Tên đăng nhập" required="" autofocus=""
                            value="<%=tk%>">
                        <input type="password" name="matkhaucr" class="form-control" placeholder="Mật khẩu" required autofocus=""
                            value="<%=mk%>">
                        <input type="password" name="rematkhaucr" class="form-control" placeholder="Nhập lại mật khẩu" required
                            autofocus="" value="<%=remk%>">
            
            
                        <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Đăng ký</button>
                        <a href="home"><i class="fas fa-angle-left"></i> Trở lại</a>
                    </form>
                </div>		
			</div>
		</div>
	</div>
	<div id="backtop">
		<i class="fas fa-chevron-up"></i>
	</div>
	<script type="text/javascript">
		$(document).ready(function () {
			$(window).scroll(function () {
				if ($(this).scrollTop()) {
					$('#backtop').fadeIn();
				} else {
					$('#backtop').fadeOut();
				}
			});
			$('#backtop').click(function () {
				$('html, body').animate({
					scrollTop: 0
				}, 500);
			});
		});
	</script>    
	<jsp:include page="includes/Footer.jsp"></jsp:include>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous">
	</script>
	<script src="js/dkdn.js"></script>
	<script src="js/tata.js"></script>
	<script type="text/javascript">
		function addAjax(masach) {
			$.ajax({
				url: "/BanSach/addAjax",
				type: "get",
				data: {
					masach: masach
				},
				success: function (data) {
					var sizecart = document.getElementById("cartMenu");
					sizecart.innerHTML = data;					
					tata.success('Thành công', 'Đã thêm sách vào giỏ!');
				},
				error: function (xhr) {
					location.reload();
				}
			});
		}	
		
	</script>	
</body>

</html>
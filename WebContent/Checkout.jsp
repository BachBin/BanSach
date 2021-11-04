<%@page import="Bo.GioHangbo"%>
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
	<title>Thanh toán</title>
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
</head>

<body>

	<% 					
   	String tk ="";
	String mk ="";
	
    Customerbean user = (Customerbean) session.getAttribute("auth");
	String hoten= (user.getHoten()!=null)?user.getHoten():"";
	String diachi= (user.getDiachi()!=null)?user.getDiachi():"";
	String sdt= (user.getSdt()!=null)?user.getSdt():"";
	String email= (user.getEmail()!=null)?user.getEmail():"";
   
    
    if(user!=null){
        tk = user.getTendn();
        mk = user.getMatkhau();
    }
    if(request.getAttribute("tknew")!=null && request.getAttribute("mknew")!=null) {
        tk = (String)request.getAttribute("tknew");
        mk = (String)request.getAttribute("mknew");
    }	
    Customerbean auth = null;
	if(session.getAttribute("auth")!=null){
		auth = (Customerbean)session.getAttribute("auth");
	}
    ArrayList<Categorybean> dscate = (ArrayList<Categorybean>)request.getAttribute("dscate");
	Bookbean booknew = (Bookbean)request.getAttribute("booknew");
	GioHangbo order = (GioHangbo)session.getAttribute("order");		
	//SHĐ
	long shd = 0;
	if(order!=null){
		shd = order.Size();
	}		
	//Tổng tiền
	long tong = 0;
	if(order!=null)
		tong = order.Tongtien();
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
                    <form action="xacnhandon" class="logreg-forms" method="post">
                        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Thông tin đặt hàng</h1>              
                        <input type="text" name="hoten" class="form-control" placeholder="Họ và tên" required="" autofocus=""
                            value="<%=hoten%>">
                        <input type="text" name="diachi" class="form-control" placeholder="Địa chỉ" required="" autofocus=""
                            value="<%=diachi%>">   
                        <input type="number" name="sdt" class="form-control" placeholder="Số điện thoại" required="" autofocus=""
                            value="<%=sdt%>">  
                       	<input type="email" name="email" class="form-control" placeholder="Email" autofocus=""
                            value="<%=email%>">                           
                       
			            <button type="submit" class="btn btn-primary form-control" >Xác nhận đơn hàng</button>		               
                    </form>
                </div>	
                <h3>Tổng tiền: <%= NumberFormat.getNumberInstance(Locale.US).format(tong) %> VNĐ</h3>                
                <table id="shoppingCart" class="table table-condensed table-responsive">
					<thead>
						<tr>
							<th style="width:60%">Tên sách</th>
							<th style="width:10%">Giá</th>
							<th style="width:25%">Số lượng</th>							
						</tr>
					</thead>
					<tbody>
						<%
	                	if(order!=null) { 
	                		for(GioHangbean i: order.ds){
	               		%>
						<tr id="row<%=i.getMasach()%>">
							<td data-th="Product">
								<div class="row">
									<div class="col-md-3 text-left">
										<img src="<%=i.getAnh() %>" alt=""
											class="img-fluid d-none d-md-block rounded mb-2 shadow ">
									</div>
									<div class="col-md-9 text-left mt-sm-2">
										<h4 style="font-weight: 10px"><%=i.getTensach() %></h4>
										<p class="font-weight-light">Tác giả: <%=i.getTacgia() %></p>
									</div>
								</div>
							</td>
							<td data-th="Price"><%= NumberFormat.getNumberInstance(Locale.US).format(i.getGia())%></td>
							<td>
								<div class="form-group d-flex justify-content-between">									
									<input style="min-width: 100px;" type="number" name="quantity" class="form-control"
										id="txt<%=i.getMasach() %>"  readonly value="<%= i.getSlmua()%>">									
								</div>
							</td>							
						</tr>
						<%} %>
						<%} %>
					</tbody>
				</table>	
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
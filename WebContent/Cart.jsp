<%@page import="Bean.Login"%>
<%@page import="Bo.Loginbo"%>
<%@page import="Bo.GioHangbo"%>
<%@page import="Bean.Customerbean"%>
<%@page import="Bean.GioHangbean"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Giỏ hàng</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https:////maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"
		id="bootstrap-css">
	<script src="https:////maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https:////cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
		integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Varela+Round">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
		integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />	

	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/giohang.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<%	
		
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
	<% 
			Login auth = null;
			if(session.getAttribute("auth")!=null){
				auth = (Login)session.getAttribute("auth");
			}			
	%>
	<jsp:include page="includes/Menu.jsp" />
	<section class="pt-5 pb-5">
		<div class="container">
			<div style="margin-top: 10px">
				<h2 class="display-5 mb-2 text-center">GIỎ HÀNG</h2>
				<p class="mb-5 text-center">
					<i class="text-info font-weight-bold" id="sohd"><%=shd %></i> sách trong giỏ hàng</p>
			</div>

			<div class="container my-3">
				<div class="d-flex py-3">
					<h3 id="sumTien">Tổng tiền: <%=NumberFormat.getNumberInstance(Locale.US).format(tong) %> VNĐ</h3>
					<a class="mx-3 btn btn-primary" href="thanhtoan">Thanh toán</a>
				</div>
				<table id="shoppingCart" class="table table-condensed table-responsive">
					<thead>
						<tr>
							<th style="width:60%">Tên sách</th>
							<th style="width:10%">Giá</th>
							<th style="width:25%">Số lượng</th>
							<th style="width:5%"></th>
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
									<a onclick="incdecAjax('<%=i.getMasach() %>','inc')" class="btn btn-sm btn-incre"
										href="javascript:return false;"><i class="fas fa-plus-square"></i></a>
									<input style="min-width: 100px;" type="number" name="quantity" class="form-control"
										id="txt<%=i.getMasach() %>"  readonly value="<%= i.getSlmua()%>">
									<a onclick="incdecAjax('<%=i.getMasach() %>','dec')" class="btn btn-sm btn-decre"
										href="javascript:return false;"><i class="fas fa-minus-square"></i></a>
								</div>
							</td>
							<td class="actions" data-th="">
								<div class="text-right">
									<a href="javascript:return false;" onclick="delRow(<%=i.getMasach() %>)"
										class="btn btn-white border-secondary bg-white btn-md mb-2">
										<i class="fas fa-trash"></i>
									</a>
								</div>
							</td>
						</tr>
						<%} %>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<jsp:include page="includes/Footer.jsp"></jsp:include>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		function deleteRow(rowid) {
			var row = document.getElementById(rowid);
			var table = row.parentNode;
			while (table && table.tagName != 'TABLE')
				table = table.parentNode;
			if (!table)
				return;
			table.deleteRow(row.rowIndex);
		}

		function incdecAjax(id, action) {
			$.ajax({
				url: "/BanSach/incdec",
				type: "get",
				data: {
					id: id,
					action: action
				},
				success: function (data) {
					if(data[1]==0) {
						window.location="home";
					}
					if (data[0] != "del") {
						document.getElementById("sumTien").innerHTML = "Tổng tiền: " + data[0] + " VNĐ";
						document.getElementById("cartMenu").innerHTML = data[1];
						document.getElementById("txt" + id).value = data[2];
					} else {
						deleteRow("row" + id);
						document.getElementById("sumTien").innerHTML = "Tổng tiền: " + data[1] + " VNĐ";
						document.getElementById("cartMenu").innerHTML = data[2];
						document.getElementById("sohd").innerHTML = data[2];
					}
				},
				error: function (xhr) {
					location.reload();
				}
			});
		}

		function delRow(row) {

			$.ajax({
				url: "/BanSach/delcart",
				type: "get",
				data: {
					id: row
				},
				success: function (data) {
					if(data[1]==0) {
						window.location="home";
					}
					deleteRow("row" + row);
					document.getElementById("sumTien").innerHTML = "Tổng tiền: " + data[0] + " VNĐ";
					document.getElementById("cartMenu").innerHTML = data[1];
					document.getElementById("sohd").innerHTML = data[1];

				},
				error: function (xhr) {
					location.reload();
				}
			});
		}
	</script>
</body>

</html>
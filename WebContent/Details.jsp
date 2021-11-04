<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Bean.Bookbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>Thông tin sản phẩm</title>
	<meta charset="utf-8">
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
	<link href="css/detail.css" rel="stylesheet" type="text/css" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />

	<link href="css/alert.css" rel="stylesheet" type="text/css" />
	<script src="js/alert.js"></script>
</head>

<body>
	<%
	     ArrayList<Bookbean> dsbook = (ArrayList<Bookbean>)request.getAttribute("dsbook");
			
			if(request.getAttribute("dsbooktk")!=null) 
				dsbook = (ArrayList<Bookbean>)request.getAttribute("dsbooktk");
			
			String tk = request.getParameter("makh");
			String mk = request.getParameter("matkhau");			
			if(tk==null) tk = "";
			if(mk==null) mk = "";
			Bookbean book = null;
			if(request.getAttribute("book")!=null){
				book = (Bookbean)request.getAttribute("book");
			}
			
	%>
	
	<jsp:include page="includes/Menu.jsp" />
	<div class="container">
		<div class="row">
			<jsp:include page="includes/Left.jsp" />
			<div class="col-sm-9">
				<div class="wrapper">
					<div class="product-img col-sm-6">
						<img src="<%=book.getAnh() %>" height="420" width="300">
					</div>
					<div class="product-info col-sm-6"">
						<div class=" product-text">
						<h1><%= book.getTensach()%></h1>
						<h2>Tác giả: <%=book.getTacgia() %></h2>
						<h5>Số tập: <%=book.getSotap() %></h5>
						<h5>Số lượng còn: <%=book.getSoluong() %></h5>
					</div>
					<div class="product-price-btn">
						<p><span class="detail">GIÁ:</span>
							<%=NumberFormat.getNumberInstance(Locale.US).format(book.getGia())%> VNĐ</p> <br><br>
						<input class="form-control rounded quantity" type="number" value="1" min="1" name="quantity"
							id="quantity"> <br>
						<a href="javascript:return false;" onclick="addAjax('<%=book.getMasach() %>')"
							class="btn btn-success btn-block"><i class="fas fa-cart-plus"></i> Thêm vào giỏ</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js/tata.js"></script>
<script type="text/javascript">
	function addAjax(masach) {
		var quantity = document.getElementById('quantity').value;
		$.ajax({
			url: "/BanSach/addAjax",
			type: "get",
			data: {
				masach: masach,
				quantity: quantity
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

</html>
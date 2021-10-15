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
	<meta charset="ISO-8859-1">
	<title>BookShop</title>
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

	<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<%
	      //Lay ve all sach, cac thong tin client
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
						
			
			
			ArrayList<Bookbean> dsbook = (ArrayList<Bookbean>)request.getAttribute("dsbook");
			ArrayList<Categorybean> dscate = (ArrayList<Categorybean>)request.getAttribute("dscate");
			Bookbean booknew = (Bookbean)request.getAttribute("booknew");

			
			String tk = request.getParameter("makh");
			String mk = request.getParameter("matkhau");			
			if(tk==null) tk = "";
			if(mk==null) mk = "";
			
			
		%>

	<jsp:include page="includes/Menu.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Loại sách
					</div>
					<ul class="list-group category_block">
						<%for(Categorybean loai: dscate){ %>
						<li class="list-group-item text-white"><a
								href="index.jsp?ml=<%=loai.getMaloai()%>"><%=loai.getTenloai()%></a></li>
						<%} %>
					</ul>
				</div>
				<div class="card bg-light mb-3">
					<div class="card-header bg-dark text-white text-uppercase">Sách mới cập nhật</div>
					<div class="card-body">
						<img class="img-fluid card-img-top" src="<%=booknew.getAnh()%>">
						<h3>
							<a href="#" class="card-title"><%=booknew.getTensach()%></a>
						</h3>
						<p class="card-text"><i class="fas fa-at"></i> Tác giả: <%=booknew.getTacgia() %></p>
						<p class="bloc_left_price">
							<%=NumberFormat.getNumberInstance(Locale.US).format(booknew.getGia())%> VNĐ</p>
						<div class="col">
							<a href="javascript:return false;" onclick="addAjax(<%=booknew.getMasach()%>)"
								class="btn btn-success btn-block closeLink">Thêm giỏ</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="row">
					<%for(Bookbean s: dsbook){ %>
					<div class="col-12 col-md-6 col-lg-4">
						<div class="card">
							<img class="card-img-top" style="height: 200px" src="<%=s.getAnh()%>" alt="Chưa có ảnh">
							<div class="card-body">
								<h4 class="card-title show_txt">
									<a href="#" title="View Product"><%=s.getTensach()%></a>
								</h4>
								<p class="card-text show_txt"><i class="fas fa-at"></i> Tác giả: <%=s.getTacgia() %></p>
								<div class="row">
									<div class="col" style="cursor: default;">
										<p disabled class="btn btn-outline-secondary btn-block"
											style="cursor: default;">Số lượng: <%=s.getSoluong()%></p>
									</div>
									<div class="col">
										<p disabled class="btn btn-outline-dark btn-block" style="cursor: default;">
											<%=NumberFormat.getNumberInstance(Locale.US).format(s.getGia())%> VNĐ</p>
									</div>
									<div class="col">
										<a href="javascript:return false;" onclick="addAjax(<%=s.getMasach() %>)"
											class="btn btn-success btn-block">Thêm giỏ</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<%} %>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="includes/Footer.jsp"></jsp:include>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		$('.closeLink').click(function (e) {
			e.preventDefault();
		});

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
				},
				error: function (xhr) {
					location.reload();
				}
			});
		}
	</script>
</body>

</html>
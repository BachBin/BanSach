<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Bean.Bookbean"%>
<%@page import="Bean.Categorybean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	ArrayList<Categorybean> dscate = (ArrayList<Categorybean>)request.getAttribute("dscate");
	Bookbean booknew = (Bookbean)request.getAttribute("booknew");
%>
<style type="text/css">
	a:hover {
		text-decoration: none;
	}

	.list-group-item a {
		display: flex;
		align-items: center;
		justify-content: center;
		height: 100%;
		width: 100%;
	}

	.category_block li a.active {
		color: white;
	}
</style>
<div class="col-sm-3">
	<div class="card bg-light mb-3">
		<div class="card-header bg-dark text-white text-uppercase"><i class="fa fa-list"></i> Loại sách
		</div>
		<ul class="list-group category_block">
			<%for(Categorybean loai: dscate){ %>
			<li id="tag<%=loai.getMaloai() %>" class="list-group-item text-white">
				<a onclick="loadByCate('<%=loai.getMaloai() %>')"
					href="javascript:return false;"><%=loai.getTenloai()%></a>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function removeActive() {
		var list = document.querySelectorAll(".active")
		for (var i = 0; i < list.length; i++) {
			list[i].classList.remove('active');
		}
	}

	function loadByCate(maloai) {
		removeActive();
		$.ajax({
			url: "/BanSach/categories",
			type: "get",
			data: {
				maloai: maloai
			},
			success: function (data) {
				var kich = document.getElementById("tag" + maloai);
				kich.classList.add("active");
				var row = document.getElementById("content");
				row.innerHTML = data;
			},
			error: function (xhr) {
				location.reload();
			}
		});
	}
</script>
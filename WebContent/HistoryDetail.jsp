<%@page import="Bean.SubOrder"%>
<%@page import="Bean.Order"%>
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
    <title>Chi tiết đơn hàng</title>
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
	<script src="js/tata.js"></script>	

</head>

<body>

    <%
    	ArrayList<GioHangbean> orders = (ArrayList<GioHangbean>)request.getAttribute("dsOrder");
        //SHĐ
        long shd = (orders!=null)?orders.size():0;
        	
        //Tổng tiền
        long tong = 0;
        if(orders!=null) {
        	for(GioHangbean i: orders){
        		tong += i.getGia() * i.getSlmua();
        	}
        }            
        
        ArrayList<Categorybean> dscate = (ArrayList<Categorybean>)request.getAttribute("dscate");
        Bookbean booknew = (Bookbean)request.getAttribute("booknew");
        Customerbean auth = null;
			if(session.getAttribute("auth")!=null){
				auth = (Customerbean)session.getAttribute("auth");
			}	
	%>
    <jsp:include page="includes/Menu.jsp" />

    <div class="container">
        <div class="row">
            <!--Categories-->
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
                            <a href="detail?bookid='<%=booknew.getMasach() %>'"
                                class="card-title"><%=booknew.getTensach()%></a>
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
            <!--Categories-->
            <div class="col-sm-9">
                <div id="content" class="row">
                    <section class="pt-5 pb-5">
                        <div class="container">
                            <div style="margin-top: 10px">
                                <h2 class="display-5 mb-2 text-center">CHI TIẾT ĐƠN HÀNG</h2>
                                <p class="mb-5 text-center">
                                    <i class="text-info font-weight-bold" id="sohd"><%=shd %></i> sản phẩm
                                </p>
                            </div>
							<div class="d-flex py-3">
                                    <h3 id="sumTien">Tổng tiền:
                                        <%=NumberFormat.getNumberInstance(Locale.US).format(tong) %> VNĐ
                                    </h3>                                    
                            </div>
                            <div>                                
                                <table class="table table-condensed table-responsive">
                                    <thead>
                                        <tr>
                                            <th width="5%" scope="col">STT</th>
                                            <th width="30%" scope="col">Hình ảnh</th>
                                            <th width="30%" scope="col">Tên sách</th>
                                            <th width="20%" scope="col">Giá</th>
                                            <th width="10%" scope="col">SL</th>                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%                                        
                                    if(orders!=null) {
                                    	int stt = 1;
                                        for(GioHangbean i: orders){
                               %>		
                                        <tr>                                       
                                        	<td scope="row">   
                                                 <%=stt %>                                        
                                            </td>
                                            
                                            <td>   
                                                 <img class="img-fluid card-img-top" src="<%=i.getAnh()%>">                                    
                                            </td>
                                            <td>
                                                <%= i.getTensach()%>
                                            </td>                                                                                       
                                            <td>
                                                <%=NumberFormat.getNumberInstance(Locale.US).format(i.getGia())%>
                                            </td>
                                            <td>
                                                <%= i.getSlmua()%>
                                            </td>                                            
                                       </tr>                                      
                                        <%stt++;} %>
                                        <%} %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </div>   	
    <div id="backtop">
        <i class="fas fa-chevron-up"></i>
    </div>   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
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
    <jsp:include page="includes/Footer.jsp"></jsp:include>   	
</body>

</html>
<%@page import="Bean.GioHangbean"%>
<%@page import="Dao.Bookdao"%>
<%@page import="Bean.Customerbean"%>
<%@page import="Bean.Categorybean"%>
<%@page import="Bean.Bookbean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.tomcat.util.buf.UEncoder.SafeCharsSet"%>
<%@page import="org.apache.tomcat.util.buf.UEncoder.SafeCharsSet"%>
<%@page import="Bo.Customerbo"%>
<%@page import="Bo.Categorybo"%>
<%@page import="Bo.Bookbo"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
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

	<link rel="stylesheet" href="css/swiper-bundle.min.css">
	<script src="js/swiper-bundle.min.js"></script>
	<link href="css/style.css" rel="stylesheet" type="text/css" />	
	<script src="js/tata.js"></script>	
</head>

<body>
	<c:if test = "${not empty dsbooktk}">
		<c:set var="dsbook" value="${dsbooktk}" scope="request"/>		
    </c:if>
    
    <c:if test="${not empty sessionScope.successod }">
    	<script type="text/javascript">
			tata.success('Th??nh c??ng', '?????t h??ng th??nh c??ng, ch??ng t??i s??? li??n l???c s???m!');
		</script>
		<c:remove var="successod"/>
    </c:if>    
	
	<c:if test="${not empty sessionScope.alert }">
    	<script type="text/javascript">
			tata.success('Th??nh c??ng', "C???p nh???t t??i kho???n th??nh c??ng!");
		</script>
		<c:remove var="alert"/>
    </c:if>     
	
	<jsp:include page="includes/Menu.jsp" />

	<div class="container">
		<div class="row">
			<jsp:include page="includes/Left.jsp" />
			<div class="col-sm-9">
				<div class="swiper-container mySwiper">
                    <div class="swiper-wrapper">
                        <img src="image_sach/ancient-place.jpg" class="about__img swiper-slide slide-about" style="height: 200px; width: 100%;">
                        <img src="image_sach/kayaks.jpg" class="about__img swiper-slide slide-about" style="height: 200px;">
                        <img src="image_sach/mountain-view.jpg" class="about__img swiper-slide slide-about" style="height: 200px;">
                    	<img src="image_sach/riverside-city.jpg" class="about__img swiper-slide slide-about" style="height: 200px;">                    
                    </div>                                      
                </div>
				<div id="content" class="row">
					<c:forEach items="${dsbook }" var="s">
						<div class="col-12 col-md-6 col-lg-4">
						<div class="card">
						<a href='detail?bookid=${s.getMasach() }'	title="View Product">
							<img class="card-img-top" style="height: 200px" src="${s.getAnh() }" alt="Ch??a c?? ???nh">
							<div class="card-body">
								<h4 class="card-title show_txt">
									${s.getTensach() }
								</h4>
								<p class="card-text show_txt"><i class="fas fa-at"></i> T??c gi???: ${s.getTacgia() }</p>
								<div class="row">
									<div class="col" style="cursor: default;">
										<p disabled class="btn btn-outline-secondary btn-block"
											style="cursor: default;">S??? l?????ng: ${s.getSoluong() }</p>
									</div>
									<div class="col">
										<p disabled class="btn btn-outline-dark btn-block" style="cursor: default;">
											<fmt:formatNumber value="${s.getGia() }" pattern="###,###,###" /> VN??</p>
									</div>
									<div class="col">
										<a href="javascript:return false;" onclick="addAjax('${s.getMasach()}')"
											class="btn btn-success btn-block"><i class="fas fa-cart-plus"></i> Th??m
											gi???</a>
									</div>
								</div>
							</div>
							</a>
						</div>
					</div>	
					</c:forEach>					
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
					tata.success('Th??nh c??ng', '???? th??m s??ch v??o gi???!');
				},
				error: function (xhr) {
					location.reload();
				}
			});
		}	
		var swiper = new Swiper(".mySwiper", {
		    spaceBetween: 30,
		    centeredSlides: true,
		    autoplay: {
		      delay: 1000,
		      disableOnInteraction: false,
		    },        
		  });
		
	</script>
</body>

</html>
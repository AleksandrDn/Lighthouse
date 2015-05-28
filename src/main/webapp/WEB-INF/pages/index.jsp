<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>

	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>LightHOUSE | Главная</title>
	<meta name="description" content="Lighthouse"/>
	<meta name="keywords" content="sanatorium" />
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: Facebook Open Graph -->
	<meta property="og:title" content=""/>
	<meta property="og:description" content=""/>
	<meta property="og:type" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:image" content=""/>
	<!-- end: Facebook Open Graph -->

    <!-- start: CSS -->
    <link href="/css/bootstrap.css" rel="stylesheet"/>
    <link href="/css/bootstrap-responsive.css" rel="stylesheet"/>
	<link href="/css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Droid+Sans:400,700">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Droid+Serif">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Boogaloo">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Economica:700,400italic">
	<link href='http://fonts.googleapis.com/css?family=Patua+One' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Noto+Sans:400italic&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
	
	<link href='http://fonts.googleapis.com/css?family=Chewy' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=PT+Sans+Caption' rel='stylesheet' type='text/css'>
	<!-- end: CSS -->

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body>
	
	<!--start: Header -->
	<header>
		
		<!--start: Container -->
		<div class="container">
			
			<!--start: Row -->
			<div class="row">
					
				<!--start: Logo -->
				<div class="logo span3">
						
					<a class="brand" href="#"><img src="img/logo.png" alt="Logo"></a>
						
				</div>
				<!--end: Logo -->
					
				<!--start: Navigation -->
				<div class="span9">

					<div class="navbar navbar-inverse">
						<div class="navbar-inner">
							<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</a>
							<div class="nav-collapse collapse">
								<ul class="nav">
									<li class="active"><a href="/">Главная</a></li>
									<li><a href="/news">Новости</a></li>
									<li><a href="#">О нас</a></li>
									<li><a href="#">Контакты</a></li>
									<li class="dropdown">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown">Больше... <b class="caret"></b></a>
										<ul class="dropdown-menu">
											<li><a href="/pricing">Цены</a></li>
											<li><a href="#">Лечение</a></li>
											<li><a href="/booking">Бронирование</a></li>
											<li><a href="/reviews">Отзывы</a></li>
											<li><a href="#">Галерея</a></li>
											<li><a href="#">Наш персонал</a></li>
										</ul>
									</li>
									<li>${loginSelector}</li><!--<a href="/login">Войти</a>-->

								</ul>
							</div>
						</div>
					</div>

				</div>
				<!--end: Navigation -->
					
			</div>
			<!--end: Row -->
			
		</div>
		<!--end: Container-->			
			
	</header>
	<!--end: Header-->
	
	<!-- start: Slider -->
	<div class="slider-wrapper">

		<div id="da-slider" class="da-slider">
			<div class="da-slide">
				<h2>Вас приветствует</h2>
				<p>Санаторно-рекреационное учреждение дарит здоровье и полноценный отдых клиентам с 1990 года.</p>
				<a href="#" class="da-link" style="font-family: 'Patua One', cursive;">Читать</a>
				<div class="da-img"><img src="img/parallax-slider/lighth_logo.png" alt="image01" /></div>
			</div>
			<div class="da-slide">
				<h2>Наш коллектив</h2>
				<p>Наши профессионалы знают свое дело и готовы помочь Вам.</p>
				<a href="#" class="da-link" style="font-family: 'Patua One', cursive;">Читать</a>
				<div class="da-img"><img src="img/parallax-slider/staff.png" alt="image02" /></div>
			</div>
			<div class="da-slide">
				<h2>Уютные номера</h2>
				<p>Номера европейского уровня позволяют чувствовать высокий комфорт во время Вашего отдыха.</p>
				<a href="#" class="da-link" style="font-family: 'Patua One', cursive;">Читать</a>
				<div class="da-img"><img src="img/parallax-slider/keys.png" alt="image03" /></div>
			</div>
			<div class="da-slide">
				<h2>Высокий сервис</h2>
				<p>Сервис принесет вам ощущения, которые больше чем просто комфорт.</p>
				<a href="#" class="da-link" style="font-family: 'Patua One', cursive;">Читать</a>
				<div class="da-img"><img src="img/parallax-slider/service.png" alt="image04" /></div>
			</div>
			<nav class="da-arrows">
				<span class="da-arrows-prev"></span>
				<span class="da-arrows-next"></span>
			</nav>
		</div>

	</div>
	<!-- end: Slider -->
			
	<!--start: Wrapper-->
	<div id="wrapper">
				
		<!--start: Container -->
    	<div class="container">
	
      		<!-- start: Hero Unit - Main hero unit for a primary marketing message or call to action -->
			<div class="hero-unit">
				<p style="font-family: 'Noto Sans', sans-serif;">
					Санаторий "Lighthouse" расположен в лесопарке Одесской области, на берегу Черного моря, в долине Национального природного парка.
				</p>
				<p><a class="btn btn-success btn-large" style="font-family: 'Noto Sans', sans-serif;">Читать больше &raquo;</a></p>
			</div>
			<!-- end: Hero Unit -->

			<hr>
		
			<!-- start Clients List -->	
			<div class="clients-carousel">

				<ul class="slides clients">
					<li><img src="img/logos/1.jpg" alt=""/></li>
					<li><img src="img/logos/2.jpg" alt=""/></li>
					<li><img src="img/logos/3.jpg" alt=""/></li>
					<li><img src="img/logos/4.jpg" alt=""/></li>
					<li><img src="img/logos/5.jpg" alt=""/></li>
					<li><img src="img/logos/6.jpg" alt=""/></li>
					<li><img src="img/logos/7.jpg" alt=""/></li>
					<li><img src="img/logos/8.jpg" alt=""/></li>
					<li><img src="img/logos/9.jpg" alt=""/></li>
					<li><img src="img/logos/10.jpg" alt=""/></li>
				</ul>
		
			</div>
			<!-- end Clients List -->
		
			<hr>
			
			<!-- start: Row -->
			<div class="row">

				<!-- start: Icon Boxes -->
				<div class="icons-box-vert-container">

					<!-- start: Icon Box Start -->
					<div class="span6">
						<div class="icons-box-vert">
							<i class="ico-ok ico-color circle-color big"></i>
							<div class="icons-box-vert-info">
								<h3>Вас приветствует</h3>
								<p style="font-size:9pt">Санаторно-рекреационное учреждение дарит здоровье и полноценный отдых клиентам с 1990 года.</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<!-- end: Icon Box-->

					<!-- start: Icon Box Start -->
					<div class="span6">
						<div class="icons-box-vert">
							<i class="ico-cup  ico-white circle-color-full big-color"></i>
							<div class="icons-box-vert-info">
								<h3>Наш коллектив</h3>
								<p>Наши профессионалы знают свое дело и готовы помочь Вам.</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<!-- end: Icon Box -->

					<!-- start: Icon Box Start -->
					<div class="span6">
						<div class="icons-box-vert">
							<i class="ico-ipad ico-color circle-color big"></i>
							<div class="icons-box-vert-info">
								<h3>Уютные номера</h3>
								<p>Номера европейского уровня позволяют чувствовать высокий комфорт во время Вашего отдыха.</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<!-- end: Icon Box -->

					<!-- start: Icon Box Start -->
					<div class="span6">
						<div class="icons-box-vert">
							<i class="ico-thumbs-up  ico-white circle-color-full big-color"></i>
							<div class="icons-box-vert-info">
								<h3>Высокий сервис</h3>
								<p>Сервис принесет вам ощущения, которые больше чем просто комфорт.</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<!-- end: Icon Box -->

				</div>
				<!-- end: Icon Boxes -->
				<div class="clear"></div>
			</div>
			<!-- end: Row -->
			
			<hr>
			
		</div>
		<!--end: Container-->
	
	</div>
	<!-- end: Wrapper  -->			

    <!-- start: Footer Menu -->
	<div id="footer-menu" class="hidden-tablet hidden-phone">

		<!-- start: Container -->
		<div class="container">
			
			<!-- start: Row -->
			<div class="row">

				<!-- start: Footer Menu Logo -->
				<div class="span2">
					<div id="footer-menu-logo">
						<a href="#"><img src="img/logo-footer-menu.png" alt="logo" /></a>
					</div>
				</div>
				<!-- end: Footer Menu Logo -->

				<!-- start: Footer Menu Links-->
				<div class="span9">

					<div id="footer-menu-links">

						<ul id="footer-nav">

							<li><a href="/" style="font-family: 'Open Sans', sans-serif;">главная</a></li>

							<li><a href="/news" style="font-family: 'Open Sans', sans-serif;">новости</a></li>

							<li><a href="#" style="font-family: 'Open Sans', sans-serif;">про нас</a></li>

							<li><a href="#" style="font-family: 'Open Sans', sans-serif;">контакты</a></li>

							<li><a href="#" style="font-family: 'Open Sans', sans-serif;">лечение</a></li>

							<li><a href="#" style="font-family: 'Open Sans', sans-serif;">цены</a></li>

							<li><a href="#" style="font-family: 'Open Sans', sans-serif;">бронирование</a></li>

							<li><a href="/reviews" style="font-family: 'Open Sans', sans-serif;">отзывы</a></li>

							<li><a href="#" style="font-family: 'Open Sans', sans-serif;">галерея</a></li>

						</ul>

					</div>

				</div>
				<!-- end: Footer Menu Links-->

				<!-- start: Footer Menu Back To Top -->
				<div class="span1">
						
					<div id="footer-menu-back-to-top">
						<a href="#"></a>
					</div>
				
				</div>
				<!-- end: Footer Menu Back To Top -->
			
			</div>
			<!-- end: Row -->
			
		</div>
		<!-- end: Container  -->	

	</div>	
	<!-- end: Footer Menu -->

	<!-- start: Footer -->
	<div id="footer">

		<!-- start: Container -->
		<div class="container">

			<!-- start: Row -->
			<div class="row">

				<!-- start: About -->
				<div class="span3">

					<h3>Про нас</h3>
					<p style="font-family: 'Open Sans', sans-serif;">
						Санаторий "Lighthouse" расположен в лесопарке Одесской области, на берегу Черного моря, в долине Национального природного парка. Наш санаторий гармонично объединяет в себе лечебно-диагностический центр с лучшими врачами страны, комфортабельные спальные корпуса, современную столовую с большим разнообразием блюд.
					</p>

				</div>
				<!-- end: About -->

				<!-- start: Photo Stream -->
				<div class="span3">

					<h3>Мы здесь</h3>
					<div id="small-map-container"><a href="contact.html"></a></div>
					<iframe id="small-map" width="210" height="210" frameborder="0" scrolling="yes" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2251.0528362057225!2d30.295126000000014!3d45.93182500000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zNDXCsDU1JzU0LjYiTiAzMMKwMTcnNDIuNSJF!5e1!3m2!1sru!2sua!4v1429471948226"></iframe>

				</div>
				<!-- end: Photo Stream -->

				<div class="span6">

					<!-- start: Follow Us -->
					<h3>Следите за нами</h3>
					<ul class="social-grid">
						<li>
							<div class="social-item">
								<div class="social-info-wrap">
									<div class="social-info">
										<div class="social-info-front social-twitter">
											<a href="http://twitter.com"></a>
										</div>
										<div class="social-info-back social-twitter-hover">
											<a href="http://twitter.com"></a>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="social-item">
								<div class="social-info-wrap">
									<div class="social-info">
										<div class="social-info-front social-facebook">
											<a href="http://facebook.com"></a>
										</div>
										<div class="social-info-back social-facebook-hover">
											<a href="http://facebook.com"></a>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="social-item">
								<div class="social-info-wrap">
									<div class="social-info">
										<div class="social-info-front social-dribbble">
											<a href="http://dribbble.com"></a>
										</div>
										<div class="social-info-back social-dribbble-hover">
											<a href="http://dribbble.com"></a>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="social-item">
								<div class="social-info-wrap">
									<div class="social-info">
										<div class="social-info-front social-flickr">
											<a href="http://flickr.com"></a>
										</div>
										<div class="social-info-back social-flickr-hover">
											<a href="http://flickr.com"></a>
										</div>
									</div>
								</div>
							</div>
						</li>
					</ul>
					<!-- end: Follow Us -->

					<!-- start: Newsletter -->
					<form id="newsletter">
						<h3>Сообщение</h3>
						<p style="font-family: 'Open Sans', sans-serif;">Оставьте адрес Вашего почтового ящика. Мы с вами свяжемся.</p>
						<label for="newsletter_input">@:</label>
						<input type="text" id="newsletter_input"/>
						<input type="submit" id="newsletter_submit" value="отправить">
					</form>
					<!-- end: Newsletter -->

				</div>

			</div>
			<!-- end: Row -->

		</div>
		<!-- end: Container  -->

	</div>
	<!-- end: Footer -->

	<!-- start: Copyright -->
	<div id="copyright">

		<!-- start: Container -->
		<div class="container">

			<p>
				&copy; 2015, ДИИТ, КИТ. designed in Dp
			</p>

		</div>
		<!-- end: Container  -->

	</div>
	<!-- end: Copyright -->

<!-- start: Java Script -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/js/jquery-1.8.2.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/js/flexslider.js"></script>
<script src="/js/carousel.js"></script>
<script src="/js/jquery.cslider.js"></script>
<script src="/js/slider.js"></script>
<script defer="defer" src="/js/custom.js"></script>
<!-- end: Java Script -->

</body>
</html>
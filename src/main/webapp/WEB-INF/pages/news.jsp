<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>

	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>LightHOUSE | Новости</title>
	<meta name="description" content="GotYa Free Bootstrap Theme"/>
	<meta name="keywords" content="Template, Theme, web, html5, css3, Bootstrap" />
	<meta name="author" content="Łukasz Holeczek from creativeLabs"/>
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
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link href="css/custom-styles.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Noto+Sans:400italic&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Droid+Sans:400,700">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Droid+Serif">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Boogaloo">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Economica:700,400italic">
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
		<!-- start: Page Title -->
	<div id="page-title">

		<div id="page-title-inner">

			<!-- start: Container -->
			<div class="container">

				<span class="glyphicon glyphicon-search" aria-hidden="true"></span><h2>Новости</h2>

			</div>
			<!-- end: Container  -->

		</div>	

	</div>
	<!-- end: Page Title -->
	<div id="wrapper">

		<!-- start:Container -->
		<div class="container" id="news_placeholder">

		</div>
		<img class="preload-anim" src="/img/loading_animation.gif">
		<div class="row" style="text-align: center">
			<a class="btn btn-success btn-large" id="getMoreNews">Далее »</a>
		</div>
	</div>


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

				<h3>Twitter</h3>
				<a class="twitter-timeline" href="https://twitter.com/svarnik_a" data-widget-id="598411585963610112">Tweets by @svarnik_a</a>
				<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>

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
<script src="js/jquery-1.8.2.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/flexslider.js"></script>
<script src="js/carousel.js"></script>
<script src="js/jquery.cslider.js"></script>
<script src="js/slider.js"></script>
<script src="js/news_loader.js"></script>
<script def src="js/custom.js"></script>
<!-- end: Java Script -->

</body>
</html>
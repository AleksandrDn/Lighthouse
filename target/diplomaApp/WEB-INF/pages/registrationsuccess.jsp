<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>LightHOUSE | Успешная регистрация</title>
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
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Droid+Sans:400,700">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Droid+Serif">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Boogaloo">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Economica:700,400italic">
    <link href='http://fonts.googleapis.com/css?family=Patua+One' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Noto+Sans:400italic&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
    <link href="http://fonts.googleapis.com/css?family=Chewy" rel="stylesheet" type="text/css">
    <!-- end: CSS -->

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script language='JavaScript'>
        var time = 15; //How long (in seconds) to countdown
        var page = "/login"; //The page to redirect to
        function countDown(){
            time--;
            gett("timecontainer").innerHTML = time;
            if(time == 0){
                window.location = page;
            }
        }
        function gett(id){
            if(document.getElementById) return document.getElementById(id);
            if(document.all) return document.all.id;
            if(document.layers) return document.layers.id;
            if(window.opera) return window.opera.id;
        }
        function init(){
            if(gett('timecontainer')){
                setInterval(countDown, 1000);
                gett("timecontainer").innerHTML = time;
            }
            else{
                setTimeout(init, 50);
            }
        }
        document.onload = init();
    </SCRIPT>
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

                <a class="brand" href="#"><img src="img/logo.png"></a>

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
                                <li><a href="/">Главная</a></li>
                                <li><a href="/news">Новости</a></li>
                                <li><a href="#">О нас</a></li>
                                <li><a href="#">Контакты</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Больше... <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Цены</a></li>
                                        <li><a href="#">Лечение</a></li>
                                        <li><a href="/booking">Бронирование</a></li>
                                        <li><a href="/reviews">Отзывы</a></li>
                                        <li><a href="#">Галерея</a></li>
                                        <li><a href="#">Наш персонал</a></li>
                                    </ul>
                                </li>
                                <li class="active"><a href="/login">Войти</a></li>

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

            <h2  style=" font-family: 'Chewy', cursive !important;font-weight: normal !important;font-size: 24px;">
                <img src="/img/glyphicons/glyphicons-387-log-in.png"/> Регистрация прошла успешно
            </h2>

        </div>
        <!-- end: Container  -->

    </div>

</div>
<!-- end: Page Title -->
<h2 style="text-align:center">Добро пожаловать, ${registration.firstName}</h2>
<h3 style="text-align:center">Вы будете перенаправлены на страницу входа через <span id='timecontainer'></span> секунд.</h3>
<br><h4 style="text-align:center"><a href="/login">Перейти сейчас!</a></h4>


</body>
</html>

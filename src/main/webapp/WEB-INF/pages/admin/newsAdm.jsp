<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Новости</title>
  <!-- Bootstrap Styles-->
  <link href="/dashboard/css/bootstrap.css" rel="stylesheet" />
  <!-- FontAwesome Styles-->
  <link href="/dashboard/css/font-awesome.css" rel="stylesheet" />
  <!-- Morris Chart Styles-->

  <!-- Custom Styles-->
  <link href="/dashboard/css/custom-styles.css" rel="stylesheet" />
  <!-- Google Fonts-->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
  <!-- TABLE STYLES-->
  <link href="/dashboard/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>

<body>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<div id="wrapper">
  <nav class="navbar navbar-default top-navbar" role="navigation">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">Lighthouse</a>
    </div>

    <ul class="nav navbar-top-links navbar-right">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
          <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-messages">
          <li>
            <a href="#">
              <div>
                <strong>John Doe</strong>
                                    <span class="pull-right text-muted">
                                        <em>Today</em>
                                    </span>
              </div>
              <div>Lorem Ipsum has been the industry's standard dummy text ever since the 1500s...</div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="#">
              <div>
                <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
              </div>
              <div>Lorem Ipsum has been the industry's standard dummy text ever since an kwilnw...</div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="#">
              <div>
                <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
              </div>
              <div>Lorem Ipsum has been the industry's standard dummy text ever since the...</div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a class="text-center" href="#">
              <strong>Read All Messages</strong>
              <i class="fa fa-angle-right"></i>
            </a>
          </li>
        </ul>
        <!-- /.dropdown-messages -->
      </li>
      <!-- /.dropdown -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
          <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-tasks">
          <li>
            <a href="#">
              <div>
                <p>
                  <strong>Отдыхающих</strong>
                  <span class="pull-right text-muted">${campers}% Отдыхает</span>
                </p>
                <div class="progress progress-striped active">
                  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${campers}" aria-valuemin="0" aria-valuemax="100" style="width: ${campers}%">
                    <span class="sr-only"></span>
                  </div>
                </div>
              </div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="#">
              <div>
                <p>
                  <strong>Номеров</strong>
                  <span class="pull-right text-muted">${rooms}% Заполнено</span>
                </p>
                <div class="progress progress-striped active">
                  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${rooms}" aria-valuemin="0" aria-valuemax="100" style="width: ${rooms}%">
                    <span class="sr-only"></span>
                  </div>
                </div>
              </div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="#">
              <div>
                <p>
                  <strong>Занятость персонала</strong>
                  <span class="pull-right text-muted">${employees}% Занято</span>
                </p>
                <div class="progress progress-striped active">
                  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${employees}" aria-valuemin="0" aria-valuemax="100" style="width: ${employees}%">
                    <span class="sr-only"></span>
                  </div>
                </div>
              </div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a class="text-center" href="/admin/indexAdm">
              <strong>Смотреть статистику</strong>
              <i class="fa fa-angle-right"></i>
            </a>
          </li>
        </ul>
        <!-- /.dropdown-tasks -->
      </li>
      <!-- /.dropdown -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
          <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-alerts">
          <li>
            <a href="#">
              <div>
                <i class="fa fa-comment fa-fw"></i> New Comment
                <span class="pull-right text-muted small">4 min</span>
              </div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="#">
              <div>
                <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                <span class="pull-right text-muted small">12 min</span>
              </div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="#">
              <div>
                <i class="fa fa-envelope fa-fw"></i> Message Sent
                <span class="pull-right text-muted small">4 min</span>
              </div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="#">
              <div>
                <i class="fa fa-tasks fa-fw"></i> New Task
                <span class="pull-right text-muted small">4 min</span>
              </div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="#">
              <div>
                <i class="fa fa-upload fa-fw"></i> Server Rebooted
                <span class="pull-right text-muted small">4 min</span>
              </div>
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a class="text-center" href="#">
              <strong>See All Alerts</strong>
              <i class="fa fa-angle-right"></i>
            </a>
          </li>
        </ul>
        <!-- /.dropdown-alerts -->
      </li>
      <!-- /.dropdown -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
          <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
          <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
          </li>
          <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
          </li>
          <li class="divider"></li>
          <li><a href="${logoutUrl}"><i class="fa fa-sign-out fa-fw"></i> Выйти</a>
          </li>
        </ul>
        <!-- /.dropdown-user -->
      </li>
      <!-- /.dropdown -->
    </ul>
  </nav>
  <!--/. NAV TOP  -->
  <nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
      <ul class="nav" id="main-menu">

        <li>
          <a href="/admin/indexAdm"><i class="fa fa-dashboard"></i> Статистика</a>
        </li>
        <li>
          <a class="active-menu" href="/admin/newsAdm"><i class="fa fa-desktop"></i> Новости</a>
        </li>
        <li>
          <a href="/admin/clientAdm"><i class="fa fa-users"></i> Клиенты</a>
        </li>
        <li>
          <a href="/admin/phonesAdm"><i class="fa fa-phone"></i> Телефоны</a>
        </li>
        <li>
          <a href="/admin/reviewsAdm"><i class="fa fa-thumbs-o-up"></i> Отзывы</a>
        </li>
      </ul>

    </div>

  </nav>
  <!-- /. NAV SIDE  -->
  <div id="page-wrapper">
    <div id="page-inner">


      <div class="row">
        <div class="col-md-12">
          <h1 class="page-header">
            Новости <small>Управление новостями</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="/">Главная страница</a></li>
            <li><a href="/news">Новости</a></li>
            <li class="active">Управление</li>
          </ol>
        </div>
      </div>


      <!-- /. ROW  -->
      <div class="panel panel-default">
        <div class="panel-heading">
          Добавить
        </div>
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-6">
              <form role="form" action="/admin/newsAdm" method="post" encType="multipart/form-data">
                <div class="form-group">
                  <label>Заголовок новости</label>
                  <input name="title" class="form-control" placeholder="Введите заголовок">
                </div>
                <div class="form-group">
                  <label>Прикрепить фото</label>
                  <input type="file" name="file">
                  <p class="help-block">Размер фото не больше 10 Мб</p>
                </div>
                <div class="form-group">
                  <label>Текст</label>
                  <textarea class="form-control" rows="10" name="content"></textarea>
                </div>
                <button type="submit" class="btn btn-default">Опубликовать</button>
                <button type="reset" class="btn btn-default">Очистить</button>
                <div class="form-group">
                  <label>${isSuccessful}</label>
                </div>
              </form>
            </div>
            <!-- /.col-lg-6 (nested) -->
          </div>
          <!-- /.row (nested) -->
        </div>
      </div>
        <!-- /.panel-body -->
        <div class="panel panel-default">
          <div class="panel-heading">
            Новости
          </div>
          <div class="panel-body">
            <div class="table-responsive">
              <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                <tr>
                  <th>Заголовок</th>
                  <th>Короткий текст</th>
                  <th>Удалить</th>
                </tr>
                </thead>
                <tbody id="all_news_placeholder">

                </tbody>
              </table>
            </div>

          </div>
        </div>
        <!--End Advanced Tables -->
        <!-- /. ROW  -->
      <!-- /. ROW  -->


    </div>
    <!-- /. PAGE INNER  -->
  </div>
  <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="/dashboard/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="/dashboard/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="/dashboard/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="/dashboard/js/dataTables/jquery.dataTables.js"></script>
<script src="/dashboard/js/dataTables/dataTables.bootstrap.js"></script>
<script src="/dashboard/js/dataTables/news_loader.js"></script>
<script>
  $(document).ready(function () {
    getPage();
    //$('#dataTables-example').dataTable();
  });
</script>
<!-- Custom Js -->
<script src="/dashboard/js/custom-scripts.js"></script>

</body>

</html>

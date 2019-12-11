<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-10-11
  Time: 오전 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><tiles:getAsString name="title" /></title>

    <link rel="stylesheet" href="/resources/css/assets/bootstrap/css/bootstrap.min.css">
    <%--    <link rel="stylesheet" href="/resources/css/assets/fonts/font-awesome.min.css">--%>
    <link rel="stylesheet" href="/resources/css/assets/css/Corporate-Footer-Clean.css">
    <%--    <link rel="stylesheet" href="/resources/css/assets/assets/css/styles.css">--%>
    <style type="text/css">
        .navbar.navbar-dark.navbar-expand-md.bg-dark {
            background-color: #000!important;
            opacity: 0.8;
        }

        .navbar-dark .navbar-nav .nav-link .apple.logo {
            color: #fff;
            font-size: 13px;
        }

        .navbar-dark .navbar-nav .nav-link .apple-logo {
            color: #fff;
            font-size: 21px;
            line-height: 0;
        }

        .amazingpeople {
        }

        .amazing {
            padding-top: 100px;
            text-align: center;
            padding-bottom: 100px;
        }

        .amazing h2 {
            font-size: 27px;
            font-weight: 400;
        }

        .amazing h1 {
            font-size: 56px;
            font-weight: bold;
        }

        .product .links {
            font-size: 21px;
            margin-bottom: 80px;
        }

        .product .links .learn-more {
        }

        .amazing .links {
            font-size: 21px;
            margin-bottom: 80px;
        }

        .amazing .links .learn-more {
            margin-right: 20px;
        }

        .amazing.mainpage {
            background-color: #f9f9f9;
        }

        .amazing .airpot {
            background-color: #121217;
        }

        .amazing.dark {
            background-color: #121217;
            color: #fff;
        }

        .amazing.dark {
            background-color: #121217;
            color: #fff;
        }

        .amazing.icon {
            background-color: #242424;
            color: #fff;
        }

    </style>


    <script src="/resources/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>


</head>


<%--<link href="<c:url value='/css/layout/layout.css' />" rel="stylesheet"></link>--%>


<header id="header">
    <tiles:insertAttribute name="header" />
</header>

<%--<section id="sidemenu">--%>
<%--    <tiles:insertAttribute name="menu" />--%>
<%--</section>--%>

<section id="siteContent">
    <tiles:insertAttribute name="body" />
</section>


<!-- Metis Menu Plugin JavaScript -->
<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<%--<script src="/resources/vendor/raphael/raphael.min.js"></script>--%>
<script src="/resources/raphael.js"></script>
<%--<script src="/resources/morris.min.js"></script>--%>


<!-- Custom Theme JavaScript -->
<%--<script src="/resources/js/sb/sb-admin-2.js"></script>--%>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

</body>
</html>

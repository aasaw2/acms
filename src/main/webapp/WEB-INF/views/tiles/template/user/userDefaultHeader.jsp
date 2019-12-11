<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-10-10
  Time: 오후 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<tiles:importAttribute name="header"/>
<head>
    <link rel="stylesheet" href="/resources/css/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/resources/css/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/assets/css/Corporate-Footer-Clean.css">
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

    </style>
</head>
    <nav class="navbar navbar-dark navbar-expand-md bg-dark">
    <div class="container"><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav flex-grow-1 justify-content-between">
                <li class="nav-item" role="presentation"><a class="nav-link active" href="#"><i class="fa fa-adn apple-logo"></i></a></li>
                <c:forEach var="hd" items="${sessionScope.header}" varStatus="status">
                    <li class="nav-item" role="presentation"><a class="nav-link text-white" href="/user/board/${hd.id}">${hd.name}</a></li>
                </c:forEach>
                <li class="nav-item" role="presentation"><a class="nav-link text-white" href="#"><i class="fa fa-search border-white"></i></a></li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-white d-lg-flex align-items-lg-center" data-toggle="dropdown" aria-expanded="false" href="#" style="margin: 4px;"><i class="fa fa-gear"></i></a>
                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="#"><i class="fa fa-search"></i>&nbsp;내 정보 보기</a><a class="dropdown-item" role="presentation" href="#"><i class="fa fa-wrench"></i>&nbsp;관리자 메뉴</a><a class="dropdown-item" role="presentation"
                                                                                                                                                                                                                                                                   href="/Login"><i class="fa fa-sign-out"></i>&nbsp;로그인</a></div>
                </li>
            </ul>
        </div>
    </div>
</nav>

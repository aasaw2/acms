<!DOCTYPE html>
<html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Untitled</title>
<%--    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">--%>
<%--    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">--%>
<%--    <link rel="stylesheet" href="assets/css/Lista-Productos-Canito.css">--%>
<%--    <link rel="stylesheet" href="assets/css/styles.css">--%>
    <script src="/resources/jquery-3.3.1.min.js"></script>

</head>

<body class="flex-grow-1">
<div>
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
                        <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="#"><i class="fa fa-search"></i>&nbsp;내 정보 보기</a><a class="dropdown-item" role="presentation" href="#"><i class="fa fa-wrench"></i>&nbsp;관리자 메뉴</a><a class="dropdown-item" role="presentation" href="#"><i class="fa fa-sign-out"></i>&nbsp;로그인</a></div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="wrapper">
        <div class="row">
            <div class="col-md-4">
                <h2 style="width: 343px;">${board.name}</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">

                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>게시글</th>
                        <th>작성자</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="result" items="${resultList.content}" varStatus="status">
                        <tr id="update_${result.id}" idx="${result.id}">
                            <td>
                                    ${resultList.totalElements - (resultList.size * resultList.number ) - status.index }
                            </td>
                            <td><c:out value="${result.name}"/></td>
                            <td><c:out value="${result.writer.accountName}"/></td>

                                <%--                                    <td><input type="button" class="set_btn" c:out id="set_${result.id}"--%>
                                <%--                                               value="편집"/></td>--%>
                        </tr>
                    </c:forEach>

                    <c:if test="${resultList.totalElements == 0}">
                        <tr>
                            <td colspan="5">등록된 데이터가 없습니다.</td>
                        </tr>
                    </c:if>

                    </tbody>
                </table>
                <div class="fixed-table-pagination C " style="display: block;">
                    <ul class="pagination">
                        <c:if test="${!resultList.first}">
                            <li class="page-first">
                                <a href="?page=${resultList.number-1}">&larr;</a>
                            </li>
                        </c:if>
                        <c:forEach begin="1" end="${resultList.totalPages}" var="i">
                            <c:choose>
                                <c:when test="${resultList.number eq i-1}">
                                    <li class="page-number active"><a href="#">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-number"><a href="?page=${i-1}">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <c:if test="${!resultList.last}">
                            <li class="page-last">
                                <a href="?page=${resultList .number+1}">&rarr;</a>
                            </li>
                        </c:if>
                        <button type="button" class="create-content-btn" id="${board.id}">등록</button>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<nav class="border-primary">--%>
<%--    <ul class="pagination"></ul>--%>
<%--</nav>--%>
<script src="/resources/js/user/userContent.js"/>
<%--<script src="assets/js/jquery.min.js"></script>--%>
<%--<script src="assets/bootstrap/js/bootstrap.min.js"></script>--%>x
</body>

</html>
<%--
  Created by IntelliJ IDEA.
  User: JH
  Date: 2019-09-23
  Time: 오후 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">자유게시판</h1>
            <h5>누구나 사용 할 수 있는 자유 게시판입니다</h5>
        </div>
    </div>
    <div class="row">
        <!-- /.col-lg-12 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
<%--                <div class="panel-heading">--%>
<%--                </div>--%>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table" id="menuListTable">
                            <thead>
                            <tr>
                                <th scope="col" class="no" width="10%">번호</th>
                                <th scope="col" class="title" width="50%">제목</th>
                                <th scope="col" class="author" width="25%">작성자</th>
                                <th scope="col" class="date" width="25%">작성일</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>1</th>
                                <th>예제입니다.</th>
                                <th>황진혁</th>
                                <th>2019.09.23</th>
                            </tr>
                            </tbody>

                            <tbody>
                            <tr>
                                <th>2</th>
                                <th>가입인사드립니다.</th>
                                <th>김대숲</th>
                                <th>2019.09.25</th>
                            </tr>
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
                                        <c:otherwise>z
                                            <li class="page-number"><a href="?page=${i-1}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <c:if test="${!resultList.last}">
                                    <li class="page-last">
                                        <a href="?page=${resultList .number+1}">&rarr;</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                    <!-- /.table-responsive -->
                    <input id="createSave" class="btn btn-lg btn-success btn-block" type="button" value="생성" />
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
</div>
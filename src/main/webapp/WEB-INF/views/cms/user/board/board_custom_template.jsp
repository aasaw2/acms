<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-09-25
  Time: 오후 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page-wrapper">
    <div class="flex-grow-1">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">커스텀 리스트 게시판 형</h1>
        </div>
    </div>

    <div class="row">
        <!-- /.col-lg-6 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1>${board.name}</h1>
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped" id="boardListTable">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>게시글 이름</th>
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
                                        <%--                                    <td><input type="button" class="set_btn" c:out id="set_${result.id}"--%>
                                        <%--                                               value="편집"/></td>--%>
                                    <td><c:out value="${result.writer.accountName}"/></td>
                                </tr>
                            </c:forEach>

                            <c:if test="${resultList.totalElements == 0}">
                                <tr>
                                    <td colspan="5">등록된 데이터가 없습니다.</td>
                                </tr>
                            </c:if>

                            <%--   <c:if test="${authorityLists.size() == 0}" >--%>

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
                            </ul>
                        </div>


                    </div>
                    <!-- /.table-responsive -->
                    <input id="boardContentSave" class="btn btn-lg btn-success btn-block" idx="${board.id}" type="button" value="등록"/>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
    </div>
</div>
<!-- /.row -->
</div>
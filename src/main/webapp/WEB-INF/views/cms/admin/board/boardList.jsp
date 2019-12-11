<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">게시판 관리</h1>
        </div>
    </div>

    <div class="row">
        <!-- /.col-lg-6 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Board Manager
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped" id="boardListTable">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>게시판 이름</th>
                                <th>게시판 편집</th>
                                <th>게시판 상세보기</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="result" items="${resultList.content}" varStatus="status">
                                <tr id="update_${result.id}" idx="${result.id}">
                                    <td>
                                            ${resultList.totalElements - (resultList.size * resultList.number ) - status.index }
                                    </td>
                                    <td><c:out value="${result.name}"/></td>
                                    <td><input type="button" class="set_btn" c:out id="set_${result.id}"
                                               value="편집"/></td>
                                    <td><input type="button" class="show_btn" c:out id="show_${result.id}"
                                               value="상세보기"/></td>
                                </tr>
                            </c:forEach>

                            <c:if test="${resultList.totalElements == 0}" >
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
                                        <a href="?page=${resultList.number+1}">&rarr;</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>


                    </div>
                    <!-- /.table-responsive -->
                    <input id="boardSave" class="btn btn-lg btn-success btn-block" type="button" value="등록" />
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>

</div>
<!-- /.row -->
</div>

<script>

    $('#boardSave').on('click', function (e) {
        window.location.href = "/admin/board/create";
    });

    $(".set_btn").on('click', function (e) {
        var setId = $(this).attr('id');
        var parseId = setId.slice(4);
        window.location.href = "/admin/board/" + parseId;
    });

    $(".show_btn").on('click', function (e) {
        var showId = $(this).attr('id');
        var parseId = showId.slice(5);
        window.location.href = "/admin/board/show/" + parseId;
    })

</script>
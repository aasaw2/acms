<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-09-24
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<%--                                <th>게시글 편집</th>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="result" items="${resultList.content}" varStatus="status">
                                <tr class="showDetail" id="update_${result.id}" idx="${result.id}">
                                    <td>
                                            ${resultList.totalElements - (resultList.size * resultList.number ) - status.index }
                                    </td>
                                    <td><c:out value="${result.name}"/></td>
<%--                                    <td><input type="button" class="set_btn" c:out id="set_${result.id}"--%>
<%--                                               value="편집"/></td>--%>
                                </tr>
                                <c:if test="${not empty result.answer}">
                                    <c:forEach var="answer" items="${result.answer}" varStatus="status">
                                    <tr id="update_${answer.id}" idx="${answer.id}">
                                        <td>
                                            답글
                                        </td>
                                        <td><c:out value="${answer.name}"/></td>
                                    </tr>
                                    </c:forEach>
                                </c:if>
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
                                        <a href="?page=${resultList .number+1}">&rarr;</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>


                    </div>
                    <!-- /.table-responsive -->
                    <input id="boardContentSave" class="btn btn-lg btn-success btn-block" idx="${board.id}" type="button" value="등록" />
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

<script type="javascript">
    $("#boardContentSave").on('click', function (e) {
        window.location.href = "/board/${board.id}/content";
    });

    $(".showDetail").click(function() {
        alert("click");
        // var str = "";
        // var tdArr = new Array();    // 배열 선언

        // 현재 클릭된 Row(<tr>)
        // var tr = $(this);
        // var td = tr.children();
        // tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
        //   console.log("클릭한 Row의 모든 데이터 : "+tr.text());
        //  console.log("클릭한 Row의 모든 데이터 : "+tr.attr("idx"));
        //console.log("클릭한 Row의 idx 데이터 : "+td.eq(1).text());
        //  console.log("클릭한 Row의 idx 데이터 : "+td.eq(0).text());

        // 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.
        // td.each(function(i){
        //     tdArr.push(td.eq(i).text());
        // });

        //  console.log("배열에 담긴 값 : "+tdArr);
        //   console.log("배열에 담긴 값 : "+tdArr);

        var idx = $(this).attr("idx");
        alert(idx);
        location.href="/admin/board/contents/detail/" + idx;
    });

</script>
<%--
  User: Eido
  Date: 2018-10-09
  Time: 오후 3:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Tables</h1>
        </div>
    </div>
    <div class="row">
        <!-- /.col-lg-6 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Basic Table
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table" id="authorityListTable">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>권한이름</th>
                                <th>권한url</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="result" items="${resultList.content}" varStatus="status">
                                <tr id="update_${result.id}" idx="${result.id}">
                                    <td>
                                            ${resultList.totalElements - (resultList.size * resultList.number ) - status.index }
                                    </td>
                                    <td><c:out value="${result.name}"/></td>
                                    <td><c:out value="${result.authorityUrl}"/></td>
                                </tr>
                            </c:forEach>

                            <c:if test="${resultList.totalElements == 0}" >
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
                            </ul>
                        </div>
                    </div>
                    <!-- /.table-responsive -->
                    <input id="authoritySave" class="btn btn-lg btn-success btn-block" type="button" value="등록" />
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

<%--<script src="/resources/js/account/account.js"></script>--%>
<script>
    $( "#authoritySave" ).click(function() {
        location.href="/admin/Authority/write";
    });

    $("#authorityListTable tr").click(function() {

        var str = ""
        var tdArr = new Array();    // 배열 선언

        // 현재 클릭된 Row(<tr>)
        var tr = $(this);
        var td = tr.children();
        // tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
        //   console.log("클릭한 Row의 모든 데이터 : "+tr.text());
        //  console.log("클릭한 Row의 모든 데이터 : "+tr.attr("idx"));
        //console.log("클릭한 Row의 idx 데이터 : "+td.eq(1).text());
        //  console.log("클릭한 Row의 idx 데이터 : "+td.eq(0).text());

        // 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.
        td.each(function(i){
            tdArr.push(td.eq(i).text());
        });

        //  console.log("배열에 담긴 값 : "+tdArr);
        //   console.log("배열에 담긴 값 : "+tdArr);

        location.href="/admin/Authority/update/"+tr.attr("idx");


    });


</script>
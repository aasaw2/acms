<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="page-wrapper">
    <div class="row">
       <div class="col-lg-12">
         <h1 class="page-header">메뉴 관리</h1>
       </div>
    </div>
        <div class="row">
        <!-- /.col-lg-12 -->
             <div class="col-lg-12">
                 <div class="panel panel-default">
                     <div class="panel-heading">
                      메뉴 목록
                     </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table" id="menuListTable">
                                    <thead>
                                        <tr>
                                        <th width="10%">메뉴 ID</th>
                                        <th width="30%">메뉴 이름</th>
<%--                                        <th width="30%">메뉴 URL</th>--%>
                                        <th width="30%">메뉴 정렬 순서</th>
<%--                                        <th width="10%">메뉴 아이콘(추가 예정)</th>--%>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="result" items="${menuList.content}" varStatus="status">
                                            <tr id="update_${result.menuId}" idx="${result.menuId}">
                                            <td><c:out value="${result.menuId}"/> </td>
                                            <td><c:out value="${result.menuName}"/></td>
                                            <td><c:out value="${result.menuSort}"/></td>
<%--                                            <td><i class="${result.menuZone}"/></td>--%>
                                            <td><input type="button" class="checkname" id="Check_${result.menuId}" value="세부메뉴 보기" ></td>
                                            <td><input type="button" class="update_btn" id="Edit_${result.menuId}" value="수정"></td>
                                            <td><input type="button" class="delete_btn" id="Delete_${result.menuId}" value="삭제"></td>
                                            </tr>
                                          </c:forEach>
                                        <c:if test="${menuList.totalElements == 0}" >
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
                      <input id="menuSave" class="btn btn-lg btn-success btn-block" type="button" value="등록" />
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
</div>


<script>

    $( "#menuSave" ).click(function() {
     location.href="/admin/menu/write";
    });


    $('.update_btn').click(function(e) {
        e.preventDefault();

        var id = $(this).attr('id');
        var ch =  id.slice(5);
        location.href="/admin/menu/update/"+ch;
    });

    $('.delete_btn').click(function(e) {
        e.preventDefault();

        var id = $(this).attr('id');
        var ch = id.slice(7);

        if(confirm("메뉴를 삭제 하시겠습니까?") == true) {

        $.ajax({
            type: "DELETE",
            url: "/admin/menu/delete/"+ch,
            success: function () {
            alert("삭제 완료!");
            window.location.href = "/menu/list";
         },
         error: function () {
          alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');
        }
        });

        } else {
           return;
     }
    });

    $('.checkname').click(function(e) {
        e.preventDefault();
        alert("세부 메뉴로 이동합니다.");

        var id = $(this).attr('id');
        var ch = id.slice(6);

        alert(id);
        location.href="/admin/menu/detaillist/"+ch;
    })

    $("#menuListTable tr").click(function() {

        var str = "";
        var tdArr = new Array();    // 배열 선언

        // 현재 클릭된 Row(<tr>)
        var tr = $(this);
        var td = tr.children();

        location.href="/admin/menu/detaillist/"+ch;
    });

</script>
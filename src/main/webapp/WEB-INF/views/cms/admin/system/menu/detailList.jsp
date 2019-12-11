<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">세부 메뉴 설정</h1>
        </div>
    </div>

        <div class="row">
            <!-- /.col-lg-12 -->
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        세부 메뉴 목록
                        <a href="javascript:history.back()" style="float: right;">메뉴 리스트로 이동</a>
                     </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table" id="menuDetailListTable">
                                <thead>
                                    <tr>
                                    <th>메뉴 노출 순서</th>
                                    <th>상위 메뉴 이름</th>
                                    <th>세부 메뉴 이름</th>
                                    <th>세부 메뉴 접속 URL</th>
                                    <th></th>
                                    <th></th>
                                    </tr>
                                    </thead>
                                        <tbody>
                                        <c:forEach var="result" items="${menuDetailList}" varStatus="status">
                                        <tr id="update_${result.menuSubId}" idx="${result.menuSubId}">
                                            <td><c:out value="${result.menuSubSort}"/></td>
                                            <td><c:out value="${result.menu.menuName}"/> </td>
                                            <td><c:out value="${result.menuSubName}"/></td>
                                            <td><c:out value="${result.menuSubLink}"/></td>
                                            <td><input type="button" class="update_btn" id="Edit_${result.menuSubId}" value="수정" style="float: right"></td>
                                            <td><input type="button" class="delete_btn" id="Delete_${result.menuSubId}" value="삭제" style="float: right"></td>
                                        </tr>
                                    </c:forEach>

                                        <c:if test="${menuDetailList.size() == '0'}" >
                                            <tr>
                                            <td colspan="5" align="center">등록된 데이터가 없습니다.</td>
                                            </tr>
                                        </c:if>

                                        </tbody>
                                </table>
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
        location.href="/admin/menu/detailwrite";
        });


    $('.update_btn').click(function(e) {
    e.preventDefault();
    alert("수정 선택");

    var id = $(this).attr('id');
    var ch = id.slice(5);
    location.href="/admin/menu/detailupdate/"+ch;
    });

    $('.delete_btn').click(function(e) {

    e.preventDefault();

    var id = $(this).attr('id');
    var ch = id.slice(7);

    if(confirm("메뉴를 삭제 하시겠습니까?") == true) {
        $.ajax({
        type: "DELETE",
        url: "/admin/menu/detaildelete/"+ch,
        success: function () {
        alert("삭제 완료!");
        window.location.reload();
        },
        error: function () {
        alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');
        }
        });

    } else {
            return;
        }

    })

</script>
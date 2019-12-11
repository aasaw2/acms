<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $(function () {
        var dialog, form,

            // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
            emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,

            tips = $(".validateTips");

        dialog = $("#dialog-form").dialog({
            autoOpen: false,
            height: 400,
            width: 350,
            modal: true,
            buttons: {
                // "Create an account": addUser,
                Cancel: function () {
                    dialog.dialog("close");
                }
            },
            close: function () {
                form[0].reset();
            }
        });

        form = dialog.find("form").on("submit", function (event) {
            event.preventDefault();
            // addUser();
        });

        $("#create-restriction").button().on("click", function () {
            dialog.dialog("open");
        });


    });
</script>

<div id="wrapper">
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">권한 추가</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Basic Form Elements
                    </div>
                    <div class="panel-body">

                        <div id="dialog-form" title="Create DivisionWithAuthority">
                            <p class="validateTips">All form fields are required.</p>
                            <form>
                                <fieldset>
                                    <table class="table" id="divisionListTable">
                                        <thead>
                                        <tr>
                                            <th>권한 코드</th>
                                            <th>권한 이름</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <c:forEach var="result" items="${resultList.content}" varStatus="status">
                                            <tr id="update_${result.id}" idx="${result.id}">
                                                <td><c:out value="${result.url}"/></td>
                                                <td><c:out value="${result.name}"/></td>
                                                <td><input type="button" class="add_btn" c:out id="add_${result.id}"
                                                           value="what"/></td>
                                                <td><input type="button" class="delete_btn" c:out
                                                           id="delete_${result.id}" value="삭제"/></td>
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
                                                        <li class="page-number active"><a href="#">${i} please</a></li>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <li class="page-number" value="${i}"><a href="?page=${i-1}">${i}
                                                            haaaaa</a></li>
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

                                </fieldset>
                            </form>
                        </div>

                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="authorityForm" name="authorityForm">
                                    <div class="form-group">
                                        <label>권한코드</label>
                                        <input class="form-control" type="text" name="authorityCode" id="authorityCode"
                                               value="${authority.authorityCode}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>권한이름</label>
                                        <input class="form-control" name="name" id="name" value="${authority.name}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>권한 url</label>
                                        <input class="form-control" name="authorityUrl" id="authorityUrl"
                                               value="${authority.authorityUrl}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>제약 등록</label>
                                        <input readonly class="form-control" name="authorityGroupName"
                                               id="authorityGroupName" value="">
                                        <button type="button" id="create-restriction">Add Authority</button>
                                    </div>
                                    <button type="button" id="authorityInsert">저장</button>

                                    <button type="button" id="authorityDelete">삭제</button>
                                </form>
                            </div>
                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
<script language="JavaScript">

    var tdArr = new Array();    // 배열 선언
    var tdReArr = new Array();
    var val;

    $('.add_btn').click(function (e) {
        e.preventDefault();

        alert("추가 클릭");
        var bo = true;
        var vid = $(this).attr('id');
        var id = vid.slice(4);
        for (var i = 0; i < tdArr.length; i++) {
            if (id == tdArr[i]) {
                bo = false;
            }
        }
        if (bo == true) {
            tdArr.push(id);
        } else {
            alert("사용자가 이미 추가되어 있습니다.");
        }

        $('#authorityGroupName').val(tdArr);
        alert("추가 완료");
    });

    $('.delete_btn').click(function (e) {
        e.preventDefault();

        var vid = $(this).attr('id');
        var id = vid.slice(7);
        for (var i = 0; i < tdArr.length; i++) {
            alert(tdArr[i]);
            alert(id);
            // tdArr.slice();
            if (id == tdArr[i]) {
                tdArr.splice(i, 1);
            }
        }
        $('#authorityGroupName').val(tdArr);
        alert("삭제 클릭");
    });
    <c:forEach items="${authority.restrictionMenus}" var="item">
    val ="${item.id}";
    alert(val);
    tdArr.push(val);
    </c:forEach>

    $('#authorityGroupName').val(tdArr);

    $('#authorityInsert').on('click', function () {
        var cmd = "${authority.cmd}";
        var formData = $("form[name=authorityForm]").serialize();
        var url;
        if (cmd == 'update')
            url = '/admin/Authority/update/${authority.id}';
        if (cmd == 'insert')
            url = '/admin/Authority/write';


        $.ajax({
            type: "POST",
            url: url,
            data: formData,
            success: function (data) {
                alert("등록 완료");
                var form = document.authorityForm;
                form.method = "get";
                form.action = "/admin/Authority/list";
                form.submit();
            },
            error: function (xhr, status, error) {
                alert("문제가 발생했습니다 \n 개발팀에 문의 바랍니다.");
            }
        });
    });

    $('#authorityDelete').on('click', function () {
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "/admin/Authority/delete/${authority.id}",
            success: function (data) {
                alert(data.message);
                var form = document.authorityForm;
                form.action = '/admin/Authority/list';
                form.submit();

            },
            error: function () {
                alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');
            }
        });
    });

    <%--var tdArr = new Array();    // 배열 선언--%>
    <%--var tdReArr = new Array();--%>
    <%--var val;--%>
    <%--<c:forEach items="${resultList}" var="item">--%>
    <%--val ="${item.restrictionMenus.name}";--%>
    <%--alert(val);--%>
    <%--tdArr.push(val);--%>
    <%--console.debug("${item.id}");--%>
    <%--</c:forEach>--%>

    <%--$('#authorityGroupName').val(tdArr);--%>
</script>

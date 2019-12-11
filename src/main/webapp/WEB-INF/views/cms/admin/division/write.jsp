<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%--
  ~ CreateDay : 18. 10. 18 오전 8:06
  ~ fileName : write.jsp
  ~ CreateName : Eido
  ~ Create by Amazingpeoples.io
  --%>
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

        $("#create-authority").button().on("click", function () {
            dialog.dialog("open");
        });


    });
</script>
<div id="wrapper">
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">부서 추가</h1>
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
                                                <td><c:out value="${result.authorityCode}"/></td>
                                                <td><c:out value="${result.name}"/></td>
                                                <td><input type="button" class="add_btn" c:out id="add_${result.name}"
                                                           value="추가"/></td>
                                                <td><input type="button" class="delete_btn" c:out
                                                           id="delete_${result.name}" value="삭제"/></td>
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
                                <form role="form" id                                                                                                                                                                                           ="divisionForm" name="divisionForm">
                                    <div class="form-group">
                                        <label>부서코드</label>
                                        <input class="form-control" name="divisionCode" id="divisionCode"
                                               value="${division.divisionCode}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>부서이름</label>
                                        <input class="form-control" name="divisionName" id="divisionName"
                                               value="${division.divisionName}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <%--  <label>부서이asdasd름</label>
                                          <c:forEach var="aaa" items="${mdaa}" varStatus="status">
                                            &lt;%&ndash;  [${status.index}]: ${mdaa[status.index]}&ndash;%&gt;
                                              ${aaa.authority.id}
                                          </c:forEach>
                                          <p class="help-block">Example block-level help text here.</p>
    --%>
<%--                                        <label>권한</label>--%>
<%--                                        <c:forEach var="result" items="${authorityList}" varStatus="status">--%>
<%--                                            <label class="checkbox-inline">--%>
<%--                                                <input type="checkbox" id="authorityId" name="authorityId"--%>
<%--                                                       value="${result.id}"--%>
<%--                                                        <c:forEach var="resultss" items="${mdaa}" varStatus="status">--%>
<%--                                                            <c:if test="${ resultss.authority.id eq result.id}">checked="checked"</c:if>}--%>
<%--                                                        </c:forEach>--%>
<%--                                                />--%>
<%--                                                    ${result.authorityName}--%>
<%--                                            </label>--%>
<%--                                        </c:forEach>--%>
<%--                                        <br>--%>

                                        <label>권한 등록</label>
<%--                                        <input readonly class="form-control" name="authorityName" id="authorityName" value="">--%>
<%--                                        <input type="hidden" name="authorityId" id="authorityId" value="${.authority.id}">--%>
<%--                                        <button type="button" id="create-user-authority">Create AuthorityWithUser</button>--%>
<%--                                        <label>사용자 등록</label>--%>
                                        <input readonly class="form-control" name="authorityGroupName" id="authorityGroupName" value="">
                                        <button type="button" id="create-authority">Add Authority</button>


                                    </div>
                                    <button type="button" id="divisionInsert">저장</button>

                                    <button type="button" id="divisionDelete">삭제</button>
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

<script>
    <c:forEach items="${mdaaList}" var="item">
    console.debug("${item.id}");
    </c:forEach>
    $(document).ready(function () {
        //  $(".sidebar").addClass("active");
        //alert('안됨?');
        $('#side-menu').metisMenu();
    });



    $('#divisionInsert').on('click', function () {
        var cmd = "${division.cmd}";
        // var formData = $("form[name=divisionForm]").serialize();
        var url;
        var type;
        if (cmd == 'update') {
            url = '/admin/division/update/${division.id}';
            type = 'PUT';
            alert("update click")
        } else {
            url = '/admin/division/create';
            type = 'POST';
        }

        alert(url);
        alert(type);
        var divisionCode = $('#divisionCode').val();
        var divisionName = $('#divisionName').val();
        var authority = $('#authorityGroupName').val();

        var obj = new Object();
        obj.divisionCode = divisionCode;
        obj.divisionName = divisionName;
        obj.authority = authority;

        $.ajax({
            type : type,
            data : JSON.stringify(obj),
            contentType : 'application/json',
            url : url,
            success : function (data) {
                alert('success');
                window.location.href = '/admin/Division/list'
            },
            error : function (xhr) {
                console.log(xhr);
                alert('error');
            }
        })
    });

    $('#divisionDelete').on('click', function () {
        $.ajax({
            type: "DELETE",
            dataType: 'json',
            url: "/admin/Division/delete/${division.id}",
            success: function (data) {
                alert(data.message);
                var form = document.divisionForm;
                form.action = '/admin/Division/list';
                form.submit();
            },
            error: function () {
                alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');
            }
        });
    });
    
    var tdArr = new Array();    // 배열 선언
    var tdReArr = new Array();
    var val;
    <c:forEach items="${mdaaList}" var="item">
    val ="${item.authority.name}";
    tdArr.push(val);
    console.debug("${item.id}");
    </c:forEach>

    $('#authorityGroupName').val(tdArr);

    $('.add_btn').click(function (e) {
        e.preventDefault();

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
    });

    $('.page-first').click(function (e) {
        e.preventDefault();
        window.location.href = "?page=${resultList.number-1}";
    });

    $('.page-number').click(function (e) {
        e.preventDefault();
        // var i = $(this)();
        // alert("페이징 클릭" + i);
        <%--window.location.href = "?page=${i-1}";--%>
        // alert("하이고...")
    });

    $('.page-last').click(function (e) {
        e.preventDefault();
        window.location.href = "?page=${resultList .number+1}";
    });

    <%--<ul class="pagination">--%>
    <%--    <c:if test="${!resultList.first}">--%>
    <%--    <li class="page-first">--%>
    <%--    <a href="?page=${resultList.number-1}">&larr;</a>--%>
    <%--</li>--%>
    <%--</c:if>--%>
    <%--<c:forEach begin="1" end="${resultList.totalPages}" var="i">--%>
    <%--<c:choose>--%>
    <%--<c:when test="${resultList.number eq i-1}">--%>
    <%--<li class="page-number active"><a href="#">${i}</a></li>--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
    <%--<li class="page-number"><a href="?page=${i-1}">${i}</a></li>--%>
    <%--</c:otherwise>--%>
    <%--</c:choose>--%>
    <%--</c:forEach>--%>

    <%--<c:if test="${!resultList.last}">--%>
    <%--<li class="page-last">--%>
    <%--    <a href="?page=${resultList .number+1}">&rarr;</a>--%>
    <%--</li>--%>
    <%--</c:if>--%>
    <%--</ul>--%>
</script>

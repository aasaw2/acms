<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-08-31
  Time: 오후 3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<%--<script src="https://code.jquery.com/jquery-1.12.4.js"></script>--%>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $( function() {
        var dialog, form,

            // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
            emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,

            tips = $( ".validateTips" );


        function addCodeDetail() {
            var valid = true;
            //divisionName
            if ( valid ) {
                dialog.dialog( "close" );
            }
            return valid;
        }

        dialog = $( "#dialog-form" ).dialog({
            autoOpen: false,
            height: 400,
            width: 350,
            modal: true,
            buttons: {

                //  "Create an account": addUser,
                추가 : function() {
                    var id = '${code.id}';
                    if (id != "") {
                    location.href='/code/codeDetail/${code.id}';
                    } else {
                        Location.href = "/code/codeDetail/write";
                    }
                },
                Cancel: function() {
                    dialog.dialog( "close" );
                }
            },
            close: function() {
                form[ 0 ].reset();
            }
        });

        form = dialog.find( "form" ).on( "submit", function( event ) {
            event.preventDefault();
            addCodeDetail();
        });

        $( "#create-codeDetail" ).button().on( "click", function() {
            dialog.dialog( "open" );
        });

        $("#codeDetailListTable tr").click(function() {
            var str = "";
            var tdArr = new Array();    // 배열 선언

            var tr = $(this);
            var td = tr.children();

            td.each(function(i){
                tdArr.push(td.eq(i).text());
            });

            $( "#codeGroupId").val(td.eq(1).text());
            $( "#codeGroupName").val(tr.attr("idx"));

            dialog.dialog( "close" );
        });
    } );
</script>

<div id="wrapper">
    <div id="page-wrapper">

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">코드 추가</h1>
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

                        <div id="dialog-form" title="Create CodeDetail">
                            <p class="validateTips">All form fields are required.</p>
                            <form>
                                <fieldset>
                                    <table class="table" id="codeDetailListTable">
                                        <thead>
                                        <c:if test="${codeDetailList.size() > 0}" >
                                        <tr>
                                            <th>코드 아이디</th>
                                            <th>코드 그룹 이름</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="result" items="${codeDetailList}" varStatus="status">
                                            <tr id="update_${result.id}" idx="${result.id}">
                                                <td><c:out value="${result.codeDetailName}"/></td>
                                                <td><c:out value="${result.codeDetailOrder}"/></td>
                                                <td><input type="button" class="update-details" id="update_${result.id}" onclick="location.href='/code/${code.id}/update/${result.id}';" value="수정"/></td>
<%--                                                <td><input type="submit" class="update-detail" id="update-${result.id}" value="수정"></td>--%>
                                                <td><input type="button" class="delete-detail" id="delete-${result.id}" value="삭제"></td>
                                            </tr>
                                        </c:forEach>

                                        <c:if test="${resultList.totalElements == 0}" >
                                            <tr>
                                                <td colspan="5">등록된 데이터가 없습니다.</td>
                                            </tr>
                                        </c:if>
                                        </c:if>
<%--                                        <input type="button" class="create-details" onclick="location.href='/code/${code.id}/codeDetail';" value="추가"/>--%>
                                        <%--   <c:if test="${authorityLists.size() == 0}" >--%>

                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                        </div>

                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="codeForm" name="codeForm" >
                                    <div class="form-group">
                                        <label>코드 그룹 ID</label>
                                        <input  class="form-control" type="text" name="codeGroupId" id="codeGroupId" value="${code.codeGroupId}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>코드 그룹 이름</label>
                                        <input class="form-control" name="codeGroupName" id="codeGroupName" value="${code.codeGroupName}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>코드 내용</label>
                                        <input class="form-control" name="codeOrder" id="codeOrder" value="${code.codeOrder}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <c:if test="${code.id > '0'}">
                                        <label>코드 디테일 등록</label>
                                        <br>
<%--                                        <input readonly class="form-control" name="divisionName" id="divisionName" value="">--%>
<%--                                        <input type="hidden" name="divisionId" id="divisionId" value="${account.division.id}">--%>
                                        <button type="button" id="create-codeDetail">Create Code Detail</button>
                                        <br>
                                        </c:if>
                                    </div>
                                    <button type="button" id="codeSave" >저장</button>

                                    <button type="button" id="codeDelete">삭제</button>
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
    /* $(document).ready(function() {
         console.log( "ready!" );
         alert( "ready!" );
         var cmd = "$//{authority.cmd}";
         alert(cmd);
     });*/

    $('#codeSave').on('click', function() {
        var cmd = "${code.cmd}";
        var url;
        if(cmd == 'update') {
            url = '/admin/code/update/${code.id}';
        } else {
            url = '/admin/code/create';
        }
        var codeGroupId = $("#codeGroupId").val();
        var codeGroupName = $("#codeGroupName").val();
        var codeOrder = $('#codeOrder').val();
        var obj = {};
        obj.codeGroupId = codeGroupId;
        obj.codeGroupName = codeGroupName;
        obj.codeOrder = codeOrder;

        $.ajax({
            type: "POST",
            url: url,
            contentType :'application/json',
            data: JSON.stringify(obj),
            success: function(data) {
                alert("등록 완료");
                var form = document.codeForm;
                form.action = "/admin/code/list";
                form.submit();
            },
            error: function(xhr, status, error){
                console.log(xhr);
                alert("문제가 발생했습니다 \n 개발팀에 문의 바랍니다.");
            }
        });
    });

    $('#codeDelete').on('click', function() {
        $.ajax({
            type: "DELETE",
            url: "/admin/code/delete/${code.id}",
            success: function () {
                window.location.href = "/admin/code/list";
            },
            error: function (xhr) {
                console.log(xhr);
                alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');
            }
        });
    });

    <%--$('.update-detail').on('click', function (e) {--%>
    <%--    e.preventDefault();--%>
    <%--    var str = $(this).attr('id');--%>
    <%--    var string = str.slice(7);--%>
    <%--    alert(string);--%>
    <%--    alert('update detail click');--%>
    <%--    $.ajax({--%>
    <%--        type : 'GET',--%>
    <%--        url : '/code/${code.id}/update/' + string,--%>
    <%--        success : function () {--%>
    <%--            alert('update');--%>
    <%--            window.location.href = '/code/list';--%>
    <%--        },--%>
    <%--        error : function (xhr) {--%>
    <%--            console.log(xhr);--%>
    <%--            alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');--%>
    <%--        }--%>
    <%--    })--%>
    <%--});--%>

    $('.delete-detail').on('click', function (e) {
        e.preventDefault();
        var str = $(this).attr('id');
        var string = str.slice(7);
        $.ajax({
            type : "DELETE",
            url : "/admin/code/codeDetail/delete/" + string,
            success : function () {
                alert('삭제 되었습니다.')
            },
            error : function (xhr) {
                console.log(xhr);
                alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');
            }
        })
    });

    <%--$(".update-detail").on('click', function (e) {--%>
    <%--    alert("구웃");--%>
    <%--    $.ajax({--%>
    <%--        type : "GET",--%>
    <%--        url : '/code/${code.id}/codeDetail',--%>
    <%--        --%>
    <%--    })--%>
    <%--})--%>


</script>

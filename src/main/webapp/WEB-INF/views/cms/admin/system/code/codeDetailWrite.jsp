<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-09-02
  Time: 오후 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="wrapper">
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">코드 디테일 추가</h1>
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
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="codeForm" name="codeForm" >
                                    <div class="form-group">

                                        <label>코드 디테일 이름</label>
                                        <input  class="form-control" type="text" name="codeDetailName" id="codeDetailName" value="${codeDetail.codeDetailName}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>코드 디테일 명령</label>
                                        <input class="form-control" name="codeDetailOrder" id="codeDetailOrder" value="${codeDetail.codeDetailOrder}">
                                        <p class="help-block">Example block-level help text here.</p>

                                    </div>
                                    <button type="button" id="codeDetailSave" >저장</button>

                                    <button type="button" id="codeDetailDelete">삭제</button>
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

    $('#codeDetailSave').on('click', function() {
        var cmd = "${codeDetail.cmd}";
        var url;
        var type;
        if(cmd == 'update') {
            url = '/admin/code/${code.id}/update/${codeDetail.id}';
            type = "PUT";
        } else {
            url = '/admin/code/${code.id}/create';
            type = "POST";
        }

        var codeDetailName = $("#codeDetailName").val();
        var codeDetailOrder = $("#codeDetailOrder").val();

        var obj = {};
        obj.codeDetailName = codeDetailName;
        obj.codeDetailOrder = codeDetailOrder;
        $.ajax({
            type: type,
            url: url,
            contentType :'application/json',
            data: JSON.stringify(obj),
            success: function(data) {
                alert("코드 디테일 등록 완료");
                var form = document.codeForm;
                form.action = "/admin/code/update/${code.id}";
                form.submit();
            },
            error: function(xhr, status, error){
                console.log(xhr);
                alert("문제가 발생했습니다 \n 개발팀에 문의 바랍니다.");
            }
        });
    });

    $('#codeDetailDelete').on('click', function() {
        $.ajax({
            type: "DELETE",
            url: "/admin/code/codeDetail/delete/${codeDetail.id}",
            success: function () {
                window.location.href = "/admin/code/list";
            },
            error: function (xhr) {
                console.log(xhr);
                alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');
            }
        });
    });


</script>

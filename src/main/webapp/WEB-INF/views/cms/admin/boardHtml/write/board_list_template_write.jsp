<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-09-24
  Time: 오후 4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="wrapper">
    <div id="page-wrapper">

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">게시글 추가</h1>
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
                                <form role="form" id="codeForm" name="codeForm">
                                    <div class="form-group">
                                        <label>게시글 이름</label>
                                        <input class="form-control" name="boardName" id="boardContentName"
                                               value="">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>게시글 내용</label>
                                        <input class="form-control" name="boardName" id="boardContentComment"
                                               value="">
                                        <p class="help-block">Example block-level help text here.</p>


                                    </div>
                                    <button type="button" id="boardContentSave">저장</button>

                                    <button type="button" id="boardContentDelete">삭제</button>
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
<script>
    $('#boardContentSave').on('click', function (e) {
        e.preventDefault();

        var name = $('#boardContentName').val();
        var comment = $('#boardContentComment').val();

        var obj = {};
        obj.name = name;
        obj.comment = comment;

        $.ajax({
            type : "POST",
            url : '/admin/board/${id}/content',
            data : JSON.stringify(obj),
            contentType : 'application/json',
            success : function () {
                alert("등록 되었습니다.");
                window.location.href = '/admin/board/show/${id}';
            },
            error : function (xhr) {
                alert("error");
                console.log(xhr);
            }
        })
    })
</script>
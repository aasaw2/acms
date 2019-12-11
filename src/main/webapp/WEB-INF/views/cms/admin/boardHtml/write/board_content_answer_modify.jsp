<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-09-27
  Time: 오전 11:03
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
                <h1 class="page-header">답글 수정</h1>
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
                                        <label>답변 제목</label>
                                        <input class="form-control" name="boardName" id="name"
                                               value="${answer.name}">

                                        <label>답변 내용</label>
                                        <input class="form-control" name="boardName" id="comment"
                                               value="${answer.comment}">

                                    </div>
                                    <button type="button" id="contentAnswerUpdate">저장</button>

                                    <button type="button" id="contentAnswerCancel">취소</button>
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
    </div>
</div>

<script>
    var id = ${answer.id};
    var contentId = ${answer.boardContent.id};

    $('#contentAnswerCancel').on("click", function (e) {
        window.location.href = '/admin/board/contents/detail/' + contentId;
    });

    $('#contentAnswerUpdate').click(function (e) {
        e.preventDefault();
        var name = $('#name').val();
        var comment = $('#comment').val();
        var obj = {};

        obj.name = name;
        obj.comment = comment;

        $.ajax({
            type: 'PUT',
            url: '/admin/board/content/answer/' + id,
            data: JSON.stringify(obj),
            contentType: 'application/json',
            success: function () {
                alert("등록 되었습니다.");
                window.location.href = '/admin/board/contents/detail/' + contentId;
                console.log(data);
            },
            error: function (xhr) {
                console.log(xhr);
                alert("error");
            }

        })
    });

</script>
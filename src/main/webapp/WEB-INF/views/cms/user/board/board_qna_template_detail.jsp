<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-09-25
  Time: 오후 12:00
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
                <h1 class="page-header">${content.name}</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <%--                    <div class="panel-heading">--%>
                    <%--                        ${content.name}--%>
                    <%--                    </div>--%>
                    <div class="panel-body">

                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="board-form" name="codeForm">
                                    <div class="form-group">
                                        <label>게시글 내용</label>
                                        <div class="comment" height="500px">${content.comment}</div>


                                    </div>
                                    <button type="button" id="boardContentUpdate">수정</button>

                                    <button type="button" id="boardContentDelete">삭제</button>
                                </form>
                            </div>
                            <br>

                        </div>

                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>


        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        답변
                    </div>
                    <div class="panel-body" id="answerTemplates">
                        <c:forEach var="answer" items="${content.answer}" varStatus="status">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="answers">
                                        <form role="form" class="answer-form" name="answerForm">
                                            <div class="form-group">

                                                <label>"${answer.writer.accountName}"의 답변</label>
                                                <div class="comment" id="comment_${answer.id}">${answer.comment}</div>
                                                <button type="button" class="boardContentAnswerUpdate" id="update_${answer.id}">수정</button>
                                                <button type="button" class="boardContentAnswerDelete">삭제</button>

                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <br>

                            </div>
                        </c:forEach>

                        <!-- /.row (nested) -->
                    </div>
                    <div class="page-header"></div>
                    <div class="answerCreate">
                        <button type="button" id="answerCreate">답변 추가</button>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /#page-wrapper -->
    </div>
</div>

<script type="text/html" id="answerCreateTemplate">
    <div class="row" id="answerTemplate">
        <!-- /.row -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    답변 추가
                </div>
                <div class="panel-body">

                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" id="codeForm" name="codeForm">
                                <div class="form-group">
                                    <label>답변 제목</label>
                                    <input class="form-control" name="answerName" id="answerName"
                                           value="">
                                    <p class="help-block">Example block-level help text here.</p>

                                    <label>게시글 내용</label>
                                    <input class="form-control" name="answerComment" id="answerComment"
                                           value="">
                                    <p class="help-block">Example block-level help text here.</p>

                                </div>
                                <button type="button" class="boardContentAnswerSave">등록</button>
                                <button type="button" class="boardContentAnswerCancel">취소</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="answerAddTemplate">
    <div class="row">
        <div class="col-lg-6">
            <div class="answers">
                <form role="form" class="answer-form" name="answerForm">
                    <div class="form-group">

                        <label></label>
                        <div class="comment">{1}</div>
                        <button type="button" class="boardContentAnswerUpdate">수정</button>
                        <button type="button" class="boardContentAnswerDelete">삭제</button>

                    </div>
                </form>
            </div>
        </div>
        <br>
    </div>
</script>

<script>
    var path = '${path}';
    var id = ${content.id};
    var contentUpdate = document.getElementById("boardContentUpdate");
    contentUpdate.onclick = function() {
        alert("click");
        window.location.href = '/${path}/board/content/update/' + id ;
    };

    <%--$('#boardContentUpdate').click(function (e) {--%>
    <%--    alert('click');--%>
    <%--    window.location.href = '/${path}/board/contents/update/' + id ;--%>
    <%--});--%>

    $('.boardContentAnswerUpdate').click(function () {
        alert('click');
        var id = $(this).attr('id');
        var vid = id.slice(7);
        alert(vid);
        window.location.href = "/user/board/content/answer/update/" + vid;
    });

    // var answerCreate = document.getElementById("answerCreate");
    // answerCreate.onclick = function () {
    //
    // };

    $("#answerCreate").click(function (e) {
        e.preventDefault();

        var tmp = $("#answerCreateTemplate").html();
        $('#answerCreate').hide();
        $('.answerCreate').append(tmp);

        $('#boardContentAnswerCancel').click(function (e) {
            e.preventDefault();

            $('#answerTemplate').remove();
            $('#answerCreate').show();
        });

        $('.boardContentAnswerSave').on('click', function (e) {
            e.preventDefault();
            alert("click");

            var obj = {};

            var name = $('#answerName').val();
            var comment = $('#answerComment').val();

            obj.name = name;
            obj.comment = comment;

            $.ajax({
                type: "POST",
                url: "/user/board/content/answer/" + id,
                data: JSON.stringify(obj),
                contentType: 'application/json',
                success: function (data) {
                    alert("등록 되었습니다.");
                    console.log(data);
                    $('#answerTemplate').remove();
                    $('#answerCreate').show();
                    // var answerTemplate = $('#answerAddTemplate').html();
                    var template = parse(data.accountName, data.comment);
                    $('#answerTemplates').append(template);
                },
                error: function (xhr) {
                    console.log(xhr);
                    alert("error");
                }
            })
        });
    });

    function parse(writer, comment) {
        return "<div class=\"row\">\n" +
            "                                <div class=\"col-lg-6\">\n" +
            "                                    <div class=\"answers\">\n" +
            "                                        <form role=\"form\" class=\"answer-form\" name=\"answerForm\">\n" +
            "                                            <div class=\"form-group\">\n" +
            "\n" +
            "                                                <label>" + writer + "의 답변</label>\n" +
            "                                                <div class=\'comment\'>" + comment + "</div>\n" +
            "                                                <button type=\"button\" class=\"boardContentAnswerUpdate\">수정</button>\n" +
            "                                                <button type=\"button\" class=\"boardContentAnswerDelete\">삭제</button>\n" +
            "\n" +
            "                                            </div>\n" +
            "                                        </form>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                                <br>\n" +
            "\n" +
            "                            </div>"
    }
</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>


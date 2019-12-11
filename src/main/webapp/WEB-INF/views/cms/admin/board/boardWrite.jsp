Created<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-09-23
  Time: 오후 3:15
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
                <h1 class="page-header">게시판 추가</h1>
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
                                        <label>게시판 이름</label>
                                        <input class="form-control" name="boardName" id="boardName"
                                               value="${board.name}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <div>
                                            <label>게시판 기본 템플릿 </label>
                                        </div>
                                        <div>
                                            <img id="showImage" src="" style="width: 500px; height: 400px">
                                        </div>

                                        <br>
                                        <h3>템플릿 형태 선택하기</h3><br>
                                        <select id="template" onchange="templateChange()">
                                            <c:forEach var="result" items="${htmlList}" varStatus="status">
                                                <option value="${result.name}" id="${result.id}">'${result.name}'
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <button type="button" id="boardSave">저장</button>

                                    <button type="button" id="boardDelete">삭제</button>
                                </form>
                                <form method="POST" enctype="multipart/form-data" id="fileUploadForm">
                                    <input type="file" id="fileUpload" name="files" accept=".jsp" multiple><br>
                                    <input type="button" id="file_button" value="파일 등록">
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

    $('#file_button').click(function () {
        var form = $('#fileUploadForm')[0];
        var formData = new FormData(form);
        $.ajax({
            type: 'POST',
            url: '/admin/file/upload',
            data: formData,
            dataType : 'json',
            contentType: false,
            processData : false,
            success: function (data) {
                alert("파일 등록이 완료 되었습니다.");
                console.log(data);
                fileData(data);
            },
            error: function (xhr) {
                alert("error...");
                console.log(xhr);
            }
        })
    });

    function fileData(data) {
        for (var i = 0; i < data.length; i++) {
            var myoption = document.createElement("option"); //works with both mozilla and IE
            myoption.id = data[i].id;
            myoption.name = data[i].name;
            myoption.text = data[i].name; //Probably, the sID stuff

            document.getElementById("template").options.add(myoption);
        }
    };

    var vid = '${board.html.id}';
    var name = '${board.html.name}';
    var fileName = "${board.html.fileName}";
    $(document).ready(function () {
        var show = document.getElementById('showImage');
        $("#template").val(name).prop("selected", 'selected');
        var templateSelect = document.getElementById("template");
        show.src = '/resources/images/'+ fileName + ".png";
        if (vid == "") {
            show.src = '/resources/images/board_list_template.png';
            $("#template").val('자유 게시판 형식').prop("selected", "selected");
        }

    });

    var boardId = '${board.id}';
    var cmd = '';
    var url = 0;
    var type = '';
    $('#boardSave').on('click', function () {
        if (boardId > 0) {
            cmd = 'update';
            url = '/admin/board/' + boardId;
            type = 'PUT';
        } else {
            url = '/admin/board/write';
            type = 'POST';
        }
        var name = $('#boardName').val();
        var obj = {};
        obj.name = name;

        var templateSelect = document.getElementById("template");
        obj.html = templateSelect.options[templateSelect.selectedIndex].id;


        $.ajax({
            type: type,
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(obj),
            success: function () {
                alert('success');
                window.location.href = "/admin/board/list";
            },
            error: function (xhr) {
                console.log(xhr);
                alert('error');
            }
        })

    });

    $('#boardDelete').on('click', function () {
        $.ajax({
            type: 'DELETE',
            url: '/board/' + boardId,
            success: function () {
                alert('success');
                window.location.href = "/admin/board/list";
            },
            error: function (xhr) {
                console.log(xhr);
                alert('error');
            }
        })
    });

    function templateChange() {
        var templateSelect = document.getElementById("template");
        var id = templateSelect.options[templateSelect.selectedIndex].id;
        var show = document.getElementById('showImage');
        if (id == 1) {
            show.src = '/resources/images/board_list_template.png';
        } else if (id == 2) {
            show.src = '/resources/images/board_qna_template.png';
        }
    };

</script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page pageEncoding="UTF-8"%>
<div id="wrapper">
            <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        <c:if test="${not empty menu}"> 메뉴 정보 수정 </c:if>
                         <c:if test="${empty menu}"> 메뉴 신규 생성 </c:if>
                    </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Basic Form Elements
                            <a href="javascript:history.back()" style="float: right;">메뉴 리스트로 이동</a>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" id="menuForm" name="menuForm" >
                                    <div class="form-group">

<%--                                        <label>메뉴 그룹</label>--%>
<%--                                        <input class="form-control" name="menuGroup" id="menuGroup" value="${menu.menuGroup}">--%>
<%--                                        <p class="help-block">Example block-level help text here.</p>--%>

                                        <label>메뉴 이름</label>
                                        <input  class="form-control" type="text" name="menuName" id="menuName" value="${menu.menuName}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>메뉴 노출 순서</label>
                                        <input  class="form-control" type="text" name="menuSort" id="menuSort" value="${menu.menuSort}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>메뉴 URL</label>
                                        <input  class="form-control" type="text" name="menuLink" id="menuLink" value="${menu.menuLink}">
                                        <p class="help-block">Example block-level help text here.</p>



        <%--                                        <label>메뉴 아이콘 변경</label><br>--%>
<%--                                        <select name="menuIcon">--%>
<%--                                            <option value="톱니바퀴"><i class="fa fa-gear fa-fw"/> 톱니바퀴</option>--%>
<%--                                            <option value="그래프"><i class="fa fa-bar-chart-o fa-fw" /> 차트</option>--%>
<%--                                        </select>--%>
<%--                                         <p class="help-block">Example block-level help text here.</p>--%>
<%--                                        <input  class="form-control" type="text" name="menuZone" id="menuZone" value="${menu.menuZone}">--%>
<%--                                        <p class="help-block">Example block-level help text here.</p>--%>


<%--                                        <label>메뉴 링크</label>--%>
<%--                                        <input class="form-control" name="menuLink" id="menuLink" value="${menu.menuLink}">--%>
<%--                                        <p class="help-block">Example block-level help text here.</p>--%>

                                        </div>
                                        <button type="button" id="menuInsert" >저장</button>

                                        <button type="button" id="menuDelete">삭제</button>
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

   $('#menuInsert').on('click', function() {
       var cmd = "${menu.cmd}";
       var url;
       if(cmd == 'update') {
           url = '/menu/update/${menu.menuId}';
           alert(url);
        }
        else {
         url = '/menu/create';
            alert(url);
        }

        var menuName = $("#menuName").val();
        var menuLink = $("#menuLink").val();
        var menuGroup = $('#menuGroup').val();

        var obj ={};
        obj.menuName = menuName;
        obj.menuLink = menuLink;
        obj.menuGroup = menuGroup;
        alert(obj.menuName);


        $.ajax({
            type: "POST",
            url: url,
            contentType :'application/json',
            data: JSON.stringify(obj),
            success: function() {
                alert("등록 완료");
                var form = document.menuForm;
                    form.action = "/menu/list";
                    form.submit();
            },
            error: function(xhr, status, error){
            console.log(xhr)
            alert("문제가 발생했습니다 \n 개발팀에 문의 바랍니다.");
            alert(url);
            }
        });

   });

   <%--$('#authorityDelete').on('click', function() {--%>
   <%--    $.ajax({--%>
   <%--        type: "POST",--%>
   <%--        dataType: 'json',--%>
   <%--        url: "/Authority/delete.ap/${authority.id}",--%>
   <%--        success: function (data) {--%>
   <%--            alert(data.message);--%>
   <%--            var form = document.authorityForm;--%>
   <%--            form.action = '/Authority/list.ap';--%>
   <%--            form.submit();--%>

   <%--        },--%>
   <%--        error: function () {--%>
   <%--            alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');--%>
   <%--        }--%>
   <%--    });--%>
   <%--});--%>


</script>

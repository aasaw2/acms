<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page pageEncoding="UTF-8"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<%--<script src="https://code.jquery.com/jquery-1.12.4.js"></script>--%>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $( function() {
    var dialog, form,

    // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
    emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,

    tips = $( ".validateTips" );


    function addUser() {
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
        addUser();
        });

        $( "#selectSort" ).button().on( "click", function() {
            dialog.dialog( "open" );
        });

        $("#menuListTable tr").click(function() {
        var str = ""
        var tdArr = new Array();    // 배열 선언

        var tr = $(this);
        var td = tr.children();

        td.each(function(i){
           tdArr.push(td.eq(i).text());
        });

        alert(tr.attr("idx")); // 시퀀스
        alert(td.eq(0).text()); //메뉴 ID
        alert(td.eq(1).text()); //메뉴 이름
        $( "#menuName").val(td.eq(1).text());
        $( "#menuId").val(tr.attr("idx"));

        dialog.dialog( "close" );
        });
    } );
</script>

<div id="wrapper">
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    <c:if test="${not empty menuDetail}"> 세부 메뉴 정보 수정 </c:if>
                    <c:if test="${empty menuDetail}"> 세부 메뉴 신규 추가 </c:if>
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
                          <a href="" style="float: right;">메뉴 디테일 리스트로 이동</a>
                      </div>
                    <div class="panel-body">

                        <!-- 모달 팝업 설정 -->
                        <div id="dialog-form" title="Change MenuSort">
<%--                        <p class="validateTips">메뉴 변경 선택</p>--%>
                            <form>
                                <fieldset>
                                    <table class="table" id="menuListTable">
                                    <thead>
                                        <tr>
                                            <th style="display: none">메뉴 ID</th>
                                            <th>메뉴 이름</th>
                                        </tr>
                                    </thead>
                                        <tbody>
                                            <label>상위 메뉴</label>
                                            <c:forEach var="result" items="${menuDetailList}" varStatus="status">
                                                <tr id="update_${result.menuId}" idx="${result.menuId}">
                                                <td style="display: none"><c:out value="${result.menuId}"/></td>
                                                <td><c:out value="${result.menuName}"/></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                        </div>

                        <div class="row">
                         <div class="col-lg-6">
                            <form role="form" id="menuDetailForm" name="menuDetailForm" >
                                <div class="form-group">

                                <label>메뉴 이름</label>
                                <input  class="form-control" type="text" name="menuSubName" id="menuSubName" value="${menuDetail.menuSubName}">
                                <p class="help-block">Example block-level help text here.</p>

                                <label>메뉴 URL</label>
                                <input class="form-control" name="menuSubLink" id="menuSubLink" value="${menuDetail.menuSubLink}">
                                <p class="help-block">Example block-level help text here.</p>



                                <label>메뉴 정렬 순서</label>
                                <input  class="form-control" type="text" name="menuSubSort" id="menuSubSort" value="${menuDetail.menuSubSort}">
                                <p class="help-block">Example block-level help text here.</p>

                                <label>상위 메뉴</label>
                                <input  class="form-control" type="text" name="" id="menuName" value="${menuDetail.menu.menuName}">
                                <input type="hidden" name="menuId" id="menuId" value="${menuDetail.menu.menuId}">
                                <button type="button" id="selectSort">상위 메뉴 변경</button>
                                <p class="help-block">Example block-level help text here.</p>

                                </div>
                            <button type="button" id="menuDetailInsert" style="float: right;">저장</button>
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

    $('#menuDetailInsert').on('click', function() {
        var cmd = "${menuDetail.cmd}";
        alert("cmd:"+cmd);
        var url;
        if(cmd == 'update') {
        url = '/menu/detailupdate/${menuDetail.menu.menuId}';
        alert("업데이트 접근 :"+url);
        }
        else {
        url = '/menu/detailcreate';
        alert("신규생성 접근:"+url);
        }

        var menuSubName = $("#menuSubName").val();
        var menuSubLink = $("#menuSubLink").val();
        var menuId = $("#menuId").val();
        var menuSubSort = $("#menuSubSort").val();
        // var ex = menuId.slice(0,1);

        if(menuSubSort == 0) {
            alert("순서는 숫자 1부터 입력 가능합니다.");
        } else{


        var obj ={};
        obj.menuSubName = menuSubName;
        obj.menuSubLink = menuSubLink;
        obj.menuId = menuId;
        obj.menuSubSort = menuSubSort;
        alert("obj.menuId:"+obj.menuId);


        $.ajax({
        type: "POST",
        url: url,
        contentType :'application/json',
        data: JSON.stringify(obj),
        success: function() {
        alert("등록 완료");
        var form = document.menuDetailForm;
        form.action = history.back();
        },
        error: function(xhr, status, error){
        console.log(xhr)
        alert("문제가 발생했습니다 \n 개발팀에 문의 바랍니다.");
        alert(url);
        }

        });
        }
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

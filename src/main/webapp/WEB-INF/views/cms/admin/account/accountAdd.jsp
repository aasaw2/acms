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

        dialog = $( "#dialog-form-authority" ).dialog({
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

        $( "#create-user-authority" ).button().on( "click", function() {
            dialog.dialog( "open" );
        });

        $("#authorityListTable tr").click(function() {
            var str = "";
            var tdArr = new Array();    // 배열 선언

            var tr = $(this);
            var td = tr.children();

            td.each(function(i){
                tdArr.push(td.eq(i).text());
            });

            /*   alert(tr.attr("idx")); // 시퀀스
               alert(td.eq(0).text()); //부서코드
               alert(td.eq(1).text()); //부서이름*/
            $( "#authorityName").val(td.eq(1).text());
            $( "#authorityId").val(tr.attr("idx"));

            dialog.dialog( "close" );
        });
    } );
</script>

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

        $( "#create-user" ).button().on( "click", function() {
            dialog.dialog( "open" );
        });

        $("#divisionListTable tr").click(function() {
            var str = "";
            var tdArr = new Array();    // 배열 선언

            var tr = $(this);
            var td = tr.children();

            td.each(function(i){
                tdArr.push(td.eq(i).text());
            });

            /*   alert(tr.attr("idx")); // 시퀀스
               alert(td.eq(0).text()); //부서코드
               alert(td.eq(1).text()); //부서이름*/
            $( "#divisionName").val(td.eq(1).text());
            $( "#divisionId").val(tr.attr("idx"));

            dialog.dialog( "close" );
        });
    } );
</script>
<%--<style>
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
</style>--%>

<div id="wrapper">
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">사용자 추가</h1>
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


                        <div id="dialog-form" title="Create DivisionWithUser">
                            <p class="validateTips">All form fields are required.</p>
                            <form>
                                <fieldset>
                                    <table class="table" id="divisionListTable">
                                        <thead>
                                        <tr>
                                            <th>부서 코드123</th>
                                            <th>부서 이름456</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="result" items="${divisionList}" varStatus="status">
                                            <tr id="update_${result.id}" idx="${result.id}">
                                                <td><c:out value="${result.divisionCode}"/></td>
                                                <td><c:out value="${result.divisionName}"/></td>
                                            </tr>
                                        </c:forEach>

                                        <c:if test="${resultList.totalElements == 0}" >
                                            <tr>
                                                <td colspan="5">등록된 데이터가 없습니다.</td>
                                            </tr>
                                        </c:if>

                                        <%--   <c:if test="${authorityLists.size() == 0}" >--%>

                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                        </div>

                        <div id="dialog-form-authority" title="Create authorityWithUser">
                            <p class="validateTips">All form fields are required.</p>
                            <form>
                                <fieldset>
                                    <table class="table" id="authorityListTable">
                                        <thead>
                                        <tr>
                                            <th>권한 코드</th>
                                            <th>권한 이름</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="result" items="${authorityList}" varStatus="status">
                                            <tr id="update_${result.id}" idx="${result.id}">
                                                <td><c:out value="${result.name}"/></td>
                                                <td><c:out value="${result.name}"/></td>
                                            </tr>
                                        </c:forEach>

                                        <c:if test="${resultList.totalElements == 0}" >
                                            <tr>
                                                <td colspan="5">등록된 데이터가 없습니다.</td>
                                            </tr>
                                        </c:if>

                                        <%--   <c:if test="${authorityLists.size() == 0}" >--%>

                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                        </div>

                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="accountAddForm" name="accountAddForm" >
                                    <div class="form-group">
                                        <label>email</label>
                                        <input  class="form-control" type="text" name="email" id="email"  <c:if test="${account.cmd eq 'update'}">readonly </c:if>value="${account.email}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>password</label>
                                        <input class="form-control" name="password" id="password" type="password">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>이름</label>
                                        <input class="form-control" name="accountName" id="accountName" value="${account.accountName}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>부서 등록</label>
                                        <input readonly class="form-control" name="divisionName" id="divisionName" value="${account.division.divisionName}">
                                        <input type="hidden" name="divisionId" id="divisionId" value="${account.division.id}">
                                        <button type="button" id="create-user">Create DivisionWithUser</button>
                                        <br>
                                        <br>
                                        <label>권한 등록</label>
                                        <input readonly class="form-control" name="authorityName" id="authorityName" value="${account.authority.name}">
                                        <input type="hidden" name="authorityId" id="authorityId" value="${account.authority.id}">
                                        <button type="button" id="create-user-authority">Create AuthorityWithUser</button>

                                    </div>
                                    <button type="button" id="AccountSubmit">저장</button>
                                    <button type="button" id="AccountDelete">삭제</button>
                                </form>
                                </br>

                                <p>

                                </p>
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



    $('#AccountSubmit').on('click', function() {
        var cmd = "${account.cmd}";
        var formData = $("form[name=accountAddForm]").serialize();
        var url;

        if(cmd == 'update') {
            url = '/admin/Account/UpdateMemperProcessing/${account.id}';
        } else {
            url = '/admin/Account/JoinMemberProcessing';
        }
        $.ajax({
            type: "POST",
            url: url,
            data: formData,
            success: function(data) {
                alert("등록되었습니다.");
                var form = document.accountAddForm;
                form.method="get";
                form.action = '/admin/Account/list';
                form.submit();
            },
            error: function(request, status, error){
                alert("문제가 발생했습니다 \n 개발팀에 문의 바랍니다.");
                alert("code:"+request.status+"\n"+" url : " + url +"\n" +"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
    });

    $('#AccountDelete').on('click', function() {
        $.ajax({
            type: "POST",
            url: "/admin/Account/DeleteAccountMember.ap/${account.id}",
            success: function () {
                alert("삭제 되었습니다.");
                var form = document.accountAddForm;
                form.action = '/admin/Account/list';
                form.submit();
            },
            error: function () {
                alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');
            }
        });
    });

</script>

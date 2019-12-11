<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    // var create_set = new Set();
    // var read_set = new Set();
    // var update_set = new Set();
    // var delete_set = new Set();
    var create_arr = new Array();
    var read_arr = new Array();
    var update_arr = new Array();
    var delete_arr = new Array();
    $(function () {
        var dialog, form,

            // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
            emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,

            tips = $(".validateTips");


        dialog = $("#dialog-form-menu").dialog({
            autoOpen: false,
            height: 400,
            width: 600,
            modal: true,
            buttons: {
                Update: function () {
                    check();
                    dialog.dialog("close");
                },
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
        });

        $("#create-restriction").button().on("click", function () {
            dialog.dialog("open");
        });

        $("#restrictionMenuListTable tr").click(function () {
            var str = "";
            var tdArr = new Array();    // 배열 선언

            var tr = $(this);
            var td = tr.children();

            td.each(function (i) {
                tdArr.push(td.eq(i).text());
            });

            $("#menuName").val(td.eq(1).text());
            $("#menuId").val(tr.attr("idx"));

        });
    });

    function checkedCheckBox() {

    }

    function check() {
        var check_create = document.getElementsByName('chk_create');
        var check_read = document.getElementsByName('chk_read');
        var check_update = document.getElementsByName('chk_update');
        var check_delete = document.getElementsByName('chk_delete');

        var int_j = 0;
        var int_read = 0;
        var int_update = 0;
        var int_delete = 0;
        for (var i = 0; i < check_create.length; i++) {
            if (check_create[i].checked == true) {
                var parse_create = check_create[i].id.slice(7);
                create_arr.push(parse_create);
                int_j++;
            }
        }
        for (var i = 0; i < check_read.length; i++) {
            if (check_read[i].checked == true) {
                var parse_read = parser(check_read[i].id, "read");
                read_arr.push(parse_read);
                int_read++;
            }
        }
        for (var i = 0; i < check_update.length; i++) {
            if (check_update[i].checked == true) {
                var parse_update = parser(check_update[i].id, "update");
                update_arr.push(parse_update);
                int_update++;
            }
        }
        for (var i = 0; i < check_delete.length; i++) {
            if (check_delete[i].checked == true) {
                var parse_delete = parser(check_delete[i].id, "delete");
                delete_arr.push(parse_delete);
                int_delete++;
            }
        }
        $('#create_check').val(create_arr);
        $('#read_check').val(read_arr);
        $('#update_check').val(update_arr);
        $('#delete_check').val(delete_arr);

    }

    function parser(str, str2) {
        if (str2 == "read") {
            return str.slice(5);
        } else {
            return str.slice(7);
        }
    }



</script>
<div id="wrapper">
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">권한 추가</h1>
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

                        <div id="dialog-form-menu" title="Add Menu">
                            <p class="validateTips">All form fields are required.</p>
                            <form>
                                <fieldset>
                                    <table class="table" id="restrictionMenuListTable">
                                        <thead>
                                        <tr>
                                            <th>메뉴 번호</th>
                                            <th>메뉴 이름</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="result" items="${resultList}" varStatus="status">
                                            <tr id="update_${result.menuSubId}" idx="${result.menuSubId}">
                                                <td><c:out value="${result.menuSubId}"/></td>
                                                <td><c:out value="${result.menuSubName}"/></td>
                                                <td><input type="checkbox" class="chk_create" name="chk_create"
                                                           id="create_${result.menuSubId}" value="">Create
                                                </td>
                                                <td><input type="checkbox" class="chk_read" name="chk_read"
                                                           id="read_${result.menuSubId}" value="">Read
                                                </td>
                                                <td><input type="checkbox" class="chk_update" name="chk_update"
                                                           id="update_${result.menuSubId}" value="">Update
                                                </td>
                                                <td><input type="checkbox" class="chk_delete" name="chk_delete"
                                                           id="delete_${result.menuSubId}" value="">Delete
                                                </td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                        </div>

                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" id="authorityForm" name="authorityForm">
                                    <div class="form-group">
                                        <label>권한코드</label>
                                        <input class="form-control" type="text" name="authorityCode" id="authorityCode"
                                               value="${authority.authorityCode}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>권한이름</label>
                                        <input class="form-control" name="name" id="name" value="${authority.name}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>권한 url</label>
                                        <input class="form-control" name="authorityUrl" id="authorityUrl"
                                               value="${authority.authorityUrl}">
                                        <p class="help-block">Example block-level help text here.</p>

                                        <label>메뉴 등록</label>
                                        <input readonly class="form-control" name="authorityGroupName"
                                               id="authorityGroupName" value="">
                                        <button type="button" id="create-restriction">Add Authority</button>

                                        <input type="hidden" name="create_chk" id="create_check" value="">
                                        <input type="hidden" name="read_chk" id="read_check" value="">
                                        <input type="hidden" name="update_chk" id="update_check" value="">
                                        <input type="hidden" name="delete_chk" id="delete_check" value="">
                                    </div>
                                    <button type="button" id="authorityInsert">저장</button>

                                    <button type="button" id="authorityDelete">삭제</button>
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
<script language="JavaScript">

    var cmd = "${authority.cmd}";
    $('#authorityInsert').on('click', function () {
        alert("아이고....");
        var name = $('#name').val();
        var authorityCode = $('#authorityCode').val();
        var authorityUrl = $('#authorityUrl').val();
        var createValue = $('#create_check').val();
        var readValue = $('#read_check').val();
        var updateValue = $('#update_check').val();
        var deleteValue = $('#delete_check').val();

        alert("함 보자");
        alert(createValue);
        alert(readValue);
        alert(updateValue);
        alert(deleteValue);

        var obj = {};
        obj.name = name;
        obj.authorityCode = authorityCode;
        obj.authorityUrl = authorityUrl;
        obj.create = createValue;
        obj.read = readValue;
        obj.update = updateValue;
        obj.delete = deleteValue;
        var url = "";
        var type = "";
        if (cmd == "update") {
            alert("rid working");
            url = "/admin/Authority/update/" + '${authority.id}';
            type = "PUT";
        } else {
            url = "/admin/Authority/write";
            type = "POST";
        }
        $.ajax({
            type: type,
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(obj),
            success: function () {
                alert("save data");
                window.location.href = "/admin/Authority/list";
            }, error: function (xhr) {
                console.log(xhr);
                alert("error")
            }
        })
    });

    $('#authorityDelete').on('click', function () {
        $.ajax({
            type: "DELETE",
            dataType: 'json',
            url: "/Authority/delete/${authority.id}",
            success: function () {
                alert("삭제 성공했습니다.");
                var form = document.authorityForm;
                form.action = '/admin/Authority/list';
                form.submit();

            },
            error: function () {
                alert('시스템 장애가 발생 하였습니다 :D\n개발팀에 문의 하세요');
            }
        });
    });

    <%--var tdArr = new Array();    // 배열 선언--%>
    <%--var tdReArr = new Array();--%>
    <%--var val;--%>
    <%--<c:forEach items="${resultList}" var="item">--%>
    <%--val ="${item.restrictionMenus.name}";--%>
    <%--alert(val);--%>
    <%--tdArr.push(val);--%>
    <%--console.debug("${item.id}");--%>
    <%--</c:forEach>--%>

    <%--$('#authorityGroupName').val(tdArr);--%>
</script>

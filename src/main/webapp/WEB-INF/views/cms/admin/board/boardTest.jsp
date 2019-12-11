<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-08-16
  Time: 오후 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
    <div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <h1>작성</h1>
                <div id="boardWriterWrapper">
                    <form id="boardWrite">
                        Name : <INPUT TYPE='TEXT' NAME="name" id="name" SIZE=60><br>
                        Description : <INPUT TYPE='TEXT' id="description" NAME="description" SIZE=60><br>
                        USE_YN : <INPUT TYPE='TEXT' NAME="use_yn" id="use_yn" SIZE=60><br>
                        REG_USER : <INPUT TYPE='TEXT' NAME="reg_user" id="reg_user" SIZE=60><br>
<%--                        자동으로 현재 시간 나올 수 있게--%>
<%--                        DATETIME : <INPUT TYPE='TEXT' NAME="datetime" SIZE=60><br>--%>

                        <button type="submit" id="testBtn" value="click">버튼</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script language="JavaScript">
        $('#testBtn').click(function (e) {
            e.preventDefault();
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth()+1
            var day = date.getDate();
            if(month < 10){
                month = "0"+month;
            }
            if(day < 10){
                day = "0"+day;
            }
            var today = year+""+month+""+day;

            var obj = {};
            obj.name = $('#name').val();
            obj.description = $('#description').val();
            obj.useYn = $('#use_yn').val();
            obj.regUser = $('#reg_user').val();
            obj.date = today;
            JSON.stringify(obj);
            var url = "/boardTest";
            $.ajax({
                type: 'post',
                url: url,
                data: JSON.stringify(obj),
                contentType: 'application/json',
                success: function (data) {
                    alert('success');
                    console.log(data);
                }, error : function (xhr) {
                    console.log(xhr);
                    alert("error");
                }
            });
            alert("버튼 클릭")
        })
    </script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: JH
  Date: 2019-08-27
  Time: 오전 10:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">게시판 생성</h1>
        </div>
    </div>
    <div class="row">
        <!-- /.col-lg-12 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    게시판 유형 선택
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                            <input type="radio" id="select1" name="radio" value="0" checked="checked"> 자유게시판 형식<br>
                        <div class="box on">
                        <img id="board1" src='<c:url value="/resources/images/test.PNG"></c:url>' style="display: none" /><br>
                            <input type="radio" id="select2" name="radio" value="1"> Q&A 게시판 형식<br>
                        <img id="board2" src='<c:url value="/resources/images/test2.PNG"></c:url>' style="display: none"/>
                        </div>
                    </div>
                    <input id="selectBnt" class="button" type="button" value="생성" style="float: right;" />
                </div>
                <!-- panel-heading -->
            </div>
        </div>
    </div>
</div>


<%--<%@ page pageEncoding="UTF-8"%>--%>
<script>

    $(document).ready(function(){
        // 라디오버튼 클릭시 이벤트 발생
        $("input:radio[name=radio]").click(function(){

            if($("input[name=radio]:checked").val() == "0"){
                $("input:text[name=text]").attr("disabled",false);
                // radio 버튼의 value 값이 1이라면 활성화
                $('#board1').show();
                $('#board2').hide();
            }else if($("input[name=radio]:checked").val() == "1"){
                $("input:text[name=text]").attr("disabled",true);
                // radio 버튼의 value 값이 0이라면 비활성화
                $('#board2').show();
                $('#board1').hide();
            }
        });
    });



    $("#selectBnt").click(function(){

        var radioVal = $('input[name="radio"]:checked').val();

        if(radioVal == 0)
        {
            window.location.href = "/genarate/commonBoard";
            alert("자유게시판 형식으로 생성");
        }
        else {

            window.location.href = "/genarate/qnaBoard";
            alert("Q&A 게시판 형식으로 생성");
        }

    });

</script>
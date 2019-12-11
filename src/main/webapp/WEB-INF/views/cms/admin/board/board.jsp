<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-08-09
  Time: 오후 7:16
  To change this template use File | Settings | File Templates.
--%>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
    <link href="/resources/css/board/board.css" rel="stylesheet">
</head>
<!-- Morris Charts CSS -->
<body>
<div id="wrapper">
    <div id="mainWrapper">
        <div id="page-wrapper">
            <div class="row">
                <h1>게시판 만들기</h1>
                <div id="boardWrapper">
                    <div class="boardWrapperTop">
                        <div id="boardHeader">
                            <div id="boardHeaderFront">
                                <div id="boardHeaderFrontWidthCenter">
                                    <div id="boardHeaderFrontHeightCenter"></div>
                                </div>
                            </div>
                            <div id="boardHeaderMiddle">
                                <div id="boardHeaderMiddleCenter">
                                    <div id="boardHeaderMiddleHeightCenter"></div>
                                </div>
                            </div>
                            <div id="boardHeaderEnd">
                                <div id="boardHeaderEndCenter">
                                    <div id="boardHeaderEndHeightCenter"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="boardWrapperBody">
                        <div id="boardLeftside">
                            leftside
                        </div>
                        <div id="board_main_content">
                            main
                        </div>
                        <div id="boardRightside">
                            <div id="boardRightOfRightside"></div>
                            rightside
                        </div>
                    </div>
                    <div class="boardWrapperBottom">
                        <div id="boardFooter">
                            <div id="boardFooterFront">
                                <div id="boardFooterFrontCenter">
                                    <div id="boardFooterFrontHeightCenter"></div>
                                </div>
                            </div>
                            <div id="boardFooterMiddle">
                                <div id="boardFootterMiddleTest">
                                    <div id="boardFooterMiddleHeightCenter"></div>
                                </div>
                            </div>
                            <div id="boardFooterEnd">
                                <div id="boardFooterEndCenter">
                                    <div id="boardFooterEndHeightCenter"></div>
                                </div>
                            </div>
                            footer
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="page-footer">
        <div id="row-footer">
            <div>
                File Name : <input type="text" name="dirName" id="dirName"><br>
            </div>
            <input type="submit" class="html_button" value="check">
            </form>

            <div class="empty" id="waiting">
                <div class="fill" id="fill" draggable="true"></div>
                <div class="banner" id="banner" draggable="true"></div>
                <div class="menu" id="menu" draggable="true"></div>
                <div class="a_link" id="a_link" draggable="true" value="facebook">a_link</div>
                <div class="button" id="button" draggable="true">button</div>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/board/board.js"></script>
</body>

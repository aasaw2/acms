<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-08-23
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="/resources/css/authority/customAuthority.css" rel="stylesheet">
</head>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Tables</h1>
        </div>
    </div>
    <div class="row">
        <!-- /.col-lg-6 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Basic Table
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table" id="authorityListTable">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>권한이름</th>
                                <th>코드</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr id="authority_a">
                                <td>1</td>
                                <td>Authority_A</td>
                                <td>sdjfjh2j35nwmsdnf234@!</td>
                                <td><input type="button" class="authority_btn" value="추가"></td>
                            </tr>
                            <tr id="authority_b">
                                <td>2</td>
                                <td>Authority_B</td>
                                <td>sdasdmnfkwjberqub!@#$!</td>
                                <td><input type="button" class="authority_btn" value="추가"></td>
                            </tr>
                            <tr id="authority_c">
                                <td>3</td>
                                <td>Authority_C</td>
                                <td>qwerihosdihfajsdbtknw#!</td>
                                <td><input type="button" class="authority_btn" value="추가"></td>
                            </tr>
                            <tr id="authority_d">
                                <td>4</td>
                                <td>Authority_D</td>
                                <td>qweihtpk$nslfdjkowihel@mb</td>
                                <td><input type="button" class="authority_btn" value="추가"></td>
                            </tr>
                            <tr id="authority_e">
                                <td>5</td>
                                <td>Authority_E</td>
                                <td>asdbfkwjbkjbdujbcmdkf3@31R</td>
                                <td><input type="button" class="authority_btn" value="추가"></td>
                            </tr>
                            <tr id="authority_f">
                                <td>6</td>
                                <td>Authority_F</td>
                                <td>qrwoeimmfmmbkfknlwk32TW@ae</td>
                                <td><input type="button" class="authority_btn" value="추가"></td>
                            </tr>
                            </tbody>
                        </table>
                        </tbody>
                        </table>

                        <div class="fixed-table-pagination C " style="display: block;">
                            <ul class="pagination">
                                <c:if test="${!resultList.first}">
                                    <li class="page-first">
                                        <a href="?page=${resultList.number-1}">&larr;</a>
                                    </li>
                                </c:if>
                                <c:forEach begin="1" end="${resultList.totalPages}" var="i">
                                    <c:choose>
                                        <c:when test="${resultList.number eq i-1}">
                                            <li class="page-number active"><a href="#">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="page-number"><a href="?page=${i-1}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>

                                <c:if test="${!resultList.last}">
                                    <li class="page-last">
                                        <a href="?page=${resultList .number+1}">&rarr;</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>


                    </div>
                    <div class="table-right" id="table-right">
                        <%--                        <table class="table" id="mpa_table">--%>
                        <%--                            <thead>--%>
                        <%--                            <tr>--%>
                        <%--                                <th>참조</th>--%>
                        <%--                                <th>Access</th>--%>
                        <%--                                <th>Create</th>--%>
                        <%--                                <th>Read</th>--%>
                        <%--                                <th>Update</th>--%>
                        <%--                                <th>Delete</th>--%>
                        <%--                            </tr>--%>
                        <%--                            </thead>--%>
                        <%--                            <tbody>--%>
                        <%--                            <tr id="custom_a">--%>
                        <%--                                <td>--%>
                        <%--                                    A.com--%>
                        <%--                                </td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="access" value="Access">Access</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="create" value="Access">Create</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="read" value="Access">Read</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="update" value="Access">Update</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="delete" value="Access">Delete</td>--%>
                        <%--                            </tr>--%>
                        <%--                            <tr id="custom_b">--%>
                        <%--                                <td>--%>
                        <%--                                    B.com--%>
                        <%--                                </td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="access_b" value="Access">Access</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="create_b" value="Access">Create</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="read_b" value="Access">Read</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="update_b" value="Access">Update</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="delete_b" value="Access">Delete</td>--%>
                        <%--                            </tr>--%>
                        <%--                            <tr id="custom_a">--%>
                        <%--                                <td>--%>
                        <%--                                    C.com--%>
                        <%--                                </td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="access_c" value="Access">Access</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="create_c" value="Access">Create</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="read_c" value="Access">Read</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="update_c" value="Access">Update</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="delete_c" value="Access">Delete</td>--%>
                        <%--                            </tr>--%>
                        <%--                            <tr id="custom_a">--%>
                        <%--                                <td>--%>
                        <%--                                    D.com--%>
                        <%--                                </td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="access_d" value="Access">Access</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="create_d" value="Access">Create</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="read_d" value="Access">Read</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="update_d" value="Access">Update</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="delete_d" value="Access">Delete</td>--%>
                        <%--                            </tr>--%>
                        <%--                            <tr id="custom_a">--%>
                        <%--                                <td>--%>
                        <%--                                    E.com--%>
                        <%--                                </td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="access_e" value="Access">Access</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="create_e" value="Access">Create</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="read_e" value="Access">Read</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="update_e" value="Access">Update</td>--%>
                        <%--                                <td><input type="checkbox" name="chk_info" id="delete_e" value="Access">Delete</td>--%>
                        <%--                            </tr>--%>
                        <%--                            <c:forEach var="result" items="${resultList.content}" varStatus="status">--%>
                        <%--                                <tr id="update_${result.id}" idx="${result.id}">--%>
                        <%--                                    <td>--%>
                        <%--                                            ${resultList.totalElements - (resultList.size * resultList.number ) - status.index }--%>
                        <%--                                    </td>--%>
                        <%--                                    <td><c:out value="${result.authorityName}"/></td>--%>
                        <%--                                    <td><c:out value="${result.authorityUrl}"/></td>--%>
                        <%--                                </tr>--%>
                        <%--                            </c:forEach>--%>

                        <%--                            <c:if test="${resultList.totalElements == 0}">--%>
                        <%--                                <tr>--%>
                        <%--                                    <td colspan="5">등록된 데이터가 없습니다.</td>--%>
                        <%--                                </tr>--%>
                        <%--                            </c:if>--%>

                        <%--                            </tbody>--%>
                        <%--                        </table>--%>
                    </div>
                    <!-- /.table-responsive -->
                    <input id="authoritySave" class="btn btn-lg btn-success btn-block" type="button" value="등록"/>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>

</div>
<!-- /.row -->

<script type="text/template" id="mpa_html">
    <tbody>
    <table class="table" id="mpa_table">
        <thead>
        <tr>
            <th>참조</th>
            <th>Access</th>
            <th>Create</th>
            <th>Read</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <tr id="custom_a">
            <td>
                A.com
            </td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="access" value="access_a">Access</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="create" value="create_a">Create</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="read" value="read_a">Read</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="update" value="update_a">Update</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="delete" value="delete_a">Delete</td>
        </tr>
        <tr id="custom_b">
            <td>
                B.com
            </td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="access_b" value="access_b">Access</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="create_b" value="create_b">Create</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="read_b" value="read_b">Read</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="update_b" value="update_b">Update</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="delete_b" value="delete_b">Delete</td>
        </tr>
        <tr id="custom_c">
            <td>
                C.com
            </td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="access_c" value="access_c">Access</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="create_c" value="create_c">Create</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="read_c" value="read_c">Read</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="update_c" value="update_c">Update</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="delete_c" value="delete_c">Delete</td>
        </tr>
        <tr id="custom_d">
            <td>
                D.com
            </td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="access_d" value="access_d">Access</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="create_d" value="create_d">Create</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="read_d" value="read_d">Read</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="update_d" value="update_d">Update</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="delete_d" value="delete_d">Delete</td>
        </tr>
        <tr id="custom_e">
            <td>
                E.com
            </td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="access_e" value="access_e">Access</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="create_e" value="create_e">Create</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="read_e" value="read_e">Read</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="update_e" value="update_e">Update</td>
            <td><input type="checkbox" class="chk_info" name="chk_info" id="delete_e" value="delete_e">Delete</td>
        </tr>
        </tbody>
    </table>
</script>
<script src="/resources/js/authority/customList.js"/>

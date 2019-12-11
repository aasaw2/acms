<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<tiles:importAttribute name="leftMenu"/>
<tiles:importAttribute name="managerLevel"/>
<div class="page-sidebar-wrapper">
    <div class="page-sidebar navbar-collapse collapse">
        <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true"
            data-slide-speed="200" style="padding-top: 20px">
            <li class="sidebar-toggler-wrapper hide">
                <div class="sidebar-toggler">
                    <span></span>
                </div>
            </li>
            <c:forEach var="lm" items="${sessionScope.leftMenu}" varStatus="status">
                <li id="menu${lm.menuGroup}" class="nav-item  ">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="icon-puzzle"></i>
                        <span class="title">${lm.menuName}</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <c:forEach var="lmd" items="${lm.menuDetails}" varStatus="status">
                            <li id="menu${lmd.menuSubGroup}sub${lmd.menuSubSort}" class="nav-item  ">
                                <a href="${lmd.menuSubLink}" class="nav-link ">
                                    <span class="title">${lmd.menuSubName}</span>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>
    </div>
    <!-- END SIDEBAR -->
</div>
<script language="javascript">
    $('.nav-item').click(function (e) {
        e.preventDefault();
        alert("success");
    })
</script>
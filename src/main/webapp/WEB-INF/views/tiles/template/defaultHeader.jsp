<%@ page pageEncoding="UTF-8"%>
<form action="/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="로그아웃" />
</form>



<%--<form action="/Generator/a/test">--%>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
<%--    <input type="submit" value="Generator" />--%>
<%--</form>--%>

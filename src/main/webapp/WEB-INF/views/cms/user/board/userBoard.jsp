<%--
  Created by IntelliJ IDEA.
  User: kimda
  Date: 2019-09-25
  Time: 오후 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/views/tiles/template/user/userDefaultHeader.jsp" flush="false" />
<jsp:include page="${jsp}" flush="false"/>
<script src="/resources/js/board/customTemplate.js"></script>
<script src="/resources/css/assets/js/jquery.min.js"></script>
<script src="/resources/css/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/js/board/userBoardTemplate.js"></script>
<%--
  Created by IntelliJ IDEA.
  User: JH
  Date: 2019-09-23
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    request.setCharacterEncoding("UTF-8");
    String t_num = request.getParameter("t_num");
    String t_subject = request.getParameter("t_subject");
    String t_name = request.getParameter("t_name");
    String t_date = request.getParameter("t_date");
    String t_searchnumber = request.getParameter("t_searchnumber");

%>

<%= t_num%>
<%= t_name%>
<%= t_subject%>
<%= t_date%>
<%= t_searchnumber%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

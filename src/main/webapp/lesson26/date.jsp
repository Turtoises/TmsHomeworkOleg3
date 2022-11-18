<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 03.10.2022
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Date user</title>
</head>
<body>

<h1>Check your information:</h1>
<p>First name: ${param.userfirstname}</p>
<p>Last name: ${param.userlastname}</p>
<p>Identification number: ${param.usernumber}</p>
<p><u>Your courses:</u></p>

<%
    String[] userCourses=request.getParameterValues("courses");
    for(String course:userCourses){
        out.println("<li><b>" + course + "</b></li>");
    }
%>

</body>
</html>

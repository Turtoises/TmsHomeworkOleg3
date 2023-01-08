<%@ page import="by.tms.tmsmyproject.utils.Constants" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%
    pageContext.setAttribute("path", Constants.URI_FRONT_CONTROLLER_SERVLET);
    pageContext.setAttribute("command", Constants.PARAMETER_COMMAND);
    pageContext.setAttribute("namecommand", Constants.COMMAND_CREATE_USER);
%>


<h1><%= "Hello World!" %>

    ${pageScope.namecommand}

</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>
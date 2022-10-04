<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 04.10.2022
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>

<h3 align="center"><u>Enrollment form</u></h3>
<form action="/delete/user" method="post">
    <fieldset>
        <legend align="center">User date</legend>
        First name<br>
        <input type="text" name="userfirstname" required>
        <br><br>
        Last name<br>
        <input type="text" name="userlastname" required>
        <br><br>
        Identification number<br>
        <input type="text" name="usernumber" required>
    </fieldset>
    <br><br>
    <button type="submit">Enter</button>
    <button type="reset">Cancel</button>
</form>

<%
    ServletContext servletContext = request.getServletContext();
    String isDelete = (String) servletContext.getAttribute("delete");
    if (isDelete != null) {
        if (isDelete.equals("true")) {
            out.println("<h1><mark>The previous removal was successful</mark></h1>");
        } else if (isDelete.equals("false")) {
            out.println("<h1><mark>User not found</mark></h1>");
        }
    }

%>

</body>
</html>

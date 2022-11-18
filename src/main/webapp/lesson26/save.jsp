<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 03.10.2022
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form for user</title>
</head>
<body>

<h3 align="center"><u>Enrollment form</u></h3>
<form action="/save/form" method="post">
    <fieldset>
        <legend align="center">User date</legend>
        First name<br>
        <input type="text" name="userfirstname">
        <br><br>
        Last name<br>
        <input type="text" name="userlastname">
        <br><br>
        Identification number<br>
        <input type="text" name="usernumber">
    </fieldset>
    <br><br>
    <br>
    <fieldset>
        <legend align="center">Programming languages</legend>
        <input type="checkbox" name="courses" value="Java">Java
        <input type="checkbox" name="courses" value="Python">Python
        <input type="checkbox" name="courses" value="C++">C++
        <input type="checkbox" name="courses" value="JavaScript">JavaScript
        <input type="checkbox" name="courses" value="PHP">PHP
    </fieldset>
    <br><br>

    <button type="submit">Enter</button>
    <button type="reset">Cancel</button>
    <br><br>
</form>
<%
    List<String> listError=(List<String>)request.getAttribute("error");
    if (listError!=null && listError.size()!=0){
        out.println("<h1><mark>ERROR</mark></h1>");
        for(String error:listError){
            out.println("<h2><mark>"+error+"</mark></h1>");
        }
    }
%>

</body>
</html>

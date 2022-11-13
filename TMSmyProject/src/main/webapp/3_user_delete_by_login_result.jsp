<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 12.11.2022
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="3_result_config/result.css">
    <title>Delete user by login and password result</title>
</head>

<body>

<div class="alert alert-info text-center" role="alert">
    <h1>Result of <span class="badge text-bg-danger">deleting</span> a user</h1>
</div>
<br>
<br>

<c:if test="${user!=null}">
    <h1 align="center">User with login <span class="text-bg-info">${user.login}</span> deleted</h1>
</c:if>

<c:if test="${user==null}">
    <h1 align="center">${requestScope.delete_user_by_login}</h1>
</c:if>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>

</body>
</html>

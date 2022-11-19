<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 17.11.2022
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/"3_result_config/result.css">
    <title>Delete user by id result</title>
</head>
<body>

<div class="alert alert-info text-center" role="alert">
    <h1>Result of <span class="badge text-bg-danger">deleting</span> a user</h1>
</div>
<br>
<br>

<c:if test="${result.valid eq true}">

    <h1>User with login ${result.user.login} and id=${result.user.id} is deleted</h1>

</c:if>

<c:if test="${result.valid eq false}">

    <h3>You have some problems:</h3>

    <c:forEach var="message" items="${result.message}">
        <h3>${message}</h3>
    </c:forEach>

</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 09.10.2022
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Exception</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>

<c:if test="${exception.equals('listempty')}">
    <div class="alert alert-warning" role="alert">
        List of user is <span class="badge text-bg-warning">empty</span>
    </div>
</c:if>

<c:if test="${exception.equals('usernotfound')}">
    <div class="alert alert-warning" role="alert">
        Users for your query were <span class="badge text-bg-warning">not found</span>
    </div>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>

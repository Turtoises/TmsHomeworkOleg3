<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 03.10.2022
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add user result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-3">

            <div class="alert alert-success" role="alert">
                User has been deleted successfully
            </div>
            <br>
            <div class="alert alert-info" role="alert">
                Check the data
            </div>
            <p>First name:<span class="badge text-bg-info">${deleteduser.firstName}</span></p>
            <p>Last name:<span class="badge text-bg-info">${deleteduser.lastName}</span></p>
            <p>Status:<span class="badge text-bg-info">${deleteduser.status.value}</span></p>
            <p>Own number:<span class="badge text-bg-info">${deleteduser.initNumber}</span></p>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>

</body>
</html>

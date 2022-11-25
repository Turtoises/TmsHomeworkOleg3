<%@ page import="by.tms.tmsmyproject.utils.Constants" %><%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 05.11.2022
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="2_form_config/form.css">
    <title>Delete user by login and password</title>
</head>
<body>

<%
    pageContext.setAttribute("path", Constants.URI_FRONT_CONTROLLER_SERVLET);
    pageContext.setAttribute("command", Constants.PARAMETER_COMMAND);
    pageContext.setAttribute("name_command_delete_user_login", Constants.COMMAND_DELETE_USER_BY_LOGIN);
%>
<div class="alert alert-info text-center" role="alert">
    <h1>Please fill out this form to <span class="badge text-bg-danger">delete</span> a user</h1>
</div>
<br>
<div class="container-fluid" id="form">
    <form class="row g-3" action=${pageScope.path} method="post">
        <div class="col-4">
            <label for="validationCustom03" class="form-label">Login</label>
            <input type="text" name="login" pattern="[A-Za-z0-9]+" required class="form-control"
                   id="validationCustom03">
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-4">
            <label for="validationCustom05" class="form-label">Password (5 and more symbol)</label>
            <input type="password" name="password" pattern="[A-Za-z0-9]{5,}" required class="form-control"
                   id="validationCustom05">
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit" name=${pageScope.command} value=${pageScope.name_command_delete_user_login}>
                Submit form
            </button>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>

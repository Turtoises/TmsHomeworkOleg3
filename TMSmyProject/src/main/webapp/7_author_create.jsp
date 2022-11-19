<%@ page import="by.tms.tmsmyproject.utils.Constants" %>
<%@ page import="by.tms.tmsmyproject.utils.ConstantsRegex" %><%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 18.11.2022
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="2_form_config/form.css">
    <title>Author create form</title>
</head>
<body>

<%
    pageContext.setAttribute("path", Constants.URI_FRONT_CONTROLLER_SERVLET);
    pageContext.setAttribute("command", Constants.PARAMETER_COMMAND);
    pageContext.setAttribute("name_command_create_author", Constants.COMMAND_CREATE_AUTHOR);

    pageContext.setAttribute("regexName", ConstantsRegex.NAME_AUTHOR);
%>
<div class="alert alert-info text-center" role="alert">
    <h1>Please fill out this form to <span class="badge text-bg-danger">add</span> a new author</h1>
</div>
<br>
<div class="container-fluid" id="form">
    <form class="row g-3" action=${pageScope.path} method="post">
        <div class="col-md-5">
            <label for="validationCustom01" class="form-label">Name</label>
            <input type="text" name="name" pattern=${pageScope.regexName} required class="form-control" id="validationCustom01">
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-md-5">
            <label for="validationCustom02" class="form-label">Surname</label>
            <input type="text" name="surname" pattern=${pageScope.regexName} required class="form-control"
                   id="validationCustom02">
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <br>
        <div class="col-5">
            <label for="validationCustom05" class="form-label">Year of birth</label>
            <input type="number" name="yearBirth" value="0" required class="form-control"
                   id="validationCustom05">
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-5">
            <label for="validationCustom06" class="form-label">Year of death</label>
            <input type="number" name="yearDeath" value="0" required class="form-control"
                   id="validationCustom06">
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit" name=${pageScope.command} value=${pageScope.name_command_create_author}>
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

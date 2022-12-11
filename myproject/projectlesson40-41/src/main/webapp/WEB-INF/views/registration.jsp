<%@ page import="by.tms.tmsmyproject.utils.Constants" %>
<%@ page import="by.tms.tmsmyproject.utils.ConstantsRegex" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <jsp:include page="units/bootstrap.jsp"/>
    <title>Add user form</title>

</head>
<body>

<%
    pageContext.setAttribute("controllers_mapping", Constants.COMMAND_CREATE_USER);

    pageContext.setAttribute("regexName", ConstantsRegex.NAME_USER);
    pageContext.setAttribute("regexLogin", ConstantsRegex.LOGIN);
    pageContext.setAttribute("regexPassword", ConstantsRegex.PASSWORD);
    pageContext.setAttribute("regexEmail", ConstantsRegex.EMAIL);
%>

<jsp:include page="units/navbar.jsp"/>

<br><br>

<div class="alert alert-info text-center" role="alert">
    <h1>Please fill out this form to <span class="badge text-bg-danger">add</span> a user</h1>
</div>
<br>
<div class="container-fluid" id="form">
    <form:form class="row g-3" action="${pageScope.controllers_mapping}" method="post" modelAttribute="user">
        <form>
            <div class="col-md-4">
                <label for="name">Name</label>
                <form:input path="name" type="text" name="name" pattern="${pageScope.regexName}" id="name"
                            class="form-control"/>
                <form:errors path="name" cssClass="alert alert-danger" element="div"/>
            </div>

            <div class="col-md-4">
                <label for="surname">Surname</label>
                <form:input path="surname" type="text" name="surname" pattern="${pageScope.regexName}" id="surname"
                            class="form-control"/>
                <form:errors path="surname" cssClass="alert alert-danger" element="div"/>
            </div>

            <div class="col-md-4">
                <label for="role">Role</label>
                <form:select path="role" class="form-select" name="role">
                    <form:option selected="User" value="User">User</form:option>
                    <form:option value="MENTOR">Mentor</form:option>
                    <form:option value="Admin">Admin</form:option>
                </form:select>
            </div>

            <div class="col-md-4">
                <label for="login">Login</label>
                <form:input path="login" type="text" name="login" pattern="${pageScope.regexLogin}" id="login"
                            class="form-control"/>
                <form:errors path="login" cssClass="alert alert-danger" element="div"/>
            </div>

            <div class="col-md-4">
                <label for="password">Password</label>
                <form:input path="password" type="password" name="password" pattern="${pageScope.regexPassward}"
                            id="password" class="form-control"/>
                <form:errors path="password" cssClass="alert alert-danger" element="div"/>
            </div>

            <div class="col-md-4">
                <label for="email">Email</label>
                <form:input path="email" type="text" name="email" pattern="${pageScope.regexEmail}" id="email"
                            class="form-control"/>
                <form:errors path="email" cssClass="alert alert-danger" element="div"/>
            </div>

            <div class="col-12">
                <button class="btn btn-primary" type="submit">Submit form</button>
            </div>
        </form>
    </form:form>
</div>

</body>

<jsp:include page="units/footer.jsp"/>

</html>

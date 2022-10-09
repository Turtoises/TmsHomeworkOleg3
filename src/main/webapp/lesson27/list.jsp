<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>

<div class="container-fluid">

    <c:if test="${userlist==null}">
        <div class="alert alert-info text-center" role="alert">
            List of users is <span class="badge bg-secondary">empty</span>
        </div>
    </c:if>

    <c:if test="${userlist!=null}">

        <c:if test="${status.equals('STUDENT')}">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">№</th>
                    <th scope="col">First name</th>
                    <th scope="col">Last name</th>
                    <th scope="col">Status</th>
                    <th scope="col">Own number</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userlist}" varStatus="counter">
                    <c:if test="${(user.status.value).equals('Student')}">
                        <tr>
                            <th scope="row">${counter.count}</th>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.status.value}</td>
                            <td>${user.initNumber}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${status.equals('TEACHER')}">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">№</th>
                    <th scope="col">First name</th>
                    <th scope="col">Last name</th>
                    <th scope="col">Status</th>
                    <th scope="col">Own number</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userlist}" varStatus="counter">
                    <c:if test="${(user.status.value).equals('Teacher')}">
                        <tr>
                            <th scope="row">${counter.count}</th>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.status.value}</td>
                            <td>${user.initNumber}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${status.equals('ALL')}">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">№</th>
                    <th scope="col">First name</th>
                    <th scope="col">Last name</th>
                    <th scope="col">Status</th>
                    <th scope="col">Own number</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userlist}" varStatus="counter">
                    <tr>
                        <th scope="row">${counter.count}</th>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.status.value}</td>
                        <td>${user.initNumber}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>


    </c:if>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>

</body>
</html>

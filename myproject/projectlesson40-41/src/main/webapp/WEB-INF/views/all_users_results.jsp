<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 27.11.2022
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="units/bootstrap.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="units/navbar.jsp"/>
</div>
<br><br>

<c:if test="${users eq null or empty users}">

    <h1>Not users</h1><br>

</c:if>

<c:if test="${users != null and not empty users}">

    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Surname</th>
                <th scope="col">Login</th>
                <th scope="col">Role</th>
                <th scope="col">Email</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.login}</td>
                    <td>${user.role}</td>
                    <td>${user.email}</td>
                    <td><a href="user/delete/${user.id}" class="btn btn-danger" type="button"><i
                            class="fa fa-trash"></i> </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>


</body>
<jsp:include page="units/footer.jsp"/>
</html>

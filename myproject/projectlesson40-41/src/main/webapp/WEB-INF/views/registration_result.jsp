<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 14.11.2022
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <jsp:include page="units/bootstrap.jsp"/>
    <title>Create user result</title>

</head>

<body>

<div class="container">
    <jsp:include page="units/navbar.jsp"/>
</div>

<br><br>

<div class="alert alert-info text-center" role="alert">
    <h1>Result of <span class="badge text-bg-danger">creating</span> a user</h1>
</div>
<br>
<br>

<c:if test="${result.valid eq true}">


    <h1>Dear ${result.user.name} ${result.user.surname}</h1><br>
    <h1>You are registered on the site under the login <span class="text-bg-info">${result.user.login}</span></h1><br>
    <h1>Congratulates</h1><br>

</c:if>

<c:if test="${result.valid eq false}">

    <h3>You have some problems:</h3>

    <c:forEach var="message" items="${result.message}">
        <h3>${message}</h3>
    </c:forEach>

</c:if>

</body>

<jsp:include page="units/footer.jsp"/>

</html>

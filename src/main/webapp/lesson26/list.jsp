<%@ page import="by.tms.lesson26jsp.pojo.UserDate" %>
<%@ page import="java.util.List" %>
<%@ page import="by.tms.lesson26jsp.utils.Contants" %><%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 04.10.2022
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users list</title>
</head>
<body>

<%
    ServletContext servletContext = request.getServletContext();
    List<UserDate> userDates = (List<UserDate>) servletContext.getAttribute(Contants.USER_ATTRIBUTE);
    if (userDates == null || userDates.isEmpty()) {
        out.println("<h1><mark>List is empty</mark></h1>");
    } else {
        for (UserDate userDate : userDates) {
            out.println(
                    "<p>First name:" + userDate.getFirstName() + "</p>" +
                            "<p>Last name:" + userDate.getLastName() + "</p>" +
                            "<p>Identification number:" + userDate.getUserNumber() + "</p>" +
                            "<p><u>Courses:</u></p>");
            for (String cours : userDate.getCourse()){
                out.println("<li><b>"+cours+"</b></li>");
            }
            out.println("-------------------------------------------");
        }
    }

%>

</body>
</html>

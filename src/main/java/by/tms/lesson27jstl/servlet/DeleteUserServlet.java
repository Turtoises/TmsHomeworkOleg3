package by.tms.lesson27jstl.servlet;

import by.tms.lesson27jstl.pojo.UserDate;
import by.tms.lesson27jstl.utils.CollectionUserUtil;
import by.tms.lesson27jstl.utils.Contants;
import by.tms.lesson27jstl.utils.Status;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/user/delete")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = request.getServletContext();

        if (CollectionUserUtil.isUsersListEmptyOrNull(request)) {
            servletContext.setAttribute(Contants.ATTRIBUTE_EXCEPTION, Contants.EXCEPTION_LIST_EMPTY);
            request.getRequestDispatcher("/lesson27/exception.jsp").forward(request, response);
        }

        String firstName = request.getParameter("userfirstname");
        String lastName = request.getParameter("userlastname");
        String statusName = request.getParameter("status");
        long initNumber = Integer.parseInt(request.getParameter("number"));
        Status status = Status.valueOf(statusName);

        UserDate deleteUserDate = new UserDate(firstName, lastName, initNumber, status);

        if (CollectionUserUtil.deleteUserIntoServer(deleteUserDate, request)) {
            request.getRequestDispatcher("/lesson27/deleteresult.jsp").forward(request, response);
        } else {
            servletContext.setAttribute(Contants.ATTRIBUTE_EXCEPTION, Contants.EXCEPTION_USER_NOT_FOUND);
            request.getRequestDispatcher("/lesson27/exception.jsp").forward(request, response);
        }


    }
}

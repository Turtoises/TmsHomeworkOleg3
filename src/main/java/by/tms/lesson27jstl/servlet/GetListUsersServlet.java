package by.tms.lesson27jstl.servlet;

import by.tms.lesson27jstl.utils.CollectionUserUtil;
import by.tms.lesson27jstl.utils.Contants;
import by.tms.lesson27jstl.utils.Status;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetListUsersServlet", value = "/get/information")
public class GetListUsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = request.getServletContext();

        if (CollectionUserUtil.isUsersListEmptyOrNull(request)) {
            servletContext.setAttribute(Contants.ATTRIBUTE_EXCEPTION, Contants.EXCEPTION_LIST_EMPTY);
            request.getRequestDispatcher("/lesson27/exception.jsp").forward(request, response);
        }

        String statusName = request.getParameter("status");

        if (statusName.equals("ALL")) {
            servletContext.setAttribute(Contants.ATTRIBUTE_STATUS, statusName);
            request.getRequestDispatcher("/lesson27/list.jsp").forward(request, response);
        }

        Status status = Status.valueOf(statusName);

        if (CollectionUserUtil.isUserThisStatus(request, status)) {
            servletContext.setAttribute(Contants.ATTRIBUTE_STATUS, statusName);
            request.getRequestDispatcher("/lesson27/list.jsp").forward(request, response);
        } else {
            servletContext.setAttribute(Contants.ATTRIBUTE_EXCEPTION, Contants.EXCEPTION_USER_NOT_FOUND);
            request.getRequestDispatcher("/lesson27/exception.jsp").forward(request, response);
        }
    }
}

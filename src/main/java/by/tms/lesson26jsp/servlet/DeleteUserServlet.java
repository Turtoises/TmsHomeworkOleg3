package by.tms.lesson26jsp.servlet;

import by.tms.lesson26jsp.pojo.UserDate;
import by.tms.lesson26jsp.utils.Contants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DeleteUserServlet", value = "/delete/user")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        if (isDeleteUser(request)) {
            servletContext.setAttribute("delete", "true");
        } else {
            servletContext.setAttribute("delete", "false");
        }
        request.getRequestDispatcher("/lesson26/delete.jsp").forward(request, response);
    }

    private boolean isDeleteUser(HttpServletRequest request) {
        String firstName = request.getParameter("userfirstname");
        String lastName = request.getParameter("userlastname");
        String userNumber = request.getParameter("usernumber");

        List<UserDate> userDate = (List) getServletContext().getAttribute(Contants.USER_ATTRIBUTE);
        boolean isDelete = userDate.remove(new UserDate(firstName, lastName, userNumber, null));

        if (isDelete) {
            getServletContext().setAttribute(Contants.USER_ATTRIBUTE, userDate);
        }

        return isDelete;
    }
}

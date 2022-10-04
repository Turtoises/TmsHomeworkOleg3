package by.tms.lesson26jsp.servlet;

import by.tms.lesson26jsp.pojo.UserDate;
import by.tms.lesson26jsp.utils.Contants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FormServlet", value = "/save/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> errorMessage = getErrorMessage(request);

        if (errorMessage.size() == 0) {
            request.getRequestDispatcher("/lesson26/date.jsp").forward(request, response);
        } else {
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("/lesson26/save.jsp").forward(request, response);
        }
    }

    private List<String> getErrorMessage(HttpServletRequest request) {
        String firstName = request.getParameter("userfirstname");
        String lastName = request.getParameter("userlastname");
        String userNumber = request.getParameter("usernumber");
        String[] course = request.getParameterValues("courses");
        List<String> errorMessage = new ArrayList<>();

        if (firstName.isEmpty()) {
            errorMessage.add("NO first name");
        }
        if (lastName.isEmpty()) {
            errorMessage.add("NO Last name");
        }
        if (userNumber.isEmpty()) {
            errorMessage.add("NO identification number");
        }
        if (course == null) {
            errorMessage.add("NO programming languages");
        }

        if (errorMessage.size() == 0) {
            List<UserDate> userDate = (List) getServletContext().getAttribute(Contants.USER_ATTRIBUTE);
            userDate.add(new UserDate(firstName, lastName, userNumber, course));
            getServletContext().setAttribute(Contants.USER_ATTRIBUTE, userDate);
        }
        return errorMessage;
    }
}

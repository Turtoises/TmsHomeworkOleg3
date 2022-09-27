package by.tms.lesson24.task1.servlet;

import by.tms.lesson24.task1.UseList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletFormWriter", value = "/form/writer")
public class ServletFormWriter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("userfirstname");
        String lastName = request.getParameter("userlastname");
        String language = request.getParameter("userlanguage");
        String gender = request.getParameter("gender");
        String[] programmingLanguage = request.getParameterValues("courses");
        String additionalInformation = request.getParameter("information");
        String password = request.getParameter("password");

        UseList.addUserIntoList(firstName, lastName, language, gender,
                programmingLanguage, additionalInformation, password);

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<html><h3>Successful</h3></html>");
        }
    }
}

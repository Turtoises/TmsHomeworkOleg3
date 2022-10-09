package by.tms.lesson27jstl.servlet;

import by.tms.lesson27jstl.pojo.UserDate;
import by.tms.lesson27jstl.utils.CollectionUserUtil;
import by.tms.lesson27jstl.utils.Contants;
import by.tms.lesson27jstl.utils.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/user/add")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("userfirstname");
        String lastName = request.getParameter("userlastname");
        String statusName = request.getParameter("status");
        Status status = Status.valueOf(statusName);

        UserDate addedUserDate = new UserDate(firstName, lastName, status);
        CollectionUserUtil.addUserToServer(addedUserDate, request);

        request.getRequestDispatcher("/lesson27/addresult.jsp").forward(request, response);
    }
}

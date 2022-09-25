package by.tms.lesson22.task2.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "LoginServlet", urlPatterns = "/tms/log")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<html>" +
                    "<h1>Please enter your login and password:</h1>" +
                    "<body>" +
                    "<form action=\"/tms\" method=\"GET\">" +
                    "<input type=\"text\" name=\"name\"><br>" +
                    "<input type=\"text\" name=\"password\"><br>" +
                    "<input type=\"submit\" value=\"Enter\"/>" +
                    "</form>" +
                    "</body>" +
                    "</html>");
        }
    }
}

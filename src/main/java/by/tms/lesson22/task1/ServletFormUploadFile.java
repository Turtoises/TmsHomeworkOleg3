package by.tms.lesson22.task1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletFormUploadFile", urlPatterns = "/tms/upload/form")
public class ServletFormUploadFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<html>" +
                    "<h1>Please enter your file:</h1>" +
                    "<body>" +
                    "<form action=\"/tms/upload/file\" method=\"POST\" enctype=\"multipart/form-data\">" +
                    "<input type=\"file\" name=\"file\"><br><br>" +
                    "<input type=\"submit\" value=\"Upload\"/>" +
                    "</form>" +
                    "</body>" +
                    "</html>");

        }
    }
}

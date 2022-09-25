package by.tms.lesson22.task3.servlet;


import by.tms.lesson22.task3.Student;
import by.tms.lesson22.task3.StudentList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletStudentList", urlPatterns = "/tms/student/list")
public class ServletStudentList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = StudentList.getStudentList();

        try (PrintWriter writer = resp.getWriter()) {

            writer.println(
                            "<html>" +
                            "<h3>List of students:</h3>" +
                            "<body>" +
                            "<table border=\"1\" cellspacing=\"1\">"+
                            "<tbody>"+
                            "<tr><th>LastName</th> <th>FirstName</th> </tr>");
            for (Student student:studentList){
                writer.println("<tr> <td>"+student.getLastName()+"</td> <td>"+student.getFirstName()+"</td> </tr>");
            }

            writer.println(
                    "</tbody>"+
                    "</table>"+
                    "</body>" +
                    "</html>");
        }
    }
}

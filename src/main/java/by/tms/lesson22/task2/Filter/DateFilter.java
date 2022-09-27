package by.tms.lesson22.task2.Filter;

import by.tms.lesson22.task2.UserPasswordMap;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebFilter(displayName = "DateFilter", urlPatterns = "/tms/*")
public class DateFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = req.getSession();
        String user = req.getParameter("name");
        String password = req.getParameter("password");

        if (user != null && password != null && isUser(user, password)) {
            session.setAttribute("user", "user");
        }

        session.setAttribute("URL", req.getRequestURI());

        if (session.getAttribute("user") == null) {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/tms/log");
            requestDispatcher.forward(req, res);
        }

        chain.doFilter(req, res);
    }

    private static boolean isUser(String name, String password) {

        if (name == null || password == null) {
            return false;
        }

        Map<String, String> map = UserPasswordMap.getUserDate();
        if (map.get(name) == null) {
            return false;
        } else {
            return map.get(name).equals(password);
        }
    }
}

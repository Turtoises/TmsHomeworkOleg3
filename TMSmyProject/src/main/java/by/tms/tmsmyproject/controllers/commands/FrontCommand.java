package by.tms.tmsmyproject.controllers.commands;

import by.tms.tmsmyproject.utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;

    public void init(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
        this.request = request;
        this.response = response;
        this.context = context;
    }

    public abstract void process() throws ServletException, IOException;

    protected void forward(String nameJsp) throws ServletException, IOException {
        String jspPath = String.format(Constants.PATH_TO_ALL_JSP_IN_WEBAPP, nameJsp);
        RequestDispatcher dispatcher = context.getRequestDispatcher(jspPath);
        dispatcher.forward(request, response);
    }
}

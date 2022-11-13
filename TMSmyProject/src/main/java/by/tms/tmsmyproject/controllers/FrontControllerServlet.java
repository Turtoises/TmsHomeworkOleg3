package by.tms.tmsmyproject.controllers;

import by.tms.tmsmyproject.controllers.commands.FrontCommand;
import by.tms.tmsmyproject.controllers.commands.UnknownCommand;
import by.tms.tmsmyproject.utils.Constants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FrontControllerServlet", value = {Constants.URI_FRONT_CONTROLLER_SERVLET, Constants.URI_FIRST_PAGE})

public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FrontCommand command = getCommand(request);
        command.init(request, response, request.getServletContext());
        command.process();
    }

    private static String getNameCommand(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String nameCommand = null;

        if (uri.equals(Constants.URI_FIRST_PAGE)) {
            nameCommand = Constants.COMMAND_OPEN_FIST_PAGE;
        }

        if (nameCommand == null) {
            nameCommand = request.getParameter(Constants.PARAMETER_COMMAND);
        }

        return nameCommand;
    }

    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            Class type = Class.forName(String.format(
                    Constants.PATH_TO_ALL_COMMANDS,
                    getNameCommand(request)));
            return (FrontCommand) type
                    .asSubclass(FrontCommand.class)
                    .getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}



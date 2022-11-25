package by.tms.tmsmyproject.controllers.commands;

import by.tms.tmsmyproject.utils.Constants;

import javax.servlet.ServletException;
import java.io.IOException;

public class OpenFirstPageCommand extends FrontCommand {

    public static final String NAME_COMMAND = OpenFirstPageCommand.class.getSimpleName().replaceAll("Command", "");

    @Override
    public void process() throws ServletException, IOException {

        forward(Constants.NAME_JSP_FIRST_PAGE);
    }
}

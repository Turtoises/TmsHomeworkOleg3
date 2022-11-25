package by.tms.tmsmyproject.controllers.commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class UserAuthenticationCommand extends FrontCommand{

    public static final String NAME_COMMAND = UserAuthenticationCommand.class.getSimpleName().replaceAll("Command", "");

    @Override
    public void process() throws ServletException, IOException {

    }
}

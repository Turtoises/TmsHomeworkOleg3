package by.tms.tmsmyproject.controllers.commands;

import by.tms.tmsmyproject.entities.ResponseMessage;
import by.tms.tmsmyproject.services.UserServiceImpl;
import by.tms.tmsmyproject.utils.Constants;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import java.io.IOException;

@Slf4j
public class UserDeleteByIdCommand extends FrontCommand {

    public static final String NAME_COMMAND = UserDeleteByIdCommand.class.getSimpleName().replaceAll("Command", "");

    @Override
    public void process() throws ServletException, IOException {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            responseMessage = new UserServiceImpl().deleteById(id);
        } catch (RuntimeException e) {
            log.info(e.getMessage());
            responseMessage.setValid(false).addMessage("Incorrect id");
        }

        request.setAttribute(Constants.ATTRIBUTE_RESPONSE_MESSAGE_OBJECT, responseMessage);
        forward(Constants.NAME_JSP_USER_DELETE_BY_ID_RESULT);
    }
}

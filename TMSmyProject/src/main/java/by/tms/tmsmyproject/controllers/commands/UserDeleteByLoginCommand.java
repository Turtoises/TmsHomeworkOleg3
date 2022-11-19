package by.tms.tmsmyproject.controllers.commands;

import by.tms.tmsmyproject.entities.ResponseMessage;
import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.dto.user.UserLoginPasswordDto;
import by.tms.tmsmyproject.services.UserServiceImpl;
import by.tms.tmsmyproject.utils.Constants;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class UserDeleteByLoginCommand extends FrontCommand {

    public static final String NAME_COMMAND = UserDeleteByLoginCommand.class.getSimpleName().replaceAll("Command", "");

    @Override
    public void process() throws ServletException, IOException {
        User userDto = creatUserDtoFromRequest(request);
        ResponseMessage responseMessage = new UserServiceImpl().delete(userDto);
        request.setAttribute(Constants.ATTRIBUTE_RESPONSE_MESSAGE_OBJECT, responseMessage);

        forward(Constants.NAME_JSP_USER_DELETE_BY_LOGIN_RESULT);
    }

    private User creatUserDtoFromRequest(HttpServletRequest request) {
        return UserLoginPasswordDto.builder()
                .password(request.getParameter("password"))
                .login(request.getParameter("login"))
                .build();
    }
}

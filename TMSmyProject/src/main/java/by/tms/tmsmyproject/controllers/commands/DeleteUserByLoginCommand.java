package by.tms.tmsmyproject.controllers.commands;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.dto.user.UserLoginPasswordDto;
import by.tms.tmsmyproject.services.UserServiceImpl;
import by.tms.tmsmyproject.utils.Constants;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class DeleteUserByLoginCommand extends FrontCommand {

    public static final String NAME_COMMAND = DeleteUserByLoginCommand.class.getSimpleName().replaceAll("Command", "");

    @Override
    public void process() throws ServletException, IOException {
        User userDto = creatUserDtoFromRequest(request);
        boolean isDelete = new UserServiceImpl(request).delete(userDto);
        if (isDelete){
            String message=String.format("User with login %s deleted", userDto.getLogin());
            log.info("User with login {} deleted", userDto.getLogin());
            request.setAttribute(Constants.ATTRIBUTE_USER_DELETED_OBJECT, userDto);
        }
        forward(Constants.NAME_JSP_USER_DELETE_BY_LOGIN_RESULT);
    }

    private User creatUserDtoFromRequest(HttpServletRequest request) {
        return UserLoginPasswordDto.builder()
                .password(request.getParameter("password"))
                .login(request.getParameter("login"))
                .build();
    }
}

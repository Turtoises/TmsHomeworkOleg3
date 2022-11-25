package by.tms.tmsmyproject.controllers.commands;

import by.tms.tmsmyproject.entities.ResponseMessage;
import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.enums.RoleUser;
import by.tms.tmsmyproject.services.UserService;
import by.tms.tmsmyproject.services.UserServiceImpl;
import by.tms.tmsmyproject.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class UserCreateCommand extends FrontCommand {

    public static final String NAME_COMMAND = UserCreateCommand.class.getSimpleName().replaceAll("Command", "");


    @Override
    public void process() throws ServletException, IOException {

        User newUser = creatUserFromRequest(request);
        ApplicationContext context=new AnnotationConfigApplicationContext("by.tms.tmsmyproject");

        ResponseMessage responseMessage = context.getBean(UserService.class).create(newUser);
        request.setAttribute(Constants.ATTRIBUTE_RESPONSE_MESSAGE_OBJECT, responseMessage);

        forward(Constants.NAME_JSP_USER_CREATE_RESULT);
    }

   private User creatUserFromRequest(HttpServletRequest request) {
        return User.builder()
                .name(request.getParameter("name"))
                .surname(request.getParameter("surname"))
                .password(request.getParameter("password"))
                .login(request.getParameter("login"))
                .email(request.getParameter("email"))
                .userRole(RoleUser.valueOf(request.getParameter("role")))
                .build();
    }
}

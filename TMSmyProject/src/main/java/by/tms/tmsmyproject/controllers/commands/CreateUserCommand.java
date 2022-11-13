package by.tms.tmsmyproject.controllers.commands;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.enums.RoleUser;
import by.tms.tmsmyproject.services.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class CreateUserCommand extends FrontCommand {

    public static final String NAME_COMMAND = CreateUserCommand.class.getSimpleName().replaceAll("Command", "");


    @Override
    public void process() throws ServletException, IOException {

        User newUser = creatUserFromRequest(request);
        boolean isCreat = new UserServiceImpl(request).create(newUser);

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

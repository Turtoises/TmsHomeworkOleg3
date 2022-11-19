package by.tms.tmsmyproject.controllers.commands;

import by.tms.tmsmyproject.entities.Author;
import by.tms.tmsmyproject.entities.ResponseMessage;
import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.enums.RoleUser;
import by.tms.tmsmyproject.services.AuthorServiceImpl;
import by.tms.tmsmyproject.utils.Constants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthorCreateCommand extends FrontCommand {

    public static final String NAME_COMMAND = AuthorCreateCommand.class.getSimpleName().replaceAll("Command", "");

    @Override
    public void process() throws ServletException, IOException {
        ResponseMessage responseMessage = new ResponseMessage();

        try{
            Author newAuthor = creatAuthorFromRequest(request);
            ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
            responseMessage = context.getBean("authors-service", AuthorServiceImpl.class).create(newAuthor);
        } catch (RuntimeException e){
            responseMessage.setValid(false).addMessage("Invalid date");
        }
        request.setAttribute(Constants.ATTRIBUTE_RESPONSE_MESSAGE_OBJECT, responseMessage);

        forward(Constants.NAME_JSP_AUTHOR_CREATE_RESULT);
    }

    private Author creatAuthorFromRequest(HttpServletRequest request) {
        return Author.builder()
                .name(request.getParameter("name"))
                .surname(request.getParameter("surname"))
                .yearBirth(Integer.valueOf(request.getParameter("yearBirth")))
                .yearDeath(Integer.valueOf(request.getParameter("yearDeath")))
                .build();
    }
}

package by.tms.tmsmyproject.utils;

import by.tms.tmsmyproject.controllers.commands.CreateUserCommand;
import by.tms.tmsmyproject.controllers.commands.DeleteUserByLoginCommand;
import by.tms.tmsmyproject.controllers.commands.OpenFirstPageCommand;

public final class Constants {

    private Constants() {
    }

    public static final String CONTEXT_ATTRIBUTE_IS_CONNECT = "connect";

    //attribute message from service to jsp

    public static final String ATTRIBUTE_CREATE_USER = "create_user";

    public static final String ATTRIBUTE_DELETE_USER_BY_ID = "delete_user_by_ID";

    public static final String ATTRIBUTE_DELETE_USER_BY_LOGIN = "delete_user_by_login";

    public static final String ATTRIBUTE_USER_DELETED_OBJECT = "user";

    //command

    public static final String PATH_TO_ALL_COMMANDS = "by.tms.tmsmyproject.controllers.commands.%sCommand";

    public static final String PARAMETER_COMMAND = "command";

    public static final String COMMAND_OPEN_FIST_PAGE = OpenFirstPageCommand.NAME_COMMAND;

    public static final String COMMAND_CREATE_USER = CreateUserCommand.NAME_COMMAND;

    public static final String COMMAND_DELETE_USER_BY_LOGIN = DeleteUserByLoginCommand.NAME_COMMAND;


    //URI path and JSP name

    public static final String PATH_TO_ALL_JSP_IN_WEBAPP = "/%s.jsp";

    public static final String URI_FRONT_CONTROLLER_SERVLET = "/book-online/controller/servlet";

    public static final String URI_FIRST_PAGE = "/book-online";

    public static final String NAME_JSP_FIRST_PAGE = "1_front_page";

    public static final String NAME_JSP_USER_DELETE_BY_LOGIN_RESULT = "3_user_delete_by_login_result";

    public static final String NAME_JSP_UNKNOWN_COMMAND = "unknown_command";

    //session attribute

    public static final String SESSION_ATTRIBUTE_ROLE = "role";

    public static final String SESSION_ATTRIBUTE_LOGIN = "login";

    //role


}

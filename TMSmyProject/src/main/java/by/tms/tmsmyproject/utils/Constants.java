package by.tms.tmsmyproject.utils;

import by.tms.tmsmyproject.controllers.commands.*;

public final class Constants {

    private Constants() {
    }

    //database

    public static final String CONTEXT_ATTRIBUTE_IS_CONNECT = "connect";

    //authentication

    public static final String SESSION_ATTRIBUTE_ROLE = "role";

    public static final String SESSION_ATTRIBUTE_LOGIN = "login";

    //attribute message from service to jsp

    public static final String ATTRIBUTE_CREATE_USER = "create_user";

    public static final String ATTRIBUTE_DELETE_USER_BY_ID = "delete_user_by_ID";

    public static final String ATTRIBUTE_DELETE_USER_BY_LOGIN = "delete_user_by_login";

    public static final String ATTRIBUTE_USER_OBJECT = "user";

    public static final String ATTRIBUTE_RESPONSE_MESSAGE_OBJECT = "result";

    //command

    public static final String PATH_TO_ALL_COMMANDS = "by.tms.tmsmyproject.controllers.commands.%sCommand";

    public static final String PARAMETER_COMMAND = "command";

    public static final String COMMAND_OPEN_FIST_PAGE = OpenFirstPageCommand.NAME_COMMAND;

    //command user

    public static final String COMMAND_CREATE_USER = UserCreateCommand.NAME_COMMAND;

    public static final String COMMAND_DELETE_USER_BY_LOGIN = UserDeleteByLoginCommand.NAME_COMMAND;

    public static final String COMMAND_DELETE_USER_BY_Id = UserDeleteByIdCommand.NAME_COMMAND;

    public static final String COMMAND_UPDATE_USER = UserUpdateCommand.NAME_COMMAND;

    public static final String COMMAND_Authentication = UserAuthenticationCommand.NAME_COMMAND;

    //command author

    public static final String COMMAND_CREATE_AUTHOR = AuthorCreateCommand.NAME_COMMAND;


    //URI path and JSP name

    public static final String PATH_TO_ALL_JSP_IN_WEBAPP = "/%s.jsp";

    public static final String URI_FRONT_CONTROLLER_SERVLET = "/book-online/controller/servlet";

    public static final String URI_FIRST_PAGE = "/book-online";

    public static final String NAME_JSP_FIRST_PAGE = "1_front_page";

    public static final String NAME_JSP_USER_CREATE_RESULT = "2_user_registration_result";

    public static final String NAME_JSP_USER_DELETE_BY_LOGIN_RESULT = "3_user_delete_by_login_result";

    public static final String NAME_JSP_USER_DELETE_BY_ID_RESULT = "4_user_delete_by_id_result";

    public static final String NAME_JSP_AUTHOR_CREATE_RESULT = "7_author_create_result";

    public static final String NAME_JSP_UNKNOWN_COMMAND = "unknown_command";


}

package by.tms.tmsmyproject.utils.constants;

public final class Constants {

    private Constants() {
    }

    public static final String PATH_TO_ALL_JSP_IN_WEBAPP = "/WEB-INF/views/";

    public static final String NAME_JSP_FIRST_PAGE = "frontpage";

    public static final String NAME_JSP_REGISTRATION = "registration";
    public static final String NAME_JSP_REGISTRATION_MAPPING = "/" + NAME_JSP_REGISTRATION;

    public static final String NAME_JSP_REGISTRATION_RESULT = "registration_result";

    public static final String NAME_JSP_ALL_USERS_RESULTS = "all_users_results";

    //controllers commands

    public static final String ATTRIBUTE_COMMAND = "command";

    public static final String COMMAND_CREATE_USER = "create";
    public static final String COMMAND_CREATE_MAPPING = "/" + COMMAND_CREATE_USER;

    public static final String COMMAND_GET_ALL_USERS_MAPPING = "/users";



}

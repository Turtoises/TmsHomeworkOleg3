package by.tms.tmsmyproject.utils.constants;

import by.tms.tmsmyproject.entities.enums.RoleUser;

public final class ConstantsRegex {

    private ConstantsRegex() {
    }

    public static final String LOGIN = "^[a-z][a-z0-9]*?([-_][a-z0-9]+){0,2}$";

    public static final String NAME_USER = "[A-Z][a-z]+";

    public static final String PASSWORD = "[A-Za-z0-9]{5,}";

    public static final String ROLE = "USER|ADMIN|MENTOR";

    public static final String NAME_AUTHOR = "[A-Z][a-z]+";

    public static final String YEAR = "[0-9]+";


    public static String roleUserRegex() {
        RoleUser[] roles = RoleUser.values();
        String regex = roles[0].toString().toUpperCase();
        for (int i = 1; i < roles.length; i++) {
            regex += "|" + roles[i].toString().toUpperCase();
        }
        return regex;
    }

}

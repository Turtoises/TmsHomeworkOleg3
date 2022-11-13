package by.tms.tmsmyproject.utils;

public final class ConstantsStatement {

    private ConstantsStatement() {
    }

    //user

    public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?;";

    public static final String DELETE_USER_BY_LOGIN = "DELETE FROM users WHERE login=?;";

    public static final String SELECT_USER_BY_ID = "SELECT* FROM users WHERE id=?;";

    public static final String SELECT_USER_BY_LOGIN = "SELECT* FROM users WHERE login=?;";

    public static final String SELECT_USER_BY_EMAIL = "SELECT* FROM users WHERE email=?;";

    public static final String INSERT_USER = "INSERT INTO users (login,password,role,email,name,surname) VALUES (?,?,?,?,?,?);";

}

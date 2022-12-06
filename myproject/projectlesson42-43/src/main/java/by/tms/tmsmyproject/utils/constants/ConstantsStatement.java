package by.tms.tmsmyproject.utils.constants;

public final class ConstantsStatement {

    private ConstantsStatement() {
    }

    //user

    public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?;";

    public static final String INSERT_USER = "INSERT INTO users (login,password,role,email,name,surname) VALUES (?,?,?,?,?,?);";

    public static final String UPDATE_USER = "UPDATE users SET login=?,password=?,role=?,email=?,name=?,surname=? WHERE id=?;";

    public static final String SELECT_AMOUNT_USER_BY_LOGIN = "SELECT COUNT(*) FROM users WHERE login=?";

    public static final String SELECT_AMOUNT_USER_BY_EMAIL = "SELECT COUNT(*) FROM users WHERE email=?";

    public static final String SELECT_ALL_USER = "SELECT * FROM users";

    public static final String DELETE_USER_BY_LOGIN = "DELETE FROM users WHERE login=?";

    public static final String SELECT_USER_BY_ID = "SELECT* FROM users WHERE id=?";

    public static final String SELECT_USER_BY_LOGIN = "SELECT* FROM users WHERE login=?";

}

package by.tms.lesson32solid.services;

public interface UserService extends Service {

    boolean changePassword(String login, String oldPassword, String newPassword);

    boolean delete(String login,String password);

    boolean create(String login, String password);

    public boolean isUser(String login);

}

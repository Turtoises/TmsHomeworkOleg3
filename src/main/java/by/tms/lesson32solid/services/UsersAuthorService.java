package by.tms.lesson32solid.services;

public interface UsersAuthorService extends Service{

    public boolean addUserBook(String login, String firstAuthorName, String lastAuthorName, String book);

    public boolean deleteUserBook(String login, String firstAuthorName, String lastAuthorName, String book);

}

package by.tms.lesson32solid;

import by.tms.lesson32solid.repositories.UsersAuthorsRepository;
import by.tms.lesson32solid.repositories.UsersAuthorsRepositoryIml;
import by.tms.lesson32solid.services.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUsersAuthorServiceIml {

    UsersAuthorsRepository usersAuthorsRepository = new UsersAuthorsRepositoryIml();

    AuthorService authorService = new AuthorServiceImpl();
    UserService userService = new UserServiceIml();
    UsersAuthorService usersAuthorService = new UsersAuthorServiceIml(authorService, userService, usersAuthorsRepository);

    @ParameterizedTest
    @CsvSource(value = {
            "ivan,Aleksandr, Pushkin,Byra, true",
            "777,Aleksandr, Pushkin,Byra, false",
            "ivan,Aleksandr, Pushkin,ggg, false",
            "ivan,Aleksandr, Pushkin,null, false"
                })
    public void testAddUserBook(String login, String firstAuthorName, String lastAuthorName, String book, boolean result) {
        if(book.equals("null")){
            book=null;
        }
        boolean isAdd=usersAuthorService.addUserBook(login,firstAuthorName,lastAuthorName,book);
        assertEquals(isAdd,result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "ivan,Aleksandr, Pushkin,Byra, true",
            "ivan,Aleksandr, Pushkin,qqq, false",
    })
    public void testDeleteUserBook(String login, String firstAuthorName, String lastAuthorName, String book, boolean result) {
        usersAuthorService.addUserBook("ivan","Aleksandr", "Pushkin","Byra");
        boolean isDeleted=usersAuthorService.deleteUserBook(login,firstAuthorName,lastAuthorName,book);
        assertEquals(isDeleted,result);
    }
}

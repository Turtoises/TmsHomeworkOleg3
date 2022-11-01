package by.tms.lesson32solid;

import by.tms.lesson32solid.repositories.*;
import by.tms.lesson32solid.services.*;
import by.tms.lesson32solid.utils.FindNullUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class TestMain {

    public static void main(String[] args) {

        AuthorRepository authorRepositoryIml = new AuthorRepositoryIml();
        UserRepository userRepositoryIml = new UserRepositoryIml();
        UsersAuthorsRepository usersAuthorsRepository = new UsersAuthorsRepositoryIml();

        AuthorService authorService = new AuthorServiceImpl();
        UserService userService = new UserServiceIml();
        UsersAuthorService usersAuthorService = new UsersAuthorServiceIml(authorService, userService, usersAuthorsRepository);

        usersAuthorService.addUserBook("ivan", "Lev", "Tolstoi", "Voina i mir");
        usersAuthorService.addUserBook("ivan", "Aleksandr", "Pushkin", "Metelica");
        usersAuthorService.addUserBook("ivan", "Aleksandr", "Pushkin", "Byra");
        usersAuthorService.addUserBook("ivan", "Aleksandr", "Pushkin", "Byra");

        usersAuthorService.deleteUserBook("ivan", "Lev", "Tolstoi", "Voina i mir");
        usersAuthorService.deleteUserBook("ivan", "Aleksandr", "Pushkin", "Metelica");
        usersAuthorService.deleteUserBook("ivan", "Aleksandr", "Pushkin", "Byra");
        usersAuthorService.deleteUserBook("ivan", "Aleksandr", "Pushkin", "Byra");

    }
}

package by.tms.lesson32solid;

import by.tms.lesson32solid.repositories.*;
import by.tms.lesson32solid.services.*;
import by.tms.lesson32solid.utils.FindNullUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class TestMain {

    public static void main(String[] args) {

        /*AuthorRepositoryIml authorRepositoryIml = new AuthorRepositoryIml();
        AuthorServiceImpl authorService = new AuthorServiceImpl(authorRepositoryIml);
        authorService.addBook("Vana", "Kozlov", "Ydacha");
        authorService.deleteBook("Lev", "Tolstoi", "Voina i mir");

        UserRepositoryIml userRepositoryIml=new UserRepositoryIml();
        UserServiceIml userServiceIml=new UserServiceIml(userRepositoryIml);
        userServiceIml.changePassword("ivan","1234578","11111");
        userServiceIml.delete("ivan","11111");
        userServiceIml.create("pavel","1234");
        userServiceIml.create("pavel","789");
        userServiceIml.create("tim","");*/

        AuthorRepository authorRepositoryIml = new AuthorRepositoryIml();
        UserRepository userRepositoryIml=new UserRepositoryIml();
        UsersAuthorsRepository usersAuthorsRepository=new UsersAuthorsRepositoryIml();

        AuthorService authorService=new AuthorServiceImpl(authorRepositoryIml);
        UserService userService=new UserServiceIml(userRepositoryIml);
        UsersAuthorService usersAuthorService=new UsersAuthorServiceIml(authorService,userService,usersAuthorsRepository);

        usersAuthorService.addUserBook("ivan","Lev", "Tolstoi","Voina i mir");
        usersAuthorService.addUserBook("ivan","Aleksandr", "Pushkin","Metelica");
        usersAuthorService.addUserBook("ivan","Aleksandr", "Pushkin","Byra");
        usersAuthorService.addUserBook("ivan","Aleksandr", "Pushkin","Byra");

        usersAuthorService.deleteUserBook("ivan","Lev", "Tolstoi","Voina i mir");
        usersAuthorService.deleteUserBook("ivan","Aleksandr", "Pushkin","Metelica");
        usersAuthorService.deleteUserBook("ivan","Aleksandr", "Pushkin","Byra");
        usersAuthorService.deleteUserBook("ivan","Aleksandr", "Pushkin","Byra");
        //usersAuthorService.deleteUserBook(null,"Aleksandr", "Pushkin","Byra");


        System.out.println();

    }
}

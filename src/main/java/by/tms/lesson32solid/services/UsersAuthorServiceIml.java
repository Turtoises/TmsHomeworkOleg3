package by.tms.lesson32solid.services;

import by.tms.lesson32solid.entities.Author;
import by.tms.lesson32solid.entities.UserAuthor;
import by.tms.lesson32solid.repositories.UsersAuthorsRepository;
import by.tms.lesson32solid.utils.FindNullUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class UsersAuthorServiceIml implements UsersAuthorService {

    private static Logger logger = LoggerFactory.getLogger("UsersAuthorServiceIml");

    AuthorService authorService;
    UserService userService;
    UsersAuthorsRepository usersAuthorsRepository;

    public UsersAuthorServiceIml(AuthorService authorService, UserService userService, UsersAuthorsRepository usersAuthorsRepository) {
        this.authorService = authorService;
        this.userService = userService;
        this.usersAuthorsRepository = usersAuthorsRepository;
    }

    public boolean addUserBook(String login, String firstAuthorName, String lastAuthorName, String book) {
        if (!dataСorrectness(login, firstAuthorName, lastAuthorName, book)) {
            logger.info("Add NOT successful");
            return false;
        }
        if (!usersAuthorsRepository.isUser(login)) {
            UserAuthor newUserAuthor = create(login, firstAuthorName, lastAuthorName, book);
            usersAuthorsRepository.add(newUserAuthor);
            logger.info("Add is true");
            return true;
        }
        boolean isAdd = false;
        UserAuthor userAuthor = (UserAuthor) usersAuthorsRepository.findByLogin(login);
        Map<Author, Set<String>> map = userAuthor.getUserAuthor();
        Author author = new Author(firstAuthorName, lastAuthorName);
        Set<String> books = map.get(author);
        if (books == null) {
            books = new HashSet<>();
        }
        isAdd = books.add(book);
        map.put(author, books);
        userAuthor.setUserAuthor(map);
        usersAuthorsRepository.add(userAuthor);
        logger.info("Add is {}{}", isAdd, isAdd ? "" : "- book exists");

        return isAdd;
    }

    public boolean deleteUserBook(String login, String firstAuthorName, String lastAuthorName, String book) {
        if (!dataСorrectness(login, firstAuthorName, lastAuthorName, book)) {
            logger.info("Delete NOT successful!!");
            return false;
        }
        if (!usersAuthorsRepository.isUser(login)) {
            logger.info("Delete NOT successful. User in UsersAuthorsRepository not find");
            return true;
        }
        boolean isDelete = false;
        UserAuthor userAuthor = (UserAuthor) usersAuthorsRepository.findByLogin(login);
        Map<Author, Set<String>> map = userAuthor.getUserAuthor();
        Author author = new Author(firstAuthorName, lastAuthorName);
        Set<String> books = map.get(author);
        isDelete = books.remove(book);

        if (books.isEmpty()) {
            map.remove(author);
        } else {
            map.put(author, books);
        }
        if (map.isEmpty()) {
            usersAuthorsRepository.delete(login);
        } else {
            userAuthor.setUserAuthor(map);
            usersAuthorsRepository.add(userAuthor);
        }
        logger.info("Delete is {}{}", isDelete,isDelete?"":" book not find");

        return isDelete;
    }

    private boolean isUserOrAuthorServiceReady() {
        if (authorService.isEmpty() && userService.isEmpty()) {
            logger.warn("Author and user repository are empty");
            return false;
        }
        if (authorService.isEmpty()) {
            logger.warn("Author repository is empty");
            return false;
        }
        if (userService.isEmpty()) {
            logger.warn("User repository is empty");
            return false;
        }
        return true;
    }

    private boolean dataСorrectness(String login, String firstAuthorName, String lastAuthorName, String book) {
        if (!isUserOrAuthorServiceReady()) {
            return false;
        }
        if (FindNullUtils.isAnyNull(login, firstAuthorName, lastAuthorName, book)) {
            return false;
        }
        if (!userService.isUser(login)) {
            logger.info("User not find");
            return false;
        }
        if (!authorService.isBook(firstAuthorName, lastAuthorName, book)) {
            logger.info("Book not find");
            return false;
        }
        return true;
    }

    private UserAuthor create(String login, String firstAuthorName, String lastAuthorName, String book) {

        Author author = new Author(firstAuthorName, lastAuthorName);
        Map<Author, Set<String>> map = new HashMap<>();
        map.put(author, new HashSet<>(Arrays.asList(book)));
        UserAuthor userAuthor = new UserAuthor(login, map);
        return userAuthor;
    }

    @Override
    public boolean isEmpty() {
        return usersAuthorsRepository.isEpty();
    }
}
package by.tms.lesson32solid;

import by.tms.lesson32solid.repositories.AuthorRepository;
import by.tms.lesson32solid.repositories.AuthorRepositoryIml;
import by.tms.lesson32solid.services.AuthorService;
import by.tms.lesson32solid.services.AuthorServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAuthorServiceImpl {

    AuthorRepository authorRepository = new AuthorRepositoryIml();
    AuthorService authorService = new AuthorServiceImpl(authorRepository);


    @ParameterizedTest
    @CsvSource(value = {
            "Vova,Kozlov,Press,true",
            "Aleksandr,Pushkin,Metelica,false",
            "Aleksandr,Pushkin,null,false",
    })
    public void testAddBook(String firstName, String lastName, String book, boolean result) {

        if (book.equals("null")) {
            book = null;
        }
        boolean isAdd = authorService.addBook(firstName, lastName, book);
        assertTrue(isAdd == result);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "Aleksandr,Pushkin,Metelica,true",
            "Aleksandr,Pushkin,fff,false",
            "Aleksandr,Pushkin,null,false",
    })
    public void testDeleteBook(String firstName, String lastName, String book, boolean result) {
        if (book.equals("null")) {
            book = null;
        }
        boolean isAdd = authorService.deleteBook(firstName, lastName, book);
        assertTrue(isAdd == result);
    }


}

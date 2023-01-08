package by.tms.tmsmyproject.controllers.author;

import by.tms.tmsmyproject.entities.Author;
import by.tms.tmsmyproject.entities.dto.author.AuthorDto;
import by.tms.tmsmyproject.entities.dto.author.AuthorRequestCreateDto;
import by.tms.tmsmyproject.entities.dto.author.AuthorRequestUpdateDto;
import by.tms.tmsmyproject.entities.dto.author.AuthorResponseDeleteDto;
import by.tms.tmsmyproject.entities.dto.book.BookDto;
import by.tms.tmsmyproject.entities.mapers.AuthorMapper;
import by.tms.tmsmyproject.entities.mapers.BookMapper;
import by.tms.tmsmyproject.services.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Author", description = "Author API")
@RestController
@AllArgsConstructor
@RequestMapping("/rest/authors")
public class AuthorsRestController {

    AuthorService authorService;
    AuthorMapper authorMapper;
    BookMapper bookMapper;

    @GetMapping
    @Operation(summary = "Getting all authors")
    public List<AuthorResponseDeleteDto> getAuthors() {
        return authorMapper.toDtoList(authorService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Getting a author by ID")
    public AuthorDto getUser(@Parameter(description = "Transmitted user ID")
                             @PathVariable("id") Long id) {
        return authorMapper.toDtoGet(authorService.getById(id));
    }

    @GetMapping("/{id}/books")
    @Operation(summary = "Getting all books a author by ID")
    public List<? extends BookDto> getAllBook(@Parameter(description = "Transmitted author ID")
                                                         @PathVariable("id") Long id) {
        return bookMapper.toDtoList(authorService.getAllAuthorBooksById(id));
    }

    @GetMapping("/{id}/books/{number}")
    @Operation(summary = "Getting a book a author by ID")
    public BookDto getBook(@Parameter(description = "Transmitted author ID")
                           @PathVariable("id") Long id,
                           @Parameter(description = "Transmitted number book")
                           @PathVariable("number") Integer number) {
        return bookMapper.toDto(authorService.getBook(id, number));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creating new author")
    public AuthorDto createAuthor(@Parameter(description = "Transmitted date for creating author")
                                  @Valid @RequestBody AuthorRequestCreateDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        return authorMapper.toDtoCreate(authorService.create(author));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Updating author")
    public AuthorDto updateAuthor(@Parameter(description = "Transmitted date for updating author")
                                  @Valid @RequestBody AuthorRequestUpdateDto authorDto,
                                  @PathVariable("id") Long id) {
        Author author = authorMapper.toEntity(authorDto);
        author.setId(id);
        return authorMapper.toDtoGet(authorService.update(author));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleting author by ID")
    public AuthorDto deleteAuthor(@Parameter(description = "Transmitted author ID")
                                  @PathVariable("id") Long id) {
        return authorMapper.toDtoDelete(authorService.deleteById(id));
    }
}

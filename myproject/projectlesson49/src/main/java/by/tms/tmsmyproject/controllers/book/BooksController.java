package by.tms.tmsmyproject.controllers.book;

import by.tms.tmsmyproject.entities.Book;
import by.tms.tmsmyproject.entities.dto.author.AuthorResponseDeleteDto;
import by.tms.tmsmyproject.entities.dto.book.BookRequestCreateDto;
import by.tms.tmsmyproject.entities.dto.book.BookRequestUpdateDto;
import by.tms.tmsmyproject.entities.enums.GenreBook;
import by.tms.tmsmyproject.entities.mapers.AuthorMapper;
import by.tms.tmsmyproject.entities.mapers.BookMapper;
import by.tms.tmsmyproject.services.AuthorService;
import by.tms.tmsmyproject.services.BookService;
import by.tms.tmsmyproject.utils.constants.ControllerUtils;
import by.tms.tmsmyproject.utils.validators.BookValidator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BooksController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final BookValidator bookValidator;
    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;

    private static int currentPage = 1;
    private static String sizeSortFieldSortDirAsUri = "";

    @ModelAttribute("path")
    public String getPathToPage() {
        return "/books/page";
    }

    @ModelAttribute("uri")
    public String getUri() {
        return "/books";
    }

    @ModelAttribute("allGenres")
    public List<String> allGenres() {
        return GenreBook.GENRES;
    }

    @ModelAttribute("allAuthors")
    public List<AuthorResponseDeleteDto> allAuthors() {
        return authorMapper.toDtoList(authorService.getAll());
    }

    @GetMapping
    public String getAllBooks() {
        return "redirect:/books/page/1";
    }

    @GetMapping("/page/{id}")
    public String getAllPage(@PathVariable("id") Integer id,
                             Model model,
                             @RequestParam(name = "size", defaultValue = "5") Integer size,
                             @RequestParam(name = "sortField", defaultValue = "id") String sortField,
                             @RequestParam(name = "sortDir", defaultValue = "ASC") String sortDir) {
        currentPage = id;
        PageRequest pageRequest = PageRequest.of(id - 1, size, Sort.Direction.valueOf(sortDir), sortField);
        sizeSortFieldSortDirAsUri = ControllerUtils.getSizeSortFieldSortDirAsUri(model, id, sortField, sortDir, size);
        var page = bookService.getAllPaginated(pageRequest).map(bookMapper::toDtoCreate);
        if (id > 1 && (page.getTotalPages() < id)) {
            return "redirect:/books/page/" + (id - 1) + sizeSortFieldSortDirAsUri;
        }
        model.addAttribute("list", page);
        return "/books/all-books-page";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("object") Book book) {
        return "/books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("object") @Valid BookRequestCreateDto bookCreateDto,
                         BindingResult bindingResult) {
        bookValidator.validate(bookCreateDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "books/new";
        }
        Book book = bookMapper.toEntity(bookCreateDto);
        bookService.create(book);
        return "redirect:/books/page/" + currentPage + sizeSortFieldSortDirAsUri;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("object", bookMapper.toDtoUpdate(bookService.getById(id)));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("object") @Valid BookRequestUpdateDto bookUpdateDto, BindingResult bindingResult) {
        bookValidator.validate(bookUpdateDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        Book book = bookMapper.toEntity(bookUpdateDto);
        bookService.update(book);
        return "redirect:/books/page/" + currentPage + sizeSortFieldSortDirAsUri;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/books/page/" + currentPage + sizeSortFieldSortDirAsUri;
    }
}

package by.tms.tmsmyproject.controllers;

import by.tms.tmsmyproject.entities.dto.book.BookResponseGetDto;
import by.tms.tmsmyproject.entities.enums.GenreBook;
import by.tms.tmsmyproject.entities.mapers.BookMapper;
import by.tms.tmsmyproject.services.BookService;
import by.tms.tmsmyproject.utils.constants.ConstantsRegex;
import by.tms.tmsmyproject.utils.constants.ControllerUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/library")
public class LibraryController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    private static int currentPage = 1;
    private static String sizeSortFieldSortDirAsUri = "";
    private static String currentGenre;

    @ModelAttribute("uri")
    public String getUri() {
        return "/library";
    }

    @ModelAttribute("path")
    public String getPathToPage() {
        return "/library/books/page";
    }

    @GetMapping
    public String newUser(Model model) {
        model.addAttribute("genres", GenreBook.GENRES_LIBRARY);
        model.addAttribute("alphabet", ConstantsRegex.ALPHABET.split(""));
        return "library/library";
    }

    @GetMapping("/books/page/{id}")
    public String getAllPage(@PathVariable("id") Integer id,
                             Model model,
                             @RequestParam(name = "genre", defaultValue = "null") String genre,
                             @RequestParam(name = "size", defaultValue = "5") Integer size,
                             @RequestParam(name = "sortField", defaultValue = "author_surname") String sortField,
                             @RequestParam(name = "sortDir", defaultValue = "ASC") String sortDir) {
        currentGenre = genre.equals("null") ? currentGenre : genre;
        currentPage = id;
        PageRequest pageRequest = PageRequest.of(id - 1, size, Sort.Direction.valueOf(sortDir), sortField);
        sizeSortFieldSortDirAsUri = ControllerUtils.getSizeSortFieldSortDirAsUri(model, id, sortField, sortDir, size);
        Page<BookResponseGetDto> page = bookService.findBookByGenreOrAll(currentGenre, pageRequest).map(bookMapper::toDtoCreate);
        if (id > 1 && (page.getTotalPages() < id)) {
            return "redirect:/library/books/page/" + (id - 1) + sizeSortFieldSortDirAsUri;
        }
        model.addAttribute("list", page);
        return "/library/books-by-genre-page";
    }


}

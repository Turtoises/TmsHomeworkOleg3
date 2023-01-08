package by.tms.tmsmyproject.controllers.author;

import by.tms.tmsmyproject.entities.Author;
import by.tms.tmsmyproject.entities.dto.author.AuthorRequestCreateDto;
import by.tms.tmsmyproject.entities.dto.author.AuthorRequestUpdateDto;
import by.tms.tmsmyproject.entities.mapers.AuthorMapper;
import by.tms.tmsmyproject.services.AuthorService;
import by.tms.tmsmyproject.utils.constants.ControllerUtils;
import by.tms.tmsmyproject.utils.validators.AuthorValidator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorService authorService;
    private final AuthorValidator authorValidator;
    private final AuthorMapper authorMapper;

    private static int currentPage = 1;
    private static String sizeSortFieldSortDirAsUri = "";

    @ModelAttribute("path")
    public String getPathToPage() {
        return "/authors/page";
    }

    @ModelAttribute("uri")
    public String getUri() {
        return "/authors";
    }

    @GetMapping
    public String getAllAuthors() {
        return "redirect:/authors/page/1";
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
        var page = authorService.getAllPaginated(pageRequest).map(authorMapper::toDtoCreate);
        if (id > 1 && (page.getTotalPages() < id)) {
            return "redirect:/authors/page/" + (id - 1) + sizeSortFieldSortDirAsUri;
        }
        model.addAttribute("list", page);
        return "/authors/all-authors-page";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("object") Author author) {
        return "/authors/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("object") @Valid AuthorRequestCreateDto authorCreateDto,
                         BindingResult bindingResult) {
        authorValidator.validate(authorCreateDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "authors/new";
        }
        Author author = authorMapper.toEntity(authorCreateDto);
        authorService.create(author);
        return "redirect:/authors/page/" + currentPage + sizeSortFieldSortDirAsUri;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("object", authorMapper.toDtoUpdate(authorService.getById(id)));
        return "authors/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("object") @Valid AuthorRequestUpdateDto authorUpdateDto, BindingResult bindingResult) {
        authorValidator.validate(authorUpdateDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "authors/edit";
        }
        Author author = authorMapper.toEntity(authorUpdateDto);
        authorService.update(author);
        return "redirect:/authors/page/" + currentPage + sizeSortFieldSortDirAsUri;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        authorService.deleteById(id);
        return "redirect:/authors/page/" + currentPage + sizeSortFieldSortDirAsUri;
    }
}

package by.tms.tmsmyproject.controllers.user;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.mapers.UserMapper;
import by.tms.tmsmyproject.services.UserService;
import by.tms.tmsmyproject.utils.constants.ControllerUtils;
import by.tms.tmsmyproject.utils.validators.UserValidator;
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
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final UserMapper userMapper;

    private static int currentPage = 1;
    private static String sizeSortFieldSortDirAsUri = "";

    @ModelAttribute("path")
    public String getPathToPage() {
        return "/users/page";
    }

    @ModelAttribute("uri")
    public String getUri() {
        return "/users";
    }

    @GetMapping
    public String getAllUsers() {
        return "redirect:/users/page/1";
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
        var page = userService.getAllPaginated(pageRequest).map(userMapper::toDto);
        if (id > 1 && (page.getTotalPages() < id)) {
            return "redirect:/users/page/" + (id - 1) + sizeSortFieldSortDirAsUri;
        }
        model.addAttribute("list", page);
        return "/users/all-users-page";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("object") User user) {
        return "/users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("object") @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userService.create(user);
        return "redirect:/users/page/" + currentPage + sizeSortFieldSortDirAsUri;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("object", userService.getById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("object") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.update(user);
        return "redirect:/users/page/"+currentPage + sizeSortFieldSortDirAsUri;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users/page/"+currentPage + sizeSortFieldSortDirAsUri;
    }
}

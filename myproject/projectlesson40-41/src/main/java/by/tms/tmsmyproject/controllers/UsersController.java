package by.tms.tmsmyproject.controllers;

import by.tms.tmsmyproject.entities.ResponseMessage;
import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.exception.MyException;
import by.tms.tmsmyproject.services.UserService;
import by.tms.tmsmyproject.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping(Constants.NAME_JSP_REGISTRATION_MAPPING)
    public String registrationGet(Model model) {
        model.addAttribute("user", User.builder().build());

        return Constants.NAME_JSP_REGISTRATION;
    }

    @PostMapping(Constants.COMMAND_CREATE_MAPPING)
    public String registrationPost(@Valid @ModelAttribute("user") User user, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return Constants.NAME_JSP_REGISTRATION;
        }
        ResponseMessage responseMessage = userService.create(user);
        model.addAttribute("result", responseMessage);

        return Constants.NAME_JSP_REGISTRATION_RESULT;
    }

    @GetMapping(Constants.COMMAND_GET_ALL_USERS_MAPPING)
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());

        return Constants.NAME_JSP_ALL_USERS_RESULTS;
    }

    @GetMapping("/user/delete/{id}")
    public String userDeleteById(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);

        return "redirect:/users";
    }
}

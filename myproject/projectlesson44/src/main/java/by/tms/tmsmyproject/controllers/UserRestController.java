package by.tms.tmsmyproject.controllers;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.dto.user.UserDto;
import by.tms.tmsmyproject.entities.dto.user.UserRequestCreateDto;
import by.tms.tmsmyproject.entities.dto.user.UserRequestUpdateDto;
import by.tms.tmsmyproject.entities.dto.user.UserResponseForGetDto;
import by.tms.tmsmyproject.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "User", description = "User API")
@RestController
@AllArgsConstructor
@RequestMapping("/rest/users")
public class UserRestController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Getting all users")
    public List<UserDto> getUsers() {
        return userService.getAll().stream()
                .map(user -> modelMapper.map(user, UserResponseForGetDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Getting a user by ID")
    public UserDto getUser(@Parameter(description = "Transmitted user ID")
                           @PathVariable("id") Long id) {
        return modelMapper.map(userService.getById(id), UserResponseForGetDto.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creating new user")
    public UserDto createUser(@Parameter(description = "Transmitted date for creating user")
                              @Valid @RequestBody UserRequestCreateDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userService.create(user), UserResponseForGetDto.class);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Updating user")
    public UserDto updateUser(@Parameter(description = "Transmitted date for updating user")
                              @Valid @RequestBody UserRequestUpdateDto userDto,
                              @PathVariable("id") Long id) {
        User user = modelMapper.map(userDto, User.class);
        user.setId(id);
        return modelMapper.map(userService.update(user), UserResponseForGetDto.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Deleting user by ID")
    public UserDto deleteUser(@Parameter(description = "Transmitted user ID")
                              @PathVariable("id") Long id) {
        return modelMapper.map(userService.deleteById(id), UserResponseForGetDto.class);
    }

}
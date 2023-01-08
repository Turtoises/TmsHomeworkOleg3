package by.tms.tmsmyproject.controllers.user;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.dto.user.UserDto;
import by.tms.tmsmyproject.entities.dto.user.UserRequestCreateDto;
import by.tms.tmsmyproject.entities.dto.user.UserRequestUpdateDto;
import by.tms.tmsmyproject.entities.dto.user.UserResponseGetDto;
import by.tms.tmsmyproject.entities.mapers.UserMapper;
import by.tms.tmsmyproject.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "User", description = "User API")
@RestController
@AllArgsConstructor
@RequestMapping("/rest/users")
public class UsersRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    @Operation(summary = "Getting all users")
    public List<UserResponseGetDto> getUsers() {
        return userMapper.toDtoList(userService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Getting a user by ID")
    public UserDto getUser(@Parameter(description = "Transmitted user ID")
                           @PathVariable("id") Long id) {
        return userMapper.toDto(userService.getById(id));
    }

    @GetMapping("/page/{id}")
    @Operation(summary = "Getting a user by ID")
    public Page<UserResponseGetDto> getAllUserPaginated(@Parameter(description = "Transmitted user ID")
                                                        @PathVariable("id") Integer id,
                                                        @RequestParam("size") Integer size,
                                                        @RequestParam("fieldName") String fieldName,
                                                        @RequestParam("sortDirection") String sortDirection) {
        int page = id - 1;
        fieldName = (fieldName == null || fieldName.isEmpty()) ? "id" : fieldName;
        sortDirection = (sortDirection != null && !sortDirection.isEmpty() && sortDirection.equals("DESC") ? "DESC" : "ASC");
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(sortDirection), fieldName);
        return userService.getAllPaginated(pageRequest).map(userMapper::toDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creating new user")
    public UserDto createUser(@Parameter(description = "Transmitted date for creating user")
                              @Valid @RequestBody UserRequestCreateDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userService.create(user));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Updating user")
    public UserDto updateUser(@Parameter(description = "Transmitted date for updating user")
                              @Valid @RequestBody UserRequestUpdateDto userDto,
                              @PathVariable("id") Long id) {
        User user = userMapper.toEntity(userDto);
        user.setId(id);
        return userMapper.toDto(userService.update(user));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleting user by ID")
    public UserDto deleteUser(@Parameter(description = "Transmitted user ID")
                              @PathVariable("id") Long id) {
        return userMapper.toDto(userService.deleteById(id));
    }

}
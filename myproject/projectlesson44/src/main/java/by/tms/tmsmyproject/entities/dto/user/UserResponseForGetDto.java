package by.tms.tmsmyproject.entities.dto.user;

import by.tms.tmsmyproject.entities.enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseForGetDto extends UserDto {
    private Long id;
    private String login;
    private String role;
    private String email;
    private String name;
    private String surname;

}

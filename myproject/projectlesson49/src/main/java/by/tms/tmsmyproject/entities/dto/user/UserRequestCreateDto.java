package by.tms.tmsmyproject.entities.dto.user;

import by.tms.tmsmyproject.entities.enums.RoleUser;
import by.tms.tmsmyproject.utils.constants.ConstantsRegex;
import by.tms.tmsmyproject.utils.validators.enums.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestCreateDto extends UserDto {

    @Pattern(regexp = ConstantsRegex.LOGIN, message = "Login does not comply with site rules")
    @Size(min = 3, max = 15, message = "The length of the login should be between 3 and 15")
    private String login;

    @Pattern(regexp = ConstantsRegex.PASSWORD, message = "Password does not comply with site rules")
    @Size(min = 1, max = 25, message = "The length of the login should be between 5 and 15")
    private String password;

    @ValueOfEnum(enumClass = RoleUser.class, message = "Role incorrect")
    private String role;

    @Email(message = "Email incorrect")
    private String email;

    @Pattern(regexp = ConstantsRegex.NAME_USER, message = "Name incorrect")
    private String name;

    @Pattern(regexp = ConstantsRegex.NAME_USER, message = "Surname incorrect")
    private String surname;

}

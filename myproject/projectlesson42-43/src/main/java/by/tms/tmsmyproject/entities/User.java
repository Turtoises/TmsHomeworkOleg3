package by.tms.tmsmyproject.entities;

import by.tms.tmsmyproject.entities.enums.RoleUser;
import by.tms.tmsmyproject.utils.constants.ConstantsRegex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Arrays;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {

    @Pattern(regexp = ConstantsRegex.LOGIN, message = "Login does not comply with site rules")
    @Size(min = 3, max = 15, message = "The length of the login should be between 3 and 15")
    private String login;

    @Pattern(regexp = ConstantsRegex.PASSWORD, message = "Password does not comply with site rules")
    @Size(min = 1, max = 25, message = "The length of the login should be between 5 and 15")
    private String password;

    @NotNull(message ="The field must be filled in" )
    private RoleUser role;

    @Email(message = "Email incorrect")
    private String email;

    @Pattern(regexp = ConstantsRegex.NAME_USER, message = "Name incorrect")
    private String name;

    @Pattern(regexp = ConstantsRegex.NAME_USER, message = "Surname incorrect")
    private String surname;

    public Object[] getArrayFields() {
        return new ArrayList<>(Arrays.asList(
                getLogin(),
                getPassword(),
                getRole().toString().toUpperCase(),
                getEmail(),
                getName(),
                getSurname()
        )).toArray();
    }
}

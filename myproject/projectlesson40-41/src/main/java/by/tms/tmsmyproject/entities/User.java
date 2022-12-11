package by.tms.tmsmyproject.entities;

import by.tms.tmsmyproject.utils.Constants;
import by.tms.tmsmyproject.utils.ConstantsRegex;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {

    @Pattern(regexp = ConstantsRegex.LOGIN, message = "Login does not comply with site rules")
    @Size(min = 5, max = 10, message = "The length of the login should be between 5 and 10")
    private String login;
    @Pattern(regexp = ConstantsRegex.PASSWORD, message = "Password does not comply with site rules")
    @Size(min = 1, max = 25, message = "The length of the login should be between 5 and 15")
    private String password;
    @NotNull
    private String role;
    @Pattern(regexp = ConstantsRegex.EMAIL, message = "Email incorrect")
    private String email;
    @Pattern(regexp = ConstantsRegex.NAME_USER, message = "Name incorrect")
    private String name;
    @Pattern(regexp = ConstantsRegex.NAME_USER, message = "Surname incorrect")
    private String surname;

    public Object[] getArrayFields() {
        return new ArrayList<>(Arrays.asList(
                getLogin(),
                getPassword(),
                getRole(),
                getEmail(),
                getName(),
                getSurname()
        )).toArray();
    }
}

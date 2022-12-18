package by.tms.tmsmyproject.entities;

import by.tms.tmsmyproject.utils.constants.ConstantsRegex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
@Table(name = "users")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {

    @Pattern(regexp = ConstantsRegex.LOGIN, message = "Login does not comply with site rules")
    @Size(min = 3, max = 15, message = "The length of the login should be between 3 and 15")
    private String login;

    @Pattern(regexp = ConstantsRegex.PASSWORD, message = "Password does not comply with site rules")
    @Size(min = 1, max = 25, message = "The length of the login should be between 5 and 15")
    private String password;

    @NotNull(message ="The field must be filled in" )
    private String role;

    @Email(message = "Email incorrect")
    private String email;

    @Pattern(regexp = ConstantsRegex.NAME_USER, message = "Name incorrect")
    private String name;

    @Pattern(regexp = ConstantsRegex.NAME_USER, message = "Surname incorrect")
    private String surname;

    public Object[] arrayFields() {
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

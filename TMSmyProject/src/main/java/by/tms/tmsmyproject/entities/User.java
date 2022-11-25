package by.tms.tmsmyproject.entities;

import by.tms.tmsmyproject.entities.enums.RoleUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {

    private String login;
    private String password;
    private RoleUser userRole;
    private String email;
    private String name;
    private String surname;

    public Object[] getArrayFields(){
        return new ArrayList<>(Arrays.asList(
                getLogin(),
                getPassword(),
                getUserRole().toString(),
                getEmail(),
                getName(),
                getSurname()
        )).toArray();
    }
}

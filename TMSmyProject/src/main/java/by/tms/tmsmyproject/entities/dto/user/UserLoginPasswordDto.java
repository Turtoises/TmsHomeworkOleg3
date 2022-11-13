package by.tms.tmsmyproject.entities.dto.user;

import by.tms.tmsmyproject.entities.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class UserLoginPasswordDto extends User {

    private String login;
    private String password;

}

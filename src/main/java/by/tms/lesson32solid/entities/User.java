package by.tms.lesson32solid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String login;
    private String password;
}

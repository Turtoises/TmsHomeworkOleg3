package by.tms.lesson32solid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class UserAuthor {

    private String login;
    private Map<Author, Set<String>> userAuthor;

}

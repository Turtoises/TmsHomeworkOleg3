package by.tms.tmsmyproject.entities.dto.author;

import by.tms.tmsmyproject.entities.Author;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class AuthorCreateDto extends Author {

    private String name;
    private String surname;

}

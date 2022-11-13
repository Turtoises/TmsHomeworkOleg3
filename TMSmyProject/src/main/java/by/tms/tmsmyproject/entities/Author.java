package by.tms.tmsmyproject.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class Author extends AbstractEntity{

    private String name;
    private String surname;
    private Integer yearBirth;
    private Integer yearDeth;
    private Set<Book> books;

}

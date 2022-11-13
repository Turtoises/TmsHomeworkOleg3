package by.tms.tmsmyproject.entities;

import by.tms.tmsmyproject.entities.enums.GenreBook;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends AbstractEntity{

    private Long authorID;
    private String name;
    private Integer year;
    private Set<GenreBook> genreBook;

}

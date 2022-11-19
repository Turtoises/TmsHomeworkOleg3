package by.tms.tmsmyproject.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Author extends AbstractEntity {

    private String name;
    private String surname;
    private Integer yearBirth;
    private Integer yearDeath;
    private Set<Book> books;

    public Object[] getArrayFields() {
        return new ArrayList<>(Arrays.asList(
                getName(),
                getSurname(),
                getYearBirth(),
                getYearDeath()
        )).toArray();
    }
}

package by.tms.tmsmyproject.entities.dto.book;

import by.tms.tmsmyproject.entities.Author;
import by.tms.tmsmyproject.entities.enums.GenreBook;
import by.tms.tmsmyproject.utils.validators.enums.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestUpdateDto extends BookDto {

    private Long id;
    @Size(min = 1, max = 30, message = "The length of the name should be between 1 and 15")
    private String name;
    @Min(value = -2000, message = "Date incorrect")
    @Max(value = 2022, message = "Date incorrect")
    private Integer year;
    @ValueOfEnum(enumClass = GenreBook.class, message = "Genre of book incorrect")
    private String genreBook;
    private Author author;

}

package by.tms.tmsmyproject.entities.dto.book;

import by.tms.tmsmyproject.entities.dto.author.AuthorResponseGetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseGetDto extends BookDto {

    private Long id;
    private String name;
    private Integer year;
    private String genreBook;
    private AuthorResponseGetDto author;

}

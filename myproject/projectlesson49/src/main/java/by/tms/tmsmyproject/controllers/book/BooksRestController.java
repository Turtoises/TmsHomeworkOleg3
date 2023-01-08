package by.tms.tmsmyproject.controllers.book;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book", description = "Book API")
@RestController
@AllArgsConstructor
@RequestMapping("/rest/books")
public class BooksRestController {

}

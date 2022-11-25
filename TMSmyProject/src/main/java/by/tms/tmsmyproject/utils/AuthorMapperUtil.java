package by.tms.tmsmyproject.utils;

import by.tms.tmsmyproject.entities.Author;
import by.tms.tmsmyproject.entities.dto.author.AuthorCreateDto;

public final class AuthorMapperUtil {

    private AuthorMapperUtil() {
    }

    public static Author getAuthorCreateDto(Author author) {
        return AuthorCreateDto.builder()
                .name(author.getName())
                .surname(author.getSurname())
                .build();
    }
}

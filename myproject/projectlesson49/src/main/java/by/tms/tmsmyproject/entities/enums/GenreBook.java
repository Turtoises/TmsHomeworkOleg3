package by.tms.tmsmyproject.entities.enums;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum GenreBook {

    CLASSICS("Classics"),

    MILITANTS("Militants"),

    DRAMA("Drama"),

    ADVENTURES("Adventures"),

    HISTORY("History"),

    ROMANCE("Romance"),

    DETECTIVE("Detective"),

    FANTASY("Fantasy"),

    SCIENCE_FICTION("Science fiction"),

    THRILLER("Thriller"),

    HORROR("Horror"),

    PSYCHOLOGY("Psychology"),

    HEALTH("Health"),

    HUMOR("Humor");

    private String value;

    @Override
    public String toString() {
        return value;
    }

    public final static List<String> GENRES = Arrays.stream(GenreBook.values())
            .map(Enum::name).collect(Collectors.toList());


    public final static List<String> GENRES_LIBRARY = Arrays.stream(GenreBook.values())
            .map(genre -> genre.value).collect(Collectors.toList());
}

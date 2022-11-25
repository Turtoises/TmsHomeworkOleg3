package by.tms.tmsmyproject.entities.enums;

import lombok.AllArgsConstructor;

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
}

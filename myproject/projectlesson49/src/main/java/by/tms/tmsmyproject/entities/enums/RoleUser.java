package by.tms.tmsmyproject.entities.enums;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum RoleUser {

    USER("User"),

    MENTOR("Mentor"),

    ADMIN("Admin");

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

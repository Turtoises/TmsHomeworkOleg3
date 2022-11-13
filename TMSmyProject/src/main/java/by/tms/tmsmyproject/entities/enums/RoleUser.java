package by.tms.tmsmyproject.entities.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleUser {

    USER("User"),

    MENTOR("Mentor"),

    ADMIN("Admin");

    private String value;

    @Override
    public String toString() {
        return value;
    }
}

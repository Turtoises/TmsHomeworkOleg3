package by.tms.tmsmyproject.entities.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderStatus {

    IN_WORK("in work"),

    PUT_OFF("put off"),

    NEEDS_REFINED("needs to be refined");

    private String value;

    @Override
    public String toString() {
        return value;
    }
}

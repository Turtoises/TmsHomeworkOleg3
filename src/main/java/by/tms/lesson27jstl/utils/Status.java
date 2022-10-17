package by.tms.lesson27jstl.utils;

public enum Status {

    STUDENT("Student"),
    TEACHER("Teacher");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

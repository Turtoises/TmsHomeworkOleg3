package by.tms.lesson26jsp.pojo;

import java.util.Objects;

public class UserDate {

    private String firstName;
    private String lastName;
    private String userNumber;
    private String[] course;

    public UserDate(String firstName, String lastName, String userNumber, String[] course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userNumber = userNumber;
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String[] getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDate userDate = (UserDate) o;
        return Objects.equals(firstName, userDate.firstName) && Objects.equals(lastName, userDate.lastName) && Objects.equals(userNumber, userDate.userNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userNumber);
    }
}

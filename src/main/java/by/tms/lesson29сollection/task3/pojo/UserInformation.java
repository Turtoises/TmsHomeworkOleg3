package by.tms.lesson29сollection.task3.pojo;

import java.util.Objects;

public class UserInformation {
    private String firstName;
    private String lastName;
    private int userID;

    public UserInformation(String firstName, String lastName, int userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInformation that = (UserInformation) o;
        return userID == that.userID && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userID);
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", userID=" + userID +
                '}';
    }
}

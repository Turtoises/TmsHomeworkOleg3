package by.tms.lesson27jstl.pojo;

import by.tms.lesson27jstl.utils.InitialNumber;
import by.tms.lesson27jstl.utils.Status;

import java.util.Objects;

public class UserDate {

    private String firstName;
    private String lastName;
    private long initNumber;
    private Status status;

    public UserDate(String firstName, String lastName, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.initNumber = InitialNumber.getInitialNumber();
    }

    public UserDate(String firstName, String lastName, long initNumber, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.initNumber = initNumber;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getInitNumber() {
        return initNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setInitNumber(long initNumber) {
        this.initNumber = initNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDate userDate = (UserDate) o;
        return initNumber == userDate.initNumber && Objects.equals(firstName, userDate.firstName) && Objects.equals(lastName, userDate.lastName) && status == userDate.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, initNumber, status);
    }
}

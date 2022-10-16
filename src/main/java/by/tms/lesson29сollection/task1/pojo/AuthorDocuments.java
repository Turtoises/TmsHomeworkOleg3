package by.tms.lesson29сollection.task1.pojo;

import java.util.Objects;

public class AuthorDocuments {

    private String firstName;
    private String lastName;
    private int compilerID;

    public AuthorDocuments(String firstName, String lastName, int compilerID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.compilerID = compilerID;
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

    public int getCompilerID() {
        return compilerID;
    }

    public void setCompilerID(int compilerID) {
        this.compilerID = compilerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDocuments that = (AuthorDocuments) o;
        return compilerID == that.compilerID && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, compilerID);
    }

    @Override
    public String toString() {
        return "firstName=" + firstName +
                ", lastName=" + lastName +
                ", compilerID=" + compilerID;
    }
}

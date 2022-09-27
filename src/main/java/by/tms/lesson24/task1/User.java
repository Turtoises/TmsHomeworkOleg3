package by.tms.lesson24.task1;

import java.util.Arrays;

public class User {
    private String firstName;
    private String lastName;
    private String language;
    private String gender;
    private String[] programmingLanguage;
    private String additionalInformation;
    private String password;

    public User(String firstName, String lastName,
                String language, String gender, String[] programmingLanguage,
                String additionalInformation, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
        this.gender = gender;
        this.programmingLanguage = programmingLanguage;
        this.additionalInformation = additionalInformation;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLanguage() {
        return language;
    }

    public String getGender() {
        return gender;
    }

    public String[] getProgrammingLanguage() {
        return programmingLanguage;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", language='" + language + '\'' +
                ", gender='" + gender + '\'' +
                ", programmingLanguage=" + Arrays.toString(programmingLanguage) +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}

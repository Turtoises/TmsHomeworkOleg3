package by.tms.lesson28ClassObject.task1;

import java.util.Objects;

public abstract class Person implements Cloneable {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    public Person(String firstNane, String lastNane, int age, Gender gender) {
        this.firstName = firstNane;
        this.lastName = lastNane;
        this.age = age;
        this.gender = gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender);
    }

    @Override
    public String toString() {
        return "firstName=" + firstName +
                ", lastName=" + lastName +
                ", age=" + age +
                ", gender=" + gender.getGender();
    }
}

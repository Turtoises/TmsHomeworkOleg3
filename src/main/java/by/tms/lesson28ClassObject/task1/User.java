package by.tms.lesson28ClassObject.task1;

import java.util.Objects;

public class User extends Person implements Cloneable {

    private Adress adress;

    public User(String firstNane, String lastNane, int age, Gender gender, Adress adress) {
        super(firstNane, lastNane, age, gender);
        this.adress = adress;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(adress, user.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), adress);
    }

    @Override
    public String toString() {
        return "User{" +
                super.toString() +
                " adress=" + adress +
                "} ";
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        User userCopy = (User) super.clone();

        return userCopy;
    }
}

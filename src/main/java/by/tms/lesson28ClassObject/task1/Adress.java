package by.tms.lesson28ClassObject.task1;

import java.util.Objects;

public class Adress implements Cloneable {

    private String streetName;
    private int numberHouse;
    private int numberApartment;

    public Adress(String streetName, int numberHouse, int numberApartment) {
        this.streetName = streetName;
        this.numberHouse = numberHouse;
        this.numberApartment = numberApartment;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }

    public int getNumberApartment() {
        return numberApartment;
    }

    public void setNumberApartment(int numberApartment) {
        this.numberApartment = numberApartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return numberHouse == adress.numberHouse && numberApartment == adress.numberApartment && Objects.equals(streetName, adress.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, numberHouse, numberApartment);
    }

    @Override
    public String toString() {
        return "streetName " + streetName +
                ", numberHouse " + numberHouse +
                ", numberApartment " + numberApartment;
    }

    @Override
    public Adress clone() throws CloneNotSupportedException {
        return (Adress) super.clone();
    }
}

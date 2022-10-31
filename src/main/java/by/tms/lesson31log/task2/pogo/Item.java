package by.tms.lesson31log.task2.pogo;

import java.util.Objects;

public class Item {

    private String name;
    private long itemID;
    private double price;

    public Item(String name, long itemID, double price) {
        this.name = name;
        this.itemID = itemID;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemID == item.itemID && Double.compare(item.price, price) == 0 && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, itemID, price);
    }

    @Override
    public String toString() {
        return "Your item: name=" + name + '\'' +
                ", itemID=" + itemID +
                ", price=" + price;
    }
}

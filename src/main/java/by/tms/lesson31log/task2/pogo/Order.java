package by.tms.lesson31log.task2.pogo;

import by.tms.lesson31log.task2.utils.MapItemUtil;
import by.tms.lesson31log.task2.utils.MapUserUtil;

import java.util.Objects;

public class Order {
    private long userID;
    private long itemID;
    private int amountItem;

    public Order(long userID, long itemID, int amountItem) {
        this.userID = userID;
        this.itemID = itemID;
        this.amountItem = amountItem;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public int getAmountItem() {
        return amountItem;
    }

    public void setAmountItem(int amountItem) {
        this.amountItem = amountItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return userID == order.userID && itemID == order.itemID && amountItem == order.amountItem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, itemID, amountItem);
    }

    @Override
    public String toString() {
        return MapUserUtil.getUser(userID).toString() +
                "\n" +
                MapItemUtil.getItem(itemID).toString() +
                ", amount=" + amountItem;
    }
}

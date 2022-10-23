package by.tms.lesson31log.task2.pogo;

import java.util.Objects;

public class User {
    private String name;
    private long ownID;

    public User(String name, long ownID) {
        this.name = name;
        this.ownID = ownID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOwnID() {
        return ownID;
    }

    public void setOwnID(long ownID) {
        this.ownID = ownID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ownID == user.ownID && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ownID);
    }

    @Override
    public String toString() {
        return "User: name='" + name +
                ", ownID=" + ownID;
    }
}

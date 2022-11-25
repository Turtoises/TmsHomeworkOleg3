package by.tms.lesson36Pattern2.task3observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AbstractEditor implements Editor {

    private Currency currency;
    protected List<Subscriber> subscribers = new ArrayList<>();

    public AbstractEditor(Currency currency) {
        this.currency = currency;
    }
}

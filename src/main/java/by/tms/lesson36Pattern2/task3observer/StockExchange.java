package by.tms.lesson36Pattern2.task3observer;

import java.util.HashMap;
import java.util.Map;

public class StockExchange {

    private Map<Currency, Double> currencyMap = new HashMap<>();
    private Map<Currency, AbstractEditor> currencyEditor = new HashMap<>();

    public StockExchange() {
        addCurrency(Currency.DOLLAR, 2.0);
        addCurrency(Currency.EURO, 3.0);
    }

    public void addCurrency(Currency currency, Double course) {
        currencyMap.put(currency, course);
        currencyEditor.put(currency, new EditorImpl(currency));
    }

    public void addSubscriber(Currency currency, Subscriber subscriber) {
        currencyEditor.get(currency).addSuscriber(subscriber);
    }

    public void removeSubscriber(Currency currency, Subscriber subscriber) {
        currencyEditor.get(currency).removeSuscriber(subscriber);
    }

    public void changeCurrency(Currency currency, Double newRent) {
        currencyMap.put(currency, newRent);
        currencyEditor.get(currency).notifySuscriber();
    }
}

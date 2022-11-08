package by.tms.lesson36Pattern2.task3observer;

public class MainObserver {

    public static void main(String[] args) {

        StockExchange stockExchange=new StockExchange();

        User user1=new User("ivan","mf@rambler");
        User user2=new User("petr","ju@rambler");
        User user3=new User("fedr","mk@rambler");

        stockExchange.addSubscriber(Currency.DOLLAR,user1);
        stockExchange.addSubscriber(Currency.DOLLAR,user2);
        stockExchange.addSubscriber(Currency.EURO,user3);
        stockExchange.addSubscriber(Currency.DOLLAR,user3);

        stockExchange.changeCurrency(Currency.DOLLAR,3.0);


    }
}

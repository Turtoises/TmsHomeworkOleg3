package by.tms.lesson36Pattern2.task3observer;

public interface Editor {

    void addSuscriber(Subscriber subscriber);

    void removeSuscriber(Subscriber subscriber);

    void notifySuscriber();

}

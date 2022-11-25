package by.tms.lesson36Pattern2.task3observer;

public class EditorImpl extends AbstractEditor {

    public EditorImpl(Currency currency) {
        super(currency);
    }

    @Override
    public void addSuscriber(Subscriber subscriber) {
        subscribers.add(subscriber);

    }

    @Override
    public void removeSuscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySuscriber() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
}

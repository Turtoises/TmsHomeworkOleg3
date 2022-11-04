package by.tms.lesson35patterns.task3abstractfactory;

public class FactoryMan implements AbstractFactoryNationality{
    @Override
    public Pole createPole() {
        return new PoleMan();
    }

    @Override
    public Belarusian createBelarusian() {
        return new BelarusianMan();
    }

    @Override
    public Ukrainian createUkrainian() {
        return new UkrainianMan();
    }
}

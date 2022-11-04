package by.tms.lesson35patterns.task3abstractfactory;

public class FactoryWoman implements AbstractFactoryNationality{
    @Override
    public Pole createPole() {
        return new PoleWoman();
    }

    @Override
    public Belarusian createBelarusian() {
        return new BelarusianWoman();
    }

    @Override
    public Ukrainian createUkrainian() {
        return new UkrainianWoman();
    }
}

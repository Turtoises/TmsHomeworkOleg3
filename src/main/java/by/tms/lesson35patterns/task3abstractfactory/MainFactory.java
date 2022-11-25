package by.tms.lesson35patterns.task3abstractfactory;

public class MainFactory {

    public static void main(String[] args) {

        Pole poleWoman = new FactoryWoman().createPole();

        System.out.println(poleWoman);

    }
}

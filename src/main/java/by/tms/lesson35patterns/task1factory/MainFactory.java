package by.tms.lesson35patterns.task1factory;

public class MainFactory {

    public static void main(String[] args) {

        EngineerFactory engineerFactory = new EngineerFactory();

        Employer engineer = engineerFactory.create(EngineerAppointment.ENGINEER);
        engineer.setName("Ivan");
        engineer.setSurname("Ivanov");

        Employer engineer1st = engineerFactory.create(EngineerAppointment.ENGINEER_1_CLASS);
        engineer1st.setName("Fedr");
        engineer1st.setSurname("Ivanov");

        System.out.println(engineer);
        System.out.println(engineer1st);
    }
}

package by.tms.lesson35patterns.task1factory;

public class EngineerFactory implements EmployerFactories {

    @Override
    public Employer create(EngineerAppointment engineerAppointment) {

        switch (engineerAppointment) {
            case ENGINEER -> {
                return new Engineer();
            }
            case ENGINEER_2_CLASS -> {
                return new EngineerSecondClass();
            }
            case ENGINEER_1_CLASS -> {
                return new EngineerFirstClass();
            }
            case ENGINEER_LEAD -> {
                return new EngineerLead();
            }
            default -> throw new IllegalArgumentException();
        }
    }
}

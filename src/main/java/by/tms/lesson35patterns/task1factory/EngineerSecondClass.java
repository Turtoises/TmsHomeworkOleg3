package by.tms.lesson35patterns.task1factory;

public class EngineerSecondClass extends Employer {

    public EngineerSecondClass() {
        setEngineerAppointment(EngineerAppointment.ENGINEER_2_CLASS);
        setSalary(EngineerSolary.ENGINEER_2_CLASS);
        getDuties().add("do a simple job");
    }
}

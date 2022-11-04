package by.tms.lesson35patterns.task1factory;

public class EngineerFirstClass extends Employer {

    public EngineerFirstClass() {
        setEngineerAppointment(EngineerAppointment.ENGINEER_1_CLASS);
        setSalary(EngineerSolary.ENGINEER_1_CLASS);
        getDuties().add("do the hard work");
    }
}

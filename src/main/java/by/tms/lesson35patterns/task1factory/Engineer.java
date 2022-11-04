package by.tms.lesson35patterns.task1factory;

public class Engineer extends Employer {

    public Engineer() {
        setEngineerAppointment(EngineerAppointment.ENGINEER);
        setSalary(EngineerSolary.ENGINEER_SOLARY);
        getDuties().add("Learning");
        getDuties().add("Helping");
    }
}

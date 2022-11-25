package by.tms.lesson35patterns.task1factory;

public class EngineerLead extends Employer {

    public EngineerLead() {
        setEngineerAppointment(EngineerAppointment.ENGINEER_LEAD);
        setSalary(EngineerSolary.ENGINEER_LEAD);
        getDuties().add("supervise other engineers");
    }
}

package by.tms.lesson35patterns.task1factory;

public enum EngineerAppointment {

    ENGINEER("Engineer"),
    ENGINEER_1_CLASS("First category engineer"),
    ENGINEER_2_CLASS("Second category engineer"),
    ENGINEER_LEAD("Lead engineer");

    private String value;

    EngineerAppointment(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

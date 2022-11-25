package by.tms.lesson36Pattern2.task1adapter;

public class AdapterStudentToWoker extends Worker {

    private Student student;

    public AdapterStudentToWoker(Student student) {

        this.student = student;
    }

    @Override
    public String getAppointment() {
        return "Intern";
    }

    @Override
    public String getFirstName() {
        return student.getName();
    }

    @Override
    public Double getHourWeek() {
        return 4.0;
    }

    @Override
    public String getLastName() {
        return student.getSurname();
    }

    @Override
    public Double getSolar() {
        return 0.0;
    }
}

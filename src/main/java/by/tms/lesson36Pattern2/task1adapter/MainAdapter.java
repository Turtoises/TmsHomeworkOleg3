package by.tms.lesson36Pattern2.task1adapter;

public class MainAdapter {

    public static void main(String[] args) {

        Worker worker = Worker.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .appointment("Engineer")
                .solar(10000.0)
                .hourWeek(8.0)
                .build();

        Student student = Student.builder()
                .name("Petr")
                .surname("Aleksandrovich")
                .build();

        ServiceWork.printInfo(worker);

        ServiceWork.printInfo(new AdapterStudentToWoker(student));
    }
}

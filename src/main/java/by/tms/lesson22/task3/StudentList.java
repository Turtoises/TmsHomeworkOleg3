package by.tms.lesson22.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class StudentList {

    private static List<Student> studentList = new ArrayList<>();

    private static void addStudentList() {
        studentList = Arrays.asList(
                new Student("Ivan", "Ivanov"),
                new Student("Tana", "Petrova"),
                new Student("Oleg", "Sidorov"),
                new Student("Aleksey", "Fedorov"),
                new Student("Fedor", "Nikitin"),
                new Student("Rafal", "Sidorov"),
                new Student("Veniamin", "Sidorov"),
                new Student("Oleg", "Sidorov")
        );
    }

    public static List<Student> getStudentList() {
        addStudentList();
        return studentList;
    }
}

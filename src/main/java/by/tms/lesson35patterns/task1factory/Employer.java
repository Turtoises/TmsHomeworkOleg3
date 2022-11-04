package by.tms.lesson35patterns.task1factory;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Employer {

    private String name;
    private String surname;
    private EngineerAppointment engineerAppointment;
    private double salary;
    private List<String> duties=new ArrayList<>();
}

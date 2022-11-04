package by.tms.lesson35patterns.task3abstractfactory;

import lombok.Data;


public class PoleWoman extends Woman implements Pole{

    @Override
    public String toString() {
        return "PoleWoman{} " + super.toString();
    }
}

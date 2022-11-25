package by.tms.lesson35patterns.task2builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Plane {
    private Integer number;
    private Engine engine;
    private Hull hull;
    private Wheel wheel;
    private Integer numberSeats;

}

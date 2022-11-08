package by.tms.lesson36Pattern2.task1adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    private String firstName;
    private String lastName;
    private String appointment;
    private Double solar;
    private Double hourWeek;

}

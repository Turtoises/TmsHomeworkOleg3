package by.tms.lesson35patterns.task4ptototype;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Man extends Person{

    private final String gender = "man";
    private Double weight;
    private Double high;

    public Man(Man man) {
        super(man);
        this.weight = man.getWeight();
        this.high=man.getHigh();
    }

    @Override
    public Man creatPrototype() {
        return new Man(this);
    }
}

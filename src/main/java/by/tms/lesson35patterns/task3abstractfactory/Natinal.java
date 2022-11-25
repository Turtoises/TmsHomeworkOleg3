package by.tms.lesson35patterns.task3abstractfactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum Natinal {
    POLE("Pole"),
    BELARUSIAN("Belarusian"),
    UKRAINIAN("Ukrainian");

    private String value;

    @Override
    public String toString() {
        return value;
    }
}

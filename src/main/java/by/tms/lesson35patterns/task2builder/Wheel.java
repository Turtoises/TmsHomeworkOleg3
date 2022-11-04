package by.tms.lesson35patterns.task2builder;

import by.tms.lesson35patterns.task2builder.util.FindNullOrEmptyUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Wheel {

    private String mark;
    private Integer diameter;
    private String rubberType;

    public static class Builder {
        private Wheel wheel;

        public Builder() {
            this.wheel = new Wheel();
        }

        public Builder mark(String mark) {
            wheel.setMark(mark);
            return this;
        }

        public Builder diameter(int diameter) {
            wheel.setDiameter(diameter);
            return this;
        }

        public Builder rubberType(String rubberType) {
            wheel.setRubberType(rubberType);
            return this;
        }

        public Wheel build() {
            FindNullOrEmptyUtils.isAnyNull(wheel.mark, wheel.diameter, wheel.rubberType);
            return wheel;
        }
    }
}

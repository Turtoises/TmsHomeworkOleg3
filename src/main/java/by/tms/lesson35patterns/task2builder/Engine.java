package by.tms.lesson35patterns.task2builder;

import by.tms.lesson35patterns.task2builder.util.FindNullOrEmptyUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Engine {

    private Double power;
    private String mark;

    public Engine() {
    }

    public static class Builder {
        private Engine engine;

        public Builder() {
            engine = new Engine();
        }

        public Builder power(Double power) {
            engine.setPower(power);
            return this;
        }

        public Builder mark(String mark) {
            engine.setMark(mark);
            return this;
        }

        public Engine build() {
            FindNullOrEmptyUtils.isAnyNull(engine.mark, engine.power);
            return engine;
        }
    }
}

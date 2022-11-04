package by.tms.lesson35patterns.task2builder;

import by.tms.lesson35patterns.task2builder.util.FindNullOrEmptyUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Hull {

    private String gradeSteel;
    private Double steelStrength;

    public Hull() {
    }

    public static class Builder {
        private Hull hull;

        public Builder() {
            this.hull = new Hull();
        }

        public Builder gradeSteel(String gradeSteel) {
            hull.setGradeSteel(gradeSteel);
            return this;
        }

        public Builder steelStrength(Double steelStrength) {
            hull.setSteelStrength(steelStrength);
            return this;
        }

        public Hull build() {
            FindNullOrEmptyUtils.isAnyNull(hull.gradeSteel, hull.steelStrength);
            return hull;
        }
    }
}

package by.tms.lesson31log.task3;

import java.util.Optional;

public final class DividingTwoNumbersUtil {

    private DividingTwoNumbersUtil() {
    }

    public static Optional<Long> getResult(long first, long second) {
        if (second == 0) {
            return Optional.empty();
        }

        int sign = (first < 0 && second < 0 || first > 0 && second > 0) ? 1 : -1;

        first = (first < 0) ? -first : first;
        second = (second < 0) ? -second : second;

        if (first < second) {
            return Optional.of(0L);
        }
        long result = 0;
        while (first >= second) {
            first -= second;
            result++;
        }
        return Optional.of(result * sign);
    }
}

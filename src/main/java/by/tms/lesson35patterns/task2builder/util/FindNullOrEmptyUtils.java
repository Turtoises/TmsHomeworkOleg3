package by.tms.lesson35patterns.task2builder.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public final class FindNullOrEmptyUtils {

    private FindNullOrEmptyUtils() {
    }

    public static boolean isAnyNull(Object... obj) {
        if (obj == null || Arrays.stream(obj).anyMatch(object -> object == null || object.toString().isEmpty())) {
            log.info("There are empty fields");
            return true;
        }
        return false;
    }
}

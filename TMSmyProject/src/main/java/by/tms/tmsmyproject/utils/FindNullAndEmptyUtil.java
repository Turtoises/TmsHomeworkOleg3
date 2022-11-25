package by.tms.tmsmyproject.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;

@Slf4j
public final class FindNullAndEmptyUtil {

    private FindNullAndEmptyUtil() {
    }

    public static boolean isAnyNullOrEmpty(Object... obj) {
        if (obj == null || Arrays.stream(obj).anyMatch(object -> object == null || object.toString().isEmpty())) {
            log.info("Find Null");
            return true;
        }
        return false;
    }

    public static boolean isAllNull(Object... obj) {
        if (obj == null) {
            return false;
        }
        if (Arrays.stream(obj).allMatch(Objects::isNull)) {
            return true;
        }
        return false;
    }
}

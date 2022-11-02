package by.tms.lesson33sql.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;

@Slf4j
public class FindNullUtils {

    private FindNullUtils() {
    }

    public static boolean isAnyNull(Object... obj) {
        if (obj == null || Arrays.stream(obj).anyMatch(object -> object == null || object.toString().isEmpty())) {
            log.info("Find Null");
            return true;
        }
        return false;
    }
}


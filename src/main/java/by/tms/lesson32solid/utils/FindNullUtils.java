package by.tms.lesson32solid.utils;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;

@Slf4j
public final class FindNullUtils {

    private static Logger logger = LoggerFactory.getLogger("FindNullUtils");

    private FindNullUtils() {
    }

    public static boolean isAnyNull(Object... obj) {
        if (obj == null || Arrays.stream(obj).anyMatch(Objects::isNull)) {
            logger.info("Find Null");
            return true;
        }
        return false;
    }
}

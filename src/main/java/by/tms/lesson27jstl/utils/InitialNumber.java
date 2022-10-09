package by.tms.lesson27jstl.utils;

public final class InitialNumber {

    private static long START_VALUE = 1L;

    private InitialNumber() {
    }

    public static long getInitialNumber() {
        return START_VALUE++;
    }
}

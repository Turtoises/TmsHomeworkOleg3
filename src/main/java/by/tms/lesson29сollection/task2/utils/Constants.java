package by.tms.lesson29сollection.task2.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class Constants {

    private Constants() {
    }

    public static final Path PATH_FILE_WITH_NAME = Paths.get("src", "main", "resources", "lesson29", "names.txt");
    public static final int MAX_YEAR_USER = 100;
    public static final int AMOUNT_USER_IN_LIST = 1000;
    public static final int AMOUNT_USER_FOR_PRINT = 10;
}

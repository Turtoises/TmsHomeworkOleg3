package by.tms.lesson33sql.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class Constants {

    private Constants() {
    }

    public static final Path DATABASE_PROPERTIES_FILE_PATH = Paths.get("src", "main", "resources", "database.properties");

    public static final String DELETE_STUDENT_STATEMENT="DELETE FROM students WHERE id=?";

    public static final String DELETE_CITY_STATEMENT="DELETE FROM cities WHERE id=?";

    public static final String INSERT_STUDENT_STATEMENT="INSERT INTO students (name,surname,city_id) VALUES (?,?,?);";

    public static final String INSERT_CITY_STATEMENT="INSERT INTO cities (city) VALUES (?);";

    public static final String SELECT_CITY_STATEMENT="SELECT * FROM cities WHERE city=?;";

    public static final String SELECT_STUDENT_INF_STATEMENT="SELECT name,surname,city " +
            "FROM students JOIN cities ON students.city_id = cities.id;";
}

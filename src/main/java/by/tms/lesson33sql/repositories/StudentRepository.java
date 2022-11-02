package by.tms.lesson33sql.repositories;

import by.tms.lesson33sql.entities.Student;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface StudentRepository extends Repository<Student> {

    public ResultSet getResulSet(String statement) throws SQLException, IOException;

}

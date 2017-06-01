package db.layer;

import model.layer.Employee;

import java.sql.SQLException;


/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface EmployeeDbIf {
    void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) throws SQLException;

    boolean update(Employee employee, String personId) throws SQLException;

    boolean delete(String id) throws SQLException;

    Employee read(String id) throws SQLException;
}

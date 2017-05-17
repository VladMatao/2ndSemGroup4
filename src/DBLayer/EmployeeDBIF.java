package DBLayer;

import ModelLayer.Employee;
import ModelLayer.Person;

import java.sql.SQLException;


/**
 * Created by Alexander on 5/12/2017.
 */
public interface EmployeeDBIF {
    void create (String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, String department) throws SQLException;
    boolean update (Person person,Employee employee, String personId) throws SQLException;
    boolean delete (String id) throws SQLException;
    Employee read (String id) throws SQLException;
}

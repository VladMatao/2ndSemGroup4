package DBLayer;

import ModelLayer.Employee;
import ModelLayer.Person;

import java.sql.SQLException;


/**
 * Created by Alexander on 5/12/2017.
 */
public interface EmployeeDBIF {
    void create(String id,String department, java.util.Date schedule) throws SQLException;
    boolean update (Employee empl) throws SQLException;
    boolean delete (String id) throws SQLException;
    Employee read (String id) throws SQLException;
}

package ControlLayer;
import DBLayer.*;
import ModelLayer.*;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Group 4  on 09.05.2017.
 */
public class EmployeeController {
    EmployeeDB employeeDb;

    public EmployeeController() {
        employeeDb = new EmployeeDB();
    }

    public boolean create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, Date schedule, String department){
        try {
            employeeDb.create(id, f_name, l_name, CNP, address, phNr, city, position, wage, schedule,department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Employee read(String id){
        Employee employee = null;
        try {
            employee = employeeDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public boolean update(Employee employee){

        try {
            return employeeDb.update(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = employeeDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

package control.layer;

import db.layer.EmployeeDb;
import model.layer.Employee;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageEmployee {


    private EmployeeDb employeeDb;

    public ManageEmployee() {
        employeeDb = new EmployeeDb();
    }

    public boolean createEmployee(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, String department) {
        try {
            employeeDb.create(id, f_name, l_name, CNP, address, phNr, city, position, wage, department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Employee readEmployee(String personId) {
        Employee employee = null;
        try {
            employee = employeeDb.read(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


    public boolean updateEmployee(Employee employee, String personId) {

        try {
            return employeeDb.update(employee, personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteEmployee(String personId) {
        boolean aux = false;
        try {
            aux = employeeDb.delete(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }

}

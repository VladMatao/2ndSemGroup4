package ControlLayer;

import ModelLayer.Employee;

import java.sql.SQLException;
import DBLayer.EmployeeDB;
import ModelLayer.Person;

/**
 * Created by Mircea on 24-May-17.
 */
public class ManagePerson {


    private EmployeeDB employeeDB;

    public ManagePerson() {
        employeeDB = new EmployeeDB();
    }

    public boolean create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage,String department){
        try {
            employeeDB.create(id, f_name, l_name, CNP, address, phNr, city, position, wage, department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Person read(String id){
        Person person = null;
        try {
            person = employeeDB.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public boolean update(Product product,String barcode){

        try {
            return productDb.update(product,barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = employeeDB.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

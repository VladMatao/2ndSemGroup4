package ControlLayer;

import DBLayer.ManagerDB;
import ModelLayer.Employee;

import java.sql.SQLException;
import DBLayer.EmployeeDB;
import ModelLayer.Manager;
import ModelLayer.Person;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManagePerson {


    private EmployeeDB employeeDB;
    private ManagerDB managerDB;

    public ManagePerson() {
        employeeDB = new EmployeeDB();
        managerDB= new ManagerDB();
    }

    public boolean createEmployee(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage,String department){
        try {
            employeeDB.create(id, f_name, l_name, CNP, address, phNr, city, position, wage, department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean createManager(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage,String password){
        try {
            managerDB.create(id, f_name, l_name, CNP, address, phNr, city, position, wage, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Employee readEmployee(String personId){
        Employee employee = null;
        try {
            employee = employeeDB.read(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


    public Manager readManager(String personId){
        Manager manager = null;
        try {
            manager = managerDB.read(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }
    public boolean updateEmployee(Employee employee,String personId){

        try {
            return employeeDB.update(employee,personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateManager(Manager manager,String personId){

        try {
            return managerDB.update(manager,personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteEmployee(String personId){
        boolean aux = false;
        try {
            aux = employeeDB.delete(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }

    public boolean deleteManager(String personId){
        boolean aux = false;
        try {
            aux = managerDB.delete(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

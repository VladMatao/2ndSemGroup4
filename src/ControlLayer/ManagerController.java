package ControlLayer;
import ModelLayer.*;
import java.sql.SQLException;
/**
 * Created by Group 4  on 09.05.2017.
 */
public class ManagerController {
    ManagerDB managerDb;

    public ManagerController() {
        managerDb = new ManagerDB();
    }

    public boolean create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, String password){
        try {
            managerDb.create(id, f_name, l_name, CNP, address, phNr, city, position, wage,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Manager read(String id){
        Manager manager = null;
        try {
            manager = managerDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }

    public boolean update(Manager manager){

        try {
            return managerDb.update(manager);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = managerDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

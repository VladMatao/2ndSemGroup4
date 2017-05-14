package ControlLayer;
import DBLayer.*;
import ModelLayer.*;
import java.sql.SQLException;
/**
 * Created by Group 4  on 09.05.2017.
 */
public class PersonController {
    PersonDB personDb;

    public PersonController() {
        personDb = new PersonDB();
    }

    /*public boolean create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage){
        try {
            personDb.create(id,f_name,l_name,CNP,address,phNr,city,position,wage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }*/

    public Person read(String id){
        Person person = null;
        try {
            person = personDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    /*public boolean update(Person person){

        try {
            return personDb.update(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }*/

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = personDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

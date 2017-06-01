package control.layer;

import db.layer.PersonDb;
import model.layer.Person;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManagePerson {


    private PersonDb personDb;

    public ManagePerson() {
        personDb = new PersonDb();
    }

    public boolean createEmployee(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) {
        try {
            personDb.create(id, f_name, l_name, CNP, address, phNr, city, position, wage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Person readEmployee(String personId) {
        Person person = null;
        try {
            person = personDb.read(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }


    public boolean updateEmployee(Person person, String personId) {

        try {
            return personDb.update(person, personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteEmployee(String personId) {
        boolean aux = false;
        try {
            aux = personDb.delete(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }

}
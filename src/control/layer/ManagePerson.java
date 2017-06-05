package control.layer;

import db.layer.PersonDb;
import model.layer.Person;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManagePerson {


    private final PersonDb personDb;

    public ManagePerson() {
        personDb = new PersonDb();
    }

    public void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) {
        personDb.create(id, f_name, l_name, CNP, address, phNr, city, position, wage);
    }

    public ArrayList<Person> readAll() {
        ArrayList<Person> allpersons = null;
        try {
            allpersons = personDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allpersons;
    }


    public void update(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) {
        Person person = new Person(id, f_name, l_name, CNP, address, phNr, city, position, wage);
        personDb.update(person, id);
    }


    public void delete(String personId) {
        try {
            personDb.delete(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package control.layer;

import db.layer.PersonDb;
import model.layer.Company;
import model.layer.Person;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManagePerson {


    private PersonDb personDb;

    public ManagePerson() {
        personDb = new PersonDb();
    }

    public boolean create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) {
        try {
            personDb.create(id, f_name, l_name, CNP, address, phNr, city, position, wage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Person read(String personId) {
        Person person = null;
        try {
            person = personDb.read(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
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


    public boolean update(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) {
        Person person = new Person(id, f_name, l_name, CNP, address, phNr, city, position, wage);
        try {
            return personDb.update(person, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean delete(String personId) {
        boolean aux = false;
        try {
            aux = personDb.delete(personId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }

}

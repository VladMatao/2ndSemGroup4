package db.layer;

import model.layer.Person;

import java.sql.SQLException;


/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface PersonDbIf {
    void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) throws SQLException;

    boolean update(Person person, String personId) throws SQLException;

    boolean delete(String id) throws SQLException;

    Person read(String id) throws SQLException;
}

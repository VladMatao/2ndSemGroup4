package DBLayer;

import ModelLayer.Manager;

import java.sql.SQLException;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface ManagerDBIF {
    void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, String password) throws SQLException;
    boolean update(Manager manager, String personId) throws SQLException;
    boolean delete (String id) throws SQLException;
    Manager read (String id) throws SQLException;

}

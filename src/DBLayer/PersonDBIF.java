package DBLayer;

import ModelLayer.Person;

import java.sql.SQLException;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface PersonDBIF  {

   void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) throws SQLException;
   boolean update (Person person, String personID) throws SQLException;
   boolean delete (String id) throws SQLException;
   Person read (String id) throws SQLException;
}

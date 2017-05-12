package DBLayer;

import ModelLayer.Person;

import java.sql.SQLException;

/**
 * Created by Alexander on 5/12/2017.
 */
public interface PersonDBIF  {

   void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) throws SQLException;
   boolean update (Person person) throws SQLException;
   boolean delete (String id) throws SQLException;
   Person read (String id) throws SQLException;
}

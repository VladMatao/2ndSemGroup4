package db.layer;

import model.layer.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class PersonDb implements PersonDbIf {

    @Override
    public void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            PreparedStatement psPersonCreation = conn.prepareStatement("INSERT INTO Person (PersonID, F_name, L_name, CNP, Adress, Phone_number, City, Position, Wage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            psPersonCreation.setString(1, id);
            psPersonCreation.setString(2, f_name);
            psPersonCreation.setString(3, l_name);
            psPersonCreation.setInt(4, CNP);
            psPersonCreation.setString(5, address);
            psPersonCreation.setString(6, phNr);
            psPersonCreation.setString(7, city);
            psPersonCreation.setString(8, position);
            psPersonCreation.setDouble(9, wage);
            psPersonCreation.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception in PersonDb.create()!");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Person person, String personId) {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            PreparedStatement psttmPerson = conn.prepareStatement("UPDATE Person SET F_name = ?, L_name = ?, CNP = ?, Adress = ?, Phone_number = ?, City = ?, Position = ?, Wage = ? WHERE PersonID = ?");
            psttmPerson.setString(1, person.getF_name());
            psttmPerson.setString(2, person.getL_name());
            psttmPerson.setInt(3, person.getCNP());
            psttmPerson.setString(4, person.getAddress());
            psttmPerson.setString(5, person.getPhNr());
            psttmPerson.setString(6, person.getCity());
            psttmPerson.setString(7, person.getposition());
            psttmPerson.setDouble(8, person.getWage());
            psttmPerson.setString(9, personId);

        } catch (SQLException e) {
            System.err.println("Got an exception at personDB.update()");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            String sql = String.format("Delete from Person where PersonID='%s'", id);
            conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DbConnection.closeConnection();
        }
        return true;
    }

    @Override
    public Person read(String id) throws SQLException {
        Person person = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDbCon();
            String sqlPerson = String.format("SELECT * FROM Person where PersonID =%s", id);
            ResultSet rs = conn.createStatement().executeQuery(sqlPerson);
            if (rs.next()) {
                person = buildObject(rs);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return person;
    }

    public ArrayList<Person> readAll() throws SQLException {
        ArrayList<Person> personcollection = new ArrayList<>();
        Person person;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDbCon();
            String sql = "SELECT * FROM Person ";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                person = buildObject(rs);
                personcollection.add(person);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return personcollection;
    }


    private static Person buildObject(ResultSet rs) throws SQLException {
        Person person;
        try {
            String id = rs.getString(1);
            String f_name = rs.getString(2);
            String l_name = rs.getString(3);
            int CNP = rs.getInt(4);
            String address = rs.getString(5);
            String phNr = rs.getString(6);
            String city = rs.getString(7);
            String position = rs.getString(8);
            double wage = rs.getDouble(9);

            person = new Person(id, f_name, l_name, CNP, address, phNr, city, position, wage);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return person;
    }
}
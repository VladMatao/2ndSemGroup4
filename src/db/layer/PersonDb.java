package db.layer;

import model.layer.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class PersonDb implements PersonDbIf {

    @Override
    public void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            PreparedStatement psEmployeeCreation = conn.prepareStatement("INSERT INTO Employee (PersonID, F_name, L_name, CNP, Adress, Phone_number, City, Position, Wage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            psEmployeeCreation.setString(1, id);
            psEmployeeCreation.setString(2, f_name);
            psEmployeeCreation.setString(3, l_name);
            psEmployeeCreation.setInt(4, CNP);
            psEmployeeCreation.setString(5, address);
            psEmployeeCreation.setString(6, phNr);
            psEmployeeCreation.setString(7, city);
            psEmployeeCreation.setString(8, position);
            psEmployeeCreation.setDouble(9, wage);
            psEmployeeCreation.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception in PersonDb.create()!");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Person person, String personId) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            PreparedStatement psttmEmployee = conn.prepareStatement("UPDATE Employee SET F_name = ?, L_name = ?, CNP = ?, Adress = ?, Phone_number = ?, City = ?, Position = ?, Wage = ? WHERE PersonID = ?");
            psttmEmployee.setString(1, person.getF_name());
            psttmEmployee.setString(2, person.getL_name());
            psttmEmployee.setInt(3, person.getCNP());
            psttmEmployee.setString(4, person.getAddress());
            psttmEmployee.setString(5, person.getPhNr());
            psttmEmployee.setString(6, person.getCity());
            psttmEmployee.setString(7, person.getposition());
            psttmEmployee.setDouble(8, person.getWage());
            psttmEmployee.setString(9, personId);

        } catch (SQLException e) {
            System.err.println("Got an exception at employeeDB.update()");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
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
            java.sql.Connection conn = DbConnection.getInstance().getDBcon();
            String sqlEmployee = String.format("SELECT * FROM Person where PersonID =%s", id);
            ResultSet rs = conn.createStatement().executeQuery(sqlEmployee);
            if (rs.next()) {
                person = buildObject(rs);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return person;
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
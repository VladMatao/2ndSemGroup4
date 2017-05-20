package DBLayer;
import ModelLayer.Manager;
import ModelLayer.Person;

import java.sql.*;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManagerDB implements ManagerDBIF {

    @Override
    public  void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage,String password) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
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
            PreparedStatement psEmployeeCreation = conn.prepareStatement("INSERT INTO Manager (PersonID, Pw) VALUES (?, ?)");
            psEmployeeCreation.setString(1, id);
            psEmployeeCreation.setString(2, password);
            psPersonCreation.executeUpdate();
            psEmployeeCreation.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception in ManagerDB.create()!");
            System.err.println(e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Manager manager, String personId) throws SQLException {
        try {
            PersonDB personDB = new PersonDB();
            personDB.update(manager,personId);
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Manager SET PersonID = ?, Pw= ? WHERE PersonID = ? ");
            psttm.setString(1,manager.getId());
            psttm.setString(2,manager.getPassword());
            psttm.setString(3,personId);
            psttm.executeUpdate();
        } catch(SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }finally{
            DBConnection.closeConnection();
        }
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("Delete from Manager where PersonID='%s'", id);
            String sql2 = String.format("Delete from Person where PersonID='%s'", id);
            conn.createStatement().executeUpdate(sql);
            conn.createStatement().executeUpdate(sql2);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBConnection.closeConnection();
        }
        return true;
    }

    @Override
    public Manager read(String id) throws SQLException{
        Manager manager = null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM Manager where PersonID =%s",id);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                manager = buildObject(rs);
            }
        }catch (SQLException e) {
            throw e;
        }finally{
            DBConnection.closeConnection();
        }
        return manager;
    }


    private static Manager buildObject(ResultSet rs) throws SQLException{
        Manager manager;
        PersonDB personDB= new PersonDB();
        try {

            String id = rs.getString(1);
            Person person = personDB.read(id);
            String password = rs.getString(2);
            String f_name = person.getF_name();
            String l_name = person.getL_name();
            int CNP = person.getCNP();
            String address = person.getAddress();
            String phNr = person.getPhNr();
            String city = person.getCity();
            String position = person.getposition();
            double wage = person.getWage();

            manager = new Manager(id,f_name,l_name,CNP,address,phNr,city,position,wage,password);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return manager;
    }
}

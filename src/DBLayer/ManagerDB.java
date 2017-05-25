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
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttmPerson = conn.prepareStatement("UPDATE Person SET F_name = ?, L_name = ?, CNP = ?, Adress = ?, Phone_number = ?, City = ?, Position = ?, Wage = ?  WHERE PersonID = ?");
            psttmPerson.setString(1,manager.getF_name());
            psttmPerson.setString(2,manager.getL_name());
            psttmPerson.setInt(3,manager.getCNP());
            psttmPerson.setString(4,manager.getAddress());
            psttmPerson.setString(5,manager.getPhNr());
            psttmPerson.setString(6,manager.getCity());
            psttmPerson.setString(7,manager.getposition());
            psttmPerson.setDouble(8,manager.getWage());
            psttmPerson.setString(9,personId);

            psttmPerson.executeUpdate();

            PreparedStatement psttmManager = conn.prepareStatement("UPDATE Manager SET Pw = ? WHERE PersonID = ? ");
            psttmManager.setString(1,manager.getPassword());
            psttmManager.setString(2,personId);

            psttmManager.executeUpdate();
        } catch(SQLException e) {
            System.err.println("Got an exception at ManagerDB.update()");
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
            String sqlManager = String.format("SELECT * FROM Manager where PersonID =%s",id);
            String sqlPerson = String.format("SELECT * FROM Person where PersonID =%s",id);
            ResultSet rs = conn.createStatement().executeQuery(sqlManager);
            ResultSet rs1 = conn.createStatement().executeQuery(sqlPerson);
            if (rs.next() && rs1.next()){
                manager = buildObject(rs,rs1);
            }
        }catch (SQLException e) {
            throw e;
        }finally{
            DBConnection.closeConnection();
        }
        return manager;
    }


    private static Manager buildObject(ResultSet rs, ResultSet rs1) throws SQLException{
        Manager manager;
        try {
            String id = rs.getString(1);
            String password = rs.getString(2);
            String f_name = rs1.getString(2);
            String l_name = rs1.getString(3);
            int CNP = rs1.getInt(4);
            String address = rs1.getString(5);
            String phNr = rs1.getString(6);
            String city = rs1.getString(7);
            String position = rs1.getString(8);
            double wage = rs1.getDouble(9);

            manager = new Manager(id,f_name,l_name,CNP,address,phNr,city,position,wage,password);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return manager;
    }
}
package DBLayer;
import ModelLayer.Employee;
import ModelLayer.Person;

import java.sql.*;
import java.util.*;
import java.sql.Date;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class EmployeeDB implements EmployeeDBIF {

    @Override
    public void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, String department) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String query = " INSERT INTO Employee (PersonID, Departament)"
                    + " values (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            PersonDB personDB= new PersonDB();
            personDB.create(id, f_name, l_name, CNP, address, phNr, city, position, wage);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, department);


            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }finally{
            DBConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Person person,Employee employee, String personId) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            PersonDB personDB = new PersonDB();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Employee SET PersonID = ?, Department = ? WHERE PersonID = ? ");
            personDB.update(person,personId);
            psttm.setString(1,employee.getId());
            psttm.setString(2,employee.getDepartment());
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
            String sql = String.format("Delete from Employee where PersonID='%s'", id);
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
    public Employee read(String id) throws SQLException{
        Employee employee = null;
        PersonDB personDB=new PersonDB();
        Person person= null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM Employee where PersonID =%s",id);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                employee = buildObject(rs);
            }
        }catch (SQLException e) {
            throw e;
        }finally{
            DBConnection.closeConnection();
        }
        return employee;
    }


    private static Employee buildObject(ResultSet rs) throws SQLException{
        Employee employee;
        PersonDB personDB= new PersonDB();
        try {

            String id = rs.getString(1);
            Person person = personDB.read(id);
            String department = rs.getString(2);
            String f_name = person.getF_name();
            String l_name = person.getL_name();
            int CNP = person.getCNP();
            String address = person.getAddress();
            String phNr = person.getPhNr();
            String city = person.getCity();
            String position = person.getposition();
            double wage = person.getWage();

            employee = new Employee(id,f_name,l_name,CNP,address,phNr,city,position,wage,department);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return employee;
    }
}
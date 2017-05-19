package DBLayer;
import ModelLayer.Employee;
import ModelLayer.Person;

import java.sql.*;


/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class EmployeeDB implements EmployeeDBIF {

    @Override
    public  void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage,String department) throws SQLException {
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
            PreparedStatement psEmployeeCreation = conn.prepareStatement("INSERT INTO Employee (PersonID, Department) VALUES (?, ?)");
            psEmployeeCreation.setString(1, id);
            psEmployeeCreation.setString(2, department);
            psPersonCreation.executeUpdate();
            psEmployeeCreation.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception in EmployeeDB.create()!");
            System.err.println(e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
    }

    public void createPerson(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage){
        PersonDB personDB= new PersonDB();
        personDB.create(id, f_name, l_name, CNP, address, phNr, city, position, wage);
    }
    @Override
    public boolean update(Employee employee, String personId) throws SQLException {
        try {
            PersonDB personDB = new PersonDB();
            personDB.update(employee,personId);
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Employee SET PersonID = ?, Department = ? WHERE PersonID = ? ");
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
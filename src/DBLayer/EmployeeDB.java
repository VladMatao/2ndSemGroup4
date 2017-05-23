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

    @Override
    public boolean update(Employee employee, String personId) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttmPerson = conn.prepareStatement("UPDATE Person SET F_name = ?, L_name = ?, CNP = ?, Adress = ?, Phone_number = ?, City = ?, Position = ?, Wage = ?  WHERE PersonID = ?");
            psttmPerson.setString(1,employee.getF_name());
            psttmPerson.setString(2,employee.getL_name());
            psttmPerson.setInt(3,employee.getCNP());
            psttmPerson.setString(4,employee.getAddress());
            psttmPerson.setString(5,employee.getPhNr());
            psttmPerson.setString(6,employee.getCity());
            psttmPerson.setString(7,employee.getposition());
            psttmPerson.setDouble(8,employee.getWage());
            psttmPerson.setString(9,personId);

            psttmPerson.executeUpdate();

            PreparedStatement psttmEmployee = conn.prepareStatement("UPDATE Employee SET Department = ? WHERE PersonID = ? ");
            psttmEmployee.setString(1,employee.getDepartment());
            psttmEmployee.setString(2,personId);

            psttmEmployee.executeUpdate();
        } catch(SQLException e) {
            System.err.println("Got an exception at employeeDB.update()");
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
            String sqlEmployee = String.format("SELECT * FROM Employee where PersonID =%s",id);
            String sqlPerson = String.format("SELECT * FROM Person where PersonID =%s",id);
            ResultSet rs = conn.createStatement().executeQuery(sqlEmployee);
            ResultSet rs1 = conn.createStatement().executeQuery(sqlPerson);
            if (rs.next() && rs1.next()){
                employee = buildObject(rs,rs1);
            }
        }catch (SQLException e) {
            throw e;
        }finally{
            DBConnection.closeConnection();
        }
        return employee;
    }


    private static Employee buildObject(ResultSet rs, ResultSet rs1) throws SQLException{
        Employee employee;
        try {
            String id = rs.getString(1);
            String department = rs.getString(2);
            String f_name = rs1.getString(2);
            String l_name = rs1.getString(3);
            int CNP = rs1.getInt(4);
            String address = rs1.getString(5);
            String phNr = rs1.getString(6);
            String city = rs1.getString(7);
            String position = rs1.getString(8);
            double wage = rs1.getDouble(9);

            employee = new Employee(id,f_name,l_name,CNP,address,phNr,city,position,wage,department);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return employee;
    }
}
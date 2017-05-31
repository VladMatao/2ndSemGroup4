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
            PreparedStatement psEmployeeCreation = conn.prepareStatement("INSERT INTO Employee (PersonID, F_name, L_name, CNP, Adress, Phone_number, City, Position, Wage,Department) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
            psEmployeeCreation.setString(1, id);
            psEmployeeCreation.setString(2, f_name);
            psEmployeeCreation.setString(3, l_name);
            psEmployeeCreation.setInt(4, CNP);
            psEmployeeCreation.setString(5, address);
            psEmployeeCreation.setString(6, phNr);
            psEmployeeCreation.setString(7, city);
            psEmployeeCreation.setString(8, position);
            psEmployeeCreation.setDouble(9, wage);
            psEmployeeCreation.setString(10, department);
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
            PreparedStatement psttmEmployee = conn.prepareStatement("UPDATE Employee SET F_name = ?, L_name = ?, CNP = ?, Adress = ?, Phone_number = ?, City = ?, Position = ?, Wage = ?, Department=?  WHERE PersonID = ?");
            psttmEmployee.setString(1,employee.getF_name());
            psttmEmployee.setString(2,employee.getL_name());
            psttmEmployee.setInt(3,employee.getCNP());
            psttmEmployee.setString(4,employee.getAddress());
            psttmEmployee.setString(5,employee.getPhNr());
            psttmEmployee.setString(6,employee.getCity());
            psttmEmployee.setString(7,employee.getposition());
            psttmEmployee.setDouble(8,employee.getWage());
            psttmEmployee.setString(8,employee.getDepartment());
            psttmEmployee.setString(9,personId);

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
            conn.createStatement().executeUpdate(sql);
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
            ResultSet rs = conn.createStatement().executeQuery(sqlEmployee);
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
            String department = rs.getString(10);

            employee = new Employee(id,f_name,l_name,CNP,address,phNr,city,position,wage,department);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return employee;
    }
}
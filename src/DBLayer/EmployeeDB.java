package DBLayer;

import ModelLayer.Employee;
import ModelLayer.Person;

import java.sql.*;


/**
 * Created by Alexander on 5/12/2017
 */
public class EmployeeDB implements EmployeeDBIF{
    public void create(String id,String department, java.util.Date schedule) throws SQLException {
        try{
            Connection conn = DBConnection.getInstance().getDBcon();
            String query = " INSERT INTO Employee (id, department, schedule" + "values(?, ?, ?)";

            //create mysql insert preparesstatement

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, department);
            preparedStmt.setDate(3,(java.sql.Date) schedule);

            //execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public boolean update(Employee empl) throws SQLException {
    try{
        PersonDB person = create("1","12",); PersonDB person1 = person;
        Connection conn = DBConnection.getInstance().getDBcon();
        String id = person1.getId();
        Date schedule = (Date) empl.getSchedule();
        String department = empl.getDepartment();
        PreparedStatement psttm = conn.prepareStatement("UPDATE Employee SET Schedule, Department , WHERE PersonID  = ?");
        psttm.setDate(2,schedule);
        psttm.setString(3,department);
        psttm.executeUpdate();
    }catch(SQLException e) {
        e.printStackTrace();
        throw e;
    }
    return true;
    }
@Override
    public Employee read(String id ) throws SQLException {
        Employee empl  = null;
        try{
            ResultSet rs;
            try (Connection conn = DBConnection.getInstance().getDBcon()) {
                String sql = String.format("SELECT * FROM Employee where PersonID=%s", id);
                rs = conn.createStatement().executeQuery(sql);
            }
            if (rs.next()){
                empl = buildObject(rs);
            }
        }catch (SQLException e) {
            throw e;
        }finally{
            DBConnection.closeConnection();
        }
        return empl;
        }

    public static Employee buildObject(ResultSet rs) throws SQLException {
    Employee empl;
    try{
        String id = rs.getString(1);
        Date schedule = rs.getDate(2);
        String department = rs.getString(3);

        empl = new Employee(id,schedule,department);
    }catch(SQLException e ) {
        e.printStackTrace();
        throw e;
    }
    return empl;
    }

    public boolean delete(String id) throws SQLException {
    try{
        Connection conn = DBConnection.getInstance().getDBcon();
        String sql = String.format("Delete from Employee where PersonID='%s'", id);
        conn.createStatement().executeUpdate(sql);
    }catch(SQLException e) {
        e.printStackTrace();
        throw  e;
    }finally {
        DBConnection.closeConnection();
    }
    return true;
    }
}


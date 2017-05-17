
package DBLayer;
import ModelLayer.Company;
import java.sql.*;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class CompanyDB implements CompanyDBIF {

    @Override
    public void create(String id, String name, String phNr, String email, String companyType, String address) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String query = " INSERT INTO Company (CompanyID, Name, Phone_number, Email, Company_type, Adress)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, phNr);
            preparedStmt.setString(4, email);
            preparedStmt.setString(5, companyType);
            preparedStmt.setString(6, address);

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
    public boolean update(Company company, String id) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Company SET CompanyID = ?, Name = ?, Phone_number = ?, Email = ?, Company_type = ?, Adress = ? WHERE CompanyID = ? ");
            //psttm.setInt(1,curentQuantity);
            psttm.setString(1,company.getId());
            psttm.setString(2,company.getName());
            psttm.setString(3,company.getPhNr());
            psttm.setString(4,company.getEmail());
            psttm.setString(5,company.getcompanyType());
            psttm.setString(6,company.getAddress());
            psttm.setString(7,id);
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
            String sql = String.format("Delete from Company where CompanyID='%s'", id);
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
    public Company read(String id) throws SQLException{
        Company company = null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM company where CompanyID =%s",id);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                company = buildObject(rs);
            }
        }catch (SQLException e) {
            throw e;
        }finally{
            DBConnection.closeConnection();
        }
        return company;
    }


    private static Company buildObject(ResultSet rs) throws SQLException{
        Company company;
        try {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String phNr = rs.getString(3);
            String email = rs.getString(4);
            String companyType = rs.getString(5);
            String address=rs.getString(6);
            company = new Company(id, name,phNr,email,companyType,address);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return company;
    }
}

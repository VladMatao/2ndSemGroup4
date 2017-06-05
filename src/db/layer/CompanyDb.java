
package db.layer;

import model.layer.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class CompanyDb implements CompanyDbIf {

    @Override
    public void create(String id, String name, String phNr, String email, String companyType, String address) {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
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
        } finally {
            DbConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Company company, String id) {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Company SET CompanyID = ?, Name = ?, Phone_number = ?, Email = ?, Company_type = ?, Adress = ? WHERE CompanyID = ? ");
            //psttm.setInt(1,curentQuantity);
            psttm.setString(1, company.getId());
            psttm.setString(2, company.getName());
            psttm.setString(3, company.getPhNr());
            psttm.setString(4, company.getEmail());
            psttm.setString(5, company.getCompanyType());
            psttm.setString(6, company.getAddress());
            psttm.setString(7, id);
            psttm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Got an exception!");
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
            String sql = String.format("Delete from Company where CompanyID='%s'", id);
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
    public Company read(String id) throws SQLException {
        Company company = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDbCon();
            String sql = String.format("SELECT * FROM Company where CompanyID =%s", id);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) {
                company = buildObject(rs);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return company;
    }

    public ArrayList<Company> readAll() throws SQLException {
        ArrayList<Company> companyCollection = new ArrayList<>();
        Company company;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDbCon();
            String sql = "SELECT * FROM Company ";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                company = buildObject(rs);
                companyCollection.add(company);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return companyCollection;
    }


    private static Company buildObject(ResultSet rs) throws SQLException {
        Company company;
        try {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String phNr = rs.getString(3);
            String email = rs.getString(4);
            String companyType = rs.getString(5);
            String address = rs.getString(6);
            company = new Company(id, name, phNr, email, companyType, address);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return company;
    }
}

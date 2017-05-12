package DBLayer;

import ModelLayer.Company;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.*;

public class CompanyDB implements CompanyDBIF {
    public static void main(String[] args){

        try {
            Company product = new Company("1","Adidas","999999","adidas@adidas.com","Customer", "Bucharest");
            new CompanyDB().delete("1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("success");
    }

    public boolean create(String id, String name, String phNr, String email, String companyType, String address) throws SQLException {
        try {
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("ADD Company SET CompanyID = ?, Name = ?, Phone_Number = ?, Email = ?, Company_type = ?, Adress = ?");
            psttm.setNString(1,id);
            psttm.setNString(2,name);
            psttm.setNString(3,phNr);
            psttm.setNString(4,email);
            psttm.setNString(5,companyType);
            psttm.setNString(6,address);
            psttm.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    public boolean update(Company company) throws SQLException {
        try {
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String id=company.getId();
            String name = company.getName();
            String phNr = company.getPhNr();
            String email = company.getEmail();
            String companyType=company.getcompanyType();
            String address=company.getAddress();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Company SET CompanyID = ?, Name = ?, Phone_Number = ?, Email = ?, Company_type = ?, Adress = ? WHERE id = ? ");
            psttm.setNString(1,id);
            psttm.setNString(2,name);
            psttm.setNString(3,phNr);
            psttm.setNString(4,email);
            psttm.setNString(5,companyType);
            psttm.setNString(6,address);
            psttm.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    public boolean delete(String id) throws SQLException {
        try {
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("Delete from Company where id='%s'", id);
            conn.createStatement().executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBConnection.closeConnection();
        }
        return true;
    }

    public Company read(String barcode) throws SQLException{
        Company company = null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM Company where id=%s",barcode);
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
            String email= rs.getString(4);
            String companyType = rs.getString(5);
            String address=rs.getString(6);
            company = new Company(id,name,phNr,email,companyType,address);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return company;
    }
}

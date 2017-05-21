package DBLayer;
import ModelLayer.Order;
import java.sql.*;
import java.sql.Date;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class OrdersDB implements OrdersDBIF {

    @Override
    public void create(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String companyType) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String query = " INSERT INTO Orders (OrderID, Total_price, Order_Status, Delivery_Date, CompanyID, Company_type)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, id);
            preparedStmt.setDouble(2, totalPrice);
            preparedStmt.setString(3, orderStatus);
            preparedStmt.setDate(4, deliveryDate);
            preparedStmt.setString(5, companyId);
            preparedStmt.setString(6, companyType);

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
    public boolean update(Order company, String id) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Orders SET  Total_price = ?, Order_Status = ?,Delivery_date = ?, CompanyID = ?, Company_type = ? WHERE OrderID = ? ");
            psttm.setString(1,company.getId());
            psttm.setDouble(2,company.getTotalPrice());
            psttm.setString(3,company.getOrderStatus());
            psttm.setDate(4, (Date) company.getDeliveryDate());
            psttm.setString(5,company.getCompanyId());
            psttm.setString(6,company.getCompanyType());
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
            String sql = String.format("Delete from Orders where OrderID='%s'", id);
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
    public Order read(String id) throws SQLException{
        Order company = null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM Company where OrderID =%s",id);
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


    private static Order buildObject(ResultSet rs) throws SQLException{
        Order company;
        try {
            String id = rs.getString(1);
            Double totalPrice = rs.getDouble(2);
            String orderStatus = rs.getString(3);
            Date deliveryDate = rs.getDate(4);
            String companyID = rs.getString(5);
            String companyType=rs.getString(6);
            company = new Order(id,deliveryDate,orderStatus,totalPrice,companyID,companyType);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return company;
    }
}

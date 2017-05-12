
package DBLayer;
import ModelLayer.Order;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class OrdersDB {

    public void create(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String companyType) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String query = " INSERT INTO Orders (OrderID, Total_price, Order_Status, Delivery_date, CompanyID, Company_type)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, id);
            preparedStmt.setDouble(2, totalPrice);
            preparedStmt.setString(3, orderStatus);
            preparedStmt.setDate(4, (java.sql.Date) deliveryDate);
            preparedStmt.setString(5, companyId);
            preparedStmt.setString(6, companyType);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }


    public boolean update(Order order) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String id=order.getId();
            Date deliveryDate = order.getDeliveryDate();
            String orderStatus = order.getOrderStatus();
            double totalPrice = order.getTotalPrice();
            String companyId=order.getCompanyId();
            String companyType=order.getCompanyType();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Order SET OrderID = ?, Total_price = ?, Order_Status = ?, Delivery_Date = ?, CompanyID= ?, Company_type= ? WHERE OrderID = ? ");
            psttm.setNString(1,id);
            psttm.setDouble(2,totalPrice);
            psttm.setString(3,orderStatus);
            psttm.setDate(4, (java.sql.Date) deliveryDate);
            psttm.setString(5, companyId);
            psttm.setString(6, companyType);
            psttm.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    public boolean delete(String id) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("Delete from Order where id='%s'", id);
            conn.createStatement().executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBConnection.closeConnection();
        }
        return true;
    }

    public Order read(String id) throws SQLException{
        Order order = null;
        try{
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM Order where id=%s",id);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                order = buildObject(rs);
            }
        } finally{
            DBConnection.closeConnection();
        }
        return order;
    }

    private static Order buildObject(ResultSet rs) throws SQLException{
        Order order;
        try {
            String id = rs.getString(1);
            Double totalPrice = rs.getDouble(2);
            String orderStatus = rs.getString(3);
            Date deliveryDate = rs.getDate(4);
            String companyId = rs.getString(5);
            String companyType=rs.getString(6);
            order = new Order(id,deliveryDate,orderStatus,totalPrice,companyId,companyType);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return order;
    }
}

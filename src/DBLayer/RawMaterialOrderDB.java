package DBLayer;

import ModelLayer.Order;
import ModelLayer.RAW_Material;
import ModelLayer.RawMaterialOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RawMaterialOrderDB implements RawMaterialOrderDBIF{

    @Override
    public void create(String rawMaterialOrderId, String deliveryDate, String orderStatus, double totalPrice, String companyId,String rawMaterialLineId) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String queryOrder = " INSERT INTO Orders (OrderID, Total_price, Order_Status, Delivery_date, CompanyID)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmtO = conn.prepareStatement(queryOrder);
            preparedStmtO.setString(1, rawMaterialOrderId);
            preparedStmtO.setDouble(2, totalPrice);
            preparedStmtO.setString(3, orderStatus);
            preparedStmtO.setString(4,  deliveryDate);
            preparedStmtO.setString(5, companyId);

            preparedStmtO.execute();

            String queryRawMaterialOrder = " INSERT INTO RawMaterialOrder (RawMaterialOrder,RawMaterialLineID)"
                    + " values (?, ?)";

            PreparedStatement preparedStmtPO = conn.prepareStatement(queryRawMaterialOrder);
            preparedStmtPO.setString(1, rawMaterialOrderId);
            preparedStmtPO.setString(2, rawMaterialLineId);

            preparedStmtPO.execute();
        } catch (Exception e) {
            System.err.println("Got an exception in RawMaterialDB.create()!");
            System.err.println(e.getMessage());
        }finally{
            DBConnection.closeConnection();
        }
    }

    @Override
    public boolean update(RawMaterialOrder rawMaterialOrder,String RawMaterialOrderId) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttmOrder = conn.prepareStatement("UPDATE Orders SET Total_price = ?, Order_Status = ?, Delivery_date = ?, CompanyID = ? WHERE OrderID = ?");
            psttmOrder.setDouble(1,rawMaterialOrder.getTotalPrice());
            psttmOrder.setString(2,rawMaterialOrder.getOrderStatus());
            psttmOrder.setString(3,rawMaterialOrder.getDeliveryDate());
            psttmOrder.setString(4,rawMaterialOrder.getCompanyId());
            psttmOrder.setString(5,RawMaterialOrderId);
            psttmOrder.executeUpdate();

            PreparedStatement psttmRMO = conn.prepareStatement("UPDATE RawMaterialOrder SET RawMaterialLineID = ? WHERE RawMaterialOrderID = ?");
            psttmRMO.setString(1,rawMaterialOrder.getRawMaterialLineId());
            psttmRMO.setString(2,RawMaterialOrderId);
            psttmRMO.executeUpdate();
        } catch(SQLException e) {
            System.err.println("Got an exception at rawMaterialOrderDb.update()");
            System.err.println(e.getMessage());
        }finally{
            DBConnection.closeConnection();
        }
        return true;
    }

    @Override
    public boolean delete(String rawMaterialOrderId) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("Delete from RawMaterialOrder where RawMaterialOrderID='%s'", rawMaterialOrderId);
            String sql1 = String.format("Delete from Orders where OrderID='%s'", rawMaterialOrderId);
            conn.createStatement().executeUpdate(sql);
            conn.createStatement().executeUpdate(sql1);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBConnection.closeConnection();
        }
        return true;
    }

    @Override
    public RawMaterialOrder read(String orderId) throws SQLException{
        RawMaterialOrder rawMaterialOrder = null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sqlO = String.format("SELECT * FROM Orders where OrderID=%s",orderId);
            ResultSet rsO = conn.createStatement().executeQuery(sqlO);

            String sqlRMO = String.format("SELECT * FROM RawMaterialOrder where RawMaterialOrderId=%s",orderId);
            ResultSet rsRMO = conn.createStatement().executeQuery(sqlRMO);
            if (rsO.next() && rsRMO.next()){
                rawMaterialOrder = buildObject(rsO,rsRMO);
            }
        } finally{
            DBConnection.closeConnection();
        }
        return rawMaterialOrder ;
    }


    private static RawMaterialOrder buildObject(ResultSet rsO,ResultSet rsRMO) throws SQLException{
        RawMaterialOrder rawMaterialOrder;
        try {
            String id = rsO.getString(1);
            String deliveryDate = rsO.getString(4);
            String orderStatus = rsO.getString(3);
            double totalPrice = rsO.getDouble(2);
            String companyId = rsO.getString(5);
            String rawMaterialLineId=rsRMO.getString(2);
            rawMaterialOrder = new RawMaterialOrder(id,deliveryDate,orderStatus,totalPrice,companyId,rawMaterialLineId);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return rawMaterialOrder;
    }
}

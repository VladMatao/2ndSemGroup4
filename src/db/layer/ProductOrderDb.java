package db.layer;

import model.layer.ProductOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ProductOrderDb implements ProductOrderDbIf {

    @Override
    public void create(String productOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId, Double totalProductionTime) {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            String queryOrder = " INSERT INTO Orders (OrderID, Total_price, Order_Status, Delivery_date, CompanyID)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmtO = conn.prepareStatement(queryOrder);
            preparedStmtO.setString(1, productOrderId);
            preparedStmtO.setDouble(2, totalPrice);
            preparedStmtO.setString(3, orderStatus);
            preparedStmtO.setString(4, deliveryDate);
            preparedStmtO.setString(5, companyId);

            String queryProductOrder = " INSERT INTO ProductOrder (ProductOrderId, ProductLineID, TotalProductionTime)"
                    + " values (?, ?, ?)";

            PreparedStatement preparedStmtPO = conn.prepareStatement(queryProductOrder);
            preparedStmtPO.setString(1, productOrderId);
            preparedStmtPO.setString(2, productLineId);
            preparedStmtPO.setDouble(3, totalProductionTime);

            preparedStmtO.execute();
            preparedStmtPO.execute();
        } catch (Exception e) {
            System.err.println("Got an exception in ProductOrderDb.create()!");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
    }

    @Override
    public boolean update(ProductOrder productOrder, String productOrderId) {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            PreparedStatement psttmOrder = conn.prepareStatement("UPDATE Orders SET Total_price = ?, Order_Status = ?, Delivery_date = ?, CompanyID = ? WHERE OrderID = ?");
            psttmOrder.setDouble(1, productOrder.getTotalPrice());
            psttmOrder.setString(2, productOrder.getOrderStatus());
            psttmOrder.setString(3, productOrder.getDeliveryDate());
            psttmOrder.setString(4, productOrder.getCompanyId());
            psttmOrder.setString(5, productOrderId);
            psttmOrder.executeUpdate();

            PreparedStatement psttmPO = conn.prepareStatement("UPDATE ProductOrder SET ProductLineID = ?, TotalProductionTime = ? WHERE ProductOrderID = ?");
            psttmPO.setString(1, productOrder.getProductLineId());
            psttmPO.setDouble(2, productOrder.getTotalProductionTime());
            psttmPO.setString(3, productOrderId);
            psttmPO.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Got an exception at productOrderDb.update()");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
        return true;
    }

    @Override
    public boolean delete(String productOrderId) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            String sql = String.format("Delete from ProductOrder where ProductOrderId='%s'", productOrderId);
            String sql1 = String.format("Delete from Orders where OrderID='%s'", productOrderId);
            conn.createStatement().executeUpdate(sql);
            conn.createStatement().executeUpdate(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DbConnection.closeConnection();
        }
        return true;
    }

    @Override
    public ProductOrder read(String orderId) throws SQLException {
        ProductOrder productOrder = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDbCon();
            String sqlO = String.format("SELECT * FROM Orders where OrderID=%s", orderId);
            ResultSet rsO = conn.createStatement().executeQuery(sqlO);

            String sqlPO = String.format("SELECT * FROM ProductOrder where ProductOrderId=%s", orderId);
            ResultSet rsPO = conn.createStatement().executeQuery(sqlPO);
            if (rsO.next() && rsPO.next()) {
                productOrder = buildObject(rsO, rsPO);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return productOrder;
    }

    public ArrayList<ProductOrder> readAll() throws SQLException {
        ArrayList<ProductOrder> productOrders = new ArrayList<>();
        ProductOrder productOrder;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDbCon();
            String sqlO = "SELECT * FROM Orders";
            ResultSet rsO = conn.createStatement().executeQuery(sqlO);
            String sqlPO = "SELECT * FROM ProductOrder";
            ResultSet rsPO = conn.createStatement().executeQuery(sqlPO);
            while(rsPO.next()) {
                while(rsO.next()) {
                    productOrder = buildObject(rsO, rsPO);
                    productOrders.add(productOrder);
                }
            }
        } finally {
            DbConnection.closeConnection();
        }
        return productOrders;
    }
    

    private static ProductOrder buildObject(ResultSet rsO, ResultSet rsPO) throws SQLException {
        ProductOrder productOrder;
        try {
            String id = rsO.getString(1);
            String deliveryDate = rsO.getString(4);
            String orderStatus = rsO.getString(3);
            double totalPrice = rsO.getDouble(2);
            String companyId = rsO.getString(5);
            String productLineId = rsPO.getString(2);
            double totalProductionTime = rsPO.getDouble(3);
            productOrder = new ProductOrder(id, deliveryDate, orderStatus, totalPrice, companyId, totalProductionTime, productLineId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return productOrder;
    }
}

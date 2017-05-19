package DBLayer;

import ModelLayer.Product;
import ModelLayer.ProductOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ProductOrderDB implements ProductOrderDBIF{

    @Override
    public void create(String productOrderId, String orderId, String productBarcode,  double totalPrice, String orderStatus, String deliveryDate, String companyId) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String queryOrder = " INSERT INTO Orders (OrderID, Total_price, Order_Status, Delivery_date, CompanyID)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmtO = conn.prepareStatement(queryOrder);
            preparedStmtO.setString(1, orderId);
            preparedStmtO.setDouble(2, totalPrice);
            preparedStmtO.setString(3, orderStatus);
            preparedStmtO.setString(4, deliveryDate);
            preparedStmtO.setString(5, companyId);

            String queryProductOrder = " INSERT INTO ProductOrder (ProductOrderId, OrderID, ProductBarcode)"
                    + " values (?, ?, ?)";

            PreparedStatement preparedStmtPO = conn.prepareStatement(queryProductOrder);
            preparedStmtPO.setString(1, productOrderId);
            preparedStmtPO.setString(2, orderId);
            preparedStmtPO.setString(3, productBarcode);
            // execute the preparedstatement
            preparedStmtO.execute();
            preparedStmtPO.execute();
        } catch (Exception e) {
            System.err.println("Got an exception in ProductDB.create()!");
            System.err.println(e.getMessage());
        }finally{
            DBConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Product product, String barcode) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Product SET Name = ?, Barcode = ?, Price = ?, Stock = ?, Production_Time = ?, RequiredMatID = ? WHERE Barcode = ? ");
            //psttm.setInt(1,curentQuantity);
            psttm.setNString(1,product.getName());
            psttm.setNString(2,product.getBarcode());
            psttm.setDouble(3,product.getPrice());
            psttm.setInt(4,product.getStock());
            psttm.setInt(5,product.getProductionTime());
            psttm.setNString(6,product.getRequiredMatID());
            psttm.setNString(7,barcode);
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
    public boolean delete(String barcode) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("Delete from Product where barcode='%s'", barcode);
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
    public Product read(String barcode) throws SQLException{
        Product product = null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM product where barcode=%s",barcode);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                product = buildObject(rs);
            }
        } finally{
            DBConnection.closeConnection();
        }
        return product;
    }


    private static Product buildObject(ResultSet rs) throws SQLException{
        Product product;
        try {
            String name = rs.getString(1);
            String barcode = rs.getString(2);
            double price = rs.getDouble(3);
            int stock = rs.getInt(4);
            int productionTime = rs.getInt(5);
            String requiredMatID=rs.getString(6);
            product = new Product(name,barcode,price,stock,productionTime,requiredMatID);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return product;
    }
}


package db.layer;

import model.layer.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class ProductDb implements ProductDbIf {

    @Override
    public void create(String name, String barcode, double price, int stock, int productionTime, String requiredMatID) {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            String query = " INSERT INTO Product (Name, Barcode, Price, Stock, Production_Time, RequiredMatID)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, barcode);
            preparedStmt.setDouble(3, price);
            preparedStmt.setInt(4, stock);
            preparedStmt.setInt(5, productionTime);
            preparedStmt.setString(6, requiredMatID);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception in ProductDb.create()!");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Product product, String barcode) {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Product SET Name = ?, Barcode = ?, Price = ?, Stock = ?, Production_Time = ?, RequiredMatID = ? WHERE Barcode = ? ");
            //psttm.setInt(1,curentQuantity);
            psttm.setNString(1, product.getName());
            psttm.setNString(2, product.getBarcode());
            psttm.setDouble(3, product.getPrice());
            psttm.setInt(4, product.getStock());
            psttm.setInt(5, product.getProductionTime());
            psttm.setNString(6, product.getRequiredMatID());
            psttm.setNString(7, barcode);
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
    public boolean delete(String barcode) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            String sql = String.format("Delete from Product where barcode=%s", barcode);
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
    public Product read(String barcode) throws SQLException {
        Product product = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDbCon();
            String sql = String.format("SELECT * FROM Product where Barcode='%s'", barcode);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) {
                product = buildObject(rs);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return product;
    }


    public ArrayList<Product> readAll() throws SQLException {
        ArrayList<Product> productcollection = new ArrayList<>();
        Product product;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDbCon();
            String sql = "SELECT * FROM Product ";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                product = buildObject(rs);
                productcollection.add(product);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return productcollection;
    }


    private static Product buildObject(ResultSet rs) throws SQLException {
        Product product;
        try {
            String name = rs.getString(1);
            String barcode = rs.getString(2);
            double price = rs.getDouble(3);
            int stock = rs.getInt(4);
            int productionTime = rs.getInt(5);
            String requiredMatID = rs.getString(6);
            product = new Product(name, barcode, price, stock, productionTime, requiredMatID);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return product;
    }
}

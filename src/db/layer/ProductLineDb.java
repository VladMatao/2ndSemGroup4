
package db.layer;

import model.layer.ProductLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class ProductLineDb implements ProductLineDbIf {

    @Override
    public void create(String id, double quantity, String productBarcode) {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            String query = " INSERT INTO ProductLine (ID, Quantity,ProductBarcode)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, id);
            preparedStmt.setDouble(2, quantity);
            preparedStmt.setString(3, productBarcode);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception in ProductLineDb.create()!");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
    }

    public void update(ProductLine productLine, String id) {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE ProductLine SET ID = ?, Quantity = ?, ProductBarcode = ? WHERE ID = ? ");
            //psttm.setInt(1,curentQuantity);
            psttm.setString(1, productLine.getproductLineId());
            psttm.setDouble(2, productLine.getQuantity());
            psttm.setString(3, productLine.getProductBarcode());
            psttm.setString(4, id);
            psttm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
    }

    public boolean delete(String id) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            String sql = String.format("Delete from ProductLine where id='%s'", id);
            conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DbConnection.closeConnection();
        }
        return true;
    }

    public ArrayList<ProductLine> readAll() throws SQLException {
        ArrayList<ProductLine> productLinecollection = new ArrayList<>();
        ProductLine productLine;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDbCon();
            String sql = "SELECT * FROM ProductLine ";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                productLine = buildObject(rs);
                productLinecollection.add(productLine);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return productLinecollection;
    }

    public ProductLine read(String id, String productBarcode) throws SQLException {
        ProductLine productLine = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDbCon();
            String sql = String.format("SELECT * FROM ProductLine where ID=%s AND ProductBarcode=%s", id, productBarcode);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) {
                productLine = buildObject(rs);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return productLine;
    }

    private static ProductLine buildObject(ResultSet rs) throws SQLException {
        ProductLine productLine;
        try {
            String productLineID = rs.getString(1);
            Double quantity = rs.getDouble(2);
            String productBarcode = rs.getString(3);
            productLine = new ProductLine(productLineID, quantity, productBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return productLine;
    }

    @Override
    public boolean deleteProductFromProductLine(String id, String productBarcode) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDbCon();
            String sql = String.format("Delete from ProductLine where id='%s' AND ProductBarcode='%s' ", id, productBarcode);
            conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DbConnection.closeConnection();
        }
        return true;
    }
}

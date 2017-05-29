
package DBLayer;
import ModelLayer.ProductLine;
import java.sql.*;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class ProductLineDB implements ProductLineDBIF {

    @Override
    public void create(String id, double quantity, String productBarcode) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
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
            System.err.println("Got an exception in ProductLineDB.create()!");
            System.err.println(e.getMessage());
        }finally{
            DBConnection.closeConnection();
        }
    }

    @Override
    public boolean update(ProductLine productLine, String id) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE ProductLine SET ID = ?, Quantity = ?, ProductBarcode = ? WHERE ID = ? ");
            //psttm.setInt(1,curentQuantity);
            psttm.setString(1,productLine.getproductLineId());
            psttm.setDouble(2,productLine.getQuantity());
            psttm.setString(3,productLine.getProductBarcode());
            psttm.setString(4,id);
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
            String sql = String.format("Delete from ProductLine where id='%s'", id);
            conn.createStatement().executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBConnection.closeConnection();
        }
        return true;
    }

    /*@Override
    public ProductLine readAll(String id) throws SQLException{
        ProductLine productLine = null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM ProductLine where ID=%s",id);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                productLine = buildObject(rs);
            }
        } finally{
            DBConnection.closeConnection();
        }
        return productLine;
    }*/

    @Override
    public ProductLine read(String id, String productBarcode) throws SQLException{
        ProductLine productLine = null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM ProductLine where ID=%s AND ProductBarcode=%s",id,productBarcode);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                productLine = buildObject(rs);
            }
        } finally{
            DBConnection.closeConnection();
        }
        return productLine;
    }

    private static ProductLine buildObject(ResultSet rs) throws SQLException{
        ProductLine productLine;
        try {
            String productLineID = rs.getString(1);
            Double quantity = rs.getDouble(2);
            String productBarcode = rs.getString(3);
            productLine = new ProductLine(productLineID,quantity,productBarcode);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return productLine;
    }

    @Override
    public boolean deleteProductFromProductLine(String id, String productBarcode) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("Delete from ProductLine where id='%s' AND ProductBarcode='%s' ", id,productBarcode);
            conn.createStatement().executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBConnection.closeConnection();
        }
        return true;
    }
}

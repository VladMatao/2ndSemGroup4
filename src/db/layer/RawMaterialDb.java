
package db.layer;

import model.layer.RawMaterial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class RawMaterialDb implements RawMaterialDbIf {

    @Override
    public void create(String barcode, String name, Double stock,Double price) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            String query = " INSERT INTO RawMaterial (Barcode, Name, Stock,Price)"
                    + " values (?, ?, ?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, barcode);
            preparedStmt.setString(2, name);
            preparedStmt.setDouble(3, stock);
            preparedStmt.setDouble(4, price);
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
    public boolean update(RawMaterial rawMat, String barcode) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE RawMaterial SET Barcode = ?, Name = ?, Stock = ?, Price = ?  WHERE Barcode = ? ");
            //psttm.setInt(1,curentQuantity);
            psttm.setString(1, rawMat.getBarcode());
            psttm.setString(2, rawMat.getName());
            psttm.setDouble(3, rawMat.getStock());
            psttm.setDouble(4, rawMat.getPrice());
            psttm.setString(5, barcode);
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
            Connection conn = DbConnection.getInstance().getDBcon();
            String sql = String.format("Delete from RawMaterial whereBarcode='%s'", barcode);
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
    public RawMaterial read(String barcode) throws SQLException {
        RawMaterial rawMat = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM RawMaterial where Barcode =%s", barcode);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) {
                rawMat = buildObject(rs);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return rawMat;
    }

    public ArrayList<RawMaterial> readAll() throws SQLException {
        ArrayList<RawMaterial> rawMaterialcollection = new ArrayList<RawMaterial>();
        RawMaterial rawMaterial = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDBcon();
            String sql = "SELECT * FROM RawMaterial ";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                rawMaterial = buildObject(rs);
                rawMaterialcollection.add(rawMaterial);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return rawMaterialcollection;
    }


    private static RawMaterial buildObject(ResultSet rs) throws SQLException {
        RawMaterial rawMat;
        try {
            String barcode = rs.getString(1);
            String name = rs.getString(2);
            Double stock = rs.getDouble(3);
            Double price = rs.getDouble(3);
            rawMat = new RawMaterial(barcode, name, stock,price);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return rawMat;
    }
}

package db.layer;

import model.layer.RequiredRawMaterial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RequiredRawMaterialDb implements RequiredRawMaterialDbIf{
    @Override
    public void create(String requiredMatId, String rawMaterialBarcode, double quantity) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            String query = " INSERT INTO RequiredRawMaterial (RequiredMatId, RawMaterialBarcode, Quantity)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, requiredMatId);
            preparedStmt.setString(2, rawMaterialBarcode);
            preparedStmt.setDouble(3, quantity);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception in RequiredRawMaterialDb.create()!");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
    }

    @Override
    public boolean update(RequiredRawMaterial requiredRawMaterial, String requiredMatId) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE RequiredRawMaterial SET RequiredMatId = ?, RawMaterialBarcode = ?, Quantity = ?" + "WHERE RequiredMatId = ? ");
            psttm.setString(1, requiredRawMaterial.getRequiredMatId());
            psttm.setString(2, requiredRawMaterial.getRawMaterialBarcode());
            psttm.setDouble(3, requiredRawMaterial.getQuantity());
            psttm.setString(4, requiredMatId);

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
    public boolean delete(String requiredMatId) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            String sql = String.format("Delete from RequiredRawMaterialCtr where requiredMatId=%s", requiredMatId);
            conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DbConnection.closeConnection();
        }
        return true;
    }

    public ArrayList<RequiredRawMaterial> readAll() throws SQLException {
        ArrayList<RequiredRawMaterial> requiredRawMaterialArrayList = new ArrayList<RequiredRawMaterial>();
        RequiredRawMaterial requiredRawMaterial = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDBcon();
            String sql = "SELECT * FROM RequiredRawMaterial";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                requiredRawMaterial = buildObject(rs);
                requiredRawMaterialArrayList.add(requiredRawMaterial);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return requiredRawMaterialArrayList;
    }

    private static RequiredRawMaterial buildObject(ResultSet rs) throws SQLException {
        RequiredRawMaterial requiredRawMaterial;
        try {
            String requiredRawMaterialId = rs.getString(1);
            String rawMaterialBarcode = rs.getString(2);
            double quantity = rs.getDouble(3);
            requiredRawMaterial = new RequiredRawMaterial(requiredRawMaterialId, rawMaterialBarcode, quantity);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return requiredRawMaterial;
    }
}

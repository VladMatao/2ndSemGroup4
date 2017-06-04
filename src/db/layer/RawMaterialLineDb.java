
package db.layer;

import model.layer.ProductLine;
import model.layer.RawMaterialLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class RawMaterialLineDb implements RawMaterialLineDbIf {

    @Override
    public void create(String id, double quantity, String rawMaterialBarcode) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            String query = " INSERT INTO RawMaterialLine (RawMaterialLineID, Quantity, RawBarcode)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, id);
            preparedStmt.setDouble(2, quantity);
            preparedStmt.setString(3, rawMaterialBarcode);
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
    public boolean update(RawMaterialLine rawMLine, String id) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE RawMaterialLine SET RawMaterialLineID = ?, Quantity = ?, RawBarcode = ? WHERE RawMaterialLineID = ? AND RawBarcode = ?");
            //psttm.setInt(1,curentQuantity);
            psttm.setString(1, rawMLine.getId());
            psttm.setDouble(2, rawMLine.getQuantity());
            psttm.setString(3, rawMLine.getRawMaterialBarcode());
            psttm.setString(4, id);
            psttm.setString(5, rawMLine.getRawMaterialBarcode());
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
    public boolean delete(String id) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            String sql = String.format("Delete from RawMaterialLine where RawMaterialLineID='%s'", id);
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
    public RawMaterialLine read(String id) throws SQLException {
        RawMaterialLine rawMLine = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM RawMaterialLine where RawMaterialLineID =%s", id);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) {
                rawMLine = buildObject(rs);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return rawMLine;
    }

    public ArrayList<RawMaterialLine> readAll() throws SQLException {
        ArrayList<RawMaterialLine> rawMaterialLinecollection = new ArrayList<RawMaterialLine>();
        RawMaterialLine rawMaterialLine = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDBcon();
            String sql = "SELECT * FROM RawMaterialLine ";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
            	rawMaterialLine = buildObject(rs);
            	rawMaterialLinecollection.add(rawMaterialLine);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return rawMaterialLinecollection;
    }

    private static RawMaterialLine buildObject(ResultSet rs) throws SQLException {
        RawMaterialLine rawMLine;
        try {
            String id = rs.getString(1);
            Double quantity = rs.getDouble(2);
            String rawMaterialBarcode = rs.getString(3);
            rawMLine = new RawMaterialLine(id, quantity, rawMaterialBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return rawMLine;
    }


    @Override
    public boolean deleteRawMaterialFromRawMaterialLine(String id, String rawMaterialBarcode) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            String sql = String.format("Delete from RawMaterialLine where RawMaterialLineID='%s' AND RawBarcode='%s' ", id, rawMaterialBarcode);
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

package DBLayer;
import ModelLayer.RAW_Material;

import javax.lang.model.element.Name;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class RawMaterialDB implements RawMaterialDBIF {
    @Override
    public void create(String barcode, String name) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String query = " INSERT INTO RawMaterial (Barcode, Name)"
                    + " values (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1,barcode );
            preparedStmt.setString(2, name);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean update(RAW_Material rawMat) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String barcode=rawMat.getBarcode();
            String  name = rawMat.getName();
            PreparedStatement psttm = conn.prepareStatement("UPDATE RawMaterial SET Barcode = ?, Name = ? WHERE barcode = ? ");
            psttm.setString(1,barcode);
            psttm.setString(2,name);
            psttm.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }
    @Override
    public boolean delete(String barcode) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("Delete from RawMaterial where barcode='%s'", barcode);
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
    public RAW_Material read(String barcode) throws SQLException{
        RAW_Material rawMat = null;
        try{
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM RawMaterial where barcode=%s",barcode);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                rawMat = buildObject(rs);
            }
        } finally{
            DBConnection.closeConnection();
        }
        return rawMat;
    }

    private static RAW_Material buildObject(ResultSet rs) throws SQLException{
        RAW_Material rawMat;
        try {
            String barcode = rs.getString(1);
            String name = rs.getString(2);
            rawMat = new RAW_Material(barcode,name);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return rawMat;
    }
}

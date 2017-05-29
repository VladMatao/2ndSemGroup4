
package DBLayer;
import ModelLayer.Company;
import ModelLayer.RAW_Material;
import java.sql.*;
import java.util.ArrayList;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class RawMaterialDB implements RawMaterialDBIF {

    @Override
    public void create(String barcode, String name) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String query = " INSERT INTO RawMaterial (Barcode, Name)"
                    + " values (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, barcode);
            preparedStmt.setString(2, name);
            // execute the preparedstatement

            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }finally{
            DBConnection.closeConnection();
        }
    }

    @Override
    public boolean update(RAW_Material rawMat, String barcode) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE RawMaterial SET Barcode = ?, Name = ? WHERE Barcode = ? ");
            //psttm.setInt(1,curentQuantity);
            psttm.setString(1,rawMat.getBarcode());
            psttm.setString(2,rawMat.getName());
            psttm.setString(3,barcode);
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
            String sql = String.format("Delete from RawMaterial whereBarcode='%s'", barcode);
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
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM RawMaterial where Barcode =%s",barcode);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                rawMat = buildObject(rs);
            }
        }catch (SQLException e) {
            throw e;
        }finally{
            DBConnection.closeConnection();
        }
        return rawMat;
    }
    
    public ArrayList<RAW_Material> readAll() throws SQLException{
        ArrayList<RAW_Material>rawMaterialcollection = new ArrayList<RAW_Material>();
    	RAW_Material rawMaterial = null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM RawMaterial ");
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
            	rawMaterial = buildObject(rs);
            	rawMaterialcollection.add(rawMaterial);
            }
        } finally{
            DBConnection.closeConnection();
        }
        return rawMaterialcollection;
    }


    private static RAW_Material buildObject(ResultSet rs) throws SQLException{
        RAW_Material rawMat;
        try {
            String barcode = rs.getString(1);
            String name = rs.getString(2);
            rawMat = new RAW_Material(barcode, name);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return rawMat;
    }
}

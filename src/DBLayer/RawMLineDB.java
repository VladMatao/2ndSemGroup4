
package DBLayer;
import ModelLayer.RawMaterialLine;
import java.sql.*;

public class RawMLineDB implements RawMLineDBIF {

    @Override
    public void create(String id, double quantity, String rawMaterialBarcode, String rawMaterialOrderId) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String query = " INSERT INTO RawMLine (ID, Quantity, RawBarcode, RawID)"
                    + " values (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, id);
            preparedStmt.setDouble(2, quantity);
            preparedStmt.setString(3, rawMaterialBarcode);
            preparedStmt.setString(4, rawMaterialOrderId);
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
    public boolean update(RawMaterialLine rawMLine, String id) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE RawMLine SET ID = ?, Quantity = ?, RawBarcode = ?, RawID = ? WHERE ID = ? ");
            //psttm.setInt(1,curentQuantity);
            psttm.setString(1,rawMLine.getId());
            psttm.setDouble(2,rawMLine.getQuantity());
            psttm.setString(3,rawMLine.getRawMaterialBarcode());
            psttm.setString(4,rawMLine.getRawMaterialOrderId());
            psttm.setString(5,id);
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
            String sql = String.format("Delete from RawMLine where ID='%s'", id);
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
    public RawMaterialLine read(String id) throws SQLException{
        RawMaterialLine rawMLine = null;
        try{
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM rawMLine where ID =%s",id);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                rawMLine = buildObject(rs);
            }
        }catch (SQLException e) {
            throw e;
        }finally{
            DBConnection.closeConnection();
        }
        return rawMLine;
    }


    private static RawMaterialLine buildObject(ResultSet rs) throws SQLException{
        RawMaterialLine rawMLine;
        try {
            String id = rs.getString(1);
            Double quantity = rs.getDouble(2);
            String rawMaterialBarcode = rs.getString(3);
            String rawMaterialOrderID = rs.getString(4);
            rawMLine = new RawMaterialLine(id, quantity,rawMaterialBarcode,rawMaterialOrderID);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return rawMLine;
    }
}

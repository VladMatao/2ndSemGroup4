package DBLayer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReqRawForProdDB implements ReqRawForProdDBIF {
    public boolean create(String requiredMatID, String RAWBarcode, double quantity) throws SQLException {
        try {
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("ADD Components SET RequiredMatID = ?, BarcodeRaw = ?, Quantity = ?");
            psttm.setNString(1,requiredMatID);
            psttm.setNString(2,RAWBarcode);
            psttm.setDouble(3,quantity);
            psttm.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }
    public boolean delete(String requiredMatID) throws SQLException {
        try {
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("Delete from Components where requiredMatID='%s'", requiredMatID);
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

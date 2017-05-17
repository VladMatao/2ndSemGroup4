package DBLayer;

import java.sql.SQLException;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface ReqRawForProdDBIF {
    boolean create(String requiredMatID, String RAWBarcode, double quantity) throws SQLException;
    boolean delete(String requiredMatID) throws SQLException;
}

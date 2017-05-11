package DBLayer;

import java.sql.SQLException;

/**
 * Created by Vlad Mataoanu on 09.05.2017.
 */
public interface ReqRawForProdDBIF {
    boolean create(String requiredMatID, String RAWBarcode, double quantity) throws SQLException;
    boolean delete(String requiredMatID) throws SQLException;
}

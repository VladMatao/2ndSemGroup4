package DBLayer;

import ModelLayer.RawMaterialLine;

import java.sql.SQLException;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  RawMLineDBIF {

    void create(String id, double quantity, String rawMaterialBarcode, String rawMaterialOrderId) throws SQLException;
    boolean update (RawMaterialLine rawMLine, String id ) throws SQLException;
    boolean delete (String id) throws SQLException;
    RawMaterialLine read(String id) throws SQLException;
}

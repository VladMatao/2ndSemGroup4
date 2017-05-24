package DBLayer;

import ModelLayer.RawMaterialLine;

import java.sql.SQLException;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface RawMaterialLineDBIF {

    void create(String id, double quantity, String rawMaterialBarcode, String rawMaterialOrderId) throws SQLException;
    boolean update (RawMaterialLine rawMLine, String id ) throws SQLException;
    boolean delete (String id) throws SQLException;
    RawMaterialLine read(String id) throws SQLException;
}

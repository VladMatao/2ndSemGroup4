package db.layer;

import model.layer.RawMaterialLine;

import java.sql.SQLException;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface RawMaterialLineDbIf {

    void create(String id, double quantity, String rawMaterialBarcode) throws SQLException;
    boolean update (RawMaterialLine rawMLine, String id ) throws SQLException;
    boolean delete (String id) throws SQLException;
    RawMaterialLine read(String id) throws SQLException;
    boolean deleteRawMaterialFromRawMaterialLine(String id, String rawMaterialBarcode) throws SQLException;
}

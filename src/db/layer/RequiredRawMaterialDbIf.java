package db.layer;

import model.layer.RequiredRawMaterial;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface RequiredRawMaterialDbIf {
    void create(String requiredMatId, String rawMaterialBarcode, double quantity) throws SQLException;
    boolean update(RequiredRawMaterial requiredRawMaterial, String requiredMatId) throws SQLException;
    boolean delete(String requiredMatId) throws SQLException;
}

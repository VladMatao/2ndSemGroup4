package db.layer;

import model.layer.RawMaterial;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface RawMaterialDbIf {

    void create(String barcode, String name, Double stock, Double price) throws SQLException;

    boolean update(RawMaterial rawMat, String barcode) throws SQLException;

    boolean delete(String barcode) throws SQLException;

    RawMaterial read(String barcode) throws SQLException;

    ArrayList<RawMaterial> readAll() throws SQLException;
}

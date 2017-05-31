package db.layer;

import model.layer.ProductLine;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface ProductLineDbIf {

    void create(String productId, double quantity, String productBarcode) throws SQLException;

    boolean update(ProductLine productLine, String id) throws SQLException;

    boolean delete(String id) throws SQLException;

    ProductLine read(String id, String productBarcode) throws SQLException;

    boolean deleteProductFromProductLine(String id, String productBarcode) throws SQLException;
}

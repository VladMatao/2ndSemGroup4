package db.layer;

import model.layer.Product;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface ProductDbIf {

    void create(String name, String barcode, double price, int stock, int productionTime, String requiredMatID) throws SQLException;

    boolean update(Product product, String barcode) throws SQLException;

    boolean delete(String barcode) throws SQLException;

    Product read(String barcode) throws SQLException;
}

package db.layer;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
interface ProductLineDbIf {

    void create(String productId, double quantity, String productBarcode);

    boolean deleteProductFromProductLine(String id, String productBarcode) throws SQLException;
}

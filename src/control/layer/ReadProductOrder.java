package control.layer;

import db.layer.ProductOrderDb;
import model.layer.ProductOrder;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ReadProductOrder {
    public ProductOrder read(String id) {
        ProductOrder productOrder = null;
        ProductOrderDb productOrderDb = new ProductOrderDb();
        try {
            productOrder = productOrderDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productOrder;
    }
}

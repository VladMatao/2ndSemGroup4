package control.layer;

import db.layer.ProductOrderDb;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class DeleteProductOrder {
    ProductOrderDb productOrderDb=new ProductOrderDb();
    ManageProductLine productLineCtr=new ManageProductLine();
    public void delete(String orderId) {
        try {
            productLineCtr.delete(productOrderDb.read(orderId).getProductLineId());
            productOrderDb.delete(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

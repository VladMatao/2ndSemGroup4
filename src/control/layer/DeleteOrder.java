package control.layer;

import db.layer.ProductOrderDb;
import db.layer.RawMaterialOrderDb;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class DeleteOrder {
    private final ProductOrderDb productOrderDb = new ProductOrderDb();
    private final ManageProductLine productLineCtr = new ManageProductLine();
    private final RawMaterialOrderDb rawMaterialOrderDb= new RawMaterialOrderDb();
    private final ManageRawMaterialLine rawMaterialLineCtr= new ManageRawMaterialLine();

    public void deleteProductOrder(String orderId) {
        try {
            productLineCtr.delete(productOrderDb.read(orderId).getProductLineId());
            productOrderDb.delete(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRawMaterialOrder(String orderId) {
        try {
            rawMaterialLineCtr.delete(rawMaterialOrderDb.read(orderId).getRawMaterialLineId());
            rawMaterialOrderDb.delete(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

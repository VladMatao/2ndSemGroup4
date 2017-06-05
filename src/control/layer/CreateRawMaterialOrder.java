package control.layer;

import db.layer.RawMaterialDb;
import db.layer.RawMaterialLineDb;
import db.layer.RawMaterialOrderDb;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class CreateRawMaterialOrder {
    private final RawMaterialOrderDb RawMaterialOrderDb;
    private final RawMaterialDb RawMaterialDb;

    public CreateRawMaterialOrder() {
        RawMaterialOrderDb = new RawMaterialOrderDb();
        RawMaterialLineDb RawMaterialLineDb = new RawMaterialLineDb();
        RawMaterialDb = new RawMaterialDb();
    }

    public void create(String RawMaterialOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String RawMaterialLineId) {
        RawMaterialOrderDb.create(RawMaterialOrderId, deliveryDate, orderStatus, totalPrice, companyId, RawMaterialLineId);
    }

    public double calculatePrice(String RawMaterialBarcode, int quantity) {
        double totalPrice = 0;
        try {
            totalPrice = RawMaterialDb.read(RawMaterialBarcode).getPrice() * quantity;
            //System.out.println(RawMaterialDb.read(RawMaterialBarcode).getPrice()*quantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrice;
    }

}

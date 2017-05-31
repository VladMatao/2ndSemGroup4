package control.layer;

import db.layer.ProductDb;
import db.layer.ProductLineDb;
import db.layer.ProductOrderDb;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class CreateProductOrder {
    private ProductOrderDb productOrderDb;
    private ProductDb productDb;

    public CreateProductOrder() {
        productOrderDb = new ProductOrderDb();
        ProductLineDb productLineDb = new ProductLineDb();
        productDb = new ProductDb();
    }

    public boolean create(String productOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId, double totalProductionTime) {
        try {
            productOrderDb.create(productOrderId, totalPrice, orderStatus, deliveryDate, companyId, productLineId, totalProductionTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public double calculatePrice(String productBarcode, int quantity) {
        double totalPrice = 0;
        try {
            totalPrice = productDb.read(productBarcode).getPrice() * quantity;
            //System.out.println(productDb.read(productBarcode).getPrice()*quantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrice;
    }

    public double calculateTime(String productBarcode, int quantity) {
        double totalTime = 0;
        try {
            totalTime = productDb.read(productBarcode).getProductionTime() * quantity;
            //System.out.println(productDb.read(productBarcode).getProductionTime()*quantity)
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalTime;
    }
}

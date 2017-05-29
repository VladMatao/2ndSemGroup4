package ControlLayer;

import DBLayer.ProductDB;
import DBLayer.ProductLineDB;
import DBLayer.ProductOrderDB;
import ModelLayer.ProductOrder;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class CreateProductOrder {
    private ProductOrderDB productOrderDB;
    private ProductLineDB productLineDB;
    private ProductDB productDB;

    public CreateProductOrder() {
        productOrderDB = new ProductOrderDB();
    }

    public boolean create(String productOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId, Double totalProductionTime){
        try {
            productOrderDB.create(productOrderId, totalPrice, orderStatus, deliveryDate, companyId, productLineId, totalProductionTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public double calculatePrice(String productBarcode, int quantity){
        double totalPrice=0;
        try {
            if(productDB.read(productBarcode)!=null)
                totalPrice=productDB.read(productBarcode).getPrice()*quantity;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrice;
    }

    public double calculateTime(String productBarcode, int quantity){
        double totalTime=0;
        try {
            if(productDB.read(productBarcode)!=null)
                totalTime=productDB.read(productBarcode).getProductionTime()*quantity;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalTime;
    }
}
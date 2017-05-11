package ModelLayer;

import java.util.*;

/**
 * Created by Mircea on 27-Mar-17.
 */
public class Product {

    private String name;
    private String barcode;
    private double price;
    private int stock;
    private int productionTime;
    private String requiredMatID;

    public Product(String name, String barcode, double price, int stock, int productionTime, String requiredMatID) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.stock = stock;
        this.productionTime = productionTime;
        this.requiredMatID = requiredMatID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public String getRequiredMatID() {
        return requiredMatID;
    }

    public void setRequiredMatID(String requiredMatID) {
        this.requiredMatID = requiredMatID;
    }
}

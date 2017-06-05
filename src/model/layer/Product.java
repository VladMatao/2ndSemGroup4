package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Product {

    private final String name;
    private final String barcode;
    private final double price;
    private final int stock;
    private final int productionTime;
    private final String requiredMatID;

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

    public String getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public String getRequiredMatID() {
        return requiredMatID;
    }

}

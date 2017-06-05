package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ProductLine {
    private final String productLineId;
    private final double quantity;
    private final String productBarcode;

    public ProductLine(String id, double quantity, String productBarcode) {
        this.productLineId = id;
        this.quantity = quantity;
        this.productBarcode = productBarcode;
    }

    public String getproductLineId() {
        return productLineId;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

}

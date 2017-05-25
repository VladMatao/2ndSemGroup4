package ModelLayer;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ProductLine {
    private String productLineId;
    private double quantity;
    private String productBarcode;

    public ProductLine(String id, double quantity, String productBarcode) {
        this.productLineId = id;
        this.quantity = quantity;
        this.productBarcode = productBarcode;
    }

    public String getproductLineId() {
        return productLineId;
    }

    public void setproductLineId(String id) {
        this.productLineId = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

}

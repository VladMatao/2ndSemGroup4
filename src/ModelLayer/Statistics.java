package ModelLayer;

/**
 * Created by Vlad Mataoanu on 03.05.2017.
 */
public class Statistics {
    private String productBarcode;
    private int revenue;
    private int quantity;

    public Statistics(String productBarcode, int revenue, int quantity) {
        this.productBarcode = productBarcode;
        this.revenue = revenue;
        this.quantity = quantity;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

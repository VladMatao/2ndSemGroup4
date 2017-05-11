package ModelLayer;

/**
 * Created by Vlad Mataoanu on 03.05.2017.
 */
public class ProductLine {
    private String id;
    private int quantity;
    private String productBarcode;
    private String productOrderId;

    public ProductLine(String id, int quantity, String productBarcode, String productOrderId) {
        this.id = id;
        this.quantity = quantity;
        this.productBarcode = productBarcode;
        this.productOrderId = productOrderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public String getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(String productOrderId) {
        this.productOrderId = productOrderId;
    }
}

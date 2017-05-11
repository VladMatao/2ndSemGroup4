package ModelLayer;

/**
 * Created by Vlad Mataoanu on 03.05.2017.
 */
public class RawMaterialLine {
    private String id;
    private double quantity;
    private String rawMaterialBarcode;
    private String rawMaterialOrderId;

    public RawMaterialLine(String id, double quantity, String rawMaterialBarcode, String rawMaterialOrderId) {
        this.id = id;
        this.quantity = quantity;
        this.rawMaterialBarcode = rawMaterialBarcode;
        this.rawMaterialOrderId = rawMaterialOrderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getRawMaterialBarcode() {
        return rawMaterialBarcode;
    }

    public void setRawMaterialBarcode(String rawMaterialBarcode) {
        this.rawMaterialBarcode = rawMaterialBarcode;
    }

    public String getRawMaterialOrderId() {
        return rawMaterialOrderId;
    }

    public void setRawMaterialOrderId(String rawMaterialOrderId) {
        this.rawMaterialOrderId = rawMaterialOrderId;
    }
}

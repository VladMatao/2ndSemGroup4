package ModelLayer;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RawMaterialLine {
    private String rawMaterialLineID;
    private double quantity;
    private String rawMaterialBarcode;
    private String rawMaterialOrderId;

    public RawMaterialLine(String id, double quantity, String rawMaterialBarcode, String rawMaterialOrderId) {
        this.rawMaterialLineID = id;
        this.quantity = quantity;
        this.rawMaterialBarcode = rawMaterialBarcode;
        this.rawMaterialOrderId = rawMaterialOrderId;
    }

    public String getId() {
        return rawMaterialLineID;
    }

    public void setId(String id) {
        this.rawMaterialLineID = id;
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

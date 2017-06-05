package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RequiredRawMaterial {
    private String requiredMatId;
    private String rawMaterialBarcode;
    private double quantity;

    public RequiredRawMaterial(String requiredMatId, String rawMaterialBarcode, double quantity) {
        this.requiredMatId = requiredMatId;
        this.rawMaterialBarcode = rawMaterialBarcode;
        this.quantity = quantity;
    }

    public String getRequiredMatId() {
        return requiredMatId;
    }

    public void setRequiredMatId(String requiredMatId) {
        this.requiredMatId = requiredMatId;
    }

    public String getRawMaterialBarcode() {
        return rawMaterialBarcode;
    }

    public void setRawMaterialBarcode(String rawMaterialBarcode) {
        this.rawMaterialBarcode = rawMaterialBarcode;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

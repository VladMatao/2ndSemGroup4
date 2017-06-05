package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RequiredRawMaterial {
    private final String requiredMatId;
    private final String rawMaterialBarcode;
    private final double quantity;

    public RequiredRawMaterial(String requiredMatId, String rawMaterialBarcode, double quantity) {
        this.requiredMatId = requiredMatId;
        this.rawMaterialBarcode = rawMaterialBarcode;
        this.quantity = quantity;
    }

    public String getRequiredMatId() {
        return requiredMatId;
    }

    public String getRawMaterialBarcode() {
        return rawMaterialBarcode;
    }

    public double getQuantity() {
        return quantity;
    }

}

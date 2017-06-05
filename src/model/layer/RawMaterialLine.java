package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RawMaterialLine {
    private final String rawMaterialLineID;
    private final double quantity;
    private final String rawMaterialBarcode;

    public RawMaterialLine(String id, double quantity, String rawMaterialBarcode) {
        this.rawMaterialLineID = id;
        this.quantity = quantity;
        this.rawMaterialBarcode = rawMaterialBarcode;
    }

    public String getId() {
        return rawMaterialLineID;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getRawMaterialBarcode() {
        return rawMaterialBarcode;
    }


}

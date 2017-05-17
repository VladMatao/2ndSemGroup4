package ModelLayer;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RAW_Material {
    private String barcode;
    private String name;

    public RAW_Material(String barcode, String name) {

        this.barcode = barcode;
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

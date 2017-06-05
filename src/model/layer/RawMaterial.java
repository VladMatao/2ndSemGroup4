package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RawMaterial {
    private final String barcode;
    private final String name;
    private final Double stock;
    private final Double price;

    public RawMaterial(String barcode, String name,double stock, double price) {
        this.stock = stock;
        this.barcode = barcode;
        this.name = name;
        this.price=price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public Double getStock() {
        return stock;
    }


    public Double getPrice() {
        return price;
    }

}

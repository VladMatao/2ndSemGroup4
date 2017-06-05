package control.layer;

import db.layer.ProductLineDb;
import model.layer.ProductLine;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageProductLine {
    private final ProductLineDb productLineDb;

    public ManageProductLine() {
        productLineDb = new ProductLineDb();
    }

    public void create(String id, double quantity, String productBarcode) {

        try {
            if (productLineDb.read(id, productBarcode) == null)
                productLineDb.create(id, quantity, productBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String id, double quantity, String productBarcode) {
        ProductLine productLine = new ProductLine(id, quantity, productBarcode);
        productLineDb.update(productLine, id);
    }

    public void delete(String id) {
        try {
            productLineDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ProductLine> readAll() {
        ArrayList<ProductLine> allproductLines = null;
        try {
            allproductLines = productLineDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allproductLines;
    }

}

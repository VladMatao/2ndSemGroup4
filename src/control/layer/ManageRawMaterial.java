package control.layer;

import db.layer.RawMaterialDb;
import model.layer.RawMaterial;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageRawMaterial {
    private final RawMaterialDb rawMaterialdDb;

    public ManageRawMaterial() {
        rawMaterialdDb = new RawMaterialDb();
    }

    public void create(String barcode, String name, Double stock, Double price) {
        rawMaterialdDb.create(barcode, name, stock,price);
    }

    public Double getPrice(String barcode){
        RawMaterial rawMaterial = null;
        try {
            rawMaterial = rawMaterialdDb.read(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rawMaterial.getPrice();
    }

    public void update(String barcode, String name, Double stack, Double price) {
        RawMaterial raw_material = new RawMaterial(barcode, name, stack,price);
        rawMaterialdDb.update(raw_material, barcode);
    }


    public ArrayList<RawMaterial> readAll() {
        ArrayList<RawMaterial> allrawmaterials = null;
        try {
            allrawmaterials = rawMaterialdDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allrawmaterials;
    }

    public void delete(String barcode) {
        try {
            rawMaterialdDb.delete(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

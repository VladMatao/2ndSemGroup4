package control.layer;

import db.layer.RawMaterialdDb;
import model.layer.RawMaterial;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageRawMaterial {
    private RawMaterialdDb rawMaterialdDb;

    public ManageRawMaterial() {
        rawMaterialdDb = new RawMaterialdDb();
    }

    public boolean create(String barcode, String name, Double stock) {
        try {
            rawMaterialdDb.create(barcode, name, stock);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public RawMaterial read(String barcode) {
        RawMaterial rawMaterial = null;
        try {
            rawMaterial = rawMaterialdDb.read(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rawMaterial;
    }

    public boolean update(String barcode, String name, Double stack) {
        RawMaterial raw_material = new RawMaterial(barcode, name, stack);
        try {
            return rawMaterialdDb.update(raw_material, barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    public boolean delete(String barcode) {
        boolean aux = false;
        try {
            aux = rawMaterialdDb.delete(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

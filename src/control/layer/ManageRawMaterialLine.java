package control.layer;

import db.layer.RawMaterialLineDb;
import model.layer.RawMaterialLine;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageRawMaterialLine {
    private final RawMaterialLineDb rawMaterialLineDb;

    public ManageRawMaterialLine() {

        rawMaterialLineDb = new RawMaterialLineDb();
    }

    public void create(String id, double quantity, String rawMaterialBarcode) {
        rawMaterialLineDb.create(id, quantity, rawMaterialBarcode);
    }

    public ArrayList<RawMaterialLine> readAll() {
        ArrayList<RawMaterialLine> allrawMaterialLines = null;
        try {
        	allrawMaterialLines = rawMaterialLineDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allrawMaterialLines;
    }
    public void update(String id, double quantity, String rawMaterialBarcode) {
        RawMaterialLine rawMaterialLine = new RawMaterialLine(id, quantity, rawMaterialBarcode);
        rawMaterialLineDb.update(rawMaterialLine, id);
    }


    public void delete(String id) {
        try {
            rawMaterialLineDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package control.layer;

import db.layer.RawMaterialLineDb;
import model.layer.ProductLine;
import model.layer.RawMaterialLine;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageRawMaterialLine {
    private RawMaterialLineDb rawMaterialLineDb;

    public ManageRawMaterialLine() {

        rawMaterialLineDb = new RawMaterialLineDb();
    }

    public boolean create(String id, double quantity, String rawMaterialBarcode) {
        try {
            rawMaterialLineDb.create(id, quantity, rawMaterialBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public RawMaterialLine read(String id) {
        RawMaterialLine rawMaterialLine = null;
        try {
            rawMaterialLine = rawMaterialLineDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rawMaterialLine;
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
    public boolean update(String id, double quantity, String rawMaterialBarcode) {
        RawMaterialLine rawMaterialLine = new RawMaterialLine(id, quantity, rawMaterialBarcode);
        try {
            return rawMaterialLineDb.update(rawMaterialLine, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean delete(String id) {
        boolean aux = false;
        try {
            aux = rawMaterialLineDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }

    public boolean deleteProductFromProducLine(String idRawMaterialLine, String rawMaterialBarcode) {
        boolean aux = false;
        try {
            aux = rawMaterialLineDb.deleteRawMaterialFromRawMaterialLine(idRawMaterialLine, rawMaterialBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

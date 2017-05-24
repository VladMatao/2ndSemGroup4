package ControlLayer;

import DBLayer.RawMaterialLineDB;
import ModelLayer.RawMaterialLine;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageRawMaterialLine {
    private RawMaterialLineDB rawMaterialLineDB;

    public ManageRawMaterialLine() {

        rawMaterialLineDB = new RawMaterialLineDB();
    }

    public boolean create(String id, double quantity, String rawMaterialBarcode){
        try {
            rawMaterialLineDB.create(id, quantity, rawMaterialBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public RawMaterialLine read(String id){
        RawMaterialLine rawMaterialLine = null;
        try {
            rawMaterialLine = rawMaterialLineDB.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rawMaterialLine;
    }

    public boolean update(RawMaterialLine rawMaterialLine,String id){

        try {
            return rawMaterialLineDB.update(rawMaterialLine,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = rawMaterialLineDB.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }

    public boolean deleteProductFromProducLine(String idRawMaterialLine, String rawMaterialBarcode){
        boolean aux = false;
        try {
            aux = rawMaterialLineDB.deleteRawMaterialFromRawMaterialLine(idRawMaterialLine,rawMaterialBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

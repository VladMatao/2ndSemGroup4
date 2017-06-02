package control.layer;

import db.layer.ProductOrderDb;
import db.layer.RawMaterialOrderDb;
import model.layer.ProductOrder;
import model.layer.RawMaterialOrder;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ReadRawMaterialOrder {
    private RawMaterialOrderDb rawMaterialOrderDb=new RawMaterialOrderDb();

    public RawMaterialOrder read(String id) {
        RawMaterialOrder rawMaterialOrder = null;
        RawMaterialOrderDb rawMaterialOrderDb = new RawMaterialOrderDb();
        try {
            rawMaterialOrder = rawMaterialOrderDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rawMaterialOrder;
    }

    public ArrayList<RawMaterialOrder> readAll() {
        ArrayList<RawMaterialOrder> allrawmaterialorders = null;
        try {
            allrawmaterialorders = rawMaterialOrderDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allrawmaterialorders;
    }
}

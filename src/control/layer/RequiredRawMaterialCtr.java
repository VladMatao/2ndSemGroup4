package control.layer;

import db.layer.RequiredRawMaterialDb;

import model.layer.RequiredRawMaterial;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RequiredRawMaterialCtr {

    public RequiredRawMaterialCtr() {
    	requiredRawMaterialDb = new RequiredRawMaterialDb();
    }
    private RequiredRawMaterialDb requiredRawMaterialDb=new RequiredRawMaterialDb();
    private final ManageRawMaterial manageRawMaterialCtr = new ManageRawMaterial();

    ArrayList<RequiredRawMaterial> readAllWithId(String requiredMaterialId) {
        ArrayList<RequiredRawMaterial> requiredRawMaterials = new ArrayList<>();
        try {
            for(RequiredRawMaterial requiredRawMaterial: RequiredRawMaterialDb.readAll())
                if (requiredRawMaterial.getRequiredMatId().equals(requiredMaterialId))
                    requiredRawMaterials.add(requiredRawMaterial);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requiredRawMaterials;
    }
    
    public ArrayList<RequiredRawMaterial> readAll() {
        ArrayList<RequiredRawMaterial> allrequiredRawMaterials = null;
        try {
        	allrequiredRawMaterials = RequiredRawMaterialDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allrequiredRawMaterials;
    }
    public void create(String id, String productBarcode, double quantity) {
        requiredRawMaterialDb.create(id, productBarcode, quantity);
    }
    
    public void delete(String id) {
        try {
            requiredRawMaterialDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

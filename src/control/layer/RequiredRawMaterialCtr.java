package control.layer;

import db.layer.CompanyDb;
import db.layer.RequiredRawMaterialDb;

import model.layer.RequiredRawMaterial;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RequiredRawMaterialCtr {
	
	private RequiredRawMaterialDb requiredRawMaterialb;

    public RequiredRawMaterialCtr() {
    	requiredRawMaterialDb = new RequiredRawMaterialDb();
    }
    RequiredRawMaterialDb requiredRawMaterialDb=new RequiredRawMaterialDb();
    ManageRawMaterial manageRawMaterialCtr = new ManageRawMaterial();

    public double calculatePrice(String requiredRawMaterialId) throws SQLException {
        double price = 0;
        for(RequiredRawMaterial requiredRawMaterial :requiredRawMaterialDb.readAll())
            if(requiredRawMaterialId.equals(requiredRawMaterial.getRequiredMatId()))
                price=price+(manageRawMaterialCtr.getPrice(requiredRawMaterial.getRawMaterialBarcode())*requiredRawMaterial.getQuantity());
        return price;
    }

    public ArrayList<RequiredRawMaterial> readAllWithId(String requiredMaterialId) {
        ArrayList<RequiredRawMaterial> requiredRawMaterials = new ArrayList<>();
        try {
            for(RequiredRawMaterial requiredRawMaterial:requiredRawMaterialDb.readAll())
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
    public boolean create(String id, String productBarcode, double quantity) {
        try {
            requiredRawMaterialDb.create(id, productBarcode, quantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean delete(String id) {
        boolean aux = false;
        try {
            aux = requiredRawMaterialDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }

}

package control.layer;

import db.layer.RequiredRawMaterialDb;
import model.layer.RequiredRawMaterial;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RequiredRawMaterialCtr {
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
}

package ControlLayer;

import DBLayer.RawMaterialDB;
import ModelLayer.RAW_Material;

import java.sql.SQLException;
/**
 * Created by Alexander on 5/24/2017.
 */
public class ManageRawMaterial {
    private RawMaterialDB rawMaterialDB;

    public ManageRawMaterial(){ rawMaterialDB = new RawMaterialDB();}

    public boolean create(String barcode, String name){
        try{
            rawMaterialDB.create(barcode, name);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public RAW_Material read(String barcode){
        RAW_Material rawMaterial = null;
        try {
            rawMaterial = rawMaterialDB.read(barcode);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rawMaterial;
    }

    public boolean update(RAW_Material raw_material, String barcode){
        try{
            return rawMaterialDB.update(raw_material,barcode);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String barcode){
        boolean aux = false;
        try{
            aux = rawMaterialDB.delete(barcode);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return aux;
    }
}

package ControlLayer;

import DBLayer.RawMaterialDB;
import ModelLayer.Company;
import ModelLayer.RAW_Material;

import java.sql.SQLException;
import java.util.ArrayList;
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

    public boolean update(String barcode, String name){
        RAW_Material raw_material=new RAW_Material( barcode,  name);
        try{
            return rawMaterialDB.update(raw_material,barcode);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    public ArrayList<RAW_Material> readAll(){
    	ArrayList<RAW_Material> allrawmaterials = null;
    	try {
    		allrawmaterials = rawMaterialDB.readAll();
    	} catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return allrawmaterials;
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

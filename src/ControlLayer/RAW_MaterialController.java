package ControlLayer;
import ModelLayer.*;
import java.sql.SQLException;
/**
 * Created by Group 4  on 09.05.2017.
 */
public class RAW_MaterialController {
    RAW_MaterialDB raw_MaterialDb;

    public RAW_MaterialController() {
        raw_MaterialDb = new RAW_MaterialDB();
    }

    public boolean create(String barcode, String name, String supplierId){
        try {
            raw_MaterialDb.create(barcode,name,supplierId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public RAW_Material read(String barcode){
        RAW_Material raw_Material = null;
        try {
            raw_Material = raw_MaterialDb.read(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return raw_Material;
    }

    public boolean update(RAW_Material raw_Material){

        try {
            return raw_MaterialDb.update(raw_Material);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String barcode){
        boolean aux = false;
        try {
            aux = raw_MaterialDb.delete(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

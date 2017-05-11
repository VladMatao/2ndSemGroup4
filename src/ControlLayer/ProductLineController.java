package ControlLayer;
import ModelLayer.*;
import java.sql.SQLException;
/**
 * Created by Group 4  on 09.05.2017.
 */
public class ProductLineController {
    ProductLineDB prodLineDb;

    public ProductLineController() {
        prodLineDb = new ProductLineDB();
    }

    public boolean create(String id, int quantity, String productBarcode, String productOrderIds){
        try {
            prodLineDb.create(id,quantity,productBarcode,productOrderIds);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ProductLine read(String id){
        ProductLine prodLine = null;
        try {
            prodLine = prodLineDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodLine;
    }

    public boolean update(ProductLine prodLine){

        try {
            return prodLineDb.update(prodLine);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = prodLineDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

package control.layer;

import db.layer.ProductLineDb;
import model.layer.ProductLine;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageProductLine {
    private ProductLineDb productLineDb;

    public ManageProductLine() {
        productLineDb = new ProductLineDb();
    }

    public boolean create(String id, double quantity, String productBarcode){

        try {
            if(productLineDb.read(id,productBarcode)==null)
                productLineDb.create(id, quantity, productBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ProductLine read(String id,String productBarcode){
        ProductLine productLine = null;
        try {
            productLine = productLineDb.read(id,productBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productLine;
    }

    public boolean update(String id, double quantity, String productBarcode){
        ProductLine productLine = new ProductLine(id, quantity, productBarcode);
        try {
            return productLineDb.update(productLine,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = productLineDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
    
    public ArrayList<ProductLine> readAll(){
    	ArrayList<ProductLine> allproductLines = null;
    	try {
    		allproductLines = productLineDb.readAll();
    	} catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return allproductLines;
    }

    public boolean deleteProductFromProducLine(String idProductLine, String productBarcode){
        boolean aux = false;
        try {
            aux = productLineDb.deleteProductFromProductLine(idProductLine,productBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

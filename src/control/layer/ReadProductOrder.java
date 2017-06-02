package control.layer;

import db.layer.ProductOrderDb;
import model.layer.Company;
import model.layer.ProductOrder;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ReadProductOrder {
	private ProductOrderDb productOrderDb=new ProductOrderDb();
	
    public ProductOrder read(String id) {
        ProductOrder productOrder = null;
        ProductOrderDb productOrderDb = new ProductOrderDb();
        try {
            productOrder = productOrderDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productOrder;
    }
    
    public ArrayList<ProductOrder> readAll() {
        ArrayList<ProductOrder> allproductorders = null;
        try {
        	allproductorders = productOrderDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allproductorders;
    }
}

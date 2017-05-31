package control.layer;

import java.sql.SQLException;

import db.layer.ProductOrderDb;
import model.layer.ProductOrder;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ReadProductOrder {
	private ProductOrderDb productOrderDb;


	
    public ProductOrder read(String id){
        ProductOrder productOrder = null;
        productOrderDb=new ProductOrderDb();
        try {
        	productOrder = productOrderDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productOrder;
    }
}

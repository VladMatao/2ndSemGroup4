package ControlLayer;

import java.sql.SQLException;

import ModelLayer.ProductOrder;
import DBLayer.ProductDB;
import DBLayer.ProductOrderDB;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ReadProductOrder {
	private ProductOrderDB productOrderDb;


	
    public ProductOrder read(String id){
        ProductOrder productOrder = null;
        productOrderDb=new ProductOrderDB();
        try {
        	productOrder = productOrderDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productOrder;
    }
}

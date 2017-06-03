package control.layer;

import db.layer.ProductOrderDb;
import db.layer.RawMaterialOrderDb;
import model.layer.Company;
import model.layer.ProductOrder;
import model.layer.RawMaterialOrder;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ReadOrder {
	private ProductOrderDb productOrderDb=new ProductOrderDb();
    private RawMaterialOrderDb rawMaterialOrderDb=new RawMaterialOrderDb();
	
    public ProductOrder readProductOrder(String id) {
        ProductOrder productOrder = null;
        ProductOrderDb productOrderDb = new ProductOrderDb();
        try {
            productOrder = productOrderDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productOrder;
    }
    
    public ArrayList<ProductOrder> readAllProductOrders() {
        ArrayList<ProductOrder> allproductorders = null;
        try {
        	allproductorders = productOrderDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allproductorders;
    }

    public RawMaterialOrder readRawMaterialOrder(String id) {
        RawMaterialOrder rawMaterialOrder = null;
        RawMaterialOrderDb rawMaterialOrderDb = new RawMaterialOrderDb();
        try {
            rawMaterialOrder = rawMaterialOrderDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rawMaterialOrder;
    }

    public ArrayList<RawMaterialOrder> readAllRawMaterialOrders() {
        ArrayList<RawMaterialOrder> allrawmaterialorders = null;
        try {
            allrawmaterialorders = rawMaterialOrderDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allrawmaterialorders;
    }
}

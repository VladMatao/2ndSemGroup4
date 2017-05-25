package ControlLayer;

import DBLayer.ProductLineDB;
import ModelLayer.ProductLine;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageProductLine {
    private ProductLineDB productLineDB;

    public ManageProductLine() {
        productLineDB = new ProductLineDB();
    }

    public boolean create(String id, double quantity, String productBarcode){
        try {
            productLineDB.create(id, quantity, productBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ProductLine read(String id,String productBarcode){
        ProductLine productLine = null;
        try {
            productLine = productLineDB.read(id,productBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productLine;
    }

    public boolean update(ProductLine productLine,String id){

        try {
            return productLineDB.update(productLine,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = productLineDB.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }

    public boolean deleteProductFromProducLine(String idProductLine, String productBarcode){
        boolean aux = false;
        try {
            aux = productLineDB.deleteProductFromProductLine(idProductLine,productBarcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

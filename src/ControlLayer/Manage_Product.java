package ControlLayer;

import DBLayer.ProductDB;
import ModelLayer.Product;

import java.sql.SQLException;
/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Manage_Product {
    private ProductDB productDb;

    public Manage_Product() {
        productDb = new ProductDB();
    }

    public boolean create(String name, String barcode, int price, int stock, int productionTime, String requiredMatID){
        try {
            productDb.create(name,barcode,price,stock,productionTime,requiredMatID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Product read(String barcode){
        Product product = null;
        try {
            product = productDb.read(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public boolean update(Product product,String barcode){

        try {
            return productDb.update(product,barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String barcode){
        boolean aux = false;
        try {
            aux = productDb.delete(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

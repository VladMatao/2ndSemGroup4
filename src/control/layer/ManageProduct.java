package control.layer;

import db.layer.ProductDb;
import model.layer.Product;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageProduct {
    private final ProductDb productDb;

    public ManageProduct() {
        productDb = new ProductDb();
    }

    public void create(String name, String barcode, double price, int stock, int productionTime, String requiredMatID) {
        productDb.create(name, barcode, price, stock, productionTime, requiredMatID);
    }

    public Product read(String barcode) {
        Product product = null;
        try {
            product = productDb.read(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public ArrayList<Product> readAll() {
        ArrayList<Product> allproducts = null;
        try {
            allproducts = productDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allproducts;


    }

    public void update(String name, String barcode, double price, int stock, int productionTime, String requiredMatID) {
        Product product = new Product(name, barcode, price, stock, productionTime, requiredMatID);
        productDb.update(product, barcode);
    }

    public void delete(String barcode) {
        try {
            productDb.delete(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

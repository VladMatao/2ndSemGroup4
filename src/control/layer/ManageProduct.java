package control.layer;

import db.layer.ProductDb;
import model.layer.Product;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageProduct {
    private ProductDb productDb;

    public ManageProduct() {
        productDb = new ProductDb();
    }

    public boolean create(String name, String barcode, double price, int stock, int productionTime, String requiredMatID) {
        try {
            productDb.create(name, barcode, price, stock, productionTime, requiredMatID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
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

    public boolean update(String name, String barcode, double price, int stock, int productionTime, String requiredMatID) {
        Product product = new Product(name, barcode, price, stock, productionTime, requiredMatID);
        try {
            return productDb.update(product, barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String barcode) {
        boolean aux = false;
        try {
            aux = productDb.delete(barcode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}
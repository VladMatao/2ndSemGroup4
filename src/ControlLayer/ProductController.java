package ControlLayer;

import java.sql.SQLException;
import DBLayer.*;
import ModelLayer.*;
import java.sql.SQLException;
/**
 * Created by Vlad Mataoanu on 09.05.2017.
 */
public class ProductController {
    ProductDB productDb;

    public ProductController() {
        productDb = new ProductDB();
    }

    public boolean create(String name, String barcode, int productionTime, double price, int stock, String requiredMatID){
        try {
            productDb.create(name,barcode,productionTime,price,stock,requiredMatID);
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

    public boolean update(Product product){

        try {
            return productDb.update(product);
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

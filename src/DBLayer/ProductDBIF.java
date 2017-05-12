package DBLayer;

import ModelLayer.Product;

import java.sql.SQLException;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  ProductDBIF {

    void create(String name, String barcode, double price,  int stock, int productionTime, String requiredMatID) throws SQLException;
    boolean update (Product product, String barcode) throws SQLException;
    boolean delete (String barcode) throws SQLException;
    Product read(String barcode) throws SQLException;
}

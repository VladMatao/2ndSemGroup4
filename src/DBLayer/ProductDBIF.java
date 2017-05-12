package DBLayer;

import ModelLayer.Product;

import java.sql.SQLException;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  ProductDBIF {

    void create(String name, String barcode, int productionTime, int price, int stock, String requiredMatID) throws SQLException;
    boolean update (Product product) throws SQLException;
    boolean delete (String barcode) throws SQLException;
    Product read(String barcode) throws SQLException;
}

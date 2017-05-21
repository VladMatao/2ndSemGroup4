package ControlLayer;

import DBLayer.ProductOrderDB;
import ModelLayer.ProductOrder;

import java.sql.SQLException;
import java.util.Date;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
*/

public class ProductOrderController {
   ProductOrderDB productOrderDB;

    public ProductOrderController() {
        productOrderDB = new ProductOrderDB();
    }

    public boolean create(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String companyType) {
        try {
            productOrderDB.create(id, deliveryDate, orderStatus, totalPrice, companyId, companyType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ProductOrder read(String id) {
        ProductOrder productOrder = null;
        try {
            productOrder = productOrderDB.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productOrder;
    }

    public boolean update(ProductOrder productOrder) {
        try {
            return productOrderDB.update(productOrder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        boolean aux = false;
        try {
            aux = productOrderDB.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }

}*/



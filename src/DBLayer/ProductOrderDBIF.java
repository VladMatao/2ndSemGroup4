package DBLayer;

import ModelLayer.ProductOrder;

import java.sql.SQLException;
import java.util.Date;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface ProductOrderDBIF {
    void create(String productOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId, Double totalProductionTime) throws SQLException;
    ProductOrder read(String orderId) throws SQLException;
    boolean update(ProductOrder productOrder,String productOrderId) throws SQLException;
    boolean delete(String productOrderId) throws SQLException;
}

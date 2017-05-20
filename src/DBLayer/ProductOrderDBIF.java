package DBLayer;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface ProductOrderDBIF {
    void create(String productOrderId, String orderId, String productBarcode,  double totalPrice, String orderStatus, String deliveryDate, String companyId) throws SQLException;
}

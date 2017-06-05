package db.layer;

import model.layer.ProductOrder;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
interface ProductOrderDbIf {
    void create(String productOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId, Double totalProductionTime);

    ProductOrder read(String orderId) throws SQLException;

    boolean update(ProductOrder productOrder, String productOrderId);

    boolean delete(String productOrderId) throws SQLException;
}

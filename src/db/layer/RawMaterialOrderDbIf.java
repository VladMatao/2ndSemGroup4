package db.layer;

import model.layer.RawMaterialOrder;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface RawMaterialOrderDbIf {
    void create(String rawMaterialOrderId, String deliveryDate, String orderStatus, double totalPrice, String companyId, String rawMaterialLineId) throws SQLException;

    RawMaterialOrder read(String orderId) throws SQLException;

    boolean update(RawMaterialOrder rawMaterialOrder, String RawMaterialOrderId) throws SQLException;

    boolean delete(String rawMaterialOrderId) throws SQLException;
}

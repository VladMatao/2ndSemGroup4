package DBLayer;

import ModelLayer.RawMaterialOrder;

import java.sql.SQLException;
import java.util.Date;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface RawMaterialOrderDBIF {
    void create(String rawMaterialOrderId, String deliveryDate, String orderStatus, double totalPrice, String companyId,String rawMaterialLineId) throws SQLException;
    RawMaterialOrder read(String orderId) throws SQLException;
    boolean update(RawMaterialOrder rawMaterialOrder,String RawMaterialOrderId) throws SQLException;
    boolean delete(String rawMaterialOrderId) throws SQLException;
}

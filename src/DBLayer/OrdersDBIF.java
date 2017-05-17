package DBLayer;

import ModelLayer.Order;

import java.sql.SQLException;
import java.sql.Date;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface  OrdersDBIF {

    void create(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String companyType) throws SQLException;
    boolean update (Order order, String id) throws SQLException;
    boolean delete (String id) throws SQLException;
    Order read(String id) throws SQLException;
}

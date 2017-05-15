package DBLayer;

import ModelLayer.Order;

import java.sql.SQLException;
import java.sql.Date;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  OrdersDBIF {

    void create(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String companyType) throws SQLException;
    boolean update (Order order, String id) throws SQLException;
    boolean delete (String id) throws SQLException;
    Order read(String id) throws SQLException;
}

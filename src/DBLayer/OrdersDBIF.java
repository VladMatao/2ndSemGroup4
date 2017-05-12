package DBLayer;

import ModelLayer.Order;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  OrdersDBIF {

    boolean create(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String companyType) throws SQLException;
    boolean update (Order order) throws SQLException;
    boolean delete (String id) throws SQLException;
    Order read(String id) throws SQLException;
}

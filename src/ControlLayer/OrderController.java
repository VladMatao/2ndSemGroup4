package ControlLayer;
import ModelLayer.*;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Group 4  on 09.05.2017.
 */
public class OrderController {
    OrderDB orderDb;

    public OrderController() {
        orderDb = new OrderDB();
    }

    public boolean create(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String companyType){
        try {
            orderDb.create(id, deliveryDate,orderStatus,totalPrice,companyId,companyType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Order read(String id){
        Order order = null;
        try {
            order = orderDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public boolean update(Order order){

        try {
            return orderDb.update(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = orderDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

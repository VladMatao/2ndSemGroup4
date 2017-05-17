package ControlLayer;

import DBLayer.OrdersDB;
import ModelLayer.Order;
import java.sql.Date;

import java.sql.SQLException;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class OrderController {

    OrdersDB ordersDB;

    public OrderController() {
        ordersDB = new OrdersDB();
    }

    public boolean create(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String companyType){
        try {
            ordersDB.create(id,deliveryDate,orderStatus,totalPrice, companyId , companyType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Order read(String id){
        Order product = null;
        try {
            product = ordersDB.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public boolean update(Order order,String id){

        try {
            return ordersDB.update(order,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = ordersDB.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

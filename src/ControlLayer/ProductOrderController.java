package ControlLayer;
import ModelLayer.*;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Group 4  on 09.05.2017.
 */
public class ProductOrderController {
    ProductOrderDB prodOrderDb;

    public ProductOrderController() {
        prodOrderDb = new ProductOrderDB();
    }

    public boolean create(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String type, String productOrderId){
        try {
            prodOrderDb.create(id,deliveryDate,orderStatus,totalPrice,companyId,type,productOrderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ProductOrder read(String id){
        ProductOrder prodOrder = null;
        try {
            prodOrder = prodOrderDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodOrder;
    }

    public boolean update(ProductOrder prodOrder){

        try {
            return prodOrderDb.update(prodOrder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = prodOrderDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}

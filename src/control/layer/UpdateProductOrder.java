package control.layer;

import java.sql.SQLException;

import db.layer.ProductOrderDb;
import model.layer.Company;
import model.layer.ProductOrder;

public class UpdateProductOrder {
	private ProductOrderDb productOrderDb=new ProductOrderDb();
	
	 public boolean update(String productOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId, Double totalProductionTime) {
	        ProductOrder productOrder = new ProductOrder(productOrderId,deliveryDate, orderStatus, totalPrice, companyId, totalProductionTime,productLineId);
	        try {
	            return productOrderDb.update(productOrder, productOrderId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

}

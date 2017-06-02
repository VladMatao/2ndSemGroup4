package control.layer;

import java.sql.SQLException;

import db.layer.ProductOrderDb;

import db.layer.RawMaterialOrderDb;
import model.layer.ProductOrder;
import model.layer.RawMaterialOrder;

public class UpdateOrder {
	private ProductOrderDb productOrderDb=new ProductOrderDb();
	private RawMaterialOrderDb rawMaterialOrderDb=new RawMaterialOrderDb();
	
	 public boolean updateProductOrder(String productOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId, Double totalProductionTime) {
	        ProductOrder productOrder = new ProductOrder(productOrderId,deliveryDate, orderStatus, totalPrice, companyId, totalProductionTime,productLineId);
	        try {
	            return productOrderDb.update(productOrder, productOrderId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	public boolean updateRawMaterialOrder(String rawMaterialOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId) {
		RawMaterialOrder rawMaterialOrder = new RawMaterialOrder(rawMaterialOrderId,deliveryDate, orderStatus, totalPrice, companyId,productLineId);
		try {
			return rawMaterialOrderDb.update(rawMaterialOrder, rawMaterialOrderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

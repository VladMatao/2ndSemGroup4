package control.layer;

import db.layer.ProductOrderDb;

import db.layer.RawMaterialOrderDb;
import model.layer.ProductOrder;
import model.layer.RawMaterialOrder;

public class UpdateOrder {
	private final ProductOrderDb productOrderDb=new ProductOrderDb();
	private final RawMaterialOrderDb rawMaterialOrderDb=new RawMaterialOrderDb();
	
	 public void updateProductOrder(String productOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId, Double totalProductionTime) {
	        ProductOrder productOrder = new ProductOrder(productOrderId,deliveryDate, orderStatus, totalPrice, companyId, totalProductionTime,productLineId);
		 productOrderDb.update(productOrder, productOrderId);
	 }

	public void updateRawMaterialOrder(String rawMaterialOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId) {
		RawMaterialOrder rawMaterialOrder = new RawMaterialOrder(rawMaterialOrderId,deliveryDate, orderStatus, totalPrice, companyId,productLineId);
		rawMaterialOrderDb.update(rawMaterialOrder, rawMaterialOrderId);
	}

}

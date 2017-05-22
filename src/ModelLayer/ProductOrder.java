package ModelLayer;

import java.util.*;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ProductOrder extends Order{
    private String productLineId;

    public ProductOrder(String id, String deliveryDate, String orderStatus, double totalPrice, String companyId, String productLineId) {
        super(id, deliveryDate, orderStatus, totalPrice, companyId);
        this.productLineId = productLineId;
    }

    public String getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(String productLineId) {
        this.productLineId = productLineId;
    }
}

package ModelLayer;

import java.util.Date;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RawMaterialOrder extends Order{
    private String rawMaterialOrderId;
    private String OrderId;
    private String rawMaterialLineId;

    public RawMaterialOrder(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId) {
        super(id, deliveryDate, orderStatus, totalPrice, companyId);
    }


    public String getRawMaterialOrderId() {
        return rawMaterialOrderId;
    }

    public void setRawMaterialOrderId(String rawMaterialOrderId) {
        this.rawMaterialOrderId = rawMaterialOrderId;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getRawMaterialLineId() {
        return rawMaterialLineId;
    }

    public void setRawMaterialLineId(String rawMaterialLineId) {
        this.rawMaterialLineId = rawMaterialLineId;
    }
}

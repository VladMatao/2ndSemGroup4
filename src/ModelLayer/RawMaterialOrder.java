package ModelLayer;

import java.util.Date;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class RawMaterialOrder extends Order{
    private String rawMaterialLineId;

    public RawMaterialOrder(String id, String deliveryDate, String orderStatus, double totalPrice, String companyId,String rawMaterialLineId) {
        super(id, deliveryDate, orderStatus, totalPrice, companyId);
        this.rawMaterialLineId = rawMaterialLineId;

    }

    public String getRawMaterialLineId() {
        return rawMaterialLineId;
    }

    public void setRawMaterialLineId(String rawMaterialLineId) {
        this.rawMaterialLineId = rawMaterialLineId;
    }
}

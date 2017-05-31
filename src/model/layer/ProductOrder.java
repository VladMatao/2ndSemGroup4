package model.layer;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ProductOrder extends Order{
    private String productLineId;
    private Double totalProductionTime;

    public ProductOrder(String id, String deliveryDate, String orderStatus, double totalPrice, String companyId, double totalProductionTime, String productLineId) {
        super(id, deliveryDate, orderStatus, totalPrice, companyId);
        this.productLineId = productLineId;
        this.totalProductionTime=totalProductionTime;
    }

    public String getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(String productLineId) {
        this.productLineId = productLineId;
    }

    public Double getTotalProductionTime() {
        return totalProductionTime;
    }

    public void setTotalProductionTime(Double totalProductionTime) {
        this.totalProductionTime = totalProductionTime;
    }
}

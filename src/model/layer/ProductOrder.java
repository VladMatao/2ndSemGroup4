package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ProductOrder extends Order {
    private final String productLineId;
    private final Double totalProductionTime;

    public ProductOrder(String id, String deliveryDate, String orderStatus, double totalPrice, String companyId, double totalProductionTime, String productLineId) {
        super(id, deliveryDate, orderStatus, totalPrice, companyId);
        this.productLineId = productLineId;
        this.totalProductionTime = totalProductionTime;
    }

    public String getProductLineId() {
        return productLineId;
    }

    public Double getTotalProductionTime() {
        return totalProductionTime;
    }

}

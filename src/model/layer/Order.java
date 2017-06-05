package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Order {
    private final String id;
    private final String deliveryDate;
    private final String orderStatus;
    private final double totalPrice;
    private final String companyId;

    Order(String id, String deliveryDate, String orderStatus, double totalPrice, String companyId) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.companyId = companyId;
    }

    public String getId() {
        return id;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getCompanyId() {
        return companyId;
    }

}

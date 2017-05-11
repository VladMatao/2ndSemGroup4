package ModelLayer;

import java.util.Date;

/**
 * Created by Vlad Mataoanu on 02.05.2017.
 */
public class Order {
    private String id;
    private Date deliveryDate;
    private String orderStatus;
    private double totalPrice;
    private String companyId;
    private String companyType;

    public Order(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String companyType) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.companyId = companyId;
        this.companyType = companyType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
}

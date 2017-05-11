package ModelLayer;

import java.util.*;

/**
 * Created by Vlad Mataoanu on 03.05.2017.
 */
public class ProductOrder extends Order{
    private String productOrderId;
    private Stack<String> productsOrdered;

    public ProductOrder(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String type, String productOrderId) {
        super(id, deliveryDate, orderStatus, totalPrice, companyId, type);
        this.productOrderId=productOrderId;
        productsOrdered=new Stack<>();
    }

    public String getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(String productOrderId) {
        this.productOrderId = productOrderId;
    }

    public void addProductsOrdered(String productsBarcode){
        productsOrdered.add(productsBarcode);
    }

    public Stack<String> getProductsOrdered(){
        return productsOrdered;
    }

    public void deleteProduct(Product product){
        productsOrdered.remove(product);
    }
}

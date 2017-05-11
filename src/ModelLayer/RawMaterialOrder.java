package ModelLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.*;

/**
 * Created by Vlad Mataoanu on 03.05.2017.
 */
public class RawMaterialOrder extends Order{
    private String RawMaterialOrderId;
    private String supplierId;
    private Stack<String> rawMaterialsBarcodes;

    public RawMaterialOrder(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String type, String RawMaterialOrderId,String supplierId) {
        super(id, deliveryDate, orderStatus, totalPrice, companyId, type);
        rawMaterialsBarcodes=new Stack<>();
        this.RawMaterialOrderId=RawMaterialOrderId;
        this.supplierId=supplierId;
    }

    public void addRawMaterialsOrdered(String rawBarcode){
        rawMaterialsBarcodes.add(rawBarcode);
    }

    public Stack<String> getRaw_materials(){return rawMaterialsBarcodes;}

    public void deleteRAWMaterial(RAW_Material rawBarcode){
        rawMaterialsBarcodes.remove(rawBarcode);
    }

    public String getRawMaterialOrderId() {
        return RawMaterialOrderId;
    }

    public void setRawMaterialOrderId(String rawMaterialOrderId) {
        RawMaterialOrderId = rawMaterialOrderId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
}

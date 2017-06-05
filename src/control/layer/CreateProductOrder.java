package control.layer;

import db.layer.ProductDb;
import db.layer.ProductLineDb;
import db.layer.ProductOrderDb;
import model.layer.ProductLine;
import model.layer.RawMaterialLine;
import model.layer.RequiredRawMaterial;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class CreateProductOrder {
    private ProductOrderDb productOrderDb;
    private ProductDb productDb;

    public CreateProductOrder() {
        productOrderDb = new ProductOrderDb();
        ProductLineDb productLineDb = new ProductLineDb();
        productDb = new ProductDb();
    }

    public boolean create(String productOrderId, double totalPrice, String orderStatus, String deliveryDate, String companyId, String productLineId, double totalProductionTime) {
        try {
            productOrderDb.create(productOrderId, totalPrice, orderStatus, deliveryDate, companyId, productLineId, totalProductionTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public double calculatePrice(String productBarcode, int quantity) {
        double totalPrice = 0;
        try {
            totalPrice = productDb.read(productBarcode).getPrice() * quantity;
            //System.out.println(productDb.read(productBarcode).getPrice()*quantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrice;
    }

    public double calculateTime(String productBarcode, int quantity) {
        double totalTime = 0;
        try {
            totalTime = productDb.read(productBarcode).getProductionTime() * quantity;
            //System.out.println(productDb.read(productBarcode).getProductionTime()*quantity)
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalTime;
    }

    public void makeRawMaterialOrder(Double quanitiy, String productLineId ,String productBarcode){
        CreateRawMaterialOrder createRawMaterialOrderCtr = new CreateRawMaterialOrder();
        RequiredRawMaterialCtr requiredRawMaterialCtr = new RequiredRawMaterialCtr();
        ManageRawMaterialLine manageRawMaterialLineCtr = new ManageRawMaterialLine();
        ManageProduct manageProductCtr = new ManageProduct();
        String requiredMaterialId=manageProductCtr.read(productBarcode).getRequiredMatID();
        ArrayList<RequiredRawMaterial> requiredRawMaterialsToMakeProduct;
        requiredRawMaterialsToMakeProduct=requiredRawMaterialCtr.readAllWithId(requiredMaterialId);
        ArrayList<RawMaterialLine> allRawMaterialLines;
        allRawMaterialLines=manageRawMaterialLineCtr.readAll();
        for (RequiredRawMaterial requiredRawMaterial : requiredRawMaterialsToMakeProduct) {
            manageRawMaterialLineCtr.create("" + productLineId + "Raw", requiredRawMaterial.getQuantity() * quanitiy, requiredRawMaterial.getRawMaterialBarcode());
        }
    }
}

package gui.layer;

import control.layer.ManageProduct;
import model.layer.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class FindOrder {


	/**
     * Create the application.
     */
    public FindOrder() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 450, 300);
        frame.getContentPane().setLayout(null);
        DefaultTableModel producttable = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Name", "Barcode", "Price", "Stock", "Production Time", "Required Material ID"
                });

        JTable table = new JTable();
        table.setModel(producttable);
        table.setBounds(10, 11, 414, 239);
        frame.getContentPane().add(table);
        fillTable(producttable);
    }

    private void fillTable(DefaultTableModel model) {
        model.setRowCount(0);
        ManageProduct productCtr = new ManageProduct();
        ArrayList<Product> products = productCtr.readAll();
        if (!products.isEmpty()) {
            for (Product product : products) {
                String Name = product.getName();
                String Barcode = product.getBarcode();
                String Price = String.valueOf(product.getPrice());
                String Stock = String.valueOf(product.getStock());
                String ProductionTime = String.valueOf(product.getProductionTime());
                String RequiredMatID = product.getRequiredMatID();
                model.addRow(new Object[]{Name, Barcode, Price, Stock, ProductionTime, RequiredMatID});
            }

        } else {
            model.addRow(new Object[]{"NO", "Products", "FOUND", "!", 0});
        }
    }
}

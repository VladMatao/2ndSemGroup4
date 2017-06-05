package gui.layer;

import control.layer.ManageProduct;

import javax.swing.*;
import java.awt.*;

class CreateProduct {

    private JTextField textName;
    private JTextField textBarcode;
    private JTextField textPrice;
    private JTextField textStock;
    private JTextField textProductionTime;
    private JTextField textRequiredMat;


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 450, 350);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textName = new JTextField();
        textName.setBounds(241, 45, 86, 20);
        frame.getContentPane().add(textName);
        textName.setColumns(10);

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(101, 48, 46, 14);
        frame.getContentPane().add(lblNewLabel);

        textBarcode = new JTextField();
        textBarcode.setBounds(241, 76, 86, 20);
        frame.getContentPane().add(textBarcode);
        textBarcode.setColumns(10);

        JLabel lblBarcode = new JLabel("Barcode");
        lblBarcode.setBounds(101, 82, 75, 14);
        frame.getContentPane().add(lblBarcode);

        textPrice = new JTextField();
        textPrice.setBounds(241, 113, 86, 20);
        frame.getContentPane().add(textPrice);
        textPrice.setColumns(10);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(101, 116, 46, 14);
        frame.getContentPane().add(lblPrice);

        textStock = new JTextField();
        textStock.setBounds(241, 154, 86, 20);
        frame.getContentPane().add(textStock);
        textStock.setColumns(10);

        JLabel lblStock = new JLabel("Stock");
        lblStock.setBounds(101, 160, 46, 14);
        frame.getContentPane().add(lblStock);

        textProductionTime = new JTextField();
        textProductionTime.setBounds(241, 195, 86, 20);
        frame.getContentPane().add(textProductionTime);
        textProductionTime.setColumns(10);

        JLabel lblProductionTime = new JLabel("Production Time");
        lblProductionTime.setBounds(101, 198, 98, 14);
        frame.getContentPane().add(lblProductionTime);

        textRequiredMat = new JTextField();
        textRequiredMat.setBounds(241, 230, 86, 20);
        frame.getContentPane().add(textRequiredMat);
        textRequiredMat.setColumns(10);

        JLabel lblRequiredMatId = new JLabel("Required MatID");
        lblRequiredMatId.setBounds(101, 233, 98, 14);
        frame.getContentPane().add(lblRequiredMatId);

        JButton btnCreateProduct = new JButton("Create Product");
        btnCreateProduct.addActionListener(e -> {
            ManageProduct createProductCtr = new ManageProduct();
            createProductCtr.create(textName.getText(), textBarcode.getText(), Integer.parseInt(textPrice.getText()), Integer.parseInt(textStock.getText()), Integer.parseInt(textProductionTime.getText()), textRequiredMat.getText());

        });
        btnCreateProduct.setBounds(155, 277, 129, 23);
        frame.getContentPane().add(btnCreateProduct);

        JLabel lblCreateProduct = new JLabel("Create Product");
        lblCreateProduct.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lblCreateProduct.setBounds(118, 6, 204, 31);
        frame.getContentPane().add(lblCreateProduct);
    }

}

package GuiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControlLayer.ManageProduct;
import ModelLayer.Product;
import DBLayer.ProductDB;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;

public class ProductGUI extends JFrame {

    private JPanel contentPane;
    private JFrame frame;
    private JTable table;
    private JTable table_1;
    private JTextField barcodeTextField;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField stockTextField;
    private JTextField producionTimeTextField;
    private JTextField requiredMatIDTextField;


    /**
     * Create the frame.
     */
    public ProductGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1002, 495);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        DefaultTableModel producttable= new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Name", "Barcode", "Price", "Stock", "Production_Time", "RequiredMatID"
                });

        table = new JTable();
        table.setModel(producttable);
        table.setBounds(341, 0, 645, 456);
        fillTable(producttable);

        contentPane.add(table);

        barcodeTextField = new JTextField();
        barcodeTextField.setBounds(143, 72, 145, 31);
        contentPane.add(barcodeTextField);
        barcodeTextField.setColumns(10);

        nameTextField = new JTextField();
        nameTextField.setColumns(10);
        nameTextField.setBounds(143, 24, 145, 31);
        contentPane.add(nameTextField);

        priceTextField = new JTextField();
        priceTextField.setColumns(10);
        priceTextField.setBounds(143, 150, 145, 31);
        contentPane.add(priceTextField);

        stockTextField = new JTextField();
        stockTextField.setColumns(10);
        stockTextField.setBounds(143, 210, 145, 31);
        contentPane.add(stockTextField);

        producionTimeTextField = new JTextField();
        producionTimeTextField.setColumns(10);
        producionTimeTextField.setBounds(143, 277, 145, 31);
        contentPane.add(producionTimeTextField);

        requiredMatIDTextField = new JTextField();
        requiredMatIDTextField.setColumns(10);
        requiredMatIDTextField.setBounds(143, 340, 145, 31);
        contentPane.add(requiredMatIDTextField);

        JButton addButton = new JButton("Add");
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ManageProduct product=new ManageProduct();
                product.create(nameTextField.getText(),barcodeTextField.getText(),Double.parseDouble(priceTextField.getText()),Integer.parseInt(stockTextField.getText()),Integer.parseInt(producionTimeTextField.getText()),requiredMatIDTextField.getText());
                fillTable(producttable);


            }
        });
        addButton.setBounds(24, 394, 89, 23);
        contentPane.add(addButton);

        JButton deteleButton = new JButton("Delete");
        deteleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageProduct product=new ManageProduct();
                product.delete(barcodeTextField.getText());
                fillTable(producttable);

            }
        });
        deteleButton.setBounds(123, 394, 89, 23);
        contentPane.add(deteleButton);

        JButton updateButton = new JButton("Update");
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageProduct product=new ManageProduct();
                product.update(nameTextField.getText(),barcodeTextField.getText(),Double.parseDouble(priceTextField.getText()),Integer.parseInt(stockTextField.getText()),Integer.parseInt(producionTimeTextField.getText()),requiredMatIDTextField.getText());
                fillTable(producttable);
            }
        });
        updateButton.setBounds(242, 394, 89, 23);
        contentPane.add(updateButton);

        JLabel lblProductId = new JLabel("Name");
        lblProductId.setBounds(10, 32, 103, 14);
        contentPane.add(lblProductId);

        JLabel name = new JLabel("Barcode");
        name.setBounds(10, 80, 46, 14);
        contentPane.add(name);

        JLabel lblPhoneNumber = new JLabel("Price");
        lblPhoneNumber.setBounds(10, 158, 46, 14);
        contentPane.add(lblPhoneNumber);

        JLabel lblEmail = new JLabel("Stock");
        lblEmail.setBounds(10, 218, 46, 14);
        contentPane.add(lblEmail);

        JLabel lblProductType = new JLabel("Production Time");
        lblProductType.setBounds(10, 285, 46, 14);
        contentPane.add(lblProductType);

        JLabel lblAdress = new JLabel("Required  Material ID");
        lblAdress.setBounds(10, 348, 46, 14);
        contentPane.add(lblAdress);
    }


    private void fillTable(DefaultTableModel model) {
        model.setRowCount(0);
        ManageProduct productCtr = new ManageProduct();
        ArrayList<Product> product = productCtr.readAll();
        if (!product.isEmpty()) {
            for (Product products : product) {
            	String Name = products.getName();
				String Barcode = products.getBarcode();
				String Price = String.valueOf(products.getPrice());
				String Stock = String.valueOf(products.getStock());
				String ProductionTime= String.valueOf(products.getProductionTime());
				String RequiredMatID = products.getRequiredMatID();
				model.addRow(new Object[] { Name, Barcode, Price, Stock, ProductionTime, RequiredMatID });
            }

        } else {
            model.addRow(new Object[] { "NO", "Companies", "FOUND", "!", 0 });
        }
    }
}

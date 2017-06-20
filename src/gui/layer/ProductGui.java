package gui.layer;

import control.layer.ManageProduct;
import model.layer.Product;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class ProductGui extends JFrame {

    private final JTextField barcodeTextField;
    private final JTextField nameTextField;
    private final JTextField priceTextField;
    private final JTextField stockTextField;
    private final JTextField producionTimeTextField;
    private final JTextField requiredMatIDTextField;


    /**
     * Create the frame.
     */
    ProductGui() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1002, 577);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 93, 115));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        DefaultTableModel producttable = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Name", "Barcode", "Price", "Stock", "Production_Time", "RequiredMatID"
                });
        fillTable(producttable);

        barcodeTextField = new JTextField();
        barcodeTextField.setBounds(152, 173, 145, 31);
        contentPane.add(barcodeTextField);
        barcodeTextField.setColumns(10);

        nameTextField = new JTextField();
        nameTextField.setColumns(10);
        nameTextField.setBounds(152, 125, 145, 31);
        contentPane.add(nameTextField);

        priceTextField = new JTextField();
        priceTextField.setColumns(10);
        priceTextField.setBounds(152, 226, 145, 31);
        contentPane.add(priceTextField);

        stockTextField = new JTextField();
        stockTextField.setColumns(10);
        stockTextField.setBounds(152, 286, 145, 31);
        contentPane.add(stockTextField);

        producionTimeTextField = new JTextField();
        producionTimeTextField.setColumns(10);
        producionTimeTextField.setBounds(152, 353, 145, 31);
        contentPane.add(producionTimeTextField);

        requiredMatIDTextField = new JTextField();
        requiredMatIDTextField.setColumns(10);
        requiredMatIDTextField.setBounds(152, 416, 145, 31);
        contentPane.add(requiredMatIDTextField);
        JButton addButton = new JButton("Add");
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setBackground(new Color(2, 52, 68));
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ManageProduct product = new ManageProduct();
                product.create(nameTextField.getText(), barcodeTextField.getText(), Double.parseDouble(priceTextField.getText()), Integer.parseInt(stockTextField.getText()), Integer.parseInt(producionTimeTextField.getText()), requiredMatIDTextField.getText());
                fillTable(producttable);
            }
        });
        addButton.setBounds(10, 504, 89, 23);
        contentPane.add(addButton);

        JButton deteleButton = new JButton("Delete");
        deteleButton.setForeground(new Color(255, 255, 255));
        deteleButton.setBackground(new Color(2, 52, 68));
        deteleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageProduct product = new ManageProduct();
                product.delete(barcodeTextField.getText());
                fillTable(producttable);

            }
        });
        deteleButton.setBounds(109, 504, 89, 23);
        contentPane.add(deteleButton);

        JButton updateButton = new JButton("Update");
        updateButton.setForeground(new Color(255, 255, 255));
        updateButton.setBackground(new Color(2, 52, 68));
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageProduct product = new ManageProduct();
                product.update(nameTextField.getText(), barcodeTextField.getText(), Double.parseDouble(priceTextField.getText()), Integer.parseInt(stockTextField.getText()), Integer.parseInt(producionTimeTextField.getText()), requiredMatIDTextField.getText());
                fillTable(producttable);
            }
        });
        updateButton.setBounds(208, 504, 89, 23);
        contentPane.add(updateButton);

        JLabel lblProductId = new JLabel("Name");
        lblProductId.setForeground(new Color(255, 255, 255));
        lblProductId.setBounds(19, 133, 103, 14);
        contentPane.add(lblProductId);

        JLabel name = new JLabel("Barcode");
        name.setForeground(new Color(255, 255, 255));
        name.setBounds(19, 181, 46, 14);
        contentPane.add(name);

        JLabel lblPhoneNumber = new JLabel("Price");
        lblPhoneNumber.setForeground(new Color(255, 255, 255));
        lblPhoneNumber.setBounds(19, 234, 46, 14);
        contentPane.add(lblPhoneNumber);

        JLabel lblEmail = new JLabel("Stock");
        lblEmail.setForeground(new Color(255, 255, 255));
        lblEmail.setBounds(19, 294, 46, 14);
        contentPane.add(lblEmail);

        JLabel lblProductType = new JLabel("Production Time");
        lblProductType.setForeground(new Color(255, 255, 255));
        lblProductType.setBounds(19, 361, 103, 14);
        contentPane.add(lblProductType);

        JLabel lblAdress = new JLabel("Required  Material ID");
        lblAdress.setForeground(new Color(255, 255, 255));
        lblAdress.setBounds(19, 424, 123, 14);
        contentPane.add(lblAdress);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(341, 0, 645, 538);
        contentPane.add(scrollPane);

        JTable table = new JTable();
        scrollPane.setViewportView(table);
        table.setBackground(new Color(62, 143, 169));
        table.setModel(producttable);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("photos\\manprod.png"));
        label.setBounds(10, 0, 321, 122);
        contentPane.add(label);

        JButton button = new JButton("<");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
        button.setForeground(new Color(255, 255, 255));
        button.setBackground(new Color(2, 52, 68));
        button.setBounds(10, 473, 46, 23);
        contentPane.add(button);
    }


    private void fillTable(DefaultTableModel model) {
        model.setRowCount(0);
        ManageProduct productCtr = new ManageProduct();
        ArrayList<Product> product = productCtr.readAll();
        if (!product.isEmpty()) {
            for (int i = 0; i < product.size(); i++) {
                Product products = product.get(i);
                String Name = products.getName();
                String Barcode = products.getBarcode();
                String Price = String.valueOf(products.getPrice());
                String Stock = String.valueOf(products.getStock());
                String ProductionTime = String.valueOf(products.getProductionTime());
                String RequiredMatID = products.getRequiredMatID();
                model.addRow(new Object[]{Name, Barcode, Price, Stock, ProductionTime, RequiredMatID});
            }

        } else {
            model.addRow(new Object[]{"NO", "Products", "FOUND", "!", 0});
        }
    }
}

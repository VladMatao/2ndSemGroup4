package gui.layer;

import control.layer.CreateProductOrder;
import control.layer.CreateRawMaterialOrder;
import control.layer.ManageProductLine;
import model.layer.ProductLine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;

public class ProductOrderGui extends JFrame {

    private JFrame frame;
    private JTextField quantityTextField;
    private JTextField orderIDTextField;
    private JTextField productBarcodeTextField;
    private JTextField orderStatusTextField;
    private JTextField deliveryDateTextField;
    private JTextField companyIDTextField;
    private JTextField productLineTextField;


    /**
     * Create the frame.
     */
    public ProductOrderGui() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1002, 495);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 93, 115));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        productLineTextField = new JTextField();
        productLineTextField.setBounds(143, 422, 145, 23);
        contentPane.add(productLineTextField);
        productLineTextField.setColumns(10);

        DefaultTableModel productLineTable = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Product Barcode", "Quantity"
                });
        fillTable(productLineTable,productLineTextField.getText());

        JLabel price = new JLabel("0");
        price.setForeground(new Color(255, 255, 255));
        price.setBounds(573, 254, 46, 14);
        contentPane.add(price);

        JLabel timeLabel;
        timeLabel = new JLabel("0");
        timeLabel.setForeground(new Color(255, 255, 255));
        timeLabel.setBounds(573, 211, 46, 14);
        contentPane.add(timeLabel);

        quantityTextField = new JTextField();
        quantityTextField.setBounds(143, 369, 145, 23);
        contentPane.add(quantityTextField);
        quantityTextField.setColumns(10);

        orderIDTextField = new JTextField();
        orderIDTextField.setColumns(10);
        orderIDTextField.setBounds(143, 79, 145, 23);
        contentPane.add(orderIDTextField);



        productBarcodeTextField = new JTextField();
        productBarcodeTextField.setColumns(10);
        productBarcodeTextField.setBounds(143, 311, 145, 23);
        contentPane.add(productBarcodeTextField);

        JButton addButton = new JButton("Add");
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setBackground(new Color(2, 52, 68));
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ManageProductLine productLine = new ManageProductLine();
                CreateProductOrder order = new CreateProductOrder();
                productLine.create(productLineTextField.getText(), Double.parseDouble(quantityTextField.getText()), productBarcodeTextField.getText());
                double sum = Double.parseDouble(price.getText());
                sum = sum + order.calculatePrice(productBarcodeTextField.getText(), Integer.parseInt(quantityTextField.getText()));
                price.setText("" + sum);
                double time = Double.parseDouble(timeLabel.getText());
                time = time + order.calculateTime(productBarcodeTextField.getText(), Integer.parseInt(quantityTextField.getText()));
                timeLabel.setText("" + time);
                fillTable(productLineTable,productLineTextField.getText());
                order.makeRawMaterialOrder(Double.parseDouble(quantityTextField.getText()),productLineTextField.getText(),productBarcodeTextField.getText());
            }
        });
        addButton.setBounds(353, 314, 89, 23);
        contentPane.add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setForeground(new Color(255, 255, 255));
        deleteButton.setBackground(new Color(2, 52, 68));
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageProductLine productLine = new ManageProductLine();
                productLine.delete(productLineTextField.getText());
                fillTable(productLineTable,productLineTextField.getText());
                price.setText("0");
                timeLabel.setText("0");

            }
        });
        deleteButton.setBounds(465, 314, 89, 23);
        contentPane.add(deleteButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(2, 52, 68));
        updateButton.setForeground(new Color(255, 255, 255));
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageProductLine company = new ManageProductLine();
                company.update(productLineTextField.getText(), Double.parseDouble(quantityTextField.getText()), productBarcodeTextField.getText());
                fillTable(productLineTable,productLineTextField.getText());
            }
        });
        updateButton.setBounds(576, 314, 89, 23);
        contentPane.add(updateButton);

        JLabel lbld = new JLabel("Order Id");
        lbld.setForeground(new Color(255, 255, 255));
        lbld.setBounds(10, 83, 103, 14);
        contentPane.add(lbld);

        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setForeground(new Color(255, 255, 255));
        lblQuantity.setBounds(10, 373, 103, 14);
        contentPane.add(lblQuantity);

        JLabel lblProductBarcode = new JLabel("Product Barcode");
        lblProductBarcode.setForeground(new Color(255, 255, 255));
        lblProductBarcode.setBounds(10, 315, 103, 14);
        contentPane.add(lblProductBarcode);

        JLabel lblOrderStatus = new JLabel("Order Status");
        lblOrderStatus.setForeground(new Color(255, 255, 255));
        lblOrderStatus.setBounds(10, 141, 103, 14);
        contentPane.add(lblOrderStatus);

        orderStatusTextField = new JTextField();
        orderStatusTextField.setBounds(143, 137, 145, 23);
        contentPane.add(orderStatusTextField);
        orderStatusTextField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Delivery Date");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(10, 199, 103, 14);
        contentPane.add(lblNewLabel);

        deliveryDateTextField = new JTextField();
        deliveryDateTextField.setBounds(143, 195, 145, 23);
        contentPane.add(deliveryDateTextField);
        deliveryDateTextField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Company ID");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(10, 257, 103, 14);
        contentPane.add(lblNewLabel_1);

        companyIDTextField = new JTextField();
        companyIDTextField.setBounds(143, 253, 145, 23);
        contentPane.add(companyIDTextField);
        companyIDTextField.setColumns(10);

        JLabel lblProductlineId = new JLabel("Product Line Id");
        lblProductlineId.setForeground(new Color(255, 255, 255));
        lblProductlineId.setBounds(10, 431, 103, 14);
        contentPane.add(lblProductlineId);

        JLabel lblTotalTime = new JLabel("Total time");
        lblTotalTime.setForeground(new Color(255, 255, 255));
        lblTotalTime.setBounds(413, 211, 80, 14);
        contentPane.add(lblTotalTime);

        JLabel lblTotalPrice = new JLabel("Total Price");
        lblTotalPrice.setForeground(new Color(255, 255, 255));
        lblTotalPrice.setBounds(413, 254, 80, 14);
        contentPane.add(lblTotalPrice);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(675, 0, 311, 456);
        contentPane.add(scrollPane);

        JTable table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(productLineTable);

        JButton finalizeButton = new JButton("Finalize");
        finalizeButton.setForeground(new Color(255, 255, 255));
        finalizeButton.setBackground(new Color(2, 52, 68));
        finalizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CreateProductOrder productOrderCtr = new CreateProductOrder();
                CreateRawMaterialOrder rawMaterialOrderCtr= new CreateRawMaterialOrder();
                productOrderCtr.create(orderIDTextField.getText(), Double.parseDouble(price.getText()), orderStatusTextField.getText(), deliveryDateTextField.getText(), companyIDTextField.getText(), productLineTextField.getText(), Double.parseDouble(timeLabel.getText()));
                rawMaterialOrderCtr.create(orderIDTextField.getText()+ "RAW",Double.parseDouble(price.getText()),orderStatusTextField.getText(),deliveryDateTextField.getText(),companyIDTextField.getText(),productLineTextField.getText()+ "RAW");
                dispose();
                InvoiceGui invoiceGui = new InvoiceGui(orderIDTextField.getText());
                invoiceGui.setVisible(true);
            }
        });
        finalizeButton.setBounds(465, 422, 89, 23);
        contentPane.add(finalizeButton);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(62, 143, 169));
        panel.setBounds(353, 145, 311, 311);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("<");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		 dispose();
                 Menu menu = new Menu();
                 menu.setVisible(true);
        	}
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(2, 52, 68));
        btnNewButton.setBounds(0, 277, 41, 23);
        panel.add(btnNewButton);
        
        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("photos\\total.png"));
        label_1.setBounds(10, 0, 306, 77);
        panel.add(label_1);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("photos\\createorder.png"));
        label.setBounds(22, 0, 619, 86);
        contentPane.add(label);
    }


    private void fillTable(DefaultTableModel model, String productLineID) {
        model.setRowCount(0);
        ManageProductLine productLineCtr = new ManageProductLine();
        ArrayList<ProductLine> productLines = productLineCtr.readAll();
        if (productLines.isEmpty()) {
            model.addRow(new Object[]{"Product Lines", "FOUND"});
        } else {
            for (ProductLine productLine : productLines)
                if (productLine.getproductLineId().equals(productLineID)) {
                    double quantity = productLine.getQuantity();
                    String productBarcode = productLine.getProductBarcode();
                    model.addRow(new Object[]{productBarcode, quantity});
                }

        }
    }
}

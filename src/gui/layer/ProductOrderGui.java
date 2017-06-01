package gui.layer;

import control.layer.CreateProductOrder;
import control.layer.ManageProductLine;
import model.layer.ProductLine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        productLineTextField = new JTextField();
        productLineTextField.setBounds(383, 185, 145, 20);
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
        price.setBounds(552, 355, 46, 14);
        contentPane.add(price);

        JLabel timeLabel;
        timeLabel = new JLabel("0");
        timeLabel.setBounds(552, 312, 46, 14);
        contentPane.add(timeLabel);

        quantityTextField = new JTextField();
        quantityTextField.setBounds(383, 117, 145, 31);
        contentPane.add(quantityTextField);
        quantityTextField.setColumns(10);

        orderIDTextField = new JTextField();
        orderIDTextField.setColumns(10);
        orderIDTextField.setBounds(143, 24, 145, 31);
        contentPane.add(orderIDTextField);



        productBarcodeTextField = new JTextField();
        productBarcodeTextField.setColumns(10);
        productBarcodeTextField.setBounds(383, 24, 145, 31);
        contentPane.add(productBarcodeTextField);

        JButton addButton = new JButton("Add");
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
            }
        });
        addButton.setBounds(383, 230, 89, 23);
        contentPane.add(addButton);

        JButton deleteButton = new JButton("Delete");
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
        deleteButton.setBounds(482, 230, 89, 23);
        contentPane.add(deleteButton);

        JButton updateButton = new JButton("Update");
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageProductLine company = new ManageProductLine();
                company.update(productLineTextField.getText(), Double.parseDouble(quantityTextField.getText()), productBarcodeTextField.getText());
                fillTable(productLineTable,productLineTextField.getText());
            }
        });
        updateButton.setBounds(581, 230, 89, 23);
        contentPane.add(updateButton);

        JLabel lbld = new JLabel("order ID");
        lbld.setBounds(10, 32, 103, 14);
        contentPane.add(lbld);

        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(429, 93, 46, 14);
        contentPane.add(lblQuantity);

        JLabel lblProductBarcode = new JLabel("Product Barcode");
        lblProductBarcode.setBounds(429, 11, 99, 14);
        contentPane.add(lblProductBarcode);

        JLabel lblOrderStatus = new JLabel("Order Status");
        lblOrderStatus.setBounds(10, 93, 89, 14);
        contentPane.add(lblOrderStatus);

        orderStatusTextField = new JTextField();
        orderStatusTextField.setBounds(143, 84, 145, 23);
        contentPane.add(orderStatusTextField);
        orderStatusTextField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Delivery Date");
        lblNewLabel.setBounds(10, 158, 103, 14);
        contentPane.add(lblNewLabel);

        deliveryDateTextField = new JTextField();
        deliveryDateTextField.setBounds(146, 155, 142, 20);
        contentPane.add(deliveryDateTextField);
        deliveryDateTextField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("CompanyID");
        lblNewLabel_1.setBounds(10, 216, 89, 14);
        contentPane.add(lblNewLabel_1);

        companyIDTextField = new JTextField();
        companyIDTextField.setBounds(143, 213, 145, 20);
        contentPane.add(companyIDTextField);
        companyIDTextField.setColumns(10);

        JLabel lblProductlineId = new JLabel("ProductLineID");
        lblProductlineId.setBounds(415, 161, 113, 14);
        contentPane.add(lblProductlineId);

        JLabel lblTotalTime = new JLabel("Total time");
        lblTotalTime.setBounds(392, 312, 80, 14);
        contentPane.add(lblTotalTime);

        JLabel lblTotalPrice = new JLabel("Total Price");
        lblTotalPrice.setBounds(392, 355, 80, 14);
        contentPane.add(lblTotalPrice);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(675, 0, 311, 456);
        contentPane.add(scrollPane);

        JTable table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(productLineTable);

        JButton finalizeButton = new JButton("Finalize");
        finalizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CreateProductOrder productOrderCtr = new CreateProductOrder();
                productOrderCtr.create(orderIDTextField.getText(), Double.parseDouble(price.getText()), orderStatusTextField.getText(), deliveryDateTextField.getText(), companyIDTextField.getText(), productLineTextField.getText(), Double.parseDouble(timeLabel.getText()));
                dispose();
                InvoiceGui invoiceGui = new InvoiceGui(orderIDTextField.getText());
                invoiceGui.setVisible(true);
            }
        });
        finalizeButton.setBounds(33, 346, 89, 23);
        contentPane.add(finalizeButton);
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

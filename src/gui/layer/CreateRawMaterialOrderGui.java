package gui.layer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.layer.CreateProductOrder;
import control.layer.CreateRawMaterialOrder;
import control.layer.ManageProductLine;
import control.layer.ManageRawMaterialLine;
import model.layer.ProductLine;
import model.layer.RawMaterialLine;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class CreateRawMaterialOrderGui extends JFrame {

	private JPanel contentPane;
	private JTable table;
    private JTextField rawMaterialLineTextField;
    private JLabel lblOrderId;
    private JTextField orderIDTextField;
    private JLabel lblTotalPrice;
    private JLabel lblPrice;
    private JLabel lblOrderStatus;
    private JTextField orderStatusTextField;
    private JLabel lblNewLabel;
    private JTextField deliveryDateTextField;
    private JLabel lblCompanyId;
    private JTextField companyIDTextField;
    private JLabel lblRawmaterialBarcode;
    private JTextField rawMaterialBarcodeTextField;
    private JTextField quantityTextField;
    private JLabel lblQuantity;
    private JLabel lblRawMaterialLine;
    private JButton btnUpdate;


	/**
	 * Create the frame.
	 */
	public CreateRawMaterialOrderGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rawMaterialLineTextField = new JTextField();
		rawMaterialLineTextField.setBounds(135, 348, 145, 23);
	     contentPane.add(rawMaterialLineTextField);
	     rawMaterialLineTextField.setColumns(10);
		
		  DefaultTableModel rawMaterialLineTable = new DefaultTableModel(
	                new Object[][]{
	                },
	                new String[]{
	                        "Raw Material Barcode", "Quantity"
	                });
			fillTable(rawMaterialLineTable,rawMaterialLineTextField.getText());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(560, 0, 465, 616);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
        table.setModel(rawMaterialLineTable);
		
		lblOrderId = new JLabel("Order ID");
		lblOrderId.setBounds(10, 33, 46, 14);
		contentPane.add(lblOrderId);
		
		orderIDTextField = new JTextField();
		orderIDTextField.setBounds(135, 30, 86, 20);
		contentPane.add(orderIDTextField);
		orderIDTextField.setColumns(10);
		
		lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setBounds(315, 33, 46, 14);
		contentPane.add(lblTotalPrice);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(437, 33, 46, 14);
		contentPane.add(lblPrice);
		
		lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setBounds(10, 76, 46, 14);
		contentPane.add(lblOrderStatus);
		
		orderStatusTextField = new JTextField();
		orderStatusTextField.setBounds(135, 73, 86, 20);
		contentPane.add(orderStatusTextField);
		orderStatusTextField.setColumns(10);
		
		lblNewLabel = new JLabel("Delivery Date");
		lblNewLabel.setBounds(10, 135, 46, 14);
		contentPane.add(lblNewLabel);
		
		deliveryDateTextField = new JTextField();
		deliveryDateTextField.setBounds(135, 132, 86, 20);
		contentPane.add(deliveryDateTextField);
		deliveryDateTextField.setColumns(10);
		
		lblCompanyId = new JLabel("Company ID");
		lblCompanyId.setBounds(10, 193, 46, 14);
		contentPane.add(lblCompanyId);
		
		companyIDTextField = new JTextField();
		companyIDTextField.setBounds(135, 190, 86, 20);
		contentPane.add(companyIDTextField);
		companyIDTextField.setColumns(10);
		
		lblRawmaterialBarcode = new JLabel("RawMaterial Barcode");
		lblRawmaterialBarcode.setBounds(10, 246, 46, 14);
		contentPane.add(lblRawmaterialBarcode);
		
		rawMaterialBarcodeTextField = new JTextField();
		rawMaterialBarcodeTextField.setBounds(135, 243, 86, 20);
		contentPane.add(rawMaterialBarcodeTextField);
		rawMaterialBarcodeTextField.setColumns(10);
		
		quantityTextField = new JTextField();
		quantityTextField.setBounds(135, 296, 86, 20);
		contentPane.add(quantityTextField);
		quantityTextField.setColumns(10);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 299, 46, 14);
		contentPane.add(lblQuantity);
		
		lblRawMaterialLine = new JLabel("Raw Material Line ID");
		lblRawMaterialLine.setBounds(10, 352, 46, 14);
		contentPane.add(lblRawMaterialLine);
		
        JButton addButton = new JButton("Add");
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setBackground(new Color(2, 52, 68));
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ManageRawMaterialLine rawMaterialLine = new ManageRawMaterialLine();
                CreateRawMaterialOrder order = new CreateRawMaterialOrder();
                rawMaterialLine.create(rawMaterialLineTextField.getText(), Double.parseDouble(quantityTextField.getText()), rawMaterialBarcodeTextField.getText());
                double sum = Double.parseDouble(lblPrice.getText());
                sum = sum + order.calculatePrice(rawMaterialBarcodeTextField.getText(), Integer.parseInt(quantityTextField.getText()));
                lblPrice.setText("" + sum);
                fillTable(rawMaterialLineTable,rawMaterialLineTextField.getText());
            }
        });
        addButton.setBounds(10, 442, 89, 23);
        contentPane.add(addButton);
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		ManageRawMaterialLine rawMaterialLine = new ManageRawMaterialLine();
                rawMaterialLine.delete(rawMaterialLineTextField.getText());
                fillTable(rawMaterialLineTable,rawMaterialLineTextField.getText());
                lblPrice.setText("0");
        	}
        });
        deleteButton.setBounds(156, 442, 89, 23);
        contentPane.add(deleteButton);
        
        btnUpdate = new JButton("Update");
        btnUpdate.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 ManageRawMaterialLine rawMaterialLine= new ManageRawMaterialLine();
                 rawMaterialLine.update(rawMaterialLineTextField.getText(), Double.parseDouble(quantityTextField.getText()), rawMaterialBarcodeTextField.getText());
                 fillTable(rawMaterialLineTable,rawMaterialLineTextField.getText());
        	}
        });
        btnUpdate.setBounds(315, 442, 89, 23);
        contentPane.add(btnUpdate);
        
        

        JButton finalizeButton = new JButton("Finalize");
        finalizeButton.setForeground(new Color(255, 255, 255));
        finalizeButton.setBackground(new Color(2, 52, 68));
        finalizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CreateRawMaterialOrder rawMaterialOrderCtr = new CreateRawMaterialOrder();
                rawMaterialOrderCtr.create(orderIDTextField.getText(), Double.parseDouble(lblPrice.getText()), orderStatusTextField.getText(), deliveryDateTextField.getText(), companyIDTextField.getText(), rawMaterialLineTextField.getText());
                dispose();
            }
        });
        finalizeButton.setBounds(51, 535, 89, 23);
        contentPane.add(finalizeButton);
        

	}
	
    private void fillTable(DefaultTableModel model, String rawMaterialLineID) {
        model.setRowCount(0);
        ManageRawMaterialLine rawMaterialLineCtr = new ManageRawMaterialLine();
        ArrayList<RawMaterialLine> rawMaterialLines = rawMaterialLineCtr.readAll();
        if (rawMaterialLines.isEmpty()) {
            model.addRow(new Object[]{"Raw Materials Lines", "FOUND"});
        } else {
            for (RawMaterialLine rawMaterialLine : rawMaterialLines)
                if (rawMaterialLine.getId().equals(rawMaterialLineID)) {
                    double quantity = rawMaterialLine.getQuantity();
                    String productBarcode = rawMaterialLine.getRawMaterialBarcode();
                    model.addRow(new Object[]{productBarcode, quantity});
                }

        }
    }
}

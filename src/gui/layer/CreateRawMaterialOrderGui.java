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
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 1041, 542);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 93, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rawMaterialLineTextField = new JTextField();
		rawMaterialLineTextField.setBounds(135, 348, 159, 23);
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
		scrollPane.setBounds(453, 0, 572, 499);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(62, 143, 169));
		scrollPane.setViewportView(table);
        table.setModel(rawMaterialLineTable);
		
		lblOrderId = new JLabel("Order ID");
		lblOrderId.setForeground(new Color(255, 255, 255));
		lblOrderId.setBounds(10, 168, 115, 14);
		contentPane.add(lblOrderId);
		
		orderIDTextField = new JTextField();
		orderIDTextField.setBounds(135, 165, 159, 20);
		contentPane.add(orderIDTextField);
		orderIDTextField.setColumns(10);
		
		lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setForeground(new Color(255, 255, 255));
		lblTotalPrice.setBounds(10, 382, 77, 14);
		contentPane.add(lblTotalPrice);
		
		lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setBounds(132, 382, 46, 14);
		contentPane.add(lblPrice);
		
		lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setForeground(new Color(255, 255, 255));
		lblOrderStatus.setBounds(10, 196, 115, 14);
		contentPane.add(lblOrderStatus);
		
		orderStatusTextField = new JTextField();
		orderStatusTextField.setBounds(135, 193, 159, 20);
		contentPane.add(orderStatusTextField);
		orderStatusTextField.setColumns(10);
		
		lblNewLabel = new JLabel("Delivery Date");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 227, 115, 14);
		contentPane.add(lblNewLabel);
		
		deliveryDateTextField = new JTextField();
		deliveryDateTextField.setBounds(135, 224, 159, 20);
		contentPane.add(deliveryDateTextField);
		deliveryDateTextField.setColumns(10);
		
		lblCompanyId = new JLabel("Company ID");
		lblCompanyId.setForeground(new Color(255, 255, 255));
		lblCompanyId.setBounds(10, 258, 115, 14);
		contentPane.add(lblCompanyId);
		
		companyIDTextField = new JTextField();
		companyIDTextField.setBounds(135, 255, 159, 20);
		contentPane.add(companyIDTextField);
		companyIDTextField.setColumns(10);
		
		lblRawmaterialBarcode = new JLabel("RawMaterial Barcode");
		lblRawmaterialBarcode.setForeground(new Color(255, 255, 255));
		lblRawmaterialBarcode.setBounds(10, 289, 115, 14);
		contentPane.add(lblRawmaterialBarcode);
		
		rawMaterialBarcodeTextField = new JTextField();
		rawMaterialBarcodeTextField.setBounds(135, 286, 159, 20);
		contentPane.add(rawMaterialBarcodeTextField);
		rawMaterialBarcodeTextField.setColumns(10);
		
		quantityTextField = new JTextField();
		quantityTextField.setBounds(135, 317, 159, 20);
		contentPane.add(quantityTextField);
		quantityTextField.setColumns(10);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(255, 255, 255));
		lblQuantity.setBounds(10, 320, 115, 14);
		contentPane.add(lblQuantity);
		
		lblRawMaterialLine = new JLabel("Raw Material Line ID");
		lblRawMaterialLine.setForeground(new Color(255, 255, 255));
		lblRawMaterialLine.setBounds(10, 352, 115, 14);
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
        addButton.setBounds(55, 476, 89, 23);
        contentPane.add(addButton);
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.setForeground(new Color(255, 255, 255));
        deleteButton.setBackground(new Color(2, 52, 68));
        deleteButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		ManageRawMaterialLine rawMaterialLine = new ManageRawMaterialLine();
                rawMaterialLine.delete(rawMaterialLineTextField.getText());
                fillTable(rawMaterialLineTable,rawMaterialLineTextField.getText());
                lblPrice.setText("0");
        	}
        });
        deleteButton.setBounds(156, 476, 89, 23);
        contentPane.add(deleteButton);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBackground(new Color(2, 52, 68));
        btnUpdate.setForeground(new Color(255, 255, 255));
        btnUpdate.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 ManageRawMaterialLine rawMaterialLine= new ManageRawMaterialLine();
                 rawMaterialLine.update(rawMaterialLineTextField.getText(), Double.parseDouble(quantityTextField.getText()), rawMaterialBarcodeTextField.getText());
                 fillTable(rawMaterialLineTable,rawMaterialLineTextField.getText());
        	}
        });
        btnUpdate.setBounds(255, 476, 89, 23);
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
        finalizeButton.setBounds(354, 476, 89, 23);
        contentPane.add(finalizeButton);
        
        JButton btnNewButton = new JButton("<");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 dispose();
                 Menu menu = new Menu();
                 menu.setVisible(true);
        	}
        });
        btnNewButton.setBackground(new Color(2, 52, 68));
        btnNewButton.setBounds(0, 476, 44, 23);
        contentPane.add(btnNewButton);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("photos\\rawmaterialorder.png"));
        label.setBounds(0, 34, 473, 123);
        contentPane.add(label);
        

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

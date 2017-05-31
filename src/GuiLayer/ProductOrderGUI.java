package GuiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControlLayer.CreateProductOrder;
import ControlLayer.ManageProductLine;
import ModelLayer.ProductLine;
import ModelLayer.ProductOrder;
import DBLayer.ProductOrderDB;
import DBLayer.ProductLineDB;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ProductOrderGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField quantityTextField;
	private JTextField orderIDTextField;
	private JTextField productBarcodeTextField;
	private JTextField orderStatusTextField;
	private JTextField deliveryDateTextField;
	private JTextField companyIDTextField;
	private JTextField productLineTextField;
	private JLabel timeLabel;


	/**
	 * Create the frame.
	 */
	public ProductOrderGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel productLinetable= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Quantity", "Product Barcode"
				});
		fillTable(productLinetable);
		
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

		productLineTextField = new JTextField();
		productLineTextField.setBounds(383, 185, 145, 20);
		contentPane.add(productLineTextField);
		productLineTextField.setColumns(10);

		productBarcodeTextField = new JTextField();
		productBarcodeTextField.setColumns(10);
		productBarcodeTextField.setBounds(383, 24, 145, 31);
		contentPane.add(productBarcodeTextField);

		JButton addButton = new JButton("Add");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ManageProductLine productLine=new ManageProductLine();
                CreateProductOrder order=new CreateProductOrder();
				productLine.create(productLineTextField.getText(),Double.parseDouble(quantityTextField.getText()),productBarcodeTextField.getText());
				double sum=Double.parseDouble(price.getText());
				sum=sum+order.calculatePrice(productBarcodeTextField.getText(),Integer.parseInt(quantityTextField.getText()));
				price.setText(""+sum);
				double time=Double.parseDouble(timeLabel.getText());
				time=time+order.calculateTime(productBarcodeTextField.getText(),Integer.parseInt(quantityTextField.getText()));
				timeLabel.setText("" + time);
				fillTable(productLinetable);
			}
		});
		addButton.setBounds(383, 230, 89, 23);
		contentPane.add(addButton);
		
		JButton deteleButton = new JButton("Delete");
		deteleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageProductLine productLine=new ManageProductLine();
				productLine.delete(productLineTextField.getText());
				fillTable(productLinetable);

			}
		});
		deteleButton.setBounds(482, 230, 89, 23);
		contentPane.add(deteleButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageProductLine company=new ManageProductLine();
				company.update(productLineTextField.getText(),Double.parseDouble(quantityTextField.getText()),productBarcodeTextField.getText());
				fillTable(productLinetable);
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
		
		JLabel lblProductlineid = new JLabel("ProductLineID");
		lblProductlineid.setBounds(415, 161, 113, 14);
		contentPane.add(lblProductlineid);
		
		JLabel lblTotalTime = new JLabel("Total time");
		lblTotalTime.setBounds(392, 312, 80, 14);
		contentPane.add(lblTotalTime);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setBounds(392, 355, 80, 14);
		contentPane.add(lblTotalPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(675, 0, 311, 456);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(productLinetable);
		
		JButton finalizeButton = new JButton("Finalize");
		finalizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateProductOrder productOrder=new CreateProductOrder();
				productOrder.create(orderIDTextField.getText(),Double.parseDouble(price.getText()),orderStatusTextField.getText(),deliveryDateTextField.getText(),companyIDTextField.getText(),productLineTextField.getText(),Double.parseDouble(timeLabel.getText()));
				dispose();
				ConfirmationGUI confirmationGUI=new ConfirmationGUI();
				confirmationGUI.setVisible(true);
			}
		});
		finalizeButton.setBounds(33, 346, 89, 23);
		contentPane.add(finalizeButton);
	}
	
	
	private void fillTable(DefaultTableModel model) {
		model.setRowCount(0);
		ManageProductLine productLineCtr = new ManageProductLine();
		ArrayList<ProductLine> productLine = productLineCtr.readAll();
		if (!productLine.isEmpty()) {
			for (ProductLine productLines : productLine) {
				String productLineID = productLines.getproductLineId();
				double quantity = productLines.getQuantity();
				String productOrderID = productLines.getProductBarcode();
				model.addRow(new Object[] { productLineID, quantity, productOrderID });
			}

		} else {
			model.addRow(new Object[] { "NO", "Product Lines", "FOUND", "!", 0 });
		}
	}
}

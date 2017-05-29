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
		
		table = new JTable();
		table.setModel(productLinetable);
		table.setBounds(792, 0, 194, 456);
		fillTable(productLinetable);
		
		contentPane.add(table);
		
		quantityTextField = new JTextField();
		quantityTextField.setBounds(389, 24, 145, 31);
		contentPane.add(quantityTextField);
		quantityTextField.setColumns(10);
		
		orderIDTextField = new JTextField();
		orderIDTextField.setColumns(10);
		orderIDTextField.setBounds(143, 24, 145, 31);
		contentPane.add(orderIDTextField);
		
		productBarcodeTextField = new JTextField();
		productBarcodeTextField.setColumns(10);
		productBarcodeTextField.setBounds(586, 24, 145, 31);
		contentPane.add(productBarcodeTextField);
		
		JButton addButton = new JButton("Add");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ManageProductLine productLine=new ManageProductLine();
				productLine.create(productLineTextField.getText(),Double.parseDouble(quantityTextField.getText()),productBarcodeTextField.getText());
				fillTable(productLinetable);


			}
		});
		addButton.setBounds(24, 394, 89, 23);
		contentPane.add(addButton);
		
		JButton deteleButton = new JButton("Delete");
		deteleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageProductLine productLine=new ManageProductLine();
				productLine.delete(orderIDTextField.getText());
				fillTable(productLinetable);

			}
		});
		deteleButton.setBounds(123, 394, 89, 23);
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
		updateButton.setBounds(242, 394, 89, 23);
		contentPane.add(updateButton);
		
		JLabel lbld = new JLabel("order ID");
		lbld.setBounds(10, 32, 103, 14);
		contentPane.add(lbld);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(438, 66, 46, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblProductBarcode = new JLabel("Product Barcode");
		lblProductBarcode.setBounds(638, 66, 46, 14);
		contentPane.add(lblProductBarcode);
		
		JLabel lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setBounds(10, 93, 46, 14);
		contentPane.add(lblOrderStatus);
		
		orderStatusTextField = new JTextField();
		orderStatusTextField.setBounds(143, 84, 145, 23);
		contentPane.add(orderStatusTextField);
		orderStatusTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Delivery Date");
		lblNewLabel.setBounds(10, 158, 46, 14);
		contentPane.add(lblNewLabel);
		
		deliveryDateTextField = new JTextField();
		deliveryDateTextField.setBounds(146, 155, 142, 20);
		contentPane.add(deliveryDateTextField);
		deliveryDateTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CompanyID");
		lblNewLabel_1.setBounds(10, 216, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		companyIDTextField = new JTextField();
		companyIDTextField.setBounds(143, 213, 145, 20);
		contentPane.add(companyIDTextField);
		companyIDTextField.setColumns(10);
		
		JLabel lblProductlineid = new JLabel("ProductLineID");
		lblProductlineid.setBounds(0, 271, 113, 14);
		contentPane.add(lblProductlineid);
		
		productLineTextField = new JTextField();
		productLineTextField.setBounds(143, 268, 145, 20);
		contentPane.add(productLineTextField);
		productLineTextField.setColumns(10);
		
		JLabel time = new JLabel("New label");
		time.setBounds(143, 312, 46, 14);
		contentPane.add(time);
		
		JLabel lblTotalTime = new JLabel("Total time");
		lblTotalTime.setBounds(0, 312, 46, 14);
		contentPane.add(lblTotalTime);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setBounds(0, 355, 46, 14);
		contentPane.add(lblTotalPrice);
		
		JLabel price = new JLabel("New label");
		price.setBounds(143, 355, 46, 14);
		contentPane.add(price);
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

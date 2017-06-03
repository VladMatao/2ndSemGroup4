package gui.layer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.MouseEvent;

import control.layer.DeleteOrder;
import control.layer.ReadOrder;
import control.layer.UpdateOrder;
import model.layer.RawMaterialOrder;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SupplierOrderGui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField orderIDTextField;
	private JTextField orderStatusTextField;
	private JTextField deliveryDateTextField;
	private JTextField companyIDTextField;
	private JTextField rawMaterialsIDTextField;

	/**
	 * Create the frame.
	 */
	public SupplierOrderGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultTableModel suppliertable = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                		 "Order ID", "Total Price", "Order Status", "Delivery date", "Company ID", "Raw Material Line ID"
                });
        fillTable(suppliertable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 0, 541, 601);

		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(suppliertable);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setBounds(10, 35, 46, 14);
		contentPane.add(lblOrderId);
		
		orderIDTextField = new JTextField();
		orderIDTextField.setBounds(126, 32, 86, 20);
		contentPane.add(orderIDTextField);
		orderIDTextField.setColumns(10);
		
		JLabel lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setBounds(10, 84, 46, 14);
		contentPane.add(lblOrderStatus);
		
		orderStatusTextField = new JTextField();
		orderStatusTextField.setBounds(126, 81, 86, 20);
		contentPane.add(orderStatusTextField);
		orderStatusTextField.setColumns(10);
		
		JLabel lblDeliveryDate = new JLabel("Delivery Date");
		lblDeliveryDate.setBounds(10, 134, 46, 14);
		contentPane.add(lblDeliveryDate);
		
		deliveryDateTextField = new JTextField();
		deliveryDateTextField.setBounds(126, 131, 86, 20);
		contentPane.add(deliveryDateTextField);
		deliveryDateTextField.setColumns(10);
		
		JLabel lblCompanyid = new JLabel("CompanyID");
		lblCompanyid.setBounds(10, 182, 46, 14);
		contentPane.add(lblCompanyid);
		
		companyIDTextField = new JTextField();
		companyIDTextField.setBounds(126, 179, 86, 20);
		contentPane.add(companyIDTextField);
		companyIDTextField.setColumns(10);
		
		rawMaterialsIDTextField = new JTextField();
		rawMaterialsIDTextField.setBounds(126, 229, 86, 20);
		contentPane.add(rawMaterialsIDTextField);
		rawMaterialsIDTextField.setColumns(10);
		
		JLabel lblRawmaterialsId = new JLabel("RawMaterials ID");
		lblRawmaterialsId.setBounds(10, 232, 46, 14);
		contentPane.add(lblRawmaterialsId);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(2, 52, 68));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteOrder deleteRawMaterialOrder = new DeleteOrder();
				deleteRawMaterialOrder.deleteRawMaterialOrder(orderIDTextField.getText());
			}
		});
		btnDelete.setBounds(75, 468, 123, 23);
		contentPane.add(btnDelete);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 UpdateOrder rawMaterialtOrder = new UpdateOrder();
				 ReadOrder readRawMaterialOrder= new ReadOrder();
				 rawMaterialtOrder.updateRawMaterialOrder(orderIDTextField.getText(), readRawMaterialOrder.readRawMaterialOrder(orderIDTextField.getText()).getTotalPrice(), orderStatusTextField.getText(), deliveryDateTextField.getText(), readRawMaterialOrder.readRawMaterialOrder(orderIDTextField.getText()).getCompanyId(), readRawMaterialOrder.readRawMaterialOrder(orderIDTextField.getText()).getRawMaterialLineId());
	             fillTable(suppliertable);
			}
		});
		btnUpdate.setBounds(276, 271, 89, 23);		
		contentPane.add(btnUpdate);
		
		JButton createOrderButton = new JButton("Create supplier order");
		createOrderButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				CreateRawMaterialOrderGui createRawMaterialOrderGui=new CreateRawMaterialOrderGui();
				createRawMaterialOrderGui.setVisible(true);
			}
		});
		createOrderButton.setBounds(169, 360, 148, 23);
		contentPane.add(createOrderButton);
	}
	
	 private void fillTable(DefaultTableModel model) {
	        model.setRowCount(0);
	        ReadOrder supplierCtr = new ReadOrder();
	        ArrayList<RawMaterialOrder> rawMaterial = supplierCtr.readAllRawMaterialOrders();
	        if (!rawMaterial.isEmpty()) {
	            for (RawMaterialOrder rawMaterials : rawMaterial) {
					String orderID = rawMaterials.getId();
					String deliveryDate = rawMaterials.getDeliveryDate();
					String orderStatus = rawMaterials.getOrderStatus();
					Double totalPrice = rawMaterials.getTotalPrice();
					String companyID = rawMaterials.getCompanyId();
					String rawMaterialLineId = rawMaterials.getRawMaterialLineId();
	                model.addRow(new Object[]{orderID,totalPrice,orderStatus, deliveryDate, companyID, rawMaterialLineId});
	            }

	        } else {
	            model.addRow(new Object[]{"NO", "Raw material orders", "FOUND", "!", 0});
	        }
	    }
}

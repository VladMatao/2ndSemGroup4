package gui.layer;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.layer.DeleteOrder;
import control.layer.ReadOrder;
import model.layer.RawMaterialOrder;

class SupplierOrderGui extends JFrame {

    private final JTextField orderIDTextField;

    /**
	 * Create the frame.
	 */
	SupplierOrderGui() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 460);
        JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 93, 115));
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

        JTable table = new JTable();
		table.setBackground(new Color(62, 143, 169));
		scrollPane.setViewportView(table);
		table.setModel(suppliertable);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setForeground(new Color(255, 255, 255));
		lblOrderId.setBounds(55, 115, 46, 14);
		contentPane.add(lblOrderId);
		
		orderIDTextField = new JTextField();
		orderIDTextField.setBounds(171, 112, 130, 20);
		contentPane.add(orderIDTextField);
		orderIDTextField.setColumns(10);
		
		JLabel lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setForeground(new Color(255, 255, 255));
		lblOrderStatus.setBounds(55, 164, 106, 14);
		contentPane.add(lblOrderStatus);

        JTextField orderStatusTextField = new JTextField();
		orderStatusTextField.setBounds(171, 161, 130, 20);
		contentPane.add(orderStatusTextField);
		orderStatusTextField.setColumns(10);
		
		JLabel lblDeliveryDate = new JLabel("Delivery Date");
		lblDeliveryDate.setForeground(new Color(255, 255, 255));
		lblDeliveryDate.setBounds(55, 214, 106, 14);
		contentPane.add(lblDeliveryDate);

        JTextField deliveryDateTextField = new JTextField();
		deliveryDateTextField.setBounds(171, 211, 130, 20);
		contentPane.add(deliveryDateTextField);
		deliveryDateTextField.setColumns(10);
		
		JLabel lblCompanyid = new JLabel("CompanyID");
		lblCompanyid.setForeground(new Color(255, 255, 255));
		lblCompanyid.setBounds(55, 262, 130, 14);
		contentPane.add(lblCompanyid);

        JTextField companyIDTextField = new JTextField();
		companyIDTextField.setBounds(171, 259, 130, 20);
		contentPane.add(companyIDTextField);
		companyIDTextField.setColumns(10);

        JTextField rawMaterialsIDTextField = new JTextField();
		rawMaterialsIDTextField.setBounds(171, 309, 130, 20);
		contentPane.add(rawMaterialsIDTextField);
		rawMaterialsIDTextField.setColumns(10);
		
		JLabel lblRawmaterialsId = new JLabel("RawMaterials ID");
		lblRawmaterialsId.setForeground(new Color(255, 255, 255));
		lblRawmaterialsId.setBounds(55, 312, 106, 14);
		contentPane.add(lblRawmaterialsId);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(2, 52, 68));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(arg0 -> {
            DeleteOrder deleteRawMaterialOrder = new DeleteOrder();
            deleteRawMaterialOrder.deleteRawMaterialOrder(orderIDTextField.getText());
        });
		btnDelete.setBounds(312, 387, 77, 23);
		contentPane.add(btnDelete);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(2, 52, 68));
		btnUpdate.addMouseListener(new MouseAdapter() {
        });
		btnUpdate.setBounds(78, 387, 77, 23);		
		contentPane.add(btnUpdate);
		
		JButton createOrderButton = new JButton("Create supplier order");
		createOrderButton.setBackground(new Color(2, 52, 68));
		createOrderButton.setForeground(new Color(255, 255, 255));
		createOrderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				dispose();
				CreateRawMaterialOrderGui createRawMaterialOrderGui=new CreateRawMaterialOrderGui();
				createRawMaterialOrderGui.setVisible(true);
			}
		});
		createOrderButton.setBounds(165, 387, 137, 23);
		contentPane.add(createOrderButton);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(2, 52, 68));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(14, 387, 54, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("photos\\supplierorder.png"));
		label.setBounds(-6, 0, 395, 112);
		contentPane.add(label);
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

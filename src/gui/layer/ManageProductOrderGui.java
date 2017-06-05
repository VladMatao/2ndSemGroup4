package gui.layer;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.layer.DeleteOrder;
import control.layer.ReadOrder;
import control.layer.UpdateOrder;
import model.layer.ProductOrder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class ManageProductOrderGui extends JFrame {

    private final JTextField orderIDTextField;
	private final JTextField orderStatustextField;
	private final JTextField deliveryDatetextField;

    ManageProductOrderGui() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 541);
        JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 93, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 DefaultTableModel productOrdertable = new DefaultTableModel(
	                new Object[][]{
	                },
	                new String[]{
	                        "Order ID", "Total Price", "Order Status", "Delivery date", "Company ID", "Product Line ID","Producion time"
	                });
	        fillTable(productOrdertable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(452, 0, 605, 502);
		contentPane.add(scrollPane);

        JTable table = new JTable();
		table.setBackground(new Color(62, 143, 169));
		scrollPane.setViewportView(table);
		table.setModel(productOrdertable);
		
		
		JLabel lblNewLabel = new JLabel("OrderID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(102, 205, 80, 14);
		contentPane.add(lblNewLabel);
		
		orderIDTextField = new JTextField();
		orderIDTextField.setBounds(212, 202, 136, 20);
		contentPane.add(orderIDTextField);
		orderIDTextField.setColumns(10);
		
		JLabel lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setForeground(new Color(255, 255, 255));
		lblOrderStatus.setBounds(102, 235, 80, 14);
		contentPane.add(lblOrderStatus);
		
		orderStatustextField = new JTextField();
		orderStatustextField.setBounds(212, 232, 136, 20);
		contentPane.add(orderStatustextField);
		orderStatustextField.setColumns(10);
		
		JLabel lblDeliveryDate = new JLabel("Delivery Date");
		lblDeliveryDate.setForeground(new Color(255, 255, 255));
		lblDeliveryDate.setBounds(102, 263, 80, 14);
		contentPane.add(lblDeliveryDate);
		
		deliveryDatetextField = new JTextField();
		deliveryDatetextField.setBounds(212, 260, 136, 20);
		contentPane.add(deliveryDatetextField);
		deliveryDatetextField.setColumns(10);

        JTextField companyIDtextField = new JTextField();
		companyIDtextField.setBounds(212, 291, 136, 20);
		contentPane.add(companyIDtextField);
		companyIDtextField.setColumns(10);
		
		JLabel lblCompanyid = new JLabel("CompanyID");
		lblCompanyid.setForeground(new Color(255, 255, 255));
		lblCompanyid.setBounds(102, 294, 80, 14);
		contentPane.add(lblCompanyid);
		
		JLabel lblProductLineId = new JLabel("Product Line ID");
		lblProductLineId.setForeground(new Color(255, 255, 255));
		lblProductLineId.setBounds(102, 325, 100, 14);
		contentPane.add(lblProductLineId);

        JTextField productLineIDtextField = new JTextField();
		productLineIDtextField.setBounds(212, 322, 136, 20);
		contentPane.add(productLineIDtextField);
		productLineIDtextField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(2, 52, 68));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(arg0 -> {
            DeleteOrder deleteOrder = new DeleteOrder();
deleteOrder.deleteProductOrder(orderIDTextField.getText());
        });
		btnDelete.setBounds(75, 468, 123, 23);
		contentPane.add(btnDelete);

        JButton btnCreateNewOrder = new JButton("Create new order");
		btnCreateNewOrder.setBackground(new Color(2, 52, 68));
		btnCreateNewOrder.setForeground(new Color(255, 255, 255));
		btnCreateNewOrder.addActionListener(e -> {
            dispose();
ProductOrderGui productOrderGui = new ProductOrderGui();
productOrderGui.setVisible(true);
        });
		btnCreateNewOrder.setBounds(225, 468, 123, 23);
		contentPane.add(btnCreateNewOrder);

        JButton btnNewButton = new JButton("<");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 dispose();
                 Menu menu = new Menu();
                 menu.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(2, 52, 68));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 468, 46, 23);
		contentPane.add(btnNewButton);

        JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("photos\\productorders.png"));
		label.setBounds(20, 37, 488, 114);
		contentPane.add(label);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(2, 52, 68));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateOrder productOrder = new UpdateOrder();
				ReadOrder readOrder = new ReadOrder();
				productOrder.updateProductOrder(orderIDTextField.getText(), readOrder.readProductOrder(orderIDTextField.getText()).getTotalPrice(), orderStatustextField.getText(), deliveryDatetextField.getText(), readOrder.readProductOrder(orderIDTextField.getText()).getCompanyId(), readOrder.readProductOrder(orderIDTextField.getText()).getProductLineId(), readOrder.readProductOrder(orderIDTextField.getText()).getTotalProductionTime());
				fillTable(productOrdertable);
			}
		});
		btnUpdate.setBounds(358, 468, 89, 23);

		contentPane.add(btnUpdate);



	}
	

    private void fillTable(DefaultTableModel model) {
        model.setRowCount(0);
        ReadOrder productOrderCtr = new ReadOrder();
        ArrayList<ProductOrder> productOrders = productOrderCtr.readAllProductOrders();
        if (!productOrders.isEmpty()) {
            for (ProductOrder productOrder : productOrders) {
                String orderID = productOrder.getId();
                String deliveryDate = productOrder.getDeliveryDate();
                String orderStatus = productOrder.getOrderStatus();
                Double totalPrice = productOrder.getTotalPrice();
                String companyID = productOrder.getCompanyId();
				String productLineId = productOrder.getProductLineId();
                Double productionTime = productOrder.getTotalProductionTime();
                model.addRow(new Object[]{orderID, totalPrice, orderStatus, deliveryDate, companyID,productLineId, productionTime});
            }

        } else {
            model.addRow(new Object[]{"NO", "product orders", "FOUND", "!", 0});
        }
    }
}

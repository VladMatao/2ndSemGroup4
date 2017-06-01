package gui.layer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.layer.DeleteProductOrder;
import control.layer.ManageCompany;
import control.layer.ReadProductOrder;
import model.layer.Company;
import model.layer.ProductOrder;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ManageProductOrderGui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField orderIDTextField;
	private JTextField orderStatustextField;
	private JTextField deliveryDatetextField;
	private JTextField companyIDtextField;
	private JTextField ProductLineIDtextField;
	private JButton btnCreateNewOrder;
	private JButton btnNewButton;
	private JLabel label;

	public ManageProductOrderGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 541);
		contentPane = new JPanel();
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
		
		table = new JTable();
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
		
		companyIDtextField = new JTextField();
		companyIDtextField.setBounds(212, 291, 136, 20);
		contentPane.add(companyIDtextField);
		companyIDtextField.setColumns(10);
		
		JLabel lblCompanyid = new JLabel("CompanyID");
		lblCompanyid.setForeground(new Color(255, 255, 255));
		lblCompanyid.setBounds(102, 294, 80, 14);
		contentPane.add(lblCompanyid);
		
		JLabel lblProductLineId = new JLabel("Product Line ID");
		lblProductLineId.setForeground(new Color(255, 255, 255));
		lblProductLineId.setBounds(102, 325, 80, 14);
		contentPane.add(lblProductLineId);
		
		ProductLineIDtextField = new JTextField();
		ProductLineIDtextField.setBounds(212, 322, 136, 20);
		contentPane.add(ProductLineIDtextField);
		ProductLineIDtextField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(2, 52, 68));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteProductOrder deleteProductOrder = new DeleteProductOrder();
                deleteProductOrder.delete(orderIDTextField.getText());
			}
		});
		btnDelete.setBounds(75, 468, 123, 23);
		contentPane.add(btnDelete);
		
		btnCreateNewOrder = new JButton("Create new order");
		btnCreateNewOrder.setBackground(new Color(2, 52, 68));
		btnCreateNewOrder.setForeground(new Color(255, 255, 255));
		btnCreateNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                ProductOrderGui productOrderGui = new ProductOrderGui();
                productOrderGui.setVisible(true);
			}
		});
		btnCreateNewOrder.setBounds(225, 468, 123, 23);
		contentPane.add(btnCreateNewOrder);
		
		btnNewButton = new JButton("<");
		btnNewButton.setBackground(new Color(2, 52, 68));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 468, 46, 23);
		contentPane.add(btnNewButton);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("photos\\productorders.png"));
		label.setBounds(20, 37, 488, 114);
		contentPane.add(label);
		

	}
	

    private void fillTable(DefaultTableModel model) {
        model.setRowCount(0);
        ReadProductOrder productOrderCtr = new ReadProductOrder();
        ArrayList<ProductOrder> productOrders = productOrderCtr.readAll();
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

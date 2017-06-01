package gui.layer;

import java.awt.BorderLayout;
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

public class ManageProductOrderGui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField orderIDTextField;
	private JTextField orderStatustextField;
	private JTextField deliveryDatetextField;
	private JTextField companyIDtextField;
	private JTextField ProductLineIDtextField;
	private JButton btnCreateNewOrder;

	public ManageProductOrderGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 541);
		contentPane = new JPanel();
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
		scrollPane.setBounds(452, 0, 539, 502);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(productOrdertable);
		
		
		JLabel lblNewLabel = new JLabel("OrderID");
		lblNewLabel.setBounds(10, 23, 46, 14);
		contentPane.add(lblNewLabel);
		
		orderIDTextField = new JTextField();
		orderIDTextField.setBounds(120, 20, 86, 20);
		contentPane.add(orderIDTextField);
		orderIDTextField.setColumns(10);
		
		JLabel lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setBounds(10, 55, 46, 14);
		contentPane.add(lblOrderStatus);
		
		orderStatustextField = new JTextField();
		orderStatustextField.setBounds(120, 52, 86, 20);
		contentPane.add(orderStatustextField);
		orderStatustextField.setColumns(10);
		
		JLabel lblDeliveryDate = new JLabel("Delivery Date");
		lblDeliveryDate.setBounds(10, 99, 46, 14);
		contentPane.add(lblDeliveryDate);
		
		deliveryDatetextField = new JTextField();
		deliveryDatetextField.setBounds(120, 96, 86, 20);
		contentPane.add(deliveryDatetextField);
		deliveryDatetextField.setColumns(10);
		
		companyIDtextField = new JTextField();
		companyIDtextField.setBounds(120, 146, 86, 20);
		contentPane.add(companyIDtextField);
		companyIDtextField.setColumns(10);
		
		JLabel lblCompanyid = new JLabel("CompanyID");
		lblCompanyid.setBounds(10, 149, 46, 14);
		contentPane.add(lblCompanyid);
		
		JLabel lblProductLineId = new JLabel("Product Line ID");
		lblProductLineId.setBounds(10, 189, 46, 14);
		contentPane.add(lblProductLineId);
		
		ProductLineIDtextField = new JTextField();
		ProductLineIDtextField.setBounds(120, 186, 86, 20);
		contentPane.add(ProductLineIDtextField);
		ProductLineIDtextField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteProductOrder deleteProductOrder = new DeleteProductOrder();
                deleteProductOrder.delete(orderIDTextField.getText());
			}
		});
		btnDelete.setBounds(10, 271, 89, 23);
		contentPane.add(btnDelete);
		
		btnCreateNewOrder = new JButton("Create new order");
		btnCreateNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                ProductOrderGui productOrderGui = new ProductOrderGui();
                productOrderGui.setVisible(true);
			}
		});
		btnCreateNewOrder.setBounds(117, 271, 123, 23);
		contentPane.add(btnCreateNewOrder);
		

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

package GuiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControlLayer.ManageCompany;
import ControlLayer.ManageProductLine;
import ModelLayer.Company;
import ModelLayer.ProductLine;
import ControlLayer.ReadProductOrder;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InvoiceGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public InvoiceGUI(String orderID) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOrdID = new JLabel("");
		lblOrdID.setBounds(119, 52, 46, 14);
		contentPane.add(lblOrdID);
		lblOrdID.setText(orderID);
		
		DefaultTableModel invoicetable= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					 "ProductBarcode", "Quantity"
				});
		ReadProductOrder readProductOrder= new ReadProductOrder();
		fillTable(invoicetable,readProductOrder.read(orderID).getProductLineId());
	
		
		JLabel lblOrderid = new JLabel("OrderID:");
		lblOrderid.setBounds(45, 52, 46, 14);
		contentPane.add(lblOrderid);

		JLabel lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setBounds(10, 100, 81, 14);
		contentPane.add(lblOrderStatus);
		
		JLabel lblOrderstatus = new JLabel("orderstatus");
		lblOrderstatus.setBounds(119, 100, 73, 14);
		contentPane.add(lblOrderstatus);
		lblOrderstatus.setText(readProductOrder.read(orderID).getOrderStatus());
		
		JLabel lblDeliverydate = new JLabel("DeliveryDate");
		lblDeliverydate.setBounds(10, 143, 46, 14);
		contentPane.add(lblDeliverydate);
		
		JLabel lblDelivery = new JLabel("delivery");
		lblDelivery.setBounds(119, 143, 46, 14);
		contentPane.add(lblDelivery);
		lblDelivery.setText(readProductOrder.read(orderID).getOrderStatus());
		
		JLabel lblCompanyid = new JLabel("CompanyID");
		lblCompanyid.setBounds(10, 192, 46, 14);
		contentPane.add(lblCompanyid);
		
		JLabel lblCompanyid_1 = new JLabel("companyID");
		lblCompanyid_1.setBounds(119, 192, 54, 14);
		contentPane.add(lblCompanyid_1);
		lblCompanyid_1.setText(readProductOrder.read(orderID).getCompanyId());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(313, 0, 330, 439);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(invoicetable);
		
		JLabel lblTotalTime = new JLabel("Total time");
		lblTotalTime.setBounds(10, 230, 46, 14);
		contentPane.add(lblTotalTime);
		
		JLabel lblTime = new JLabel("time");
		lblTime.setBounds(119, 230, 46, 14);
		contentPane.add(lblTime);
		lblTime.setText(""+readProductOrder.read(orderID).getTotalProductionTime());
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setBounds(10, 269, 46, 14);
		contentPane.add(lblTotalPrice);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(119, 269, 46, 14);
		contentPane.add(lblPrice);
		lblPrice.setText(""+readProductOrder.read(orderID).getTotalPrice());
		
}
	private void fillTable(DefaultTableModel model, String productLineID) {
		model.setRowCount(0);
		ManageProductLine productLineCtr = new ManageProductLine();
		ArrayList<ProductLine> productLines = productLineCtr.readAll();
		if (!productLines.isEmpty()) {
			for (ProductLine productLine : productLines) {
				if(productLine.getproductLineId().equals(productLineID)) {
					double quantity = productLine.getQuantity();
					String productBarcode = productLine.getProductBarcode();
					model.addRow(new Object[]{productBarcode, quantity});
				}
			}

		} else {
			model.addRow(new Object[] { "Product Lines", "FOUND" });
		}
	}
}


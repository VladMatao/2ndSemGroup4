package gui.layer;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.layer.CreateProductOrder;
import control.layer.DeleteProductOrder;
import control.layer.ManageProductLine;
import model.layer.ProductLine;
import control.layer.ReadProductOrder;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InvoiceGui extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public InvoiceGui(String orderID) {

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
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			    dispose();
                ProductOrderGui productOrderGui=new ProductOrderGui();
                productOrderGui.setVisible(true);
			}
		});
		btnBack.setBounds(21, 348, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                DeleteProductOrder deleteProductOrder = new DeleteProductOrder();
                deleteProductOrder.delete(lblOrdID.getText());
                dispose();
                ProductOrderGui productOrderGui=new ProductOrderGui();
                productOrderGui.setVisible(true);
			}
		});
		btnCancel.setBounds(158, 348, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    dispose();
			    Menu menu=new Menu();
			    menu.setVisible(true);
			}
		});
		btnConfirm.setBounds(84, 405, 89, 23);
		contentPane.add(btnConfirm);
		
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


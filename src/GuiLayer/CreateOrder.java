package GuiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ControlLayer.CreateProductOrder;

public class CreateOrder extends JFrame {

	private JFrame frame;
	private JTextField textproductid;
	private JTextField textprice;
	private JTextField textorderstatus;
	private JTextField textdeliverydate;
	private JTextField textcompanyid;
	private JTextField textproductlineid;
	private JTextField textproductiontime;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public CreateOrder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 441, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textproductid = new JTextField();
		textproductid.setBounds(200, 35, 113, 20);
		frame.getContentPane().add(textproductid);
		textproductid.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(91, 38, 63, 14);
		frame.getContentPane().add(lblProductId);
		
		textprice = new JTextField();
		textprice.setBounds(200, 76, 113, 20);
		frame.getContentPane().add(textprice);
		textprice.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(91, 82, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		textorderstatus = new JTextField();
		textorderstatus.setBounds(200, 122, 113, 20);
		frame.getContentPane().add(textorderstatus);
		textorderstatus.setColumns(10);
		
		JLabel lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setBounds(91, 125, 62, 14);
		frame.getContentPane().add(lblOrderStatus);
		
		textdeliverydate = new JTextField();
		textdeliverydate.setBounds(200, 168, 113, 20);
		frame.getContentPane().add(textdeliverydate);
		textdeliverydate.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Delivery Date");
		lblNewLabel.setBounds(91, 171, 65, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textcompanyid = new JTextField();
		textcompanyid.setBounds(200, 208, 113, 20);
		frame.getContentPane().add(textcompanyid);
		textcompanyid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Company ID");
		lblNewLabel_1.setBounds(91, 211, 59, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textproductlineid = new JTextField();
		textproductlineid.setBounds(200, 253, 113, 20);
		frame.getContentPane().add(textproductlineid);
		textproductlineid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ProductLine ID");
		lblNewLabel_2.setBounds(91, 259, 70, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textproductiontime = new JTextField();
		textproductiontime.setBounds(200, 300, 113, 20);
		frame.getContentPane().add(textproductiontime);
		textproductiontime.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Production Time");
		lblNewLabel_3.setBounds(91, 306, 76, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblCreateOrder = new JLabel("Create Order");
		lblCreateOrder.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 26));
		lblCreateOrder.setBounds(130, 0, 196, 37);
		frame.getContentPane().add(lblCreateOrder);
		
		JButton buttonsendorder = new JButton("Send Order");
		buttonsendorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateProductOrder productOrderCtr = new CreateProductOrder();
				productOrderCtr.create(textproductid.getText(),Double.parseDouble(textprice.getText()) , textorderstatus.getText(), textdeliverydate.getText(), textcompanyid.getText(), textproductlineid.getText(), Double.parseDouble(textproductiontime.getText()));
			}
		});
		buttonsendorder.setBounds(161, 358, 89, 23);
		frame.getContentPane().add(buttonsendorder);
	}
}

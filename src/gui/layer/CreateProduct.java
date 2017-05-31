package gui.layer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import control.layer.ManageProduct;

public class CreateProduct {

	private JFrame frame;
	private JTextField textname;
	private JTextField textbarcode;
	private JTextField textprice;
	private JTextField textstock;
	private JTextField textproductiontime;
	private JTextField textrequiredmat;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public CreateProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textname = new JTextField();
		textname.setBounds(241, 45, 86, 20);
		frame.getContentPane().add(textname);
		textname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(101, 48, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textbarcode = new JTextField();
		textbarcode.setBounds(241, 76, 86, 20);
		frame.getContentPane().add(textbarcode);
		textbarcode.setColumns(10);
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(101, 82, 75, 14);
		frame.getContentPane().add(lblBarcode);
		
		textprice = new JTextField();
		textprice.setBounds(241, 113, 86, 20);
		frame.getContentPane().add(textprice);
		textprice.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(101, 116, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		textstock = new JTextField();
		textstock.setBounds(241, 154, 86, 20);
		frame.getContentPane().add(textstock);
		textstock.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(101, 160, 46, 14);
		frame.getContentPane().add(lblStock);
		
		textproductiontime = new JTextField();
		textproductiontime.setBounds(241, 195, 86, 20);
		frame.getContentPane().add(textproductiontime);
		textproductiontime.setColumns(10);
		
		JLabel lblProductionTime = new JLabel("Production Time");
		lblProductionTime.setBounds(101, 198, 98, 14);
		frame.getContentPane().add(lblProductionTime);
		
		textrequiredmat = new JTextField();
		textrequiredmat.setBounds(241, 230, 86, 20);
		frame.getContentPane().add(textrequiredmat);
		textrequiredmat.setColumns(10);
		
		JLabel lblRequiredMatid = new JLabel("Required MatID");
		lblRequiredMatid.setBounds(101, 233, 98, 14);
		frame.getContentPane().add(lblRequiredMatid);
		
		JButton btnCreateProduct = new JButton("Create Product");
		btnCreateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageProduct createproductCtr = new ManageProduct();
				createproductCtr.create(textname.getText(), textbarcode.getText(), Integer.parseInt(textprice.getText()), Integer.parseInt(textstock.getText()), Integer.parseInt(textproductiontime.getText()), textrequiredmat.getText());
				
			}
		});
		btnCreateProduct.setBounds(155, 277, 129, 23);
		frame.getContentPane().add(btnCreateProduct);
		
		JLabel lblCreateProduct = new JLabel("Create Product");
		lblCreateProduct.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblCreateProduct.setBounds(118, 6, 204, 31);
		frame.getContentPane().add(lblCreateProduct);
	}

}

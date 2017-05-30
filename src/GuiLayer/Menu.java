package GuiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame{

	private JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 450, 369);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmMenu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton createOrderButton = new JButton("Create Order");
		createOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				ProductOrderGUI productOrderGUI= new ProductOrderGUI();
				productOrderGUI.setVisible(true);
			}
		});
		createOrderButton.setBounds(153, 84, 140, 23);
		panel.add(createOrderButton);
		
		JButton productButton = new JButton("Products");
		productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				ProductGUI productGUI= new ProductGUI();
				productGUI.setVisible(true);
			}
		});
		productButton.setBounds(153, 154, 140, 23);
		panel.add(productButton);
		
		
		JButton statisticsButton = new JButton("Statistics");
		statisticsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		statisticsButton.setBounds(153, 188, 140, 23);
		panel.add(statisticsButton);
		
		JLabel lblScDumisSrl = new JLabel("SC DUMIS SRL");
		lblScDumisSrl.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblScDumisSrl.setHorizontalAlignment(SwingConstants.CENTER);
		lblScDumisSrl.setBounds(120, 11, 184, 31);
		panel.add(lblScDumisSrl);
		
		JButton companyButton = new JButton("Company");
		companyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmMenu.dispose();
				CompanyGUI companyGUI= new CompanyGUI();
				companyGUI.setVisible(true);
			}
		});
		companyButton.setBounds(151, 222, 140, 23);
		panel.add(companyButton);
		
		JButton employeeButton = new JButton("Employee");
		employeeButton.setBounds(153, 262, 140, 23);
		panel.add(employeeButton);
		
		JButton rawMaterialsButton = new JButton("Raw Materials");
		rawMaterialsButton.setBounds(153, 296, 140, 23);
		panel.add(rawMaterialsButton);
		
		JButton ordersButton = new JButton("Orders");
		ordersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				ChoseOrderGUI choseOrderGUI= new ChoseOrderGUI();
				choseOrderGUI.setVisible(true);
			}
		});
		ordersButton.setBounds(153, 118, 140, 23);
		panel.add(ordersButton);
	}
}

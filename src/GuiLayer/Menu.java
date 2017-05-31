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
import java.awt.Color;
import javax.swing.ImageIcon;

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
		frmMenu.setBounds(100, 100, 664, 560);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 93, 115));
		panel.setForeground(new Color(255, 255, 255));
		frmMenu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton createOrderButton = new JButton("Create Order");
		createOrderButton.setForeground(new Color(255, 255, 255));
		createOrderButton.setBackground(new Color(2, 52, 68));
		createOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				ProductOrderGUI productOrderGUI= new ProductOrderGUI();
				productOrderGUI.setVisible(true);
			}
		});
		createOrderButton.setBounds(67, 205, 140, 23);
		panel.add(createOrderButton);
		
		JButton productButton = new JButton("Products");
		productButton.setForeground(new Color(255, 255, 255));
		productButton.setBackground(new Color(2, 52, 68));
		productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				ProductGUI productGUI= new ProductGUI();
				productGUI.setVisible(true);
			}
		});
		productButton.setBounds(67, 275, 140, 23);
		panel.add(productButton);
		
		
		JButton statisticsButton = new JButton("Statistics");
		statisticsButton.setForeground(new Color(255, 255, 255));
		statisticsButton.setBackground(new Color(2, 52, 68));
		statisticsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		statisticsButton.setBounds(67, 309, 140, 23);
		panel.add(statisticsButton);
		
		JButton companyButton = new JButton("Company");
		companyButton.setForeground(new Color(255, 255, 255));
		companyButton.setBackground(new Color(2, 52, 68));
		companyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmMenu.dispose();
				CompanyGUI companyGUI= new CompanyGUI();
				companyGUI.setVisible(true);
			}
		});
		companyButton.setBounds(65, 343, 140, 23);
		panel.add(companyButton);
		
		JButton employeeButton = new JButton("Employee");
		employeeButton.setForeground(new Color(255, 255, 255));
		employeeButton.setBackground(new Color(2, 52, 68));
		employeeButton.setBounds(67, 383, 140, 23);
		panel.add(employeeButton);
		
		JButton rawMaterialsButton = new JButton("Raw Materials");
		rawMaterialsButton.setForeground(new Color(255, 255, 255));
		rawMaterialsButton.setBackground(new Color(2, 52, 68));
		rawMaterialsButton.setBounds(67, 425, 140, 23);
		panel.add(rawMaterialsButton);
		
		JButton ordersButton = new JButton("Orders");
		ordersButton.setForeground(new Color(255, 255, 255));
		ordersButton.setBackground(new Color(2, 52, 68));
		ordersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				ChoseOrderGUI choseOrderGUI= new ChoseOrderGUI();
				choseOrderGUI.setVisible(true);
			}
		});
		ordersButton.setBounds(67, 239, 140, 23);
		panel.add(ordersButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Mircea\\Downloads\\Adidas Shoebox.png"));
		label_1.setBounds(280, 144, 558, 371);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Mircea\\Desktop\\logo2.png"));
		label.setBounds(-172, 0, 810, 133);
		panel.add(label);
	}
}

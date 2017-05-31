package GuiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControlLayer.ManageCompany;
import ModelLayer.Company;
import DBLayer.CompanyDB;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CompanyGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField nameTextField;
	private JTextField companyIDTextField;
	private JTextField phoneNumberTextField;
	private JTextField emailTextField;
	private JTextField companyTypeTextField;
	private JTextField adressTextField;


	/**
	 * Create the frame.
	 */
	public CompanyGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 93, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel companytable= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Company ID", "Name", "Phone Number", "Email", "Company Type", "Adress"
				});
		fillTable(companytable);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(143, 192, 145, 31);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		companyIDTextField = new JTextField();
		companyIDTextField.setColumns(10);
		companyIDTextField.setBounds(143, 144, 145, 31);
		contentPane.add(companyIDTextField);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(143, 243, 145, 31);
		contentPane.add(phoneNumberTextField);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(143, 303, 145, 31);
		contentPane.add(emailTextField);
		
		companyTypeTextField = new JTextField();
		companyTypeTextField.setColumns(10);
		companyTypeTextField.setBounds(143, 355, 145, 31);
		contentPane.add(companyTypeTextField);
		
		adressTextField = new JTextField();
		adressTextField.setColumns(10);
		adressTextField.setBounds(143, 418, 145, 31);
		contentPane.add(adressTextField);
		
		JButton addButton = new JButton("Add");
		addButton.setForeground(new Color(255, 255, 255));
		addButton.setBackground(new Color(2, 52, 68));
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ManageCompany company=new ManageCompany();
				company.create(companyIDTextField.getText(),nameTextField.getText(),phoneNumberTextField.getText(),emailTextField.getText(),companyTypeTextField.getText(),adressTextField.getText());
				fillTable(companytable);


			}
		});
		addButton.setBounds(10, 510, 89, 23);
		contentPane.add(addButton);
		
		JButton deteleButton = new JButton("Delete");
		deteleButton.setForeground(new Color(255, 255, 255));
		
		deteleButton.setBackground(new Color(2, 52, 68));
		deteleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageCompany company=new ManageCompany();
				company.delete(companyIDTextField.getText());
				fillTable(companytable);

			}
		});
		deteleButton.setBounds(104, 510, 89, 23);
		contentPane.add(deteleButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.setForeground(new Color(255, 255, 255));
		updateButton.setBackground(new Color(2, 52, 68));
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageCompany company=new ManageCompany();
				company.update(companyIDTextField.getText(),nameTextField.getText(),phoneNumberTextField.getText(),emailTextField.getText(),companyTypeTextField.getText(),adressTextField.getText());
				fillTable(companytable);
			}
		});
		updateButton.setBounds(199, 510, 89, 23);
		contentPane.add(updateButton);
		
		JLabel lblCompanyId = new JLabel("Company ID");
		lblCompanyId.setForeground(new Color(255, 255, 255));
		lblCompanyId.setBounds(10, 152, 103, 14);
		contentPane.add(lblCompanyId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(10, 200, 103, 14);
		contentPane.add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(255, 255, 255));
		lblPhoneNumber.setBounds(10, 251, 89, 14);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(10, 311, 89, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCompanyType = new JLabel("Company Type");
		lblCompanyType.setForeground(new Color(255, 255, 255));
		lblCompanyType.setBounds(10, 363, 89, 14);
		contentPane.add(lblCompanyType);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setForeground(new Color(255, 255, 255));
		lblAdress.setBounds(10, 426, 89, 14);
		contentPane.add(lblAdress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 0, 648, 533);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(62, 143, 169));
		scrollPane.setViewportView(table);
		table.setModel(companytable);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("photos\\companies.png"));
		label.setBounds(10, 11, 351, 104);
		contentPane.add(label);
	}
	
	
	private void fillTable(DefaultTableModel model) {
		model.setRowCount(0);
		ManageCompany companyCtr = new ManageCompany();
		ArrayList<Company> company = companyCtr.readAll();
		if (!company.isEmpty()) {
			for (Company companys : company) {
				String companyID = companys.getId();
				String name = companys.getName();
				String phoneNumber = companys.getPhNr();
				String email = companys.getEmail();
				String companyType= companys.getcompanyType();
				String adress = companys.getAddress();
				model.addRow(new Object[] { companyID, name, phoneNumber, email, companyType, adress });
			}

		} else {
			model.addRow(new Object[] { "NO", "Companies", "FOUND", "!", 0 });
		}
	}
}

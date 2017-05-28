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
		setBounds(100, 100, 1002, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel companytable= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Company ID", "Name", "Phone Number", "Email", "Company Type", "Adress"
				});
		
		table = new JTable();
		table.setModel(companytable);
		table.setBounds(341, 0, 645, 456);
		fillTable(companytable);
		
		contentPane.add(table);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(143, 72, 145, 31);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		companyIDTextField = new JTextField();
		companyIDTextField.setColumns(10);
		companyIDTextField.setBounds(143, 24, 145, 31);
		contentPane.add(companyIDTextField);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(143, 150, 145, 31);
		contentPane.add(phoneNumberTextField);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(143, 210, 145, 31);
		contentPane.add(emailTextField);
		
		companyTypeTextField = new JTextField();
		companyTypeTextField.setColumns(10);
		companyTypeTextField.setBounds(143, 277, 145, 31);
		contentPane.add(companyTypeTextField);
		
		adressTextField = new JTextField();
		adressTextField.setColumns(10);
		adressTextField.setBounds(143, 340, 145, 31);
		contentPane.add(adressTextField);
		
		JButton addButton = new JButton("Add");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ManageCompany company=new ManageCompany();
				company.create(companyIDTextField.getText(),nameTextField.getText(),phoneNumberTextField.getText(),emailTextField.getText(),companyTypeTextField.getText(),adressTextField.getText());
				fillTable(companytable);


			}
		});
		addButton.setBounds(24, 394, 89, 23);
		contentPane.add(addButton);
		
		JButton deteleButton = new JButton("Delete");
		deteleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageCompany company=new ManageCompany();
				company.delete(companyIDTextField.getText());
				fillTable(companytable);

			}
		});
		deteleButton.setBounds(123, 394, 89, 23);
		contentPane.add(deteleButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageCompany company=new ManageCompany();
				company.update(companyIDTextField.getText(),nameTextField.getText(),phoneNumberTextField.getText(),emailTextField.getText(),companyTypeTextField.getText(),adressTextField.getText());
				fillTable(companytable);
			}
		});
		updateButton.setBounds(242, 394, 89, 23);
		contentPane.add(updateButton);
		
		JLabel lblCompanyId = new JLabel("Company ID");
		lblCompanyId.setBounds(10, 32, 103, 14);
		contentPane.add(lblCompanyId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 80, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(10, 158, 46, 14);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 218, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCompanyType = new JLabel("Company Type");
		lblCompanyType.setBounds(10, 285, 46, 14);
		contentPane.add(lblCompanyType);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setBounds(10, 348, 46, 14);
		contentPane.add(lblAdress);
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

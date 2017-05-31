package GuiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControlLayer.ManagePerson;
import ModelLayer.Employee;
import ModelLayer.Manager;
import ModelLayer.Person;
import DBLayer.EmployeeDB;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;

public class PersonGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField f_nameTextField;
	private JTextField personIDTextField;
	private JTextField l_nameTextField;
	private JTextField cnpTextField;
	private JTextField adressTextField;
	private JTextField phoneNumberTextField;
	private JTextField cityTextField;
	private JTextField positionTextField;
	private JTextField wageTextField;
	private JTextField departmentTextField;


	/**
	 * Create the frame.
	 */
	public PersonGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel persontable= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "f_Name", "L_Name", "CNP", "Adress", "Phone number","City","Position","Wage","Department"
				});
		
		table = new JTable();
		table.setModel(persontable);
		table.setBounds(341, 0, 645, 681);
		fillTable(persontable);
		
		contentPane.add(table);
		
		f_nameTextField = new JTextField();
		f_nameTextField.setBounds(143, 72, 145, 31);
		contentPane.add(f_nameTextField);
		f_nameTextField.setColumns(10);
		
		personIDTextField = new JTextField();
		personIDTextField.setColumns(10);
		personIDTextField.setBounds(143, 24, 145, 31);
		contentPane.add(personIDTextField);
		
		l_nameTextField = new JTextField();
		l_nameTextField.setColumns(10);
		l_nameTextField.setBounds(143, 150, 145, 31);
		contentPane.add(l_nameTextField);
		
		cnpTextField = new JTextField();
		cnpTextField.setColumns(10);
		cnpTextField.setBounds(143, 210, 145, 31);
		contentPane.add(cnpTextField);
		
		adressTextField = new JTextField();
		adressTextField.setColumns(10);
		adressTextField.setBounds(143, 277, 145, 31);
		contentPane.add(adressTextField);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(143, 340, 145, 31);
		contentPane.add(phoneNumberTextField);
		
		JButton addButton = new JButton("Add");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ManagePerson person=new ManagePerson();
				person.create(personIDTextField.getText(),f_nameTextField.getText(),l_nameTextField.getText(),cnpTextField.getText(),adressTextField.getText(),phoneNumberTextField.getText(),cityTextField.getText(),positionTextField.getText(),wageTextField.getText(),departmentTextField.getText());
				fillTable(persontable);


			}
		});
		addButton.setBounds(24, 619, 89, 23);
		contentPane.add(addButton);
		
		JButton deteleButton = new JButton("Delete");
		deteleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagePerson person=new ManagePerson();
				person.delete(personIDTextField.getText());
				fillTable(persontable);

			}
		});
		deteleButton.setBounds(123, 619, 89, 23);
		contentPane.add(deteleButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagePerson person=new ManagePerson();
				person.update(personIDTextField.getText(),f_nameTextField.getText(),l_nameTextField.getText(),cnpTextField.getText(),adressTextField.getText(),phoneNumberTextField.getText(),cityTextField.getText(),positionTextField.getText(),wageTextField.getText());
				fillTable(persontable);
			}
		});
		updateButton.setBounds(222, 619, 89, 23);
		contentPane.add(updateButton);
		
		JLabel lblCompanyId = new JLabel("ID");
		lblCompanyId.setBounds(10, 32, 103, 14);
		contentPane.add(lblCompanyId);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(10, 80, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("Last Name");
		lblPhoneNumber.setBounds(10, 158, 46, 14);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("CNP");
		lblEmail.setBounds(10, 218, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCompanyType = new JLabel("Adress");
		lblCompanyType.setBounds(10, 285, 46, 14);
		contentPane.add(lblCompanyType);
		
		JLabel lblAdress = new JLabel("Phone Number");
		lblAdress.setBounds(10, 348, 46, 14);
		contentPane.add(lblAdress);
		
		JLabel lblNewLabel = new JLabel("City");
		lblNewLabel.setBounds(10, 418, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(10, 475, 46, 14);
		contentPane.add(lblPosition);
		
		JLabel lblWage = new JLabel("Wage");
		lblWage.setBounds(10, 530, 46, 14);
		contentPane.add(lblWage);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(143, 404, 145, 28);
		contentPane.add(cityTextField);
		cityTextField.setColumns(10);
		
		positionTextField = new JTextField();
		positionTextField.setColumns(10);
		positionTextField.setBounds(143, 472, 145, 28);
		contentPane.add(positionTextField);
		
		wageTextField = new JTextField();
		wageTextField.setColumns(10);
		wageTextField.setBounds(143, 523, 145, 28);
		contentPane.add(wageTextField);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(10, 571, 46, 14);
		contentPane.add(lblDepartment);
		
		departmentTextField = new JTextField();
		departmentTextField.setBounds(143, 568, 145, 20);
		contentPane.add(departmentTextField);
		departmentTextField.setColumns(10);
	}
	
	
	private void fillTable(DefaultTableModel model) {
		model.setRowCount(0);
		ManagePerson personCtr = new ManagePerson();
		ArrayList<Person> person = personCtr.readAll();
		if (!person.isEmpty()) {
			for (Person persons : person) {
				String personID = persons.getId();
				String F_name = persons.getF_name();
				String L_name = persons.getL_name();
				int CNP = persons.getCNP();
				String Adress= persons.getAddress();
				String Phone_Number = persons.getPhNr();
				String City = persons.getCity();
				String Position = persons.getposition();
				Double Wage = persons.getWage();
				model.addRow(new Object[] { personID, F_name, L_name, CNP, Adress, Phone_Number,City,Position,Wage });
			}

		} else {
			model.addRow(new Object[] { "NO", "Companies", "FOUND", "!", 0 });
		}
	}
}

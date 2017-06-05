package gui.layer;

import control.layer.ManagePerson;
import model.layer.Person;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;

class PersonGui extends JFrame {

    private final JTextField f_nameTextField;
    private final JTextField personIDTextField;
    private final JTextField l_nameTextField;
    private final JTextField cnpTextField;
    private final JTextField adressTextField;
    private final JTextField phoneNumberTextField;
    private JTextField cityTextField;
    private JTextField positionTextField;
    private JTextField wageTextField;


    /**
     * Create the frame.
     */
    PersonGui() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1056, 720);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 93, 115));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        DefaultTableModel persontable = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "ID", "f_Name", "L_Name", "CNP", "Adress", "Phone number", "City", "Position", "Wage"
                });
        fillTable(persontable);

        f_nameTextField = new JTextField();
        f_nameTextField.setBounds(143, 251, 145, 23);
        contentPane.add(f_nameTextField);
        f_nameTextField.setColumns(10);

        personIDTextField = new JTextField();
        personIDTextField.setColumns(10);
        personIDTextField.setBounds(143, 217, 145, 23);
        contentPane.add(personIDTextField);

        l_nameTextField = new JTextField();
        l_nameTextField.setColumns(10);
        l_nameTextField.setBounds(143, 285, 145, 23);
        contentPane.add(l_nameTextField);

        cnpTextField = new JTextField();
        cnpTextField.setColumns(10);
        cnpTextField.setBounds(143, 319, 145, 23);
        contentPane.add(cnpTextField);

        adressTextField = new JTextField();
        adressTextField.setColumns(10);
        adressTextField.setBounds(143, 353, 145, 23);
        contentPane.add(adressTextField);

        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setColumns(10);
        phoneNumberTextField.setBounds(143, 387, 145, 23);
        contentPane.add(phoneNumberTextField);

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(2, 52, 68));
        addButton.setForeground(new Color(255, 255, 255));
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ManagePerson person = new ManagePerson();
                person.create(personIDTextField.getText(), f_nameTextField.getText(), l_nameTextField.getText(), Integer.parseInt(cnpTextField.getText()), adressTextField.getText(), phoneNumberTextField.getText(), cityTextField.getText(), positionTextField.getText(), Double.parseDouble(wageTextField.getText()));
                fillTable(persontable);


            }
        });
        addButton.setBounds(24, 593, 89, 23);
        contentPane.add(addButton);

        JButton deteleButton = new JButton("Delete");
        deteleButton.setBackground(new Color(2, 52, 68));
        deteleButton.setForeground(new Color(255, 255, 255));
        deteleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManagePerson person = new ManagePerson();
                person.delete(personIDTextField.getText());
                fillTable(persontable);

            }
        });
        deteleButton.setBounds(123, 593, 89, 23);
        contentPane.add(deteleButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(2, 52, 68));
        updateButton.setForeground(new Color(255, 255, 255));
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManagePerson person = new ManagePerson();
                person.update(personIDTextField.getText(), f_nameTextField.getText(), l_nameTextField.getText(), Integer.parseInt(cnpTextField.getText()), adressTextField.getText(), phoneNumberTextField.getText(), cityTextField.getText(), positionTextField.getText(), Double.parseDouble(wageTextField.getText()));
                fillTable(persontable);
            }
        });
        updateButton.setBounds(222, 593, 89, 23);
        contentPane.add(updateButton);

        JLabel lblCompanyId = new JLabel("ID");
        lblCompanyId.setForeground(new Color(255, 255, 255));
        lblCompanyId.setBounds(10, 225, 103, 14);
        contentPane.add(lblCompanyId);

        JLabel lblName = new JLabel("First Name");
        lblName.setForeground(new Color(255, 255, 255));
        lblName.setBounds(10, 259, 103, 14);
        contentPane.add(lblName);

        JLabel lblPhoneNumber = new JLabel("Last Name");
        lblPhoneNumber.setForeground(new Color(255, 255, 255));
        lblPhoneNumber.setBounds(10, 293, 103, 14);
        contentPane.add(lblPhoneNumber);

        JLabel lblEmail = new JLabel("CNP");
        lblEmail.setForeground(new Color(255, 255, 255));
        lblEmail.setBounds(10, 327, 103, 14);
        contentPane.add(lblEmail);

        JLabel lblCompanyType = new JLabel("Adress");
        lblCompanyType.setForeground(new Color(255, 255, 255));
        lblCompanyType.setBounds(10, 361, 103, 14);
        contentPane.add(lblCompanyType);

        JLabel lblAdress = new JLabel("Phone Number");
        lblAdress.setForeground(new Color(255, 255, 255));
        lblAdress.setBounds(10, 395, 103, 14);
        contentPane.add(lblAdress);

        JLabel lblNewLabel = new JLabel("City");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(10, 421, 103, 14);
        contentPane.add(lblNewLabel);

        JLabel lblPosition = new JLabel("Position");
        lblPosition.setForeground(new Color(255, 255, 255));
        lblPosition.setBounds(10, 451, 103, 14);
        contentPane.add(lblPosition);

        JLabel lblWage = new JLabel("Wage");
        lblWage.setForeground(new Color(255, 255, 255));
        lblWage.setBounds(10, 483, 103, 14);
        contentPane.add(lblWage);

        cityTextField = new JTextField();
        cityTextField.setBounds(143, 417, 145, 23);
        contentPane.add(cityTextField);
        cityTextField.setColumns(10);

        positionTextField = new JTextField();
        positionTextField.setColumns(10);
        positionTextField.setBounds(143, 448, 145, 23);
        contentPane.add(positionTextField);

        wageTextField = new JTextField();
        wageTextField.setColumns(10);
        wageTextField.setBounds(143, 476, 145, 23);
        contentPane.add(wageTextField);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(323, 0, 717, 670);
        contentPane.add(scrollPane);

        JTable table = new JTable();
                scrollPane.setViewportView(table);
                table.setModel(persontable);
                
                JButton btnBack = new JButton("Back");
                btnBack.addMouseListener(new MouseAdapter() {
                	@Override
                	public void mouseClicked(MouseEvent e) {
                		 dispose();
                         Menu menu = new Menu();
                         menu.setVisible(true);
                	}
                });
                btnBack.setForeground(new Color(255, 255, 255));
                btnBack.setBackground(new Color(2, 52, 68));
                btnBack.setBounds(24, 647, 89, 23);
                contentPane.add(btnBack);
                
                JLabel label = new JLabel("");
                label.setIcon(new ImageIcon("photos\\manageperson.png"));
                label.setBounds(10, 41, 369, 140);
                contentPane.add(label);
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
                String Adress = persons.getAddress();
                String Phone_Number = persons.getPhNr();
                String City = persons.getCity();
                String Position = persons.getposition();
                Double Wage = persons.getWage();
                model.addRow(new Object[]{personID, F_name, L_name, CNP, Adress, Phone_Number, City, Position, Wage});
            }

        } else {
            model.addRow(new Object[]{"NO", "Companies", "FOUND", "!", 0});
        }
    }
}

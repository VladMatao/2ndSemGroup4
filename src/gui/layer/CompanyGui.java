package gui.layer;

import control.layer.ManageCompany;
import model.layer.Company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class CompanyGui extends JFrame {

    private final JTextField nameTextField;
    private final JTextField companyIDTextField;
    private final JTextField phoneNumberTextField;
    private final JTextField emailTextField;
    private final JTextField companyTypeTextField;
    private final JTextField addressTextField;


    /**
     * Create the frame.
     */
    CompanyGui() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1002, 583);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 93, 115));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        DefaultTableModel companyTable = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Company ID", "Name", "Phone Number", "Email", "Company Type", "Address"
                });
        fillTable(companyTable);

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

        addressTextField = new JTextField();
        addressTextField.setColumns(10);
        addressTextField.setBounds(143, 418, 145, 31);
        contentPane.add(addressTextField);

        JButton addButton = new JButton("Add");
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setBackground(new Color(2, 52, 68));
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ManageCompany company = new ManageCompany();
                company.create(companyIDTextField.getText(), nameTextField.getText(), phoneNumberTextField.getText(), emailTextField.getText(), companyTypeTextField.getText(), addressTextField.getText());
                fillTable(companyTable);


            }
        });
        addButton.setBounds(10, 510, 89, 23);
        contentPane.add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setForeground(new Color(255, 255, 255));

        deleteButton.setBackground(new Color(2, 52, 68));
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageCompany company = new ManageCompany();
                company.delete(companyIDTextField.getText());
                fillTable(companyTable);

            }
        });
        deleteButton.setBounds(104, 510, 89, 23);
        contentPane.add(deleteButton);

        JButton updateButton = new JButton("Update");
        updateButton.setForeground(new Color(255, 255, 255));
        updateButton.setBackground(new Color(2, 52, 68));
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageCompany company = new ManageCompany();
                company.update(companyIDTextField.getText(), nameTextField.getText(), phoneNumberTextField.getText(), emailTextField.getText(), companyTypeTextField.getText(), addressTextField.getText());
                fillTable(companyTable);
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

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setForeground(new Color(255, 255, 255));
        lblAddress.setBounds(10, 426, 89, 14);
        contentPane.add(lblAddress);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(338, 0, 648, 533);
        contentPane.add(scrollPane);

        JTable table = new JTable();
        table.setBackground(new Color(62, 143, 169));
        scrollPane.setViewportView(table);
        table.setModel(companyTable);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("photos\\companies.png"));
        label.setBounds(10, 11, 351, 104);
        contentPane.add(label);

        JButton button = new JButton("<");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
        button.setForeground(new Color(255, 255, 255));
        button.setBackground(new Color(2, 52, 68));
        button.setBounds(10, 473, 47, 23);
        contentPane.add(button);
    }


    private void fillTable(DefaultTableModel model) {
        model.setRowCount(0);
        ManageCompany companyCtr = new ManageCompany();
        ArrayList<Company> company = companyCtr.readAll();
        if (!company.isEmpty()) {
            for (Company companies : company) {
                String companyID = companies.getId();
                String name = companies.getName();
                String phoneNumber = companies.getPhNr();
                String email = companies.getEmail();
                String companyType = companies.getCompanyType();
                String address = companies.getAddress();
                model.addRow(new Object[]{companyID, name, phoneNumber, email, companyType, address});
            }

        } else {
            model.addRow(new Object[]{"NO", "Companies", "FOUND", "!", 0});
        }
    }
}

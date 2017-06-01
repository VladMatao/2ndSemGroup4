package gui.layer;

import control.layer.ManageRawMaterial;
import model.layer.RawMaterial;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RawMaterialsGui extends JFrame {

    private JFrame frame;
    private JTable table_1;
    private JTextField nameTextField;
    private JTextField barcodeTextField;
    private JTextField stockTf;


    /**
     * Create the frame.
     */
    public RawMaterialsGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1002, 495);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 93, 115));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        DefaultTableModel rawMaterialtable = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Barcode", "Name", "Stock"
                });
        fillTable(rawMaterialtable);

        nameTextField = new JTextField();
        nameTextField.setBounds(90, 276, 145, 31);
        contentPane.add(nameTextField);
        nameTextField.setColumns(10);

        barcodeTextField = new JTextField();
        barcodeTextField.setColumns(10);
        barcodeTextField.setBounds(90, 179, 145, 31);
        contentPane.add(barcodeTextField);

        JButton addButton = new JButton("Add");
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setBackground(new Color(2, 52, 68));
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ManageRawMaterial rawMaterial = new ManageRawMaterial();
                rawMaterial.create(barcodeTextField.getText(), nameTextField.getText(), Double.valueOf(stockTf.getText()));
                fillTable(rawMaterialtable);
            }
        });
        addButton.setBounds(32, 422, 89, 23);
        contentPane.add(addButton);

        JButton deteleButton = new JButton("Delete");
        deteleButton.setForeground(new Color(255, 255, 204));
        deteleButton.setBackground(new Color(2, 52, 68));
        deteleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageRawMaterial rawMaterial = new ManageRawMaterial();
                rawMaterial.delete(barcodeTextField.getText());
                fillTable(rawMaterialtable);
            }
        });
        deteleButton.setBounds(131, 422, 89, 23);
        contentPane.add(deteleButton);

        JButton updateButton = new JButton("Update");
        updateButton.setForeground(new Color(255, 255, 255));
        updateButton.setBackground(new Color(2, 52, 68));
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManageRawMaterial rawMaterial = new ManageRawMaterial();
                rawMaterial.update(barcodeTextField.getText(), nameTextField.getText(), Double.valueOf(stockTf.getText()));
                fillTable(rawMaterialtable);
            }
        });
        updateButton.setBounds(230, 422, 89, 23);
        contentPane.add(updateButton);

        JLabel lblBarcode = new JLabel("Barcode:");
        lblBarcode.setForeground(new Color(255, 255, 255));
        lblBarcode.setBounds(90, 148, 103, 14);
        contentPane.add(lblBarcode);

        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(new Color(255, 255, 255));
        lblName.setBounds(90, 251, 46, 14);
        contentPane.add(lblName);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(344, 0, 642, 456);
        contentPane.add(scrollPane);

        JTable table = new JTable();
        scrollPane.setViewportView(table);
        table.setBackground(new Color(62, 143, 169));
        table.setModel(rawMaterialtable);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("photos\\rawmat.png"));
        label.setBounds(0, 11, 336, 92);
        contentPane.add(label);

        JButton btnNewButton = new JButton("<");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(2, 52, 68));
        btnNewButton.setBounds(32, 388, 46, 23);
        contentPane.add(btnNewButton);
        
        stockTf = new JTextField();
        stockTf.setBounds(87, 106, 148, 31);
        contentPane.add(stockTf);
        stockTf.setColumns(10);
        
        JLabel lblStock = new JLabel("Stock:");
        lblStock.setBounds(10, 114, 46, 14);
        contentPane.add(lblStock);
    }


    private void fillTable(DefaultTableModel model) {
        model.setRowCount(0);
        ManageRawMaterial rawMaterialCtr = new ManageRawMaterial();
        ArrayList<RawMaterial> rawMaterials = rawMaterialCtr.readAll();
        if (!rawMaterials.isEmpty()) {
            for (RawMaterial rawMaterial : rawMaterials) {
                String barcode = rawMaterial.getBarcode();
                String name = rawMaterial.getName();
                Double stock = rawMaterial.getStock();
                model.addRow(new Object[]{barcode, name, stock});
            }
        } else {
            model.addRow(new Object[]{"NO", "RawMaterials", "FOUND", "!", 0});
        }
    }
}

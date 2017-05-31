package GuiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControlLayer.ManageRawMaterial;
import ModelLayer.RAW_Material;
import DBLayer.RawMaterialDB;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class RawMaterialsGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField nameTextField;
	private JTextField barcodeTextField;


	/**
	 * Create the frame.
	 */
	public RawMaterialsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 93, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel rawMaterialtable= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Barcode", "Name"
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
				ManageRawMaterial rawMaterial=new ManageRawMaterial();
				rawMaterial.create(barcodeTextField.getText(),nameTextField.getText());
				fillTable(rawMaterialtable);


			}
		});
		addButton.setBounds(24, 394, 89, 23);
		contentPane.add(addButton);
		
		JButton deteleButton = new JButton("Delete");
		deteleButton.setForeground(new Color(255, 255, 204));
		deteleButton.setBackground(new Color(2, 52, 68));
		deteleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageRawMaterial rawMaterial=new ManageRawMaterial();
				rawMaterial.delete(barcodeTextField.getText());
				fillTable(rawMaterialtable);

			}
		});
		deteleButton.setBounds(123, 394, 89, 23);
		contentPane.add(deteleButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.setForeground(new Color(255, 255, 255));
		updateButton.setBackground(new Color(2, 52, 68));
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageRawMaterial rawMaterial=new ManageRawMaterial();
				rawMaterial.update(barcodeTextField.getText(),nameTextField.getText());
				fillTable(rawMaterialtable);
			}
		});
		updateButton.setBounds(222, 394, 89, 23);
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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(62, 143, 169));
		table.setModel(rawMaterialtable);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("photos\\rawmat.png"));
		label.setBounds(0, 11, 336, 92);
		contentPane.add(label);
	}
	
	
	private void fillTable(DefaultTableModel model) {
		model.setRowCount(0);
		ManageRawMaterial rawMaterialCtr = new ManageRawMaterial();
		ArrayList<RAW_Material> rawMaterial = rawMaterialCtr.readAll();
		if (!rawMaterial.isEmpty()) {
			for (RAW_Material rawMaterials : rawMaterial) {
				String barcode = rawMaterials.getBarcode();
				String name = rawMaterials.getName();
				model.addRow(new Object[] { barcode, name});
			}

		} else {
			model.addRow(new Object[] { "NO", "RawMaterials", "FOUND", "!", 0 });
		}
	}
}

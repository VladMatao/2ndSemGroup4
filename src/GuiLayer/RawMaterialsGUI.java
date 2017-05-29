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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel rawMaterialtable= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Barcode", "Name"
				});
		
		table = new JTable();
		table.setModel(rawMaterialtable);
		table.setBounds(341, 0, 645, 456);
		fillTable(rawMaterialtable);
		
		contentPane.add(table);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(143, 72, 145, 31);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		barcodeTextField = new JTextField();
		barcodeTextField.setColumns(10);
		barcodeTextField.setBounds(143, 24, 145, 31);
		contentPane.add(barcodeTextField);
		
		JButton addButton = new JButton("Add");
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
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageRawMaterial rawMaterial=new ManageRawMaterial();
				rawMaterial.update(barcodeTextField.getText(),nameTextField.getText());
				fillTable(rawMaterialtable);
			}
		});
		updateButton.setBounds(242, 394, 89, 23);
		contentPane.add(updateButton);
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(10, 32, 103, 14);
		contentPane.add(lblBarcode);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 80, 46, 14);
		contentPane.add(lblName);
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

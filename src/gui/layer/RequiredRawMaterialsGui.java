package gui.layer;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.layer.RequiredRawMaterialCtr;
import model.layer.RequiredRawMaterial;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

class RequiredRawMaterialsGui extends JFrame {

	private final JTextField IDTextField;
	private final JTextField ProductBarcodeTextField;
	private final JTextField QuantityTextField;

	RequiredRawMaterialsGui() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 433);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 93, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 DefaultTableModel requiredRawMaterialsTable = new DefaultTableModel(
	                new Object[][]{
	                },
	                new String[]{
	                        "ID", "Raw Barcode", "Quantity"
	                });
	        fillTable(requiredRawMaterialsTable);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setBounds(93, 131, 46, 14);
		contentPane.add(lblId);
		
		IDTextField = new JTextField();
		IDTextField.setBounds(243, 128, 116, 20);
		contentPane.add(IDTextField);
		IDTextField.setColumns(10);
		
		JLabel lblProdutctBarcode = new JLabel("Produtct Barcode");
		lblProdutctBarcode.setForeground(new Color(255, 255, 255));
		lblProdutctBarcode.setBounds(93, 178, 91, 14);
		contentPane.add(lblProdutctBarcode);
		
		ProductBarcodeTextField = new JTextField();
		ProductBarcodeTextField.setBounds(243, 175, 116, 20);
		contentPane.add(ProductBarcodeTextField);
		ProductBarcodeTextField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(255, 255, 255));
		lblQuantity.setBounds(93, 228, 46, 14);
		contentPane.add(lblQuantity);
		
		QuantityTextField = new JTextField();
		QuantityTextField.setBounds(243, 225, 116, 20);
		contentPane.add(QuantityTextField);
		QuantityTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(428, 0, 419, 394);
		contentPane.add(scrollPane);

		JTable table = new JTable();
		table.setBackground(new Color(62, 143, 169));
		scrollPane.setViewportView(table);
	    table.setModel(requiredRawMaterialsTable);
	    
	    JButton btnAdd = new JButton("Add");
	    btnAdd.setBackground(new Color(2, 52, 68));
	    btnAdd.setForeground(new Color(255, 255, 255));
	    btnAdd.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		RequiredRawMaterialCtr reqRawMatCtr = new RequiredRawMaterialCtr();
	    		reqRawMatCtr.create(IDTextField.getText(), ProductBarcodeTextField.getText(), Double.parseDouble(QuantityTextField.getText()));
                fillTable(requiredRawMaterialsTable);

	    	}
	    });
	    btnAdd.setBounds(179, 320, 89, 23);
	    contentPane.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(2, 52, 68));
		btnDelete.setForeground(new Color(255, 255, 255));
	    btnDelete.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		RequiredRawMaterialCtr reqRawMatCtr = new RequiredRawMaterialCtr();
	    		reqRawMatCtr.delete(IDTextField.getText());
                fillTable(requiredRawMaterialsTable);
	    	}
	    });
	    btnDelete.setBounds(312, 320, 89, 23);
	    contentPane.add(btnDelete);
	    
	    JButton btnBack = new JButton("Back");
	    btnBack.setBackground(new Color(2, 52, 68));
	    btnBack.setForeground(new Color(255, 255, 255));
	    btnBack.setBounds(46, 320, 89, 23);
	    contentPane.add(btnBack);
	    
	    JLabel label = new JLabel("");
	    label.setIcon(new ImageIcon("C:\\Users\\Mircea\\IdeaProjects\\ProiectChiarBaban\\photos\\reqrawmat.png"));
	    label.setBounds(10, 0, 540, 109);
	    contentPane.add(label);

	}
	

    private void fillTable(DefaultTableModel model) {
        model.setRowCount(0);
        RequiredRawMaterialCtr reqRawMatCtr = new RequiredRawMaterialCtr();
        ArrayList<RequiredRawMaterial> requieredRawMaterials = reqRawMatCtr.readAll();
        if (!requieredRawMaterials.isEmpty()) {
            for (RequiredRawMaterial requieredRawMaterial : requieredRawMaterials) {
                String ID = requieredRawMaterial.getRequiredMatId();
                String barcode = requieredRawMaterial.getRawMaterialBarcode();
                Double quantity = requieredRawMaterial.getQuantity();
                model.addRow(new Object[]{ID, barcode, quantity});
            }

        } else {
            model.addRow(new Object[]{"NO", "Raw Materials", "FOUND", "!", 0});
        }
    }
}

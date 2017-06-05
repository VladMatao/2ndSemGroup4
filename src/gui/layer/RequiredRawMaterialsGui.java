package gui.layer;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.layer.RequiredRawMaterialCtr;
import model.layer.RequiredRawMaterial;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class RequiredRawMaterialsGui extends JFrame {

	private final JTextField IDTextField;
	private final JTextField ProductBarcodeTextField;
	private final JTextField QuantityTextField;

	RequiredRawMaterialsGui() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 433);
		JPanel contentPane = new JPanel();
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
		lblId.setBounds(26, 40, 46, 14);
		contentPane.add(lblId);
		
		IDTextField = new JTextField();
		IDTextField.setBounds(160, 37, 86, 20);
		contentPane.add(IDTextField);
		IDTextField.setColumns(10);
		
		JLabel lblProdutctBarcode = new JLabel("Produtct Barcode");
		lblProdutctBarcode.setBounds(10, 87, 91, 14);
		contentPane.add(lblProdutctBarcode);
		
		ProductBarcodeTextField = new JTextField();
		ProductBarcodeTextField.setBounds(160, 84, 86, 20);
		contentPane.add(ProductBarcodeTextField);
		ProductBarcodeTextField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 137, 46, 14);
		contentPane.add(lblQuantity);
		
		QuantityTextField = new JTextField();
		QuantityTextField.setBounds(160, 134, 86, 20);
		contentPane.add(QuantityTextField);
		QuantityTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(477, 11, 370, 383);
		contentPane.add(scrollPane);

		JTable table = new JTable();
		scrollPane.setViewportView(table);
	    table.setModel(requiredRawMaterialsTable);
	    
	    JButton btnAdd = new JButton("Add");
	    btnAdd.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		RequiredRawMaterialCtr reqRawMatCtr = new RequiredRawMaterialCtr();
	    		reqRawMatCtr.create(IDTextField.getText(), ProductBarcodeTextField.getText(), Double.parseDouble(QuantityTextField.getText()));
                fillTable(requiredRawMaterialsTable);

	    	}
	    });
	    btnAdd.setBounds(48, 283, 89, 23);
	    contentPane.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
	    btnDelete.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		RequiredRawMaterialCtr reqRawMatCtr = new RequiredRawMaterialCtr();
	    		reqRawMatCtr.delete(IDTextField.getText());
                fillTable(requiredRawMaterialsTable);
	    	}
	    });
	    btnDelete.setBounds(181, 283, 89, 23);
	    contentPane.add(btnDelete);

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

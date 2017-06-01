package gui.layer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChoseOrderGui extends JFrame {

    /**
     * Create the frame.
     */
    public ChoseOrderGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton supplierOrderButton = new JButton("Supplier Order");
        supplierOrderButton.setBounds(230, 119, 109, 23);
        contentPane.add(supplierOrderButton);
        
        JButton btnProductOrders = new JButton("Product Orders");
        btnProductOrders.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        		ManageProductOrderGui manageProductOrderGui= new ManageProductOrderGui();
        		manageProductOrderGui.setVisible(true);
        	}
        });
        btnProductOrders.setBounds(66, 119, 89, 23);
        contentPane.add(btnProductOrders);
    }

}

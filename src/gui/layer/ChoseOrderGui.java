package gui.layer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
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
        contentPane.setBackground(new Color(25, 93, 115));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton supplierOrderButton = new JButton("Supplier Order");
        supplierOrderButton.setForeground(new Color(255, 255, 255));
        supplierOrderButton.setBackground(new Color(2, 52, 68));
        supplierOrderButton.setBounds(248, 147, 109, 23);
        contentPane.add(supplierOrderButton);
        
        JButton btnProductOrders = new JButton("Product Orders");
        btnProductOrders.setForeground(new Color(255, 255, 255));
        btnProductOrders.setBackground(new Color(2, 52, 68));
        btnProductOrders.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        		ManageProductOrderGui manageProductOrderGui= new ManageProductOrderGui();
        		manageProductOrderGui.setVisible(true);
        	}
        });
        btnProductOrders.setBounds(67, 147, 109, 23);
        contentPane.add(btnProductOrders);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("photos\\chooseordertype.png"));
        label.setBounds(10, 27, 410, 101);
        contentPane.add(label);
    }

}

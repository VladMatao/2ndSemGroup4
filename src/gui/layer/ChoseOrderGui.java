package gui.layer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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

        JButton productOrderButton = new JButton("Product Orders");
        productOrderButton.setBounds(77, 119, 109, 23);
        contentPane.add(productOrderButton);

        JButton supplierOrderButton = new JButton("Supplier Order");
        supplierOrderButton.setBounds(230, 119, 109, 23);
        contentPane.add(supplierOrderButton);
    }

}

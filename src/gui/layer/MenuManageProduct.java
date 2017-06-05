package gui.layer;

import javax.swing.*;
import java.awt.*;

class MenuManageProduct {

    private JFrame frame;

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnCreateProduct = new JButton("Create Product");
        btnCreateProduct.addActionListener(e -> {
            new CreateProduct();
            frame.dispose();
        });
        btnCreateProduct.setBounds(154, 84, 105, 23);
        frame.getContentPane().add(btnCreateProduct);

        JButton btnUpdateProduct = new JButton("Update Product");
        btnUpdateProduct.addActionListener(e -> {
        });
        btnUpdateProduct.setBounds(152, 118, 107, 23);
        frame.getContentPane().add(btnUpdateProduct);

        JButton btnDeleteProduct = new JButton("Delete Product");
        btnDeleteProduct.setBounds(154, 152, 107, 23);
        frame.getContentPane().add(btnDeleteProduct);

        JButton btnFindProduct = new JButton("Find Product");
        btnFindProduct.addActionListener(e -> new FindOrder());
        btnFindProduct.setBounds(154, 186, 105, 23);
        frame.getContentPane().add(btnFindProduct);

        JLabel lblManageProduct = new JLabel("Manage Product");
        lblManageProduct.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblManageProduct.setBounds(124, 11, 156, 27);
        frame.getContentPane().add(lblManageProduct);
    }
}

package gui.layer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Menu");
        setBounds(100, 100, 664, 560);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(25, 93, 115));
        panel.setForeground(new Color(255, 255, 255));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JButton createOrderButton = new JButton("Create Order");
        createOrderButton.setForeground(new Color(255, 255, 255));
        createOrderButton.setBackground(new Color(2, 52, 68));
        createOrderButton.addActionListener(e -> {
            dispose();
            ProductOrderGui productOrderGui = new ProductOrderGui();
            productOrderGui.setVisible(true);
        });
        createOrderButton.setBounds(67, 205, 140, 23);
        panel.add(createOrderButton);

        JButton productButton = new JButton("Products");
        productButton.setForeground(new Color(255, 255, 255));
        productButton.setBackground(new Color(2, 52, 68));
        productButton.addActionListener(e -> {
            dispose();
            ProductGui productGui = new ProductGui();
            productGui.setVisible(true);
        });
        productButton.setBounds(67, 275, 140, 23);
        panel.add(productButton);


        JButton statisticsButton = new JButton("Statistics");
        statisticsButton.setForeground(new Color(255, 255, 255));
        statisticsButton.setBackground(new Color(2, 52, 68));
        statisticsButton.addActionListener(arg0 -> {
        });
        statisticsButton.setBounds(67, 309, 140, 23);
        panel.add(statisticsButton);

        JButton companyButton = new JButton("Company");
        companyButton.setForeground(new Color(255, 255, 255));
        companyButton.setBackground(new Color(2, 52, 68));
        companyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                dispose();
                CompanyGui companyGui = new CompanyGui();
                companyGui.setVisible(true);
            }
        });
        companyButton.setBounds(65, 343, 140, 23);
        panel.add(companyButton);

        JButton personButton = new JButton("Person");
        personButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		dispose();
        		PersonGui persongui= new PersonGui();
        		persongui.setVisible(true);
        	}
        });
        personButton.setForeground(new Color(255, 255, 255));
        personButton.setBackground(new Color(2, 52, 68));
        personButton.setBounds(67, 383, 140, 23);
        panel.add(personButton);

        JButton rawMaterialsButton = new JButton("Raw Materials");
        rawMaterialsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                RawMaterialsGui rawmaterialgui = new RawMaterialsGui();
                rawmaterialgui.setVisible(true);
            }
        });
        rawMaterialsButton.setForeground(new Color(255, 255, 255));
        rawMaterialsButton.setBackground(new Color(2, 52, 68));
        rawMaterialsButton.setBounds(67, 425, 140, 23);
        panel.add(rawMaterialsButton);

        JButton ordersButton = new JButton("Orders");
        ordersButton.setForeground(new Color(255, 255, 255));
        ordersButton.setBackground(new Color(2, 52, 68));
        ordersButton.addActionListener(e -> {
            dispose();
            ChoseOrderGui choseOrderGui = new ChoseOrderGui();
            choseOrderGui.setVisible(true);
        });
        ordersButton.setBounds(67, 239, 140, 23);
        panel.add(ordersButton);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("photos\\Adidas Shoebox.png"));
        label_1.setBounds(272, 108, 578, 433);
        panel.add(label_1);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("photos\\logo3.png"));
        label.setBounds(-168, 11, 835, 108);
        panel.add(label);
        
        JButton requirerdRawMaterialsButton = new JButton("Required Raw Mat");
        requirerdRawMaterialsButton.setForeground(new Color(255, 255, 255));
        requirerdRawMaterialsButton.setBackground(new Color(2, 52, 68));
        requirerdRawMaterialsButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
                RequiredRawMaterialsGui requiredRawMaterialsGui = new RequiredRawMaterialsGui();
                requiredRawMaterialsGui.setVisible(true);
        	}
        });
        requirerdRawMaterialsButton.setBounds(67, 459, 140, 23);
        panel.add(requirerdRawMaterialsButton);
    }
}

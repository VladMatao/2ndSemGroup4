package GuiLayer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Menu extends JFrame {
    private JPanel panel1;
    private JButton createOrderButton;
    private JButton manageProductButton;
    private JButton managerMenuButton;
    private JButton checkSchduleButton;
    private JPanel left;
    private JPanel down;
    private JPanel center;

    public Menu() {


        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Muie viata!");
            }
        });


        managerMenuButton = new JButton();
        managerMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                dispose();
                ManagerMenu managerMenu = new ManagerMenu();
                JFrame frame= new JFrame("Menu");
                frame.setContentPane(managerMenu);
                managerMenu.setVisible(true);
            }
        });
        managerMenuButton.setBounds(248, 48, 124, 23);
        panel1.add(managerMenuButton);
    }





    public static void main(String[] args) {
        JFrame frame= new JFrame("Menu");
        frame.setContentPane(new Menu().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

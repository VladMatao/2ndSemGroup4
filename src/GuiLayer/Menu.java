package GuiLayer;

import javax.swing.*;
import java.awt.event.*;


/**
 * Created by Mircea on 16-May-17.
 */
public class Menu {
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

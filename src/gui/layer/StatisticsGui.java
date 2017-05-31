package gui.layer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatisticsGui extends JFrame {

    /**
     * Create the frame.
     */
    public StatisticsGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
    }

}

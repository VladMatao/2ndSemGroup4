import control.layer.CreateProductOrder;
import gui.layer.*;

import java.awt.*;
import java.awt.Menu;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class GuiStart {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gui.layer.Menu menu = new gui.layer.Menu();
                    menu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

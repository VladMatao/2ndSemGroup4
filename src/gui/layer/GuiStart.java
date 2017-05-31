package gui.layer;

import java.awt.*;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class GuiStart {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gui.layer.Menu menu = new gui.layer.Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

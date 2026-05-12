package src.view.main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class HeaderPanel extends JPanel {
    public HeaderPanel(int height) {
        setPreferredSize(new Dimension(0, height));
        setBackground(Color.RED);
    }
}

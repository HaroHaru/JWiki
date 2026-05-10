package src.view.panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class SidebarPanel extends JPanel {
    public SidebarPanel(int width) {
        setPreferredSize(new Dimension(width, 0));
        setBackground(Color.YELLOW);
    }
}

package src.view;

import java.awt.*;

import javax.swing.*;

import src.view.panel.ContentPanel;
import src.view.panel.HeaderPanel;
import src.view.panel.SidebarPanel;

public class MainFrame extends JFrame {
    public MainFrame(int width, int height) {
        setTitle("JWiki");

        setLayout(new BorderLayout());

        HeaderPanel head = new HeaderPanel();
        SidebarPanel side = new SidebarPanel();
        ContentPanel content = new ContentPanel();

        add(head, BorderLayout.NORTH);
        add(side, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);

        setSize(width, height);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
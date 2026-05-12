package src.view.main;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame {
    HeaderPanel headerPanel;
    SidebarPanel sidebarPanel;
    ContentPanel contentPanel;

    public MainFrame(int width, int height, int header, int sidebar) {
        setTitle("JWiki");

        setLayout(new BorderLayout());

        headerPanel = new HeaderPanel(header);
        sidebarPanel = new SidebarPanel(sidebar);
        contentPanel = new ContentPanel();

        add(headerPanel, BorderLayout.NORTH);
        add(sidebarPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        setSize(width, height);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setContent(String title, String content) {
        contentPanel.setContent(title, content);
    }
}
package src.view.main;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import src.view.components.ContentToolbar;
import src.view.pages.ContentMain;

public class ContentPanel extends JPanel {
    private ContentMain main;
    private ContentToolbar toolbar;

    public ContentPanel() {
        main = new ContentMain();
        toolbar = new ContentToolbar();

        setLayout(new BorderLayout());

        add(main, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);

        setBackground(Color.WHITE);
    }

    public void setContent(String title, String content) {
        main.setContent(title, content);
    }
}

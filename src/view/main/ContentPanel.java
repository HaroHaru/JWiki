package src.view.main;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import src.view.main.content.ContentMain;
import src.view.main.content.ContentToolbar;

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
}

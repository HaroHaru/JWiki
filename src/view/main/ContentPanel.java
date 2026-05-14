package src.view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import src.enums.Mode;
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

    public void setContent(String title, String content, Mode mode) {
        main.setContent(title, content, mode);
    }

    public void setToolbarListener(ActionListener[] listeners) {
        toolbar.setToolbarListener(listeners);
    }
}

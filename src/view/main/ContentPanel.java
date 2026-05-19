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
        toolbar.setMode(mode);
    }

    public void setToolbarListener(ActionListener[] listeners, ActionListener[] editorListeners) {
        toolbar.setToolbarListener(listeners, editorListeners);
    }

    public String getEditedContent() {
        return main.getEditedContent();
    }

    public void setTag(String tag) {
        main.setTag(tag);
    }

    public void setLink() {
        main.setLink();
    }
}

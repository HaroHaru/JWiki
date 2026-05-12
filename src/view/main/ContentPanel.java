package src.view.main;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import src.view.components.ContentToolbar;
import src.view.pages.ContentEditer;
import src.view.pages.ContentViewer;

public class ContentPanel extends JPanel {
    private ContentEditer editer;
    private ContentViewer viewer;
    private ContentToolbar toolbar;

    public ContentPanel() {
        editer = new ContentEditer();
        viewer = new ContentViewer();
        toolbar = new ContentToolbar();

        setLayout(new BorderLayout());

        add(new JScrollPane(viewer), BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);

        setBackground(Color.WHITE);
    }

    public void setContent(String title, String content) {
        viewer.setContent(title, content);
    }
}

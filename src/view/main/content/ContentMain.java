package src.view.main.content;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import src.view.main.content.pages.ContentEditer;
import src.view.main.content.pages.ContentViewer;

public class ContentMain extends JPanel {
    private CardLayout cardLayout;

    private ContentEditer editer;
    private ContentViewer viewer;

    private String title;
    private String content;

    public ContentMain() {
        editer = new ContentEditer();
        viewer = new ContentViewer();

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(new JScrollPane(viewer), "viewer");
        add(new JScrollPane(editer), "editer");

        cardLayout.show(this, "viewer");
    }

    public void setContent(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setViewMode() {
        viewer.setContent(title, content);
        cardLayout.show(this, "viewer");
    }

    public void setEditMode() {
        editer.setContent(title, content);
        cardLayout.show(this, "editer");
    }
}

package src.view.main.content;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import src.enums.Mode;
import src.view.main.content.pages.ContentEditer;
import src.view.main.content.pages.ContentViewer;

public class ContentMain extends JPanel {
    private CardLayout cardLayout;

    private ContentEditer editer;
    private ContentViewer viewer;

    public ContentMain() {
        editer = new ContentEditer();
        viewer = new ContentViewer();

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(new JScrollPane(viewer), "viewer");
        add(new JScrollPane(editer), "editer");

        cardLayout.show(this, "viewer");
    }

    public void setContent(String title, String content, Mode mode) {
        switch (mode) {
            case Mode.VIEW:
                setViewMode(title, content);
                break;
            case Mode.EDIT:
                setEditMode(title, content);
                break;
            default:
                break;
        }
    }

    public void setViewMode(String title, String content) {
        viewer.setContent(title, content);
        cardLayout.show(this, "viewer");
    }

    public void setEditMode(String title, String content) {
        editer.setContent(title, content);
        cardLayout.show(this, "editer");
    }

    public String getEditedContent() {
        return editer.getEditedContent();
    }
}
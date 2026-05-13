package src.view.pages;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

    public void setContent(String title, String content) {
        viewer.setContent(title, content);
    }
}

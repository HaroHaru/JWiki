package src.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.HyperlinkListener;

import src.etc.Header;
import src.etc.Mode;
import src.view.main.ContentPanel;
import src.view.main.HeaderPanel;
import src.view.main.SidebarPanel;

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

    public void setContent(String title, String content, Mode mode) {
        contentPanel.setContent(title, content, mode);
    }

    public void setToolbarListener(ActionListener[] listeners, ActionListener[] editorListeners) {
        contentPanel.setToolbarListener(listeners, editorListeners);
    }

    public String getEditedContent() {
        return contentPanel.getEditedContent();
    }

    public void setTag(String tag) {
        contentPanel.setTag(tag);
    }

    public void setLink() {
        contentPanel.setLink();
    }

    public void setLinkListener(HyperlinkListener listener) {
        contentPanel.setLinkListener(listener);
    }

    public void setSidebar(List<Header> list) {
        sidebarPanel.setTree(list);
    }
}
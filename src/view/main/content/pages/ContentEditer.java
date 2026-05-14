package src.view.main.content.pages;

import java.awt.BorderLayout;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContentEditer extends JPanel {
    private JLabel title;
    private JTextArea content;

    public ContentEditer() {
        title = new JLabel();
        content = new JTextArea();

        content.setLineWrap(true);
        content.setWrapStyleWord(true);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
    }

    public void setContent(String title, String content) {
        this.title.setText(title);
        this.content.setText(content);
    }
}

package src.view.main.content.pages;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;

public class ContentViewer extends JPanel {
    private JLabel title;
    private JTextPane content;

    public ContentViewer() {
        title = new JLabel();
        content = new JTextPane();

        content.setEditable(false);
        content.setFocusable(false);

        DefaultCaret caret = (DefaultCaret) content.getCaret();
        caret.setVisible(false);
        caret.setSelectionVisible(true);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
    }

    public void setContent(String title, String content) {
        this.title.setText(title);
        this.content.setText(content);
    }
}

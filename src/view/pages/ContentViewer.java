package src.view.pages;

import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;

import src.model.PageFormatter; // need to erase

public class ContentViewer extends JTextPane {
    private PageFormatter formatter;

    public ContentViewer() {
        formatter = new PageFormatter();

        setEditable(false);
        setFocusable(false);

        DefaultCaret caret = (DefaultCaret) getCaret();
        caret.setVisible(false);
        caret.setSelectionVisible(true);
    }

    public void setContent(String title, String content) {
        setText(formatter.format(title, content));
    }
}

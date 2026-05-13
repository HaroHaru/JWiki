package src.view.main.content.pages;

import javax.swing.JTextArea;

import src.util.PageFormatter;

public class ContentEditer extends JTextArea {
    private PageFormatter formatter;

    public ContentEditer() {
        formatter = new PageFormatter();

        setLineWrap(true);
        setWrapStyleWord(true);
    }

    public void setContent(String title, String content) {
        setText(formatter.format(title, content));
    }
}
